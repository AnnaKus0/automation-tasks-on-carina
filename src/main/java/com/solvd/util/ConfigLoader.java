package com.solvd.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static final Logger logger = LoggerFactory.getLogger(ConfigLoader.class);
    private Properties properties;

    public ConfigLoader() {
        properties = new Properties();
        loadProperties();
    }

    private void loadProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                logger.error("Unable to find config.properties");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            logger.error("Error loading config.properties", ex);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
