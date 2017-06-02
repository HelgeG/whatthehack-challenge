package com.helgegudmundsen.whatthehack.placefinder.util;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * Make sure we can read from properties file. Created by helge on 02/06/2017.
 */
public class ConfigTest {
    @Test
    public void readAPIKeyFromPropertiesFile() {
        assertTrue("Key from properties should be AIzaSyBTOEpuX7ISgVz6d6jjJky139FN4NXs6UE",
                Config.getProperty("api-key").equals("AIzaSyBTOEpuX7ISgVz6d6jjJky139FN4NXs6UE"));
    }
}
