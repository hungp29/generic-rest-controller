package org.example.generic.controller.support.generic.proxy;

import lombok.extern.slf4j.Slf4j;
import org.example.generic.controller.support.generic.FilterData;
import org.example.generic.controller.support.generic.exception.GenericException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static org.example.generic.controller.support.generic.annotation.APIGeneric.APIGenericMethod.READ_ONE;

/**
 * Class extends {@link ProcessArgument} for Read One Method.
 *
 * @author hungp
 */
@Slf4j
@Component
public class ProcessArgumentReadOneMethod extends ProcessArgument {

    @Override
    public Object[] prepareArguments(Object[] args, Class<?> entityType, Class<?> controllerType) {
        if (null != args && args.length > 0 && null != entityType) {
            HttpServletRequest request = getHttpServletRequest(args);
            if (null != request) {
                // Filter field array
                String[] filter = getFilterFields(request);
                // Map params
                Map<String, String> params = getParameters(request);
                FilterData filterData = new FilterData(getDTOResponseType(controllerType, READ_ONE), filter, params);

                return new Object[]{args[0], filterData};
            } else {
                throw new GenericException("Cannot find HttpServletRequest in array arguments of method");
            }
        }
        return args;
    }
}
