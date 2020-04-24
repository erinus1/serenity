package org.example.utils;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.jbehave.core.steps.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnvironmentPropertyLoader extends Steps {
    private static Logger log = LoggerFactory.getLogger(EnvironmentPropertyLoader.class);

    private static EnvironmentPropertyLoader propertyLoader = null;


    public static String getProperty(final String propertyName) {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        EnvironmentSpecificConfiguration conf =  EnvironmentSpecificConfiguration.from(environmentVariables);

        String property = conf.getProperty(propertyName);

        return property;
    }
}