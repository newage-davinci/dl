package com.dawailelo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;

public class Test extends Activity{

	Button b;
	private final String TAG = "Test";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		
		b = (Button) findViewById(R.id.testbutton);
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//		        MenuInflater menuInflater = getMenuInflater();
//		        menuInflater.inflate(R.layout.menu, null);
//				View back = findViewById(R.id.support);
//				PopupMenu pop = new PopupMenu(Test.this, back);
//				MenuInflater inflate = pop.getMenuInflater();
//			    inflate.inflate(R.menu.popup, pop.getMenu());
//			    pop.setOnMenuItemClickListener(new OnMenuItemClickListener() {
//					
//					@Override
//					public boolean onMenuItemClick(MenuItem item) {
//						// TODO Auto-generated method stub
//				        switch (item.getItemId())
//				        {
//				        case R.id.menu_call:
//				        	// Single menu item is selected do something
//				        	// Ex: launching new activity/screen or show alert message
//				        	Intent i = new Intent(PostSplash.this, CallUs.class);
//							startActivity(i);
//							return true;
//
//				        case R.id.menu_sms:
//				        	Toast.makeText(Test.this, "SMS", Toast.LENGTH_SHORT).show();
//				            return true;
//
//
//				        default:
//				            return false;
//				        }
//					}
//				});
//			    pop.show();
			}
		});
	}

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu)
//    {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.layout.menu, menu);
//        return true;
//    }
	
	
}
