package com.mmgrigorova;

import java.util.ArrayList;

public class Superhero {
    private static final int ATTACK_POINTS = 10;
    private static final int MAX_LIFE_POINTS = 100;
    private String name;
    private String secretIdentity;
    private Alignment alignment;
    private int lifePoints;
    private ArrayList<Power> immunities;
    private ArrayList<Power> powers;



    public Superhero(String name) {
        setName(name);
    }


    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public Superhero(String name, String secretIdentity, Alignment alignment) {
        setName(name);
        setSecretIdentity(secretIdentity);
        setAlignment(alignment);
        lifePoints = MAX_LIFE_POINTS;
        immunities = new ArrayList<>();
        powers = new ArrayList<>();
    }

    public void setName(String name) {
        if (name.length() < 3 || name.length() > 100) {
            System.out.println("The super hero name should be between 3 and 100 characters");
        } else {
            this.name = name;
        }
    }

    public String getName(){
        return name;
    }

    public String getSecretIdentity() {
        return secretIdentity;
    }

    public void setSecretIdentity(String secretIdentity) {
        if (name.length() < 3 || name.length() > 100) {
            System.out.println("The super hero secret identity should be between 3 and 100 characters");
        } else {
            this.secretIdentity = secretIdentity;
        }
    }


    private int getLifePoints() {
        return lifePoints;
    }


    public void decreaseLifePoints(){
        lifePoints -= ATTACK_POINTS;
    }

    public ArrayList<Power> getImmunities() {
        return immunities;
    }

    public void addImmunities(Power immunity) {
        immunities.add(immunity);
    }

    public ArrayList<Power> getPowers() {
        return powers;
    }

    public void addPower(Power power) {
        powers.add(power);
    }

    public void attack(Superhero attackedHero, Power attackingPower){
        if(powers.contains(attackingPower)){
            System.out.printf("%s does not have this power and cannot attack.\n", getName());
        } else if (attackedHero.immunities.contains(attackingPower)){
            System.out.printf("%s is immuned to %s .\n",
                                    attackedHero.getName(),
                                    attackingPower.getName());
        } else {
            attackedHero.decreaseLifePoints();
            System.out.printf("%s has been attacked. He has %d life points left.\n", attackedHero.getSecretIdentity(),
                    attackedHero.getLifePoints());
        }
    }

}
