package org.example.generic.controller.support.generic.proxy;

import lombok.extern.slf4j.Slf4j;
import org.example.generic.controller.support.generic.annotation.GenericController;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotatedElementUtils;

/**
 * Configuration Proxy. It create {@link AbstractAutoProxyCreator} to apply around advice
 * for controller has {@link GenericController} config.
 *
 * @author hungp
 */
@Slf4j
@Configuration
public class ProxyConfiguration {

    /**
     * Create {@link AbstractAutoProxyCreator} bean.
     *
     * @return {@link AbstractAutoProxyCreator} instance
     */
    @Bean
    public AbstractAutoProxyCreator autoProxyCreator() {
        return new AbstractAutoProxyCreator() {
            @Override
            protected Object[] getAdvicesAndAdvisorsForBean(Class<?> beanClass, String beanName,
                                                            TargetSource customTargetSource) throws BeansException {
                if (AnnotatedElementUtils.hasAnnotation(beanClass, GenericController.class)) {
                    log.debug("Apply proxy for Generic Controller " + beanName);
                    return new Object[]{genericAroundAdvice()};
                } else {
                    return DO_NOT_PROXY;
                }
            }
        };
    }

    /**
     * Create {@link GenericAroundAdvice} bean. It apply processing before and after call APIs.
     *
     * @return {@link GenericAroundAdvice} instance
     */
    @Bean
    public GenericAroundAdvice genericAroundAdvice() {
        return new GenericAroundAdvice();
    }
}
