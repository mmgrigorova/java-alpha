package com.mmgrigorova.springhybernatedemo.models;

import com.sun.tools.javah.Gen;

import javax.persistence.*;

@Entity
@Table(name = "towns")
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TownId")
    private int id;

    @Column(name = "Name")
    private String name;

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

    @Override
    public String toString() {
        return String.format("%d %s", id, name);
    }
}
