package com.dawailelo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.PopupMenu.OnMenuItemClickListener;

public class MainScreen extends Activity {

	ImageButton bdirect, bphoto, bphone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

//		bsms = (ImageButton) findViewById(R.id.bsms);
		bdirect = (ImageButton) findViewById(R.id.bdirect);
		bphoto = (ImageButton) findViewById(R.id.bphoto);
		bphone = (ImageButton) findViewById(R.id.bphone);

		Button bsupport = (Button) findViewById(R.id.support);
		bsupport.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				View back = findViewById(R.id.support);
				PopupMenu pop = new PopupMenu(MainScreen.this, back);
				MenuInflater inflate = pop.getMenuInflater();
			    inflate.inflate(R.menu.popup, pop.getMenu());
			    pop.setOnMenuItemClickListener(new OnMenuItemClickListener() {
					
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						// TODO Auto-generated method stub
				        switch (item.getItemId())
				        {
				        case R.id.menu_call:
				        	// Single menu item is selected do something
				        	// Ex: launching new activity/screen or show alert message
				        	Intent i = new Intent(MainScreen.this, CallUs.class);
							startActivity(i);
							return true;

				        case R.id.menu_sms:
				        	Toast.makeText(MainScreen.this, "SMS", Toast.LENGTH_SHORT).show();
				            return true;


				        default:
				            return false;
				        }
					}
				});
			    pop.show();

			}
		});
		
//		bsms.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Intent i = new Intent(MainScreen.this, SendSms.class);
//				startActivity(i);
//			}
//		});

		bdirect.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent i = new Intent(MainScreen.this, Medicines.class);
//				startActivity(i);
			}
		});

		bphoto.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainScreen.this, Photo.class);
				startActivity(i);
			}
		});

		bphone.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainScreen.this, CallUs.class);
				startActivity(i);
			}
		});

	}

}
