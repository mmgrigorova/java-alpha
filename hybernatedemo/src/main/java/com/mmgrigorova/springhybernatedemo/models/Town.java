package com.mmgrigorova.springhybernatedemo.models;

import com.sun.tools.javah.Gen;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "towns")
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TownId")
    private int id;

    @Column(name = "Name")
    private String name;

//    @OneToMany(cascade = CascadeType.ALL,
//            mappedBy = "town")
//    private List<Address> addresses;

    public Town() {
    }

    public Town(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Address> getAddresses() {
//        return addresses;
//    }
//
//    public void setAddresses(List<Address> addresses) {
//        this.addresses = addresses;
//    }

    @Override
    public String toString() {
        return String.format("%d %s", id, name);
    }
}
