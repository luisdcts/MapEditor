package org.academiadecodigo.bootcamp.MapEditor;

import org.academiadecodigo.bootcamp.Cells.Cell;
import org.academiadecodigo.bootcamp.Cells.Pointer.Pointer;
import org.academiadecodigo.bootcamp.Grids.Grid;
import org.academiadecodigo.bootcamp.Grids.PaintBar;
import org.academiadecodigo.bootcamp.InputHandlers.KeyboardManager;
import org.academiadecodigo.bootcamp.InputHandlers.MouseManager;
import org.academiadecodigo.bootcamp.SaveLoad.ReadWriteState;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MapEditor implements KeyboardHandler {
    private Grid grid;
    private Pointer pointer;
    private Keyboard keyboard;
    private PaintBar paintBar;



    public void init(int height, int width, int cellSize) {

        grid = new Grid(height, width, cellSize);
        grid.draw();
        pointer = new Pointer(grid);
        paintBar = new PaintBar( height,  width, cellSize);
        paintBar.draw();

        keyboard = new Keyboard(this);
        KeyboardManager.init(keyboard);
        new MouseManager(this);



    }

    public Grid getGrid() {
        return grid;
    }

    public PaintBar getPaintBar() {
        return paintBar;
    }

    public void save() {
        String saveGrid = "";
        for (Cell c : grid.getCells()) {
            if (c.isPainted()) {
                saveGrid += 1 + " ";
            } else {
                saveGrid += 0 + " ";
            }
        }
        saveGrid += "\n";
        for (Cell c : getGrid().getCells()) {
            saveGrid += c.getColorRed() + " " + c.getColorGreen() + " " + c.getColorBlue() + "\n";
        }
        ReadWriteState.save(saveGrid);
    }

    public void load() {

        String[] loadResultArray = ReadWriteState.load();
        String[] loadResultArrayPainted = loadResultArray[0].split(" ");


        if (loadResultArray != null) {
            String[] loadColorForEachCell;


            for (int i = 1; i < loadResultArrayPainted.length - 2; i++) {
                loadColorForEachCell = loadResultArray[i].split(" ");
                grid.getCells().get(i-1).setColor(Integer.valueOf(loadColorForEachCell[0]), Integer.valueOf(loadColorForEachCell[1]), Integer.valueOf(loadColorForEachCell[2]));
            }
            for (int i = 0; i < loadResultArrayPainted.length - 1; i++) {

                if (loadResultArrayPainted[i].contains("1")) {

                    grid.getCells().get(i).load(true);
                } else {
                    grid.getCells().get(i).load(false);
                }

            }

        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                pointer.move(Direction.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                pointer.move(Direction.DOWN);
                break;
            case KeyboardEvent.KEY_RIGHT:
                pointer.move(Direction.RIGHT);
                break;
            case KeyboardEvent.KEY_LEFT:
                pointer.move(Direction.LEFT);
                break;
            case KeyboardEvent.KEY_SPACE:
                pointer.paint();
                grid.setPainting(true);
                break;
            case KeyboardEvent.KEY_C:
                grid.clear();
                break;
            case KeyboardEvent.KEY_S:
                save();
                break;
            case KeyboardEvent.KEY_L:
                load();
                break;
            case KeyboardEvent.KEY_R:
                grid.choseRandomColor();
                grid.setRandomColor(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                grid.setPainting(false);
                break;
            case KeyboardEvent.KEY_R:
                grid.setRandomColor(false);
                break;
        }
    }
}

