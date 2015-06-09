package com.dawailelo;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.PopupMenu.OnMenuItemClickListener;

public class PostSplash extends Activity {

	Button logout;
	Button order, doctorsearch, pathlabsearch;
	SessionMan s;
	
	//OPTION SELECTOR
	private static final String OPTIONSELECTION = "OPTIONSELECTION";
	private static final String LOCATIONSELECTION = "LOCATIONSELECTION";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.postsplash);

		s = new SessionMan(this);

		logout = (Button) findViewById(R.id.logout);
		order = (Button) findViewById(R.id.makeorder);
		doctorsearch = (Button) findViewById(R.id.doctorsearch);
		pathlabsearch = (Button) findViewById(R.id.pathlabsearch);

		Button bsupport = (Button) findViewById(R.id.support);
		bsupport.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				View back = findViewById(R.id.support);
				PopupMenu pop = new PopupMenu(PostSplash.this, back);
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
				        	Intent i = new Intent(PostSplash.this, CallUs.class);
							startActivity(i);
							return true;

				        case R.id.menu_sms:
				        	Toast.makeText(PostSplash.this, "SMS", Toast.LENGTH_SHORT).show();
				            return true;


				        default:
				            return false;
				        }
					}
				});
			    pop.show();

			}
		});
		

		
		logout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				s.closeTheSession();
				Intent i = new Intent(PostSplash.this, Splash.class);
				startActivity(i);
				PostSplash.this.finish();
			}
		});

		order.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(PostSplash.this, MainScreen.class);
				startActivity(i);
			}
		});

		doctorsearch.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(PostSplash.this, OptionSelector.class);
				//Get the data from the server
				ArrayList<String> options = new ArrayList<String>();
				ArrayList<String> location = new ArrayList<String>();
				
				options.add("Select Doctor");
				options.add("General Physician");
				options.add("Dermatologist");
				options.add("Neurologist");
				options.add("Phycologist");
				options.add("Immunologist");
				options.add("Gynacologist");
				options.add("Dentist");
				
				location.add("Location");
				location.add("Delhi");
				location.add("Mumbai");
				location.add("Kolkata");
				location.add("Chennai");
				
				i.putStringArrayListExtra(OPTIONSELECTION, options);
				i.putStringArrayListExtra(LOCATIONSELECTION, location);
				startActivity(i);
			}
		});

		pathlabsearch.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(PostSplash.this, OptionSelector.class);
				
				ArrayList<String> options = new ArrayList<String>();
				ArrayList<String> location = new ArrayList<String>();
				
				options.add("Select Test");
				options.add("Blood");
				options.add("Brain");
				options.add("MRI");
				options.add("X-Ray");
				options.add("Lumbar Puncture");
				options.add("Biopsy");
				
				location.add("Location");
				location.add("Delhi");
				location.add("Mumbai");
				location.add("Kolkata");
				location.add("Chennai");
				
				i.putStringArrayListExtra(OPTIONSELECTION, options);
				i.putStringArrayListExtra(LOCATIONSELECTION, location);

				startActivity(i);
			}
		});

	}

}
