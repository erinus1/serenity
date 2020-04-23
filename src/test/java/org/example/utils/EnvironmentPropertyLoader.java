package org.example.utils;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.jbehave.core.steps.Steps;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class EnvironmentPropertyLoader extends Steps {

    public static String getProperty(final String propertyName) {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        EnvironmentSpecificConfiguration conf =  EnvironmentSpecificConfiguration.from(environmentVariables);

        String v = conf.getProperty(propertyName);

        return v;
    }
}
