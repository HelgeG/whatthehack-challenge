# whatthehack-challenge

Repo for the Lisbon What The Hack Challenge 2017

Challenge selected:

`When I have to scroll over endless feeds when I'm in a new city
and just want to find a cool place to have a drink.`

## Idea for solution

Create a small web app that uses the current location, asks the person what 
they want to do (have a drink, get takeaway, go to a disco).

The app then does a location based search for the given activity, grabs the 
best result and presents it with directions for how to get there.

## Implementation details

Since I am an old fart, I will go against the grain and code the solution in Java.

The search will be done against Google Places, so I registered for an API key.

The app will look for bars in the vicinity of the current location, and return the open bar with the highest rating.

For the web server, the app will use the Spark framework, and it will use the Freemarker template engine.

Json parsing will be done with the Jackson framework.