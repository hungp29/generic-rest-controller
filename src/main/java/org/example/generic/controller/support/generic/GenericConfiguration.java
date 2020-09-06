package org.example.generic.controller.support.generic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.generic.controller.support.generic.annotation.APIGeneric;
import org.example.generic.controller.support.generic.annotation.EnabledGeneric;
import org.example.generic.controller.support.generic.annotation.GenericController;
import org.example.generic.controller.support.generic.annotation.GenericDisabled;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static org.example.generic.controller.support.generic.annotation.APIGeneric.APIGenericMethod.*;

/**
 * Generic Configuration.
 *
 * @author hungp
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class GenericConfiguration implements ImportAware, InitializingBean {

    @Nullable
    protected AnnotationAttributes enabledGeneric;

    private final RequestMappingHandlerMapping handlerMapping;

    protected String packageScan;

    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {
        this.enabledGeneric = AnnotationAttributes.fromMap(
                importMetadata.getAnnotationAttributes(EnabledGeneric.class.getName(), false));
        if (this.enabledGeneric == null) {
            throw new IllegalArgumentException(
                    "@EnabledGeneric is not present on importing class " + importMetadata.getClassName());
        }
        packageScan = enabledGeneric.getString(EnabledGeneric.SCAN_ATTRIBUTE);
        if (StringUtils.isEmpty(packageScan)) {
            AnnotatedGenericBeanDefinition configBeanDef = new AnnotatedGenericBeanDefinition(importMetadata);
            packageScan = resolveBasePackage(Objects.requireNonNull(configBeanDef.getBeanClassName()));
        }
    }

    /**
     * Resolve base package.
     *
     * @param beanClassName class name
     * @return package
     */
    private String resolveBasePackage(String beanClassName) {
        return beanClassName.lastIndexOf(".") > 0 ? beanClassName.substring(0, beanClassName.lastIndexOf(".")) : "";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        List<RequestMappingInfo> unregister = new LinkedList<>();
        if (null != enabledGeneric) {
            doScan(packageScan);

            handlerMapping.getHandlerMethods().forEach((requestMappingInfo, handlerMethod) -> {
                if (AnnotatedElementUtils.hasAnnotation(handlerMethod.getMethod(), APIGeneric.class)
                        && !checkHandlerMethod(handlerMethod)) {
                    log.info("Inactive API: " + requestMappingInfo.toString());
                    unregister.add(requestMappingInfo);
                }
            });
        } else {
            handlerMapping.getHandlerMethods().forEach((requestMappingInfo, handlerMethod) -> {
                if (AnnotatedElementUtils.hasAnnotation(handlerMethod.getMethod(), APIGeneric.class)) {
                    log.info("Inactive API: " + requestMappingInfo.toString());
                    unregister.add(requestMappingInfo);
                }
            });
        }
        unregister.forEach(handlerMapping::unregisterMapping);
    }

    public boolean checkHandlerMethod(HandlerMethod handlerMethod) {
        APIGeneric apiGeneric = AnnotatedElementUtils.findMergedAnnotation(handlerMethod.getMethod(), APIGeneric.class);
        GenericController genericController = AnnotatedElementUtils.findMergedAnnotation(handlerMethod.getBeanType(), GenericController.class);
        GenericDisabled genericDisabled = AnnotatedElementUtils.findMergedAnnotation(handlerMethod.getBeanType(), GenericDisabled.class);

        boolean valid = false;
        if (null != apiGeneric) {
            if (null != genericController) {
                valid = DELETE.equals(apiGeneric.genericMethod()) ||
                        (CREATE.equals(apiGeneric.genericMethod()) && !GenericController.None.class.equals(genericController.createRequest())) ||
                        ((READ_ONE.equals(apiGeneric.genericMethod()) || READ_ALL.equals(apiGeneric.genericMethod())) && !GenericController.None.class.equals(genericController.readResponse())) ||
                        ((UPDATE_ALL.equals(apiGeneric.genericMethod()) || UPDATE_PART.equals(apiGeneric.genericMethod())) && !GenericController.None.class.equals(genericController.updateRequest()));
            }

            if (valid && null != genericDisabled) {
                valid = (CREATE.equals(apiGeneric.genericMethod()) && !genericDisabled.create()) ||
                        (READ_ONE.equals(apiGeneric.genericMethod()) && !genericDisabled.read()) ||
                        (READ_ALL.equals(apiGeneric.genericMethod()) && !genericDisabled.readAll()) ||
                        (UPDATE_PART.equals(apiGeneric.genericMethod()) && !genericDisabled.updatePart()) ||
                        (UPDATE_ALL.equals(apiGeneric.genericMethod()) && !genericDisabled.updateAll()) ||
                        (DELETE.equals(apiGeneric.genericMethod()) && !genericDisabled.delete());
            }
        }
        return valid;
    }

    private void doScan(String packageScan) {
        Assert.notNull(packageScan, "Package scan must be not null");
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(GenericController.class));

        // Get ValidationConfiguration instance
        ValidationConfiguration validationConfiguration = ValidationConfiguration.getInstance();
        for (BeanDefinition bd : scanner.findCandidateComponents(packageScan)) {
            try {
                Class<?> beanClass = Class.forName(bd.getBeanClassName());
                log.info("Validation class: " + beanClass.getName());

                // validation configuration for each Generic Controller class
                validationConfiguration.validateConfiguration(beanClass);
            } catch (ClassNotFoundException e) {
                log.warn("Cannot found class {}", bd.getBeanClassName());
            }
        }
    }
}
