package cs301.cannon;

import android.graphics.*;
import android.media.MediaPlayer;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;


/**
 * class that animates a ball repeatedly moving diagonally on
 * simple background
 *
 * @author Justin Pham
 * @version November 2015
 */
public class Animation implements Animator {

	// instance variables
	private boolean shoot = false;
	int gravity = -11;
	double degrees;
	private Cannon cannon = new Cannon();
	private CannonBall ball = new CannonBall();
	private Target target0 = new Target(0);
	private Target target1 = new Target(1);


	/**
	 * Interval between animation frames: .03 seconds (i.e., about 33 times
	 * per second).
	 * 
	 * @return the time interval between frames, in milliseconds.
	 */
	public int interval() {
		return 30;
	}
	
	/**
	 * The background color: a light blue.
	 * 
	 * @return the background color onto which we will draw the image.
	 */
	public int backgroundColor() {
		// create/return the background color
		return Color.rgb(180, 200, 255);
	}

	
	/**
	 * Action to perform on clock tick
	 * 
	 * @param g the graphics object on which to draw
	 */
	public void tick(Canvas g) {

		if (shoot) {
				ball.calculate(ball);
		}

		g.save();
		float angleF = (float) degrees;
		g.rotate(-angleF, 125, g.getHeight() - 80);
		cannon.paint(g);

		g.restore();
		ball.paint(g);
		target0.paint(g);
		target1.paint(g);
		if (ball.targetHit(target0)) {
			target0.setColor(backgroundColor());
		}
		if (ball.targetHit(target1)) {
			target1.setColor(backgroundColor());
		}
	}

	/**
	 * Tells that we never pause.
	 * 
	 * @return indication of whether to pause
	 */
	public boolean doPause() {
		return false;
	}

	/**
	 * Tells that we never stop the animation.
	 * 
	 * @return indication of whether to quit.
	 */
	public boolean doQuit() {
		return false;
	}

	/**
	 * draws a new CannonBall when the screen is touched
	 */
	public void onTouch(MotionEvent event)
	{
		if (event.getAction() == MotionEvent.ACTION_DOWN)
		{
			ball = new CannonBall();
			ball.setGravity(gravity);
			ball.initVel(degrees);
			shoot = true;
		}
	}

	/**
	 * Retrieves the angle set by the user
	 *
	 * @param angle the set angle
	 */
	public void getAngle(double angle) {
		degrees = angle;
	}

	/**
	 * Retrieves the gravity set by the user
	 *
	 * @param newGrav the set gravity
	 */
	public void getGravity(int newGrav) {gravity = newGrav;}


}//class TextAnimator