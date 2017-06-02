package com.helgegudmundsen.whatthehack.placefinder.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.Assert.*;
import org.junit.*;
/**
 * Reads a file with Json results and parses it. Created by helge on 02/06/2017.
 */
public class JsonParseTest {
    @Test
    public void readResultsFromJson()
            throws IOException {
        String json = new String(Files.readAllBytes(Paths.get("result.json")), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(json);

        ArrayNode resultsNode = (ArrayNode) node.get("results");
        assertTrue("We should have four results here", resultsNode.size() == 4);
        for (JsonNode result : resultsNode) {
            System.out.println(result.path("name").asText());
            System.out.println(result.path("rating").asText());
            System.out.println(result.path("opening_hours").path("open_now").asText());
            System.out.println(result.path("geometry").path("location").path("lat").asText());
            System.out.println(result.path("geometry").path("location").path("lng").asText());
            System.out.println(result.path("vicinity").asText());
            System.out.println();


        }
    }
}
