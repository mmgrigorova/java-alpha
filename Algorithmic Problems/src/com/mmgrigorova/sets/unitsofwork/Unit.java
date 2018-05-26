package com.mmgrigorova.sets.unitsofwork;

public class Unit implements Comparable<Unit> {
    private String name;
    private String type;
    private int attack;

    public Unit(String name, String type, int attack) {
        setName(name);
        this.type = type;
        setAttack(attack);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!UnitsOfWork.unitsOfWork.containsKey(name)) {
            this.name = name;
        } else {
            System.out.printf("FAIL: %s already exists!\n", name);
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }


    @Override
    public int compareTo(Unit unitToCompare) {
        int attackComp = unitToCompare.getAttack() - this.getAttack();
        if (attackComp == 0) {
            return this.getName().compareTo(unitToCompare.getName());
        } else {
            return attackComp;
        }
    }

    @Override
    public String toString() {
        return String.format("%s[%s](%d)", getName(), getType(), getAttack());
    }
}
