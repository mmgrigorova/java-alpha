package com.mmgrigorova;

import java.awt.*;

public class Position extends Point {


    public Position(char y, int x) {
        switch (y) {
            case 'a': y = 1; break;
            case 'b': y = 2; break;
            case 'c': y = 3; break;
            case 'd': y = 4; break;
            case 'e': y = 5; break;
            case 'f': y = 6; break;
            case 'g': y = 7; break;
            case 'h': y = 8; break;
            default:y=1;
        }
        this.x = x;
        this.y = y;

    }
}
