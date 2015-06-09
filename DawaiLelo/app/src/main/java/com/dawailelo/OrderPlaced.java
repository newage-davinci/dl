package com.dawailelo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class OrderPlaced extends Activity{

	Button cont, x;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.orderplaced);
		
		cont = (Button) findViewById(R.id.cont);
		x = (Button) findViewById(R.id.exit);

		cont.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(OrderPlaced.this, PostSplash.class);
				startActivity(i);
				OrderPlaced.this.finish();
			}
		});
		
		x.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				OrderPlaced.this.finish();
			}
		});
		
	}
	
	

}
