package org.academiadecodigo.bootcamp.Cells;

import org.academiadecodigo.bootcamp.Grids.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    private Rectangle rectangle;
    private int colorRed;
    private int colorGreen;
    private int colorBlue;
    private int tempoColorRed = 300;
    private int tempColorGreen = 300;
    private int tempColorBlue = 300;
    private boolean painted;

    public Cell(int col, int row, Grid grid) {
        rectangle = new Rectangle((col*grid.getCellSize())+grid.getPadding() , (row*grid.getCellSize())+grid.getPadding() ,grid.getCellSize(),grid.getCellSize());

        colorRed=0;
        colorGreen=255;
        colorBlue=255;

    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void changeColor(){
        if((tempColorGreen != 300)&&(tempColorBlue !=30)&&(tempoColorRed !=300)){
            colorRed=tempoColorRed;
            colorGreen=tempColorGreen;
            colorBlue=tempColorBlue;
        }
        if(!painted){
            rectangle.setColor(new Color(colorRed,colorGreen,colorBlue));
            rectangle.fill();
            painted = true;
            return;
        }
        rectangle.setColor(Color.BLACK);
        rectangle.draw();
        painted = false;
    }

    public void clear(){
        tempoColorRed=0;
        tempColorGreen=255;
        tempColorBlue=255;
        rectangle.setColor(Color.BLACK);
        rectangle.draw();
        painted = false;
    }

    public boolean isPainted() {
        return painted;
    }

    public void load(boolean value){
        if(value){
            painted = false;
            changeColor();
            return;
        }
        rectangle.draw();
        painted = false;
    }

    public void setColor(int red, int green, int blue) {
        tempoColorRed = red;
        tempColorGreen = green;
        tempColorBlue = blue;
    }


    public int getColorRed() {
        return colorRed;
    }

    public int getColorGreen() {
        return colorGreen;
    }

    public int getColorBlue() {
        return colorBlue;
    }
}
