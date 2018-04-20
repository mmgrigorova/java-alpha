package com.mmgrigorova;

public class Queen extends Figure {

    public Queen(String name, char y, int x) {
        super(name, y, x);
    }

    @Override
    public void isValidMovement(int currentRow, int currentCol, int nextRow, int nextCol) {
        super.isValidMovement(currentRow, currentCol, nextRow, nextCol);
    }
}
