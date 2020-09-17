package org.example.generic.controller.support.generic.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * Common Util class.
 *
 * @author hungp
 */
public class CommonUtil {

    /**
     * Prevents new {@link CommonUtil}.
     */
    private CommonUtil() {
    }

    /**
     * Convert map data to object.
     *
     * @param mapData map data
     * @param type    object class
     * @return new instance of object
     */
    public static Object convertMapToObject(Map<String, ?> mapData, Class<?> type) {
        if (null != mapData && null != type) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.convertValue(mapData, type);
        }
        return null;
    }
}
