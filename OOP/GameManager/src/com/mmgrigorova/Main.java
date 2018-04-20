package com.mmgrigorova;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	Power intelligence = new Power("Super intelligent");
	Power strenght = new Power("Super strong");
	Power canFly = new Power("Can fly");

	Superhero batman = new Superhero("Bruce Wayne", 109.5, Gender.MALE, "Batman", "Parents died",  true, false);
	batman.addSuperpower(strenght);

	Hero superman = new Superhero("Clark Kent", 89.0, Gender.MALE, "Superman", "Is not plane", true, true);
	superman.addSuperpower(canFly);

	Supervillain joker = new Supervillain("Brett Wallker", 90.9, Gender.MALE, "Joker", "Very bad", false, false );
	joker.addSuperpower(intelligence);


	Hero superTest = new Superhero("Bruce Wayne", 109.5, Gender.MALE, "Batman", "Parents died",  true, false);
	((Superhero) superTest).saveWorld();

	String batmanIdentity = batman.getSecretIdentity();
	ArrayList<Power> batmanPower = batman.getSuperPowers();
        System.out.printf("%s's power is %s.\n", batmanIdentity, batmanPower.get(0).getName());

        String batmanName =  batman.toString();
        System.out.println(batmanName);
    }
}
