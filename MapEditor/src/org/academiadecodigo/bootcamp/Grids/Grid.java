package org.academiadecodigo.bootcamp.Grids;

import org.academiadecodigo.bootcamp.Cells.Cell;


import java.util.ArrayList;

public class Grid {
    private final int padding = 10;
    private int height;
    private int width;
    private int cellSize;
    private ArrayList<Cell> cells;
    private boolean painting;
    private boolean randomColor;

    public Grid(int height, int width, int cellSize) {
        this.height = height;
        this.width = width;
        this.cellSize = cellSize;
    }

    public void draw() {

        cells = new ArrayList<>();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells.add(new Cell(i, j, this));
            }
        }

        for (Cell c : cells) {
            //c.getRectangle().draw();
        }
    }


    public void clear() {
        for (Cell c : cells) {
            c.clear();
        }
    }

    public boolean isPainting() {
        return painting;
    }

    public void setPainting(boolean painting) {
        this.painting = painting;
    }

    public boolean isRandomColor() {
        return randomColor;
    }

    public void setRandomColor(boolean randomColor) {
        this.randomColor = randomColor;
    }

    public int getPadding() {
        return padding;
    }

    public int getCellSize() {
        return cellSize;
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void choseRandomColor() {

        int c1 = (int) (Math.random() * 256);
        int c2 = (int) (Math.random() * 256);
        int c3 = (int) (Math.random() * 256);
        for (Cell c : cells) {

            c.setColor(c1, c2, c3);

        }
    }
}
