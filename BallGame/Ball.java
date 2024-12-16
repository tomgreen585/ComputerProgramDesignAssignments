// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102/112 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP-102-112 - 2022T1, Assignment 6
 * Name: Thomas Green
 * Username: greenthom
 * ID: 300536064
 */

import ecs100.*;
import java.awt.Color;

/** Ball represents a ball that is launched by the mouse towards a direction.
 *    Each time the step() method is called, it will take one step.  
 * For the Completion part, gravity should act on the ball by reducing its vertical speed.
 */

public class Ball{

    // Constants for all balls: size, position of the ground
    public static final double DIAM = 16;  // diameter of the balls.
    public static final double GROUND = BallGame.GROUND;
    public static final double RIGHT_END = BallGame.RIGHT_END;

    // Fields to store state of the ball:
    // x position, height above ground, stepX, stepY, colour
    //   The ball should initially be not moving at all. (step should be 0)
    double xposition = 0;
    double height = 0;
    double xstep = 0;
    double ystep = 0;
    Color color;

    // Constructor
    /** Construct a new Ball object.
     *    Parameters are the initial position (x and the height above the ground),
     *    Stores the parameters into fields 
     *    and initialises the colour to a random colour
     *  SHOULD NOT DRAW THE BALL!
     */
    public Ball(double x, double h){
        height = h;
        xposition = x;
        color = new Color((int)(Math.random() * 0x1000000));
        color = Color.getHSBColor((float)(Math.random()), 1.0f, 1.0f);
    }
    // Methods
    /**
     * Draw the ball on the Graphics Pane in its current position
     * (unless it is past the RIGHT_END )
     */
    public void draw(){
        UI.setColor(Color.black);//could change around with 2 below
        UI.drawOval(xposition - (DIAM/2), (GROUND - height - DIAM), DIAM, DIAM);
        UI.setColor(color);
        UI.fillOval(xposition - (DIAM/2), (GROUND - height - DIAM), DIAM, DIAM);
    }

    /**
     * Move the ball one step (DO NOT REDRAW IT)
     * Core:
     *    Change its height and x position using the vertical and horizonal steps
     * Completion:
     *    Reduce its vertical speed each step (due to gravity), 
     *    If it would go below ground, then change its y position to ground level and
     *      set the  vertical speed back to 0.
     */
    public void step(){
        xposition = xposition + xstep;
        height = height + ystep;
        ystep = ystep - 0.2;
        if(height <= 0){
            height = 0;
        }
    }

    /**
     * Set the horizontal speed of the ball: how much it moves to the right in each step.
     * (negative if ball going to the left).
     */
    public void setXSpeed(double xSpeed){
        xstep = xSpeed;
    }

    /**
     * Set the vertical speed of the ball: how much it moves up in each step
     * (negative if ball going down).
     */
    public void setYSpeed(double ySpeed){
        ystep = ySpeed;
    }

    /**
     * Return the height of the ball above the ground
     */
    public double getHeight(){
        return height;
    }

    /**
     * Return the horizontal position of the ball
     */
    public double getX(){
        return xposition;
    }
}
