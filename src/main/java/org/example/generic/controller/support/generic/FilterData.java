package org.example.generic.controller.support.generic;

import lombok.Data;

import java.util.Map;

/**
 * Contain filter data for read method.
 */
@Data
public class FilterData {

    private Class<?> responseDTOType;
    private String[] filter;
    private Map<String, String> params;

    public FilterData() {
    }

    public FilterData(Class<?> responseDTOType, String[] filter, Map<String, String> params) {
        this.responseDTOType = responseDTOType;
        this.filter = filter;
        this.params = params;
    }
}
