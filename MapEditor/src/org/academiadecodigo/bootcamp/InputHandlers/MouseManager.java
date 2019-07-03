package org.academiadecodigo.bootcamp.InputHandlers;

import org.academiadecodigo.bootcamp.Cells.Cell;
import org.academiadecodigo.bootcamp.MapEditor.MapEditor;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;



public class MouseManager implements MouseHandler{

    private Mouse mouse;
    private MouseEvent mouseEvent;
    private MapEditor mapEditor;

    public MouseManager(MapEditor mapEditor) {
        this.mapEditor = mapEditor;
        mouseEvent = new MouseEvent(100,1000,MouseEventType.MOUSE_CLICKED );
        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
            if(mouseEvent.getX()>mapEditor.getPaintBar().getX()&& mouseEvent.getX()<(mapEditor.getPaintBar().getX()+(3*mapEditor.getPaintBar().getCellSize()))) {
                for (Cell c:mapEditor.getGrid().getCells()) {

                    c.getRectangle().delete();
                }
                mapEditor.getGrid().clear();
                System.out.println("!!!!!!!!!!!");
            }
        System.out.println(mouseEvent.getX());

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
