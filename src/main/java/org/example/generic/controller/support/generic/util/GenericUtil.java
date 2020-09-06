package org.example.generic.controller.support.generic.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Generic Util class.
 *
 * @author hungp
 */
@Slf4j
public class GenericUtil {

    private GenericUtil() {
    }

    /**
     * Get generic class type from index.
     *
     * @param type  class type
     * @param index index of generic
     * @return type of generic
     */
    public static Class<?> getGenericClass(Class<?> type, int index) {
        if (null != type && index >= 0) {
            try {
                Type[] types = ((ParameterizedType) type.getGenericSuperclass()).getActualTypeArguments();
                if (null != types && types.length > 0 && index < types.length) {
                    return (Class<?>) types[index];
                }
            } catch (ClassCastException e) {
                log.warn(String.format("%s can't get ParameterizedType", type.getName()));
            }
        }
        return null;
    }

    /**
     * Get generic class type by index 0.
     *
     * @param type class type
     * @return type of generic
     */
    public static Class<?> getGenericClass(Class<?> type) {
        return getGenericClass(type, 0);
    }

    /**
     * Get generic type of field by index.
     *
     * @param field the field of object
     * @param index the index of generic
     * @return type of generic
     */
    public static Class<?> getGenericField(Field field, int index) {
        if (null != field && index >= 0) {
            try {
                Type[] types = ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
                if (null != types && types.length > 0 && index < types.length) {
                    return (Class<?>) types[index];
                }
            } catch (ClassCastException e) {
                log.warn(String.format("%s can't get ParameterizedType", field.getName()));
            }
        }
        return null;
    }

    /**
     * Get generic type of field by index 0.
     *
     * @param field the field of object
     * @return type of generic
     */
    public static Class<?> getGenericField(Field field) {
        return getGenericField(field, 0);
    }

}
