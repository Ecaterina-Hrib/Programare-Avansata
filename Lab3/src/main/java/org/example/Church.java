package org.example;

import java.time.Duration;
import java.time.LocalTime;


public class Church extends Location implements Visitable {
    private LocalTime openingTime, closingTime;
    private Duration duration;

    public Duration getDuration() {
        return duration;
    }

    /**
     * <p>Am folosit un obiect de tip Duration pentru a afla durata vizitabila </p>
     */
    public void setDuration() {
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
    public String toString() {
        return "Location with a opening time "
                + openingTime +
                " and a closing time " + closingTime + " : " + getName();

    }
}
