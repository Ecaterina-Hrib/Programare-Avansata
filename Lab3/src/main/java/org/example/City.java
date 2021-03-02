package org.example;

import java.util.ArrayList;
import java.util.List;

public class City {
    // lista de locatii + settere, gettere si constructor
    public City(List<Location> cityLocations) {
        CityLocations = cityLocations;
    }

    List<Location> CityLocations = new ArrayList<>();

    public List<Location> getCityLocations() {
        return CityLocations;
    }

    public void setCityLocations(List<Location> cityLocations) {
        CityLocations = cityLocations;
    }
}
