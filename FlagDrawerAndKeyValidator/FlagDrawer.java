// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102/112 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP-102-112 - 2022T1, Assignment 2
 * Name: Thomas Green
 * Username:greenthom
 * ID:300536064
 */

import ecs100.*;
import java.awt.Color;

/**
 * Draws various flags
 *
 * You can find lots of flag details (including the correct dimensions and colours)
 * from  http://www.crwflags.com/fotw/flags/    
 */

public class FlagDrawer{

    public static final double LEFT = 100;  // the left side of the flags
    public static final double TOP = 50;    // the top of the flags

    /**   CORE
     * Draw the flag of Belgium.
     * The flag has three vertical stripes;
     * The left is black, the middle is yellow, and the right is red.
     * The flag is 13/15 as high as it is wide (ratio 13:15).
     */
    public void drawBelgiumFlag(){
        UI.clearGraphics();
        UI.println("Belgium Flag");
        double width = UI.askDouble("How wide: ");
        /*# YOUR CODE HERE */
        double height = width * 13/15;
        double widthStripe = width / 3;
        UI.setColor(Color.black);
        UI.drawRect(LEFT, TOP, width, height);
        UI.fillRect(LEFT + widthStripe * 0/3, TOP, widthStripe, height);
        
        
        //right
        UI.setColor(Color.yellow);
        UI.drawRect(LEFT + widthStripe * 3/3, TOP, widthStripe, height);
        UI.fillRect(LEFT + widthStripe * 3/3, TOP, widthStripe * 1, height);
        
        //left
        UI.setColor(Color.red);
        UI.drawRect(LEFT + widthStripe * 2, TOP, widthStripe, height);
        UI.fillRect(LEFT + widthStripe * 2, TOP, widthStripe * 1, height);
        
        
        
    }

    /**   CORE
     *  The Red Cross flag consists of a white square with a red cross in the center
     *  The cross can be drawn as a horizontal rectangle and a vertical rectangle.
     */
    public void drawRedCrossFlag() {
        UI.println("Red Cross Flag: ");
        UI.clearGraphics();
        double size = UI.askDouble("How wide: ");
        /*# YOUR CODE HERE */
        double height = size * 1;
        double sizeStripe = size * 1;
        
        //outline
        UI.setColor(Color.black);
        UI.drawRect(LEFT, TOP, size, height);
        
        //down
        UI.setColor(Color.red);
        UI.fillRect(LEFT * 1.4, TOP + sizeStripe * 0.2, sizeStripe * 0.2, height * 0.6);
        
        //across
        double heightStripe = height * 1;
        UI.setColor(Color.red);
        UI.fillRect(LEFT + sizeStripe * 0.2, TOP * 1.8, sizeStripe * 0.2, height * 0.2);
        
        //across dos
        UI.setColor(Color.red);
        UI.fillRect(LEFT + sizeStripe * 0.6, TOP * 1.8, sizeStripe * 0.2, height * 0.2);
        
        
        
        
        

    }

    /**   COMPLETION
     *  Pacman
     *  A red pacman facing up on a black background chasing yellow, green, and blue dots.
     *  
     */
    public  void drawPacman() {
        UI.clearGraphics();        
        UI.println("Pacman Flag");
        double width = UI.askDouble("How wide: ");
        /*# YOUR CODE HERE */
        double height = width * 4 / 3;
        double heightStripe = height / 4;
        UI.setColor(Color.black);
        UI.drawRect(LEFT, TOP, width, height);
        UI.fillRect(LEFT, TOP, width, height);
        
        //draw pacman
        UI.setColor(Color.RED);
        UI.fillOval(LEFT * 1.25, TOP * 2.5, width * 0.5, heightStripe * 1.4);
        
        //mouth
        UI.setColor(Color.black);
        UI.fillArc(LEFT * 1.25, TOP * 2.5, width * 0.5, heightStripe, 50, 80); 
        
        //numero uno
        UI.setColor(Color.yellow);
        UI.fillOval(LEFT * 1.39, TOP * 2.2, width * 0.2, heightStripe * 0.5);
        
        //numero dos
        UI.setColor(Color.green);
        UI.fillOval(LEFT * 1.39, TOP * 1.7, width * 0.2, heightStripe * 0.5);
        
        //numero tres
        UI.setColor(Color.blue);
        UI.fillOval(LEFT * 1.39, TOP * 1.2, width * 0.2, heightStripe * 0.5);
        

    }

