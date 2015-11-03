package cs301.cannon;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/**
 * class that creates target objects
 *
 * @author Justin Pham
 * @version November 2015
 */
public class Target {

    //instance variables
    Random rand = new Random();
    private int x;
    private int y;
    private int size = rand.nextInt(50) + 45;
    private int color;

    /**
     * Constructor for a target
     *
     */
    public Target(int number) {
        if (number == 0) {
            x = rand.nextInt(500) + 200;
            y = rand.nextInt(400) + 100;
            color = Color.RED;
        }
        if (number == 1) {
            x = rand.nextInt(500) + 700;
            y = rand.nextInt(400) + 500;
            color = Color.BLUE;
        }
    }


    /**
     * Draws the target
     *
     * @param canvas the canvas
     */
    public void paint(Canvas canvas) {
        Paint targetPaint = new Paint();
        targetPaint.setColor(color);
        canvas.drawCircle(x, y, size, targetPaint);
    }

    //get methods
    public int getX() {return x;}
    public int getY() {return y;}
    public int getSize() {return size;}

    //set methods
    public void setColor(int newColor) {color = newColor;}
}
