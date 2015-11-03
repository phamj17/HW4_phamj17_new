package cs301.cannon;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * CannonMainActivity
 *
 * This is the activity for the cannon animation. It creates a AnimationCanvas
 * containing a particular Animator object
 *
 * @author Justin Pham
 * @version November 2015
 *
 */
public class CannonMainActivity extends Activity {

	//declare layout elements
	private SeekBar angleSeek;
	private TextView angleDisplay;
	private NumberPicker gravity;
	private MediaPlayer player;

	private double degrees;
	private Animator testAnim;

	private int gravValue;
	private String[] nums = {"-11","-10","-9","-8","-7","-6","-5","-4","-3","-2","-1","0"};

	/**
	 * creates an AnimationCanvas containing a TestAnimator.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cannon_main);

		angleSeek = (SeekBar)findViewById(R.id.angleSeek);
		angleDisplay = (TextView)findViewById(R.id.angleText);



		gravity = (NumberPicker)findViewById(R.id.gravSelect);
		gravity.setDisplayedValues(nums);
		gravity.setMinValue(0);
		gravity.setMaxValue(11);
		gravity.setWrapSelectorWheel(false);

		//disables keyboard
		gravity.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
		gravity.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
			public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
				gravValue = newVal - 11;
				testAnim.getGravity(gravValue);
			}
		});

		angleSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				degrees = (double)progress / 10.0;
				angleDisplay.setText(Double.toString(degrees));
				testAnim.getAngle(degrees);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});

		// Create an animation canvas and place it in the main layout
		testAnim = new Animation();
		AnimationCanvas myCanvas = new AnimationCanvas(this, testAnim);
		LinearLayout mainLayout = (LinearLayout) this
				.findViewById(R.id.topLevelLayout);
		mainLayout.addView(myCanvas);

		player = MediaPlayer.create(this, R.raw.cannonsound);
		testAnim.setSound(player);

	}

	/**
	 * This is the default behavior (empty menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.cannon_main, menu);
		return true;
	}
}
