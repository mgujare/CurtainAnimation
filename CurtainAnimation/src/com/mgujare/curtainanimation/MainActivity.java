package com.mgujare.curtainanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btn = (Button) findViewById(R.id.test);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub

				Animation animation = new TranslateAnimation(0, 0, 0, 0,
						Animation.RELATIVE_TO_SELF, 2.0f,
						Animation.RELATIVE_TO_SELF, 0.0f);
				animation.setDuration(4000);

				ImageView imgB = (ImageView) findViewById(R.id.bottomover);
				ImageView imgT = (ImageView) findViewById(R.id.topover);

				ObjectAnimator upTransAnimation = ObjectAnimator.ofFloat(imgT,
						"translationY", 0, -150f);
				upTransAnimation.setDuration(4000);// set duration
				upTransAnimation.start();// start animation

				ObjectAnimator downTransAnimation = ObjectAnimator.ofFloat(
						imgB, "translationY", 0, 150f);
				downTransAnimation.setDuration(4000);// set duration

				AnimatorSet animatorSet = new AnimatorSet();
				animatorSet.playSequentially(downTransAnimation);
				animatorSet.start();// start animation

				/*
				 * Lower Half
				 */
				Animation anim = new TranslateAnimation(0, 0, 0, 0,
						Animation.RELATIVE_TO_SELF, 1.0f,
						Animation.RELATIVE_TO_SELF, 0.0f);
				anim.setDuration(4000);
				Animation anim2 = new TranslateAnimation(0, 0, 0, 0,
						Animation.RELATIVE_TO_SELF, -1.0f,
						Animation.RELATIVE_TO_SELF, 0.0f);
				anim2.setDuration(4000);
				ImageView t1 = (ImageView) findViewById(R.id.top1);
				ImageView b1 = (ImageView) findViewById(R.id.bottom1);
				t1.startAnimation(anim);
				b1.startAnimation(anim2);

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
