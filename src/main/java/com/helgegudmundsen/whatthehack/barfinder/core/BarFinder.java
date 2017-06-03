package com.helgegudmundsen.whatthehack.barfinder.core;

import com.helgegudmundsen.whatthehack.barfinder.net.PickEstablishment;
import com.helgegudmundsen.whatthehack.barfinder.util.Config;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class BarFinder {
    public static void main(String[] args) {
        Configuration config = new Configuration(Configuration.VERSION_2_3_26);
        config.setClassForTemplateLoading(BarFinder.class, "/");
        try {
            get("/", (request, response) -> {
                Template lookForTemplate = config.getTemplate("lookfor.ftl");
                StringWriter writer = new StringWriter();
                Map<String, Object> map = new HashMap<>();
                String mapsApiKey = Config.getProperty("mapsapikey");
                map.put("mapsapikey", mapsApiKey);
                lookForTemplate.process(map, writer);
                return writer;
            });

            get("/beer", (request, response) -> {
                final String location = request.queryParams("lat") + "," + request.queryParams("long");
                StringWriter writer = new StringWriter();
                Map<String, Object> map = new PickEstablishment().searchGooglePlaces(location);
                Template resultTemplate;
                if (map == null) {
                    resultTemplate = config.getTemplate("no_result.ftl");
                } else {
                    resultTemplate = config.getTemplate("result.ftl");
                }
                resultTemplate.process(map, writer);
                return writer;
            });

            get("/directions", (request, response) -> {
                final String id = request.queryParams("id");
                request.queryParams("long");
                StringWriter writer = new StringWriter();
                Map<String, Object> map = new HashMap<>();
                String mapsApiKey = Config.getProperty("mapsapikey");
                map.put("mapsapikey", mapsApiKey);
                map.put("id", id);
                Template directionTemplate;
                directionTemplate = config.getTemplate("directions.ftl");
                directionTemplate.process(map, writer);
                return writer;
            });

        } catch (Exception e) {
            halt(500);
            e.printStackTrace();
        }
    }
}