package com.mmgrigorova;

import java.util.ArrayList;

public abstract class Hero extends Person {
    protected String backStory;
    protected boolean isGood;
    protected boolean canFly;
    ArrayList<Power> superPowers;
    private String secretIdentity;

    public Hero(String name, double weight, Gender gender, String secretIdentiy, String backStory, boolean isGood,
                boolean canFly) {
        super(name, weight, gender);
        setSecretIdentity(secretIdentiy);
        setBackStory(backStory);
        setGood(isGood);
        this.canFly = canFly;
        superPowers = new ArrayList<>();
    }

    protected String getSecretIdentity() {
        return secretIdentity;
    }

    public void setSecretIdentity(String secretIdentity) {
        this.secretIdentity = secretIdentity;
    }

    public String getBackStory() {
        return backStory;
    }

    public void setBackStory(String backStory) {
        this.backStory = backStory;
    }

    public boolean isGood() {
        return isGood;
    }

    public void setGood(boolean good) {
        isGood = good;
    }

    public ArrayList<Power> getSuperPowers() {
        return superPowers;
    }

    public void setSuperPowers(ArrayList<Power> superPowers) {
        this.superPowers = superPowers;
    }

    public void addSuperpower(Power power) {
        System.out.println("Adding a super power to hero");
        superPowers.add(power);
    }

    public boolean canFly(){
        return canFly;
    }

}
