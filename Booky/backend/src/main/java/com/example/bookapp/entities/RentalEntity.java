package com.example.bookapp.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RENTALS", schema = "STUDENT")
public class RentalEntity {


    private Integer id;
    private Integer itemId;
    private Integer clientId;
    private Date rentedDate;
    private Date returnedDate;

    @Id
    @Column(name = "ID_RENTAL")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ITEM_ID")
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "CLIENT_ID")
    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "RENTED_DATE")
    public Date getRentedDate() {
        return rentedDate;
    }

    public void setRentedDate(Date rentedDate) {
        this.rentedDate = rentedDate;
    }

    @Basic
    @Column(name = "RETURNED_DATE")
    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }
}
