package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Clasa TravelPlan contine un obiect de tip City si o lista cu preferinte</p>
 */
public class TravelPlan {

    public City oras;
    private List<Location> order = new ArrayList<>();


    public TravelPlan(City oras) {
        this.oras = oras;
    }

    public City getOras() {
        return oras;
    }

    public void setOras(City oras) {
        this.oras = oras;
    }

    public TravelPlan() {

    }

    public List<Location> getOrder() {
        return order;
    }

    public void setOrder(List<Location> ceva) {
        this.order = ceva;
    }

    /**
     * @param locatia1
     * @param locatia2 <p>Am folosit algortimul lui Bellman-Ford pentru shortest path intre 2 locatii</p>
     */
    public void myOrderAlgoritm(Location locatia1, Location locatia2) {
        int index1 = 0;
        int index2 = 0;
        int distance[] = new int[order.size()];
        int previous[] = new int[order.size()];
        int indice1 = 0, indice2 = 0;
        int tempDistance = 0;
        int p;
        for (int i = 0; i < order.size(); i++) {
            distance[i] = Integer.MAX_VALUE;
            if (order.get(i).getName().equals(locatia1.getName())) {
                index1 = i;
            }
            if (order.get(i).getName().equals(locatia2.getName())) {
                index2 = i;
            }
        }
        distance[index1] = 0;
        for (int i = 0; i < oras.getCityLocations().size(); i++) {
            for (int j = 0; j < oras.getCityLocations().get(i).getCost().size(); j++) {

                Location preference1 = oras.getCityLocations().get(i);
                Location preference2 = oras.getCityLocations().get(j);
                if (!preference1.equals(preference2)) {
                    try {
                        int cost = preference1.getCostInteger(preference2);


                        tempDistance = distance[j] + cost;
                        if (tempDistance < distance[i]) {
                            distance[i] = tempDistance;
                            previous[i] = j;

                        } else if (tempDistance == distance[i]) {
                            for (p = 0; p < order.size(); p++)
                                if (oras.CityLocations.get(previous[i]) == order.get(p)) {
                                    indice1 = p;

                                }
                            if (oras.CityLocations.get(j) == order.get(p)) {
                                indice2 = p;
                            }
                            if (indice1 < indice2) {
                                distance[i] = tempDistance;
                                previous[i] = indice1;
                            } else {
                                distance[i] = tempDistance;
                                previous[i] = indice2;
                            }
                        }
                    } catch (Exception e) {
                        continue;
                    }
                }
            }

        }

        System.out.println("Distanta de la " + locatia1.getName() + " catre " + locatia2.getName() + " este " + tempDistance);
    }


    @Override
    public String toString() {
        return "TravelPlan{" +
                "oras=" + oras +
                '}';
    }
}
