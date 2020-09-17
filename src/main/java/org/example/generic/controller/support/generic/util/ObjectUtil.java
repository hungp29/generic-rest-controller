package org.example.generic.controller.support.generic.util;

import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Object Util.
 *
 * @author hungp
 */
public class ObjectUtil {

    /**
     * Prevents new object util.
     */
    private ObjectUtil() {
    }

    /**
     * Get all fields of object.
     *
     * @param type         type of object
     * @param lookingSuper looking to super type
     * @return list field
     */
    public static List<Field> getFields(Class<?> type, boolean lookingSuper) {
        List<Field> fields = new ArrayList<>();
        if (null != type) {
            Class<?> checkingClass = type;
            do {
                fields.addAll(Arrays.asList(checkingClass.getDeclaredFields()));
                if (lookingSuper) {
                    checkingClass = checkingClass.getSuperclass();
                } else {
                    checkingClass = null;
                }
            } while (null != checkingClass);
        }
        return fields;
    }

    /**
     * Get all fields of object.
     *
     * @param type type of object
     * @return list field
     */
    public static List<Field> getFields(Class<?> type) {
        return getFields(type, true);
    }

    /**
     * Get field of object.
     *
     * @param type         type of object
     * @param fieldName    field name
     * @param lookingSuper flag to detect looking to super
     * @return the field of object
     */
    public static Field getField(Class<?> type, String fieldName, boolean lookingSuper) {
        if (null != type && !StringUtils.isEmpty(fieldName)) {
            Class<?> checkingClass = type;
            do {
                try {
                    return checkingClass.getDeclaredField(fieldName);
                } catch (NoSuchFieldException e) {
                    if (lookingSuper) {
                        checkingClass = checkingClass.getSuperclass();
                    } else {
                        checkingClass = null;
                    }
                }
            } while (null != checkingClass);
        }
        return null;
    }

    /**
     * Get field of object.
     *
     * @param type      type of object
     * @param fieldName field name
     * @return the field of object
     */
    public static Field getField(Class<?> type, String fieldName) {
        return getField(type, fieldName, true);
    }
}
