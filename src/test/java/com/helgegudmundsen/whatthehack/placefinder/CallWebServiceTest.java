package com.helgegudmundsen.whatthehack.placefinder;

import com.helgegudmundsen.whatthehack.placefinder.net.WebService;
import static org.junit.Assert.*;
import org.junit.*;
/**
 * Class for spike testing calls to webservice
 */
public class CallWebServiceTest {
    @Test
    public void test() {
//        fail("Not yet implemented");
    }

    @Test
    public void testCallWebService() {
        String json = WebService.executeService("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=38.766111,%20-9.094942&radius=500&type=bar&key=AIzaSyBTOEpuX7ISgVz6d6jjJky139FN4NXs6UE");
        assertFalse("JSON should not be empty", json.equals(""));
    }
}
