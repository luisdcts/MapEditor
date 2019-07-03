package org.academiadecodigo.bootcamp.Buttons;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;


import java.util.ArrayList;

public class BarGridButton implements Buttons {
    private final int numberOfRectanglesInGrid = 6;
    private int posX;
    private int posY;
    private int height;
    private int width;
    private ArrayList<Rectangle> grid;

    public BarGridButton(int posX, int posY, int height, int width) {
        this.posX = posX;
        this.posY = posY;
        this.height = height;
        this.width = width;
        grid = new ArrayList<>();
        createImage();
    }

    public void createImage() {
        int count = -1;
        for (int i = 0; i < numberOfRectanglesInGrid / 3; i++) {
            for (int j = 0; j < numberOfRectanglesInGrid / 2; j++) {
                grid.add(new Rectangle(posX + (i * height / (numberOfRectanglesInGrid / 3)), posY + 1.4 + (j * 1.3 * height / (numberOfRectanglesInGrid / 2)), height / (numberOfRectanglesInGrid / 3), width / (numberOfRectanglesInGrid / 2)));
                count++;
                grid.get(count).draw();
            }
        }
    }
}
