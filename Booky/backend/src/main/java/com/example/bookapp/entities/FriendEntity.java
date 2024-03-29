package com.example.bookapp.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FRIENDS", schema = "STUDENT")
public class FriendEntity implements Serializable {
    @Id
    private Long idFriendship;
    private Long id1;
    private Long id2;
    @Basic
    @Column(name = "ID_FRIENDSHIP")
    public Long getIdFriendship() {
        return idFriendship;
    }

    public void setIdFriendship(Long idFriendship) {
        this.idFriendship = idFriendship;
    }

    @Basic
    @Column(name = "ID1")
    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }

    @Basic
    @Column(name = "ID2")
    public Long getId2() {
        return id2;
    }

    public void setId2(Long id2) {
        this.id2 = id2;
    }


}
