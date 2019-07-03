package org.academiadecodigo.bootcamp.Cells.Pointer;

import org.academiadecodigo.bootcamp.MapEditor.Direction;
import org.academiadecodigo.bootcamp.Grids.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Pointer {
    private Position position;
    private Grid grid;
    private Rectangle rectangle;
    private Color color = Color.ORANGE;


    public Pointer(Grid grid) {
        this.grid = grid;
        position = new Position((int) (Math.random() * grid.getWidth()), (int) (Math.random() * grid.getWidth()));
        rectangle = new Rectangle(position.getCol() * grid.getCellSize() + grid.getPadding(), position.getRow() * grid.getCellSize() + grid.getPadding(), grid.getCellSize(), grid.getCellSize());
        rectangle.setColor(color);
        rectangle.fill();

    }

    public void move(Direction direction) {

        switch (direction) {
            case UP:
                if (position.getRow() > 0) {

                    position.moveUp();
                    rectangle.translate(0, -grid.getCellSize());

                }
                break;

            case DOWN:
                if (position.getRow() < grid.getHeight() - 1) {
                    position.moveDown();
                    rectangle.translate(0, grid.getCellSize());

                }
                break;

            case RIGHT:
                if (position.getCol() < grid.getWidth() - 1) {
                    position.moveRight();
                    rectangle.translate(grid.getCellSize(), 0);

                }
                break;

            case LEFT:
                if (position.getCol() > 0) {
                    position.moveLeft();
                    rectangle.translate(-grid.getCellSize(), 0);

                }
                break;

        }

        if (grid.isPainting()) {
            paint();
        }
        if(grid.isRandomColor()){
            grid.choseRandomColor();
        }

    }

    public Position getPosition() {
        return position;
    }

    public void paint() {
        grid.getCells().get(position.getCol() * grid.getWidth() + position.getRow()).changeColor();

    }

}
