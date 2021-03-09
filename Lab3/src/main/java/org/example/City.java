package org.example;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class City {
    // lista de locatii + settere, gettere si constructor
    List<Location> CityLocations = new ArrayList<>();

    public City(List<Location> cityLocations) {
        CityLocations = cityLocations;
    }

    public void setCityLocations(List<Location> cityLocations) {
        CityLocations = cityLocations;
    }

    public List<Location> getCityLocations() {
        return CityLocations;
    }

    /**
     * <p>Functia Visit Hour verifica daca o locatie este Visitable dar nu Payable, si in functie de ora, se sorteaza</p>
     */
    public void VisitHour() {
        List<Location> vizitabile = new ArrayList<>();
        for (int i = 0; i < this.CityLocations.size(); i++)
            if (CityLocations.get(i) instanceof Visitable)
                if (!(CityLocations.get(i) instanceof Payable)) {
                    vizitabile.add((CityLocations.get(i)));
                }
        vizitabile.sort(Comparator.comparing(Location::toString));
        for (int i = 0; i < vizitabile.size(); i++)
            System.out.println(vizitabile.get(i));
    }


    @Override
    public String toString() {
        return "City{" +
                "CityLocations=" + CityLocations +
                '}';
    }
}
