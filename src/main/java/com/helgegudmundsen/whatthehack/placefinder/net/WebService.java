package com.helgegudmundsen.whatthehack.placefinder.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

/**
 * Class to call a webservice and return the result
 */
public class WebService {
    static String executeService(String endpoint) {
        String json = "";
        try {
            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            json = br.lines().collect(Collectors.joining());
            conn.disconnect();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return json;
    }
}
