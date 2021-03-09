package org.example;

import java.time.LocalTime;

public class Museum extends Location implements Visitable, Payable {
    /**
     * <p>clasa Museum implemeteaza clasa interfata Visitable,Payable pentru diferitele valori pe care le va avea obiectul de tip Museum</p>
     * <p> deoarece am considerat ca un obiect de tip Museum nu va fi clasificat intr-un anumit fel</p>
     */
    private LocalTime openingTime, closingTime;
    private double ticketPrice;

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
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }


}
