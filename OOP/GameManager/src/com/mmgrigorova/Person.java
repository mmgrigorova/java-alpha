package com.mmgrigorova;

public class Person {
    private String name;
    protected double weight;
    protected Gender gender;

    public Person(String name, double weight, Gender gender) {
        setName(name);
        setWeight(weight);
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Gender getGender() {
        return gender;
    }
}
