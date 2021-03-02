package org.example;

import java.util.ArrayList;
import java.util.List;

// am integrat datele problemei din clasele Hotel, Museum,Church si Restaurant

public class App 
{
    public static void main( String[] args )
    {
     Hotel V1 = new Hotel();
     V1.setName("V1");
     Museum V2 = new Museum();
     V2.setName("V2");
     Museum V3 =  new Museum();
     V3.setName("V3");
     Church V4 = new Church();
     V4.setName("V4");
     Church V5 = new Church();
     V5.setName("V5");
     Restaurant V6 = new Restaurant();
     V6.setName("V6");
     // mapul pentru pentru tabelul de intervale din exemplu
     V1.addToCostMap(V2,10);
     V1.addToCostMap(V3,50);
     V2.addToCostMap(V3,20);
     V2.addToCostMap(V4,20);
     V2.addToCostMap(V5,10);
     V3.addToCostMap(V4,20);
     V4.addToCostMap(V5,30);
     V4.addToCostMap(V6,10);
     V5.addToCostMap(V6,20);
     // lista de locatii
     List<Location> Locations = new ArrayList<>();
     Locations.add(V1);
     Locations.add(V2);
     Locations.add(V3);
     Locations.add(V4);
     Locations.add(V5);
     Locations.add(V6);
     //am facut un oras, iar pentru orasul in cauza, am parcurs locatiile si am afisat tabelul printr-un enhanced for
     City Iasi = new City(Locations);
     for (Location location : Iasi.getCityLocations())
     {
      for(Location locationKey : location.getCostMap().keySet())
         {
             System.out.println(location.getName()+"->"+locationKey.getName() + "->" + location.getCostMap().get(locationKey));
         }
     }

    }
}
