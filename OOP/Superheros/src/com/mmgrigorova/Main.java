package com.mmgrigorova;

import com.mmgrigorova.Superhero;
import com.mmgrigorova.Power;
import com.mmgrigorova.PowerType;
import com.mmgrigorova.Alignment;


public class Main {

    public static void main(String[] args) {

        Power intelligence = new Power("Intelligence", PowerType.INTELLECT);
        Power kryptonite = new Power("Kryptonite", PowerType.CHEMICAL);
        Power invisibility = new Power("Invisibility", PowerType.OTHER);
        Power aiming = new Power("Aiming", PowerType.OTHER);
        Power java = new Power("Java Programming", PowerType.TECH);




        Superhero superman = new Superhero("Clark Kent", "Superman", Alignment.GOOD);
        superman.addImmunities(kryptonite);
        superman.addPower(aiming);
        superman.addPower(intelligence);

        Superhero batman = new Superhero("Bruce Wayne", "Batman", Alignment.NEUTRAL);
        batman.addPower(aiming);

        Superhero spiderman = new Superhero("Peter Parker", "Spiderman", Alignment.GOOD);
        spiderman.addPower(invisibility);

        Superhero villain = new Superhero("Cruela Devil", "Cruela", Alignment.EVIL);
        villain.addPower(intelligence);

        Superhero javaNinja = new Superhero("Telerik Student", "Java Ninja", Alignment.GOOD);
        javaNinja.addPower(java);
        javaNinja.addImmunities(intelligence);
        javaNinja.addImmunities(kryptonite);
        javaNinja.addImmunities(aiming);
        javaNinja.addImmunities(invisibility);

        batman.attack(spiderman,kryptonite);
        villain.attack(javaNinja,intelligence);
        spiderman.attack(javaNinja, aiming);

    }
}
