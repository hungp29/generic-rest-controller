package org.example.generic.controller.support.generic.annotation;

import org.example.generic.controller.support.generic.GenericConfigurationSelector;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation {@link EnabledGeneric} will active CRUD methods of classes have {@link GenericController} annotation.
 *
 * @author hungp
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(GenericConfigurationSelector.class)
public @interface EnabledGeneric {

    String SCAN_ATTRIBUTE = "scan";

    /**
     * Package to scan generic object
     *
     * @return package
     */
    String scan() default "";

    AdviceMode mode() default AdviceMode.PROXY;
}
