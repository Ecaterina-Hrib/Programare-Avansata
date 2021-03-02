package org.example;

import java.util.HashMap;
import java.util.Map;

public abstract class Location {
    // obiectele sunt initializate prin nume, description si un Map pentru locatie si cost
    private String name;
    private String description;
    private Map<Location,Integer> costMap = new HashMap<>();

    public Map<Location, Integer> getCostMap() {
        return costMap;
    }
    public void addToCostMap(Location location, Integer cost){
        this.costMap.put(location,cost);

    }

    public void setCostMap(Map<Location, Integer> costMap) {
        this.costMap = costMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
