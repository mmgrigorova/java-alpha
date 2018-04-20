package com.mmgrigorova;

public class Superhero extends Hero{

    public Superhero(String name, double weight, Gender gender, String secretIdentiy, String backStory, boolean
            isGood, boolean canFly) {
        super(name, weight, gender, secretIdentiy, backStory, isGood, canFly);
    }

    public void saveWorld(){}

    @Override
    public void addSuperpower(Power power){
        System.out.println("Adding super power for a super hero");
        superPowers.add(power);
    }

    @Override
    public boolean canFly() {
        return super.canFly();
    }

    public String toString(){
        return getName() + " is also " + getSecretIdentity();
    }


}
