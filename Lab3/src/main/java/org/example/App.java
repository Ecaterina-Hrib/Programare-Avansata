package org.example;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;


/**
 * <p>am integrat datele problemei din clasele Hotel, Museum,Church si Restaurant</p>
 */
public class App {
    public static void main(String[] args) {
        Hotel V1 = new Hotel();
        V1.setName("La Plaza");
        V1.setDescription(" este un hotel mirobolant ");

        Museum V2 = new Museum();
        V2.setName("Militar");

        Museum V3 = new Museum();
        V3.setName("Stiinte naturale");
        Church V4 = new Church();
        V4.setName("Sf Parascheva");
        V4.setOpeningTime(LocalTime.of(4, 0));
        Church V5 = new Church();
        V5.setOpeningTime(LocalTime.of(10, 0));
        V5.setClosingTime(LocalTime.MIDNIGHT);
        LocalTime close2 = V5.getClosingTime();
        LocalTime open2 = V5.getOpeningTime();
        V5.setDuration();
        V5.setName("Sfantul Dumitru");
        Restaurant V6 = new Restaurant();
        V6.setName("V6");
        Museum m = new Museum();
        m.setOpeningTime(LocalTime.of(9, 30));
        m.setClosingTime(LocalTime.parse("17:00"));
        m.setTicketPrice(20);
        Church c = new Church();
        c.setName("Sfantul Kamasis");
        c.setDescription(" este o locatie minunata");
        c.setOpeningTime(LocalTime.of(7, 0));
        c.setClosingTime(LocalTime.MIDNIGHT);
        LocalTime close = c.getClosingTime();
        LocalTime open = c.getOpeningTime();
        c.setDuration();

        Church V10 = new Church();
        V10.setName("Sfantul Dimitrie");
        V10.setDescription(" este o biserica cu o arhitectura foarte frumoasa");
        V10.setOpeningTime(LocalTime.of(9, 0));
        V10.setDescription(" este o biserica mirobolanta ");
        /**
         * <p>mapul pentru pentru tabelul de intervale din exemplu</p>
         */
        V1.addToCostMap(V2, 10);
        V1.addToCostMap(V3, 50);
        V2.addToCostMap(V3, 20);
        V2.addToCostMap(V4, 20);
        V2.addToCostMap(V5, 10);
        V3.addToCostMap(V2, 20);
        V3.addToCostMap(V4, 20);
        V4.addToCostMap(V5, 30);
        V4.addToCostMap(V6, 10);
        V5.addToCostMap(V4, 30);
        V5.addToCostMap(V6, 20);
        // lista de locatii
        List<Location> Locations = new ArrayList<>();
        Locations.add(V1);
        Locations.add(V2);
        Locations.add(V3);
        Locations.add(V4);
        Locations.add(V5);
        Locations.add(V6);
        //Locations.add(V10);
        Locations.add(c);
        List<Location> preferinte = new ArrayList<>();
        preferinte.add(V4);
        preferinte.add(V2);


        TravelPlan Student = new TravelPlan();


        System.out.println("Number of hours when the location " + c.getName() + " " + " is " + c.getDuration().toHours());
        System.out.println("Number of hours when the location " + V5.getName() + " " + " is " + V5.getDuration().toHours());
        System.out.println(" ");
        /**
         * <p>am facut un oras, iar pentru orasul in cauza, am parcurs locatiile si am afisat tabelul printr-un enhanced for</p>
         */
        City Iasi = new City(Locations);
        Iasi.VisitHour();
        System.out.println(" ");
        for (Location location : Iasi.getCityLocations()) {
            for (Location locationKey : location.getCost().keySet()) {
                System.out.println(location.getName() + " -> " + locationKey.getName() + " -> " + location.getCost().get(locationKey));
            }
        }
        System.out.println(" ");
        Student.setOras(Iasi);
        Student.setOrder(preferinte);
        Student.myOrderAlgoritm(V2, V4);

    }
}