    /**   COMPLETION
     * Draw the flag of Greenland.
     * The top half of the flag is white, and the bottom half is red.
     * There is a circle in the middle (off-set to left)  which is
     * also half white/red but on the opposite sides.
     * The flag is 2/3 as high as it is wide (ratio 2:3).
     */
    public void drawGreenlandFlag() {
        UI.clearGraphics();
        UI.println("Greenland Flag");
        double width = UI.askDouble("How wide: ");
        /*# YOUR CODE HERE */
        double height = width * 2 / 3;
        double heightStripe = height / 2;
        UI.drawRect(LEFT, TOP, width, heightStripe); //rectangle
        
        //fill color red bottom half
        UI.setColor(Color.RED);
        UI.fillRect(LEFT, TOP + heightStripe * 1, width, heightStripe);//bottom red
        
        //draw circle
        UI.setColor(Color.WHITE);
        UI.fillOval(LEFT * 1.1, TOP * 1.3, width * 0.4, heightStripe);
        
        //colour correct
        UI.setColor(Color.RED);
        UI.fillArc(LEFT * 1.1, TOP * 1.31, width * 0.4, heightStripe, 360, 180);
        
        //Outline
        UI.setColor(Color.BLACK);
        UI.drawRect(LEFT, TOP, width, height);

    }

    /**  CHALLENGE
     *  The Jamaican flag has a yellow diagonal cross with 
     *  green triangles top and bottom, and black triangles left and right.
     */
    public void drawJamaicaFlag(){
        UI.clearGraphics();
        UI.println("Flag of Jamaica");
        double width = UI.askDouble("How wide: ");
        /*# YOUR CODE HERE */
        double height = width * 2 / 3;
        double heightStripe = height * 1;
        UI.drawRect(LEFT, TOP, width, heightStripe); //rectangle
        
        //draw cross line
        UI.setColor(Color.yellow);
        UI.setLineWidth(10);
        UI.drawLine(LEFT * 0, TOP * 0, LEFT * 2.7, TOP * 3);
        
        //draw top triangle
        UI.setColor(Color.green);
    
        
        
        
        
        
        
        
        
      

        

    }

    /**   CHALLENGE
     * The 3 stars flag has a blue vertical stripe on the left and black
     * vertical stripe on the right and 3 red 5 pointed stars in the middle stripe
     * The height is 2/3 of the width,
     * A full marks solution will have a method for drawing a 5 pointed star,
     * and call that method for each of the stars
     */
    public void drawThreeStarsFlag() {
        UI.clearGraphics();        
        UI.println("Three stars Flag");
        double width = UI.askDouble("How wide: ");
        /*# YOUR CODE HERE */

    }


    public void setupGUI(){
        UI.addButton("Clear", UI::clearPanes);
        UI.addButton("Core: Flag of Belgium", this::drawBelgiumFlag);
        UI.addButton("Core: Red Cross Flag",  this::drawRedCrossFlag);
        // COMPLETION
        UI.addButton("Completion: Pacman Flag", this::drawPacman);
        UI.addButton("Completion: Flag of Greenland", this::drawGreenlandFlag);
        // CHALLENGE
        UI.addButton("Challenge: Flag of Jamaica", this::drawJamaicaFlag);
        UI.addButton("Challenge: Three stars flag", this::drawThreeStarsFlag);
        UI.addButton("Quit", UI::quit);

        UI.setDivider(0.3);
    }

    public static void main(String[] arguments){
        FlagDrawer fd = new FlagDrawer();
        fd.setupGUI();
    }

}
