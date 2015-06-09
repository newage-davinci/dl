package com.dawailelo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity {

	SessionMan s;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		s = new SessionMan(this);
	
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
            	decision();
            }
        }, 1000);

		
	}


	private void decision() {
		if (s.isSessionAlive()) {
			Intent i = new Intent(Splash.this, PostSplash.class);
			startActivity(i);
			Splash.this.finish();
		} else {
			Intent i = new Intent(Splash.this, LoginPage.class);
			startActivity(i);
			Splash.this.finish();
		}
	}

}
