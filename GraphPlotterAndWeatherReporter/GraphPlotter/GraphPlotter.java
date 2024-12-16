// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102/112 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP-102-112 - 2022T1, Assignment 5
 * Name: Thomas Green
 * Username: greenthom
 * ID: 300536064
 */

import ecs100.*;
import java.awt.Color;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class GraphPlotter {

    // Constants for plotting the graph
    public static final double GRAPH_LEFT = 50;
    public static final double GRAPH_RIGHT = 550;
    public static final double GRAPH_BASE = 400;

    /**
     * Plot a graph of a sequence of numbers read from a file using +'s for each point.
     * The origin of the graph should be at (GRAPH_LEFT, GRAPH_BASE)
     * The method should ask the user for the name of a file that contains only numbers
     * It should then plot the numbers:
     *  - Draw two axes
     *  - Plot each number as a small +      eg, to plot at (x,y),
     *       draw a line from (x-2,y) to (x+2,y) and a line from (x,y-2) to (x,y+2)
     *  - The x value of the first point should be at GRAPH_LEFT, and
     *    the last point should be at GRAPH_RIGHT.
     *  - (ie, the points should be separated by (GRAPH_RIGHT - GRAPH_LEFT)/(number of points - 1)
     * Hints:
     *   look at the model answers for the Temperature Analyser problem from assignment 3.
     */
    public void plotGraph() {
        UI.drawLine(GRAPH_LEFT-2, GRAPH_BASE, GRAPH_RIGHT+2, GRAPH_BASE);
        UI.drawLine(GRAPH_LEFT, GRAPH_BASE-2, GRAPH_LEFT,(GRAPH_LEFT-(GRAPH_BASE)+2));
        double total = 0;
        try {
            String fileName = UIFileChooser.open("Choose File");
            List<String> allLines = Files.readAllLines(Path.of(fileName));
            for(String line : allLines) {
                if(line==line){
                    total=total+1;
                }
            }
            double step = (GRAPH_RIGHT - GRAPH_LEFT) / (total - 1);
            double x = GRAPH_LEFT;
            for(String line : allLines) {
                Scanner scan = new Scanner(line);
                double y = scan.nextDouble();
                double numOfPoints = Double.parseDouble(line);   
                x = x + step; 
                y = GRAPH_BASE - numOfPoints;
                UI.drawLine(x-2, y, x+2, y);
                UI.drawLine(x, y-2, x, y+2);
                }
        } catch(IOException e){UI.println("File reading failed");}
    }

    /** set up the buttons */
    public void setupGUI(){
        UI.addButton("Clear", UI::clearPanes);
        UI.addButton("Plot", this::plotGraph);
        UI.addButton("Quit", UI::quit);
        UI.setDivider(0.0);
    }

    public static void main(String[] args){
        GraphPlotter gp = new GraphPlotter();
        gp.setupGUI();
    }
}

