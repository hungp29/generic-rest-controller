package org.example.generic.controller.support.generic.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

import static org.example.generic.controller.support.generic.annotation.APIGeneric.APIGenericMethod.UPDATE_ALL;

/**
 * Annotation for mapping Update All.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@APIGeneric(method = RequestMethod.PUT, genericMethod = UPDATE_ALL)
public @interface APIUpdateAll {
    /**
     * Alias for {@link APIGeneric#name}.
     */
    @AliasFor(annotation = APIGeneric.class)
    String name() default "";

    /**
     * Alias for {@link APIGeneric#value}.
     */
    @AliasFor(annotation = APIGeneric.class)
    String[] value() default {};

    /**
     * Alias for {@link APIGeneric#path}.
     */
    @AliasFor(annotation = APIGeneric.class)
    String[] path() default {};

    /**
     * Alias for {@link APIGeneric#params}.
     */
    @AliasFor(annotation = APIGeneric.class)
    String[] params() default {};

    /**
     * Alias for {@link APIGeneric#headers}.
     */
    @AliasFor(annotation = APIGeneric.class)
    String[] headers() default {};

    /**
     * Alias for {@link APIGeneric#consumes}.
     */
    @AliasFor(annotation = APIGeneric.class)
    String[] consumes() default {};

    /**
     * Alias for {@link APIGeneric#produces}.
     */
    @AliasFor(annotation = APIGeneric.class)
    String[] produces() default {};
}
