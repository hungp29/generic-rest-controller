package org.example.generic.controller.support.generic.annotation;

import org.example.generic.controller.support.generic.response.CreateResponse;
import org.example.generic.controller.support.generic.response.UpdateResponse;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

/**
 * Annotation {@link GenericController} specify the controller will be apply generic.
 *
 * @author hungp
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Controller
@ResponseBody
public @interface GenericController {

    @AliasFor(annotation = Controller.class)
    String value() default "";

    /**
     * Definition DTO request type for create method.
     *
     * @return DTO type of create method
     */
    Class<?> createRequest() default None.class;

    /**
     * Definition DTO response type for create method.
     *
     * @return DTO type of create method
     */
    Class<?> createResponse() default CreateResponse.class;

    /**
     * Definition DTO response type for read method.
     *
     * @return DTO type of read method
     */
    Class<?> readResponse() default None.class;

    /**
     * Definition DTO request type for update method.
     *
     * @return DTO type of update method
     */
    Class<?> updateRequest() default None.class;

    /**
     * Definition DTO response type for update method.
     *
     * @return DTO type of update method
     */
    Class<?> updateResponse() default UpdateResponse.class;

    /**
     * Default class.
     */
    class None {

    }
}
