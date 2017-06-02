package com.helgegudmundsen.whatthehack.placefinder.core;

import static spark.Spark.*;

public class PlaceFinder {
    public static void main(String[] args) {
        get("/beer", (req, res) -> "Hello World, Time for a beer!");
    }
}