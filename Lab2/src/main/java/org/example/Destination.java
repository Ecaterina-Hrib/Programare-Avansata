package org.example;
//settere si gettere + toString(), identificatorii de acces corespunzatori
public class Destination {
    private String name;
    private Integer comodityDemands;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getComodityDemands() {
        return comodityDemands;
    }

    public void setComodityDemands(Integer comodityDemands) {
        this.comodityDemands = comodityDemands;
    }

    public Destination(String name, Integer comodityDemands) {
        this.name = name;
        this.comodityDemands = comodityDemands;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                ", comodityDemands=" + comodityDemands +
                '}';
    }
}
