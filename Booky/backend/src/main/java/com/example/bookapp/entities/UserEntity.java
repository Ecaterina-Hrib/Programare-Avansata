package com.example.bookapp.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USERS", schema = "STUDENT")
public class UserEntity implements Serializable {
    private long idUser;
    private String name;
    private String password;
    private long isAdmin;

    @Id
    @Column(name = "ID_USER")
    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Basic
    @Column(name = "IS_ADMIN")
    public long getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(long isAdmin) {
        this.isAdmin = isAdmin;
    }
}
