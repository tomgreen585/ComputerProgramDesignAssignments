// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102/112 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP-102-112 - 2022T1, Assignment 4
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;
import java.awt.Color;

/** PatternsDrawer: 
 * Draws four different repetitive patterns. */

public class PatternsDrawer{

    public static final double LEFT = 50.0;   // Left side of the pattern
    public static final double TOP = 50.0;    // Top of the pattern
    public static final double SIZE = 300.0;  // The size of the pattern on the window

    /** 
     * Draws a row pattern consisting of a row of filled rectangles,
     *   alternating between the colours blue and orange
     * Asks the user for the number of rectangles.
     */
    public void drawRow(){
        UI.clearGraphics();
        double num = UI.askInt("How many rectangles:");
        double size = SIZE/num;
        int count = 0;
        int start = 0;
        
        for (int i = 0; i<num; i++) {
            double x = LEFT + i*size;
            UI.setColor(Color.black);
            UI.drawRect(LEFT+i*size, TOP, size, size);
            if (i%2==0){
                UI.setColor(Color.blue);
            }
            else {
                UI.setColor(Color.orange);
            }
            UI.fillRect(LEFT+i*size,TOP,size,size);
        }
}

    /** Draw a checkered board with alternating black and white squares
     *    Asks the user for the number of squares on each side
     *
     * CORE
     */
    public void drawDraughtsBoard(){
        UI.clearGraphics();
        UI.setColor(Color.black);
        int num = UI.askInt("How many rows:");

        for (int row = 0; row<num; row++) {
            for (int col = 0; col< num; col++) {
            int x = 20 * col;
            int y = 20 * row;
        
            if ((row%2)==(col%2))
                UI.setColor(Color.black);
            
            else 
                UI.setColor(Color.white);
            UI.fillRect(x+LEFT,y+TOP,20,20);
            }    
        }
        UI.setColor(Color.BLACK);
        UI.drawRect(LEFT,TOP, 20*num,20*num);
    }

    /** TriGrid
     * a triangular grid of squares that makes dark circles appear 
     * in the intersections when you look at it.
     *
     * COMPLETION
     */
    public void drawTriGrid(){
        UI.clearGraphics();
        UI.setColor(Color.black);
        int num = UI.askInt("How many rows:");
        /*# YOUR CODE HERE */
        double size = SIZE/num;
        double step = size/5;
        double square = size*4.0/5.0;
        
        for (int row = 0; row < num; row++) {
            double y = TOP+row*size;
            for (int col = 0; col < num-row; col++) {
                double x = LEFT + col*size;
                UI.fillRect(x,y,square,square);
            }
        }
    }

    public void setupGUI(){
        UI.initialise();
        UI.addButton("Clear",UI::clearPanes);
        UI.addButton("Core: row", this::drawRow);
        UI.addButton("Core: draughts", this::drawDraughtsBoard);
        UI.addButton("Completion: TriGrid", this::drawTriGrid);
        UI.addButton("Quit",UI::quit);
    }   

    public static void main(String[] arguments){
        PatternsDrawer pd = new PatternsDrawer();
        pd.setupGUI();
    }

}

