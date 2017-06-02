package com.helgegudmundsen.whatthehack.placefinder.net;

import static org.junit.Assert.*;

import com.helgegudmundsen.whatthehack.placefinder.util.Config;
import org.junit.*;
/**
 * Class for spike testing calls to webservice
 */
public class CallWebServiceTest {

    @Test
    public void testCallWebService() {
        StringBuilder queryString = new StringBuilder();
        queryString.append(Config.getProperty("places-url"));
        queryString.append("location=" + Config.getProperty("location"));
        queryString.append("&radius=" + Config.getProperty("radius"));
        queryString.append("&type=" + Config.getProperty("type"));
        queryString.append("&key=" + Config.getProperty("api-key"));

        String json = WebService.executeService(queryString.toString());
        assertFalse("JSON should not be empty", json.equals(""));
    }
}
