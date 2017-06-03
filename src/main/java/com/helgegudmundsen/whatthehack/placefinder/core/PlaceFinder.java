package com.helgegudmundsen.whatthehack.placefinder.core;

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
        //get("/beer", (req, res) -> "Hello World, Time for a beer!");

        try {
            Template lookForTemplate = config.getTemplate("lookfor.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> map = new HashMap<>();
            map.put("type", "Beer");
            lookForTemplate.process(map, writer);
            get("/beer", (request, response) -> writer);
        } catch (Exception e) {
            halt(500);
            e.printStackTrace();
        }
    }
}