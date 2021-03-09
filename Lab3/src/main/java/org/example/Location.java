package org.example;

import java.util.*;

public abstract class Location implements Comparable<Location> {
    /**
     * <p>obiectele sunt initializate prin nume, description si un Map pentru locatie si cost</p>
     */
    private String name;
    private String description;
    private Map<Location, Integer> cost = new HashMap<>();

    public Location() {

    }

    public Location(String name, String description, Map<Location, Integer> cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public Map<Location, Integer> getCost() {
        return cost;
    }

    public void addToCostMap(Location location, Integer cost) {
        this.cost.put(location, cost);

    }

    public int getCostInteger(Location ceva) {
        return cost.get(ceva);
    }

    public void setCost(Map<Location, Integer> cost) {
        this.cost = cost;
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

    public void setCost(Location node, int value) {
        cost.put(node, value);
    }

    @Override
    public int compareTo(Location other) {
        return this.name.compareTo(other.name);
        //not safe, check if name is null before
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", costMap=" + cost +
                '}';
    }
}
