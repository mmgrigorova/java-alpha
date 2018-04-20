package com.mmgrigorova;

public class King extends Figure {

    public King(String name) {
        super(name, 'e', '8');
    }
    public King(String name, char y, int x) {
        super(name, y, x);
    }


    @Override
    public void isValidMovement(int currentRow, int currentCol, int nextRow, int nextCol) {
        super.isValidMovement(currentRow, currentCol, nextRow, nextCol);
    }

}
