package com.helgegudmundsen.whatthehack.barfinder.net;

import static org.junit.Assert.*;

import com.helgegudmundsen.whatthehack.barfinder.util.Config;
import org.junit.*;
/**
 * Class for spike testing calls to webservice
 */
public class CallWebServiceTest {

    @Test
    public void testCallWebService() {
        StringBuilder queryString = new StringBuilder();
        queryString.append(Config.getProperty("placesurl"));
        queryString.append("location=" + Config.getProperty("location"));
        queryString.append("&radius=" + Config.getProperty("radius"));
        queryString.append("&type=" + Config.getProperty("type"));
        queryString.append("&key=" + Config.getProperty("placesapikey"));
        System.out.println(queryString.toString());

        String json = WebService.executeService(queryString.toString());
        assertFalse("JSON should not be empty", json.equals(""));
    }
}
