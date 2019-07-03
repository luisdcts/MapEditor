package org.academiadecodigo.bootcamp.Cells.Pointer;

public class Position {

    private int row;
    private int col;


    public Position(int row, int col) {
        this.row = row;
        this.col = col;

    }

    public void moveUp(){
        row -=1;
    }

    public void moveDown(){
        row +=1;
    }

    public void moveRight(){
        col +=1;
    }

    public void moveLeft(){
        col -=1;
    }


    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }


}
