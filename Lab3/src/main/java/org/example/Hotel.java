package org.example;

import java.time.LocalTime;
import java.util.Map;

// clasa hotel implemeteaza clasa interfata Visitable,Payable,Classifiable pentru diferitele valori pe care le va avea obiectul de tip Hotel
public class Hotel extends Location implements Visitable,Payable,Classifiable{
    private LocalTime openingTime, closingTime;
    private double ticketPrice;
    private int stars;
  public Hotel()
  {

  }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public int getStars() {
        return stars;
    }

    public Hotel(String name, String description, Map<Location, Integer> cost, LocalTime openingTime, LocalTime closingTime, double ticketPrice) {
        super(name, description, cost);
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.ticketPrice = ticketPrice;
    }

    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }
    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }


    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }
}
