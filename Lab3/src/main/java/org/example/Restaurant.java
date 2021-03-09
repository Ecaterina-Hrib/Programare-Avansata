package org.example;

import java.time.Duration;
import java.time.LocalTime;

// clasa Restaurant include Visitable si Classifiable
public class Restaurant extends Location implements Visitable, Payable, Classifiable {
    private LocalTime openingTime, closingTime;
    private Duration duration;
    private double meniu;
    private int stars;

    public void setMeniu(double meniu) {
        this.meniu = meniu;
    }

    @Override
    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public double getMeniu() {
        return meniu;
    }

    public void setTicketPrice(double ticketPrice) {
        this.meniu = ticketPrice;
    }

    public void setMeniu(int meniu) {
        this.meniu = meniu;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = Visitable.getVisitingDuration(openingTime, closingTime);
    }

    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }


    @Override
    public double getTicketPrice() {
        return meniu;
    }
}
