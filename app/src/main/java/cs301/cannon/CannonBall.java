package cs301.cannon;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * class that creates cannonball objects
 *
 * @author Justin Pham
 * @version November 2015
 */
public class CannonBall {

    //instance variables
    private int xPosition;
    private int yPosition;
    private int xVelocity;
    private int yVelocity;
    private double angle;
    private int size;
    private int g;
    private int wind;
    private final int initVelocity = 120;

    /**
     * Constructor for CannonBall
     *
     */
    public CannonBall() {
        g = -11;
        wind = -1;
        angle = 0.0;
        xPosition = 0;
        yPosition = 0;
        xVelocity = 0;
        yVelocity = 0;
        size = 45;
    }

    /**
     * Initializes the velocity components.
     *
     * @param degrees the angle of the cannon
     */
    public void initVel(double degrees) {
        angle = Math.toRadians(degrees);
        double xVel = initVelocity * Math.cos(angle);
        xVelocity = (int) xVel;
        double yVel = initVelocity * Math.sin(angle);
        yVelocity = (int) yVel;
    }

    /**
     * Calculates the velocity and position of the CannonBall
     *
     * @param current the current Cannonball object
     */
    public void calculate(CannonBall current) {

        double xVel = current.getXVelocity() + wind;
        current.setXVelocity((int) xVel);

        double yVel = current.getYVelocity() + g;
        current.setYVelocity((int) yVel);

        int x = current.getXPosition() + current.getXVelocity();
        if (x > 0) {
            current.setXPosition(x);
        }
        else {
            current.setXPosition(0);
        }
        int y = current.getYPosition() + current.getYVelocity();
        if (y > 0) {
            current.setYPosition(y);
        }
        else {
            current.setYPosition(0);
            current.setYVelocity(-2 * current.getYVelocity() / 3);
        }

    }

    /**
     * Draws the cannonball
     *
     * @param g the canvas
     */
    public void paint(Canvas g) {
        Paint cannonball = new Paint();
        cannonball.setColor(Color.BLACK);
        g.drawCircle(xPosition, g.getHeight() - yPosition - 250 - size, size, cannonball);
    }

    /**
     * Checks if a target was hit
     *
     * @param target the target to hit
     *
     * @return true if target was hit, false otherwise
     */
    public boolean targetHit(Target target) {
        if ((xPosition) > (target.getX() - target.getSize() - size) &&
                (xPosition) < (target.getX() + target.getSize() + size)) {
            if ((yPosition) > (target.getY() - target.getSize() - size) &&
                    (yPosition) < (target.getY() + target.getSize() + size)){
                return true;
            }
        }
        return false;
    }

    //get methods
    public int getXPosition() {return xPosition;}
    public int getYPosition() {return yPosition;}
    public int getXVelocity() {return xVelocity;}
    public int getYVelocity() {return yVelocity;}

    //set methods
    public void setXPosition(int newX) {xPosition = newX;}
    public void setXVelocity(int newXVel) {xVelocity = newXVel;}
    public void setYPosition(int newY) {yPosition = newY;}
    public void setYVelocity(int newYVel) {yVelocity = newYVel;}
    public void setGravity(int newGrav) {g = newGrav;}
}
