package org.example.generic.controller.support.generic;

import lombok.extern.slf4j.Slf4j;
import org.example.generic.controller.support.generic.annotation.GenericController;
import org.example.generic.controller.support.generic.exception.ConfigurationInvalidException;
import org.example.generic.controller.support.generic.util.GenericUtil;
import org.springframework.core.annotation.AnnotatedElementUtils;

import javax.persistence.Entity;

/**
 * Singleton class to validate configuration of Generic.
 *
 * @author hungp
 */
@Slf4j
public class ValidationConfiguration {

    private ValidationConfiguration() {
    }

    public static ValidationConfiguration getInstance() {
        return ValidationConfigurationHelper.INSTANCE;
    }

    private static class ValidationConfigurationHelper {
        private static final ValidationConfiguration INSTANCE = new ValidationConfiguration();
    }

    /**
     * Validate Configuration for Generic class.
     *
     * @param beanClass Controller class
     */
    public void validateConfiguration(Class<?> beanClass) {
        if (null != beanClass) {
            log.debug("Start validation configuration of class: " + beanClass.getName());
            if (AnnotatedElementUtils.hasAnnotation(beanClass, GenericController.class)) {
                if (!GenericRestController.class.isAssignableFrom(beanClass)) {
                    throw new ConfigurationInvalidException(String.format("%s must be extend %s class", beanClass.getName(), GenericRestController.class.getName()));
                } else if (null == GenericUtil.getGenericClass(beanClass)) {
                    throw new ConfigurationInvalidException(String.format("%s extends %s class, but don't define Generic Model", beanClass.getName(), GenericRestController.class.getName()));
                } else if (!AnnotatedElementUtils.hasAnnotation(GenericUtil.getGenericClass(beanClass), Entity.class)) {
                    throw new ConfigurationInvalidException(String.format("%s must be Entity class", GenericUtil.getGenericClass(beanClass)));
                }
            }
            log.debug("End validation configuration");
        }
    }
}
