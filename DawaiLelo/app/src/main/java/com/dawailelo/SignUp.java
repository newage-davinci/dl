package com.dawailelo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.PopupMenu.OnMenuItemClickListener;

public class SignUp extends Activity{

	EditText name, city, phone, email, password;
	Button okay;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		
		name = (EditText) findViewById(R.id.signupname);
		city = (EditText) findViewById(R.id.signupcity);
		phone = (EditText) findViewById(R.id.signupphone);
		email = (EditText) findViewById(R.id.signupemail);
		password = (EditText) findViewById(R.id.signuppassword);
		
		Button bsupport = (Button) findViewById(R.id.support);
		bsupport.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				View back = findViewById(R.id.support);
				PopupMenu pop = new PopupMenu(SignUp.this, back);
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
				        	Intent i = new Intent(SignUp.this, CallUs.class);
							startActivity(i);
							return true;

				        case R.id.menu_sms:
				        	Toast.makeText(SignUp.this, "SMS", Toast.LENGTH_SHORT).show();
				            return true;


				        default:
				            return false;
				        }
					}
				});
			    pop.show();

			}
		});
		

		
		okay = (Button) findViewById(R.id.signupbutton);
		
		okay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Toast.makeText(SignUp.this, "Done Sucessfully", Toast.LENGTH_SHORT).show();
				Intent i = new Intent(SignUp.this, PostSplash.class);
				startActivity(i);
				SignUp.this.finish();
			}
		});
		
	}

}
