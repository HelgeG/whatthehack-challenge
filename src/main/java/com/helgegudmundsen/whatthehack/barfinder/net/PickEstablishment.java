package com.helgegudmundsen.whatthehack.barfinder.net;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.helgegudmundsen.whatthehack.barfinder.util.Config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Class to search google places for the best fit.
 * Created by helge on 03/06/2017.
 */
public class PickEstablishment {
    public Map<String, Object> searchGooglePlaces(String location)
            throws IOException {
        return parseResult(WebService.executeService(getQueryString(location).toString()));
    }

    private Map<String,Object> parseResult(String jsonResult)
            throws IOException {
        ArrayNode resultsNode = (ArrayNode) new ObjectMapper().readTree(jsonResult).get("results");
        List<Map<String, Object>> openEstablishments = getListOfOpenEstablishments(resultsNode);
        return getHighestRatedEstablishment(openEstablishments);
    }

    private Map<String,Object> getHighestRatedEstablishment(List<Map<String, Object>> openEstablishments) {
        if (openEstablishments.size() == 0) {
            return null;
        } else if (openEstablishments.size() == 1) {
            return openEstablishments.get(0);
        } else {
            int max_index = 0;
            int index = 0;
            double max_rating = 0.0;
            for (Map<String,Object> establishment : openEstablishments) {
                String rateString = (String) establishment.get("rating");
                double rate = (rateString.equals("")) ? 0.0 : Double.parseDouble(rateString);
                if (rate >= max_rating) {
                    max_index = index;
                    max_rating = rate;
                }
                index++;
            }
            return openEstablishments.get(max_index);
        }
    }

    private List<Map<String, Object>> getListOfOpenEstablishments(ArrayNode resultsNode) {
        List<Map<String, Object>> openEstablishments = new ArrayList<>();
        for (JsonNode result : resultsNode) {
            // Only consider establishments that are currently open
            if (result.path("opening_hours").path("open_now").asText().equals("true")) {
                Map<String, Object> resultMap = new HashMap<>();
                resultMap.put("name", result.path("name").asText());
                resultMap.put("rating", result.path("rating").asText());
                resultMap.put("address", result.path("vicinity").asText());
                resultMap.put("id", result.path("place_id").asText());
                resultMap.put("location", result.path("geometry").path("location").path("lat").asText()
                    + "," + result.path("geometry").path("location").path("lng").asText());
                openEstablishments.add(resultMap);
            }
        }
        return openEstablishments;
    }

    private StringBuilder getQueryString(String location) {
        StringBuilder queryString = new StringBuilder();
        queryString.append(Config.getProperty("placesurl"));
        queryString.append("location=").append(location.equals("") ? getLocation() : location);
        queryString.append("&radius=").append(Config.getProperty("radius"));
        queryString.append("&type=").append(Config.getProperty("type"));
        queryString.append("&key=").append(Config.getProperty("placesapikey"));
        return queryString;
    }

    private String getLocation() {
        return Config.getProperty("location");
    }
}
