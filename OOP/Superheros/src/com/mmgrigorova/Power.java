package com.mmgrigorova;

public class Power {
    private String name;
    private PowerType type;

    public Power(String name, PowerType type) {
        setName(name);
        setType(type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PowerType getType() {
        return type;
    }

    public void setType(PowerType type) {
        this.type = type;
    }
}
