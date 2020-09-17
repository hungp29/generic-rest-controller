package org.example.generic.controller.support.generic.proxy;

import lombok.extern.slf4j.Slf4j;
import org.example.generic.controller.support.generic.FilterData;
import org.example.generic.controller.support.generic.Pagination;
import org.example.generic.controller.support.generic.exception.GenericException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static org.example.generic.controller.support.generic.annotation.APIGeneric.APIGenericMethod.READ_ALL;

/**
 * Class extends {@link ProcessArgument} for Read All Method.
 *
 * @author hungp
 */
@Slf4j
@Component
public class ProcessArgumentReadAllMethod extends ProcessArgument {

    @Override
    public Object[] prepareArguments(Object[] args, Class<?> entityType, Class<?> controllerType) {
        if (null != args && args.length > 0) {
            HttpServletRequest request = getHttpServletRequest(args);
            if (null != request) {
                // Pagination info
                Sort sort = getSortRequest(request);
                Pageable pageable = getPageRequest(request, sort);
                Pagination pagination = new Pagination(pageable, sort);

                // Filter field array
                String[] filter = getFilterFields(request);
                // Map params
                Map<String, String> params = getParameters(request);
                FilterData filterData = new FilterData(getDTOResponseType(controllerType, READ_ALL), filter, params);
                return new Object[]{filterData, pagination};
            } else {
                throw new GenericException("Cannot find HttpServletRequest in array arguments of method");
            }
        }
        return args;
    }
}
