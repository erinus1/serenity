package org.restAssuredBDD.utils;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnvironmentPropertyLoader {
    private static Logger log = LoggerFactory.getLogger(EnvironmentPropertyLoader.class);
    public EnvironmentSpecificConfiguration conf;

    private static EnvironmentPropertyLoader single_instance = null;

    private EnvironmentPropertyLoader() {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        conf = EnvironmentSpecificConfiguration.from(environmentVariables);
    }

    public static String getProperty(String propertyName) {
        if (single_instance == null) {
            single_instance = new EnvironmentPropertyLoader();
            log.info("Used env: "+ single_instance);
        }
        return single_instance.conf.getProperty(propertyName);
    }
}