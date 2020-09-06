package org.example.generic.controller.support.generic;

import org.example.generic.controller.support.generic.annotation.EnabledGeneric;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.AdviceModeImportSelector;

/**
 * Generic Configuration Selector.
 *
 * @author hungp
 */
public class GenericConfigurationSelector extends AdviceModeImportSelector<EnabledGeneric> {

    @Override
    protected String[] selectImports(AdviceMode adviceMode) {
        return new String[]{GenericConfiguration.class.getName()};
    }
}
