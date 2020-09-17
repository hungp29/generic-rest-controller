package org.example.generic.controller.support.generic;

import org.example.generic.controller.support.generic.util.ObjectUtil;
import org.springframework.core.annotation.AnnotatedElementUtils;

import javax.persistence.Id;
import java.lang.reflect.Field;

/**
 * Entity Information class.
 *
 * @author hungp
 */
public class EntityInformation {

    private Class<?> entityType;

    public EntityInformation(Class<?> entityType) {
        this.entityType = entityType;
    }

    public Field getIdAttribute() {
        return ObjectUtil.getFields(entityType).
                stream().filter(field -> AnnotatedElementUtils.hasAnnotation(field, Id.class)).
                findFirst().orElse(null);
    }
}
