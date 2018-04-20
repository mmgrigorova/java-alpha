package com.mmgrigorova;

public class Bishop extends Figure {

    public Bishop(String name, char y, int x) {
        super(name, y, x);
    }

    @Override
    public void isValidMovement(int currentRow, int currentCol, int nextRow, int nextCol) {
        super.isValidMovement(currentRow, currentCol, nextRow, nextCol);
    }
}
