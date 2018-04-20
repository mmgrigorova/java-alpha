package com.mmgrigorova;

public class Figure {
    protected String name;
    protected Position position;
    protected Color color;

    public Figure(String name){
        this.name = name;
        position = new Position('a',0);
    }

    public Figure(String name, char y, int x) {
        this.name = name;
        position = new Position(y,x);
    }

    public void isValidMovement(int currentRow, int currentCol, int nextRow, int nextCol){

    }

    public void takesFigure(){

    }
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
