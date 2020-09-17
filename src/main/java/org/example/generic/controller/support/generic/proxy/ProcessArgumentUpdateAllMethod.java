package org.example.generic.controller.support.generic.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static org.example.generic.controller.support.generic.annotation.APIGeneric.APIGenericMethod.UPDATE_ALL;

/**
 * Class extends {@link ProcessArgument} for Update All Method.
 *
 * @author hungp
 */
@Slf4j
@Component
public class ProcessArgumentUpdateAllMethod extends ProcessArgument {

    @Override
    public Object[] prepareArguments(Object[] args, Class<?> entityType, Class<?> controllerType) {
        if (null != args && args.length > 0) {
            return new Object[]{args[0], convertToDataTransferObject(args[1], getDTORequestType(controllerType, UPDATE_ALL))};
        }
        return args;
    }
}
