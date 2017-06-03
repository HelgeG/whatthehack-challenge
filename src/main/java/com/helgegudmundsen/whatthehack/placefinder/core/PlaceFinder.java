package com.helgegudmundsen.whatthehack.placefinder.core;

import com.helgegudmundsen.whatthehack.placefinder.net.PickEstablishment;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class PlaceFinder {
    public static void main(String[] args) {
        Configuration config = new Configuration(Configuration.VERSION_2_3_26);
        config.setClassForTemplateLoading(PlaceFinder.class, "/");

        try {
            get("/beer", (request, response) -> {
                Template lookForTemplate = config.getTemplate("lookfor.ftl");
                StringWriter writer = new StringWriter();
                Map<String, Object> map = new HashMap<>();
                map.put("type", "Beer");
                lookForTemplate.process(map, writer);
                return writer;
            });
            post("/find", (request, response) -> {
                Template lookForTemplate;
                StringWriter writer = new StringWriter();
                Map<String, Object> map = new PickEstablishment().searchGooglePlaces();
                if (map == null) {
                    lookForTemplate = config.getTemplate("no_result.ftl");
                } else {
                    lookForTemplate = config.getTemplate("result.ftl");
                }
                lookForTemplate.process(map, writer);
                return writer;
            });

        } catch (Exception e) {
            halt(500);
            e.printStackTrace();
        }
    }
}