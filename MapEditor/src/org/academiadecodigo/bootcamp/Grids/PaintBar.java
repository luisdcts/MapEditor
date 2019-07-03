package org.academiadecodigo.bootcamp.Grids;

import org.academiadecodigo.bootcamp.Buttons.BarGridButton;
import org.academiadecodigo.bootcamp.Buttons.Buttons;
import org.academiadecodigo.bootcamp.Buttons.BarElipsesButton;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import java.util.ArrayList;

public class PaintBar {
    private final int PADDING = 10;
    private int height;
    private int width;
    private int x;
    private int y;
    private int cellSize;
    private Rectangle rectangle;
    private Rectangle rectangleInterior;
    private ArrayList<Rectangle> barButtonsPositions;
    private PaintBarButtons paintBarButtons;


    public PaintBar(int height, int width, int cellSize) {
        this.height = height;
        this.width = width;
        x=(width * cellSize) + (2 * PADDING);
        y = PADDING;
        this.cellSize = cellSize;
        rectangle = new Rectangle((width * cellSize) + (2 * PADDING), PADDING, 3 * cellSize, cellSize * height);
        rectangleInterior = new Rectangle((width * cellSize) + (2 * PADDING) - 1, PADDING - 1, 3 * cellSize, cellSize * height);
        paintBarButtons = new PaintBarButtons();
    }

    public void draw() {
        rectangle.draw();
        rectangleInterior.draw();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCellSize() {
        return cellSize;
    }

    public class PaintBarButtons {
        private static final int NUMBEROFBUTTONS = 10;

        private ArrayList<Buttons> buttonList;

        public PaintBarButtons() {
            barButtonsPositions = new ArrayList<>();
            buttonList = new ArrayList<>();
            create();
        }

        public void create() {
            int posX=(width * cellSize) + (2 * PADDING) - 1;;
            int posy;
            int posHeight = 3 * cellSize;
            int posWidth = (cellSize * height * 2) / NUMBEROFBUTTONS/2;

            for (int i = 0; i < NUMBEROFBUTTONS - 1; i++) {

                posy = cellSize * 2 * i + PADDING + (i * cellSize * 2);
                barButtonsPositions.add(new Rectangle( posX, posy, posHeight, posWidth));
                barButtonsPositions.get(i).draw();


                PaintBarButtonsOptions paintBarButtonsOption = PaintBarButtonsOptions.values()[i];

                switch (paintBarButtonsOption) {
                    case GRID:
                        buttonList.add(new BarGridButton(posX, posy, posHeight, posWidth));
                        break;
                    case Eraser:
                        barButtonsPositions.get(i).fill();
                        buttonList.add(new BarElipsesButton(posX, posy, posHeight, posWidth,Color.WHITE));
                        break;
                    case ELIPSEBLUE:
                        barButtonsPositions.get(i).setColor(new Color(100, 100, 100));
                        barButtonsPositions.get(i).fill();
                        buttonList.add(new BarElipsesButton(posX, posy, posHeight, posWidth,Color.BLUE));
                        break;
                    case ELIPSEGREEN:
                        barButtonsPositions.get(i).setColor(new Color(192, 192, 192));
                        barButtonsPositions.get(i).fill();
                        buttonList.add(new BarElipsesButton(posX, posy, posHeight, posWidth,Color.GREEN));
                        break;
                    case ELIPSERANDOM:
                        barButtonsPositions.get(i).setColor(new Color((int) (Math.random() * 256),(int) (Math.random() * 256),(int) (Math.random() * 256)));
                        barButtonsPositions.get(i).fill();
                        buttonList.add(new BarElipsesButton(posX, posy, posHeight, posWidth, new Color((int) (Math.random() * 256),(int) (Math.random() * 256),(int) (Math.random() * 256))));
                        break;
                    case DRAWRECTANGLE:
                         Rectangle drawRectangle =new Rectangle(posX + posHeight/4, posy + posWidth/4, posHeight/2, posWidth/2);
                         drawRectangle.setColor(Color.LIGHT_GRAY);
                         drawRectangle.fill();
                        break;
                    case DRAWELIPSE:
                        Ellipse drawEllipse =new Ellipse(posX + posHeight/5.5, posy + posWidth/5.5, posHeight/1.5, posWidth/1.5);
                        drawEllipse.setColor(Color.LIGHT_GRAY);
                        drawEllipse.fill();
                    case FILL:

                        break;
                        default:
                            break;

                }
            }
        }
    }

    public enum PaintBarButtonsOptions {
        GRID,
        Eraser,
        ELIPSEBLUE,
        ELIPSEGREEN,
        ELIPSERANDOM,
        DRAWRECTANGLE,
        DRAWELIPSE,
        FILL,
        aaaaaaa,
        bbbbbbb
    }

}