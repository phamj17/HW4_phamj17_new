package cs301.cannon;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


/**
 * class that creates cannon objects
 *
 * @author Justin Pham
 * @version November 2015
 */

public class Cannon {

    private int length;
    private int width;

    /**
     * Constructor for the cannon
     *
     */
    public Cannon() {
        length = 500;
        width = 320;
    }

    /**
     * Draws the cannon
     *
     * @param g the canvas
     */
    public void paint(Canvas g) {
        Paint cannon = new Paint();
        cannon.setColor(Color.BLACK);
        g.drawRect(0, g.getHeight() - width - 50, length, g.getHeight() - 50, cannon);
    }
}
