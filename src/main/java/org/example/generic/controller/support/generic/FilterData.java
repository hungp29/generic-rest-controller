package org.example.generic.controller.support.generic;

import lombok.Data;

import java.util.Map;

/**
 * Contain filter data for read method.
 */
@Data
public class FilterData {

    private String[] filter;
    private Map<String, String> params;

    public FilterData() {
    }

    public FilterData(String[] filter, Map<String, String> params) {
        this.filter = filter;
        this.params = params;
    }
}
