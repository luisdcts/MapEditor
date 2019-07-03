package org.academiadecodigo.bootcamp.Buttons;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;


public class BarElipsesButton implements Buttons {

    private Color color;
    private Ellipse ellipse;


    public BarElipsesButton(int posX, int posY, int height, int width , Color color) {
        this.color = color;
        ellipse = new Ellipse( posX+height/5.5,  posY+width/5.5,  height/1.5,  width/1.5);
        ellipse.setColor(color);
        ellipse.fill();
    }

    public Color getColor() {
        return color;
    }
}
