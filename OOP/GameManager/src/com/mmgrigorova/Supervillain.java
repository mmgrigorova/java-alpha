package com.mmgrigorova;

public class Supervillain extends Hero{
    public Supervillain(String name, double weight, Gender gender, String secretIdentiy, String backStory, boolean
            isGood, boolean canFly) {
        super(name, weight, gender, secretIdentiy, backStory, isGood, canFly);
    }

    public void destroy(){}

    @Override
    public void addSuperpower(Power power){
        System.out.println("Adding power for a villain.");
        super.addSuperpower(power);
        superPowers.add(power);
    }
}
