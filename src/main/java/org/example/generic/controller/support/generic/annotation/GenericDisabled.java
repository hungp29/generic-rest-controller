package org.example.generic.controller.support.generic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * To disabled non used generic API.
 *
 * @author hungp
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface GenericDisabled {

    boolean create() default false;

    boolean read() default false;

    boolean readAll() default false;

    boolean updatePart() default false;

    boolean updateAll() default false;

    boolean delete() default false;
}
