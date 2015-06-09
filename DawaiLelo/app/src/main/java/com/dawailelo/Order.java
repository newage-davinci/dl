package com.dawailelo;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.PopupMenu.OnMenuItemClickListener;

public class Order extends Activity {

	EditText days, address, number;
	Spinner s;
	CheckBox check;
	Button done;
	ArrayAdapter<String> optionadapter;
	String url;
	String data;
	String meds, type;
	
	private static final String MEDS = "MEDS";
	private static final String TYPE = "TYPE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.orderdone);

		days = (EditText) findViewById(R.id.days);
		address = (EditText) findViewById(R.id.address);
		number = (EditText) findViewById(R.id.number);
		s = (Spinner) findViewById(R.id.orderspinner);
		check = (CheckBox) findViewById(R.id.checkbox);
		done = (Button) findViewById(R.id.ordernow);

		Button bsupport = (Button) findViewById(R.id.support);
		bsupport.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				View back = findViewById(R.id.support);
				PopupMenu pop = new PopupMenu(Order.this, back);
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
				        	Intent i = new Intent(Order.this, CallUs.class);
							startActivity(i);
							return true;

				        case R.id.menu_sms:
				        	Toast.makeText(Order.this, "SMS", Toast.LENGTH_SHORT).show();
				            return true;


				        default:
				            return false;
				        }
					}
				});
			    pop.show();

			}
		});
		

		
		url = "https://morning-retreat-6720.herokuapp.com/checkpost.php";
		data = "This is a sample data";
		
		Bundle b = getIntent().getExtras();
		if(b!=null)
		{
			meds = b.getString(MEDS);
			type = b.getString(TYPE);
		}

		optionadapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, android.R.id.text1);
		optionadapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		optionadapter.add("Regular");
		optionadapter.add("Urgent");
		s.setAdapter(optionadapter);

		done.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (check.isChecked()) {
					Toast.makeText(Order.this, "Order Placed ",
							Toast.LENGTH_SHORT).show();

					new PostRequest().execute("");
				}
			}
		});

	}

	private class GetRequest extends AsyncTask<String, String, String> {

		String returned = null;

		@Override
		protected String doInBackground(String... params) {

			Request test = new Request(url);
			try {
				returned = test.sendGetRequest();

				Log.d("Medicine", returned);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return returned;
		}

		@Override
		protected void onPostExecute(String result) {
		}

	}

	private class PostRequest extends AsyncTask<String, String, String> {

		String returned = null;

		@Override
		protected String doInBackground(String... params) {
			publishProgress("Making request.");

			Request test = new Request(url);
			try {
				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
						2);
				nameValuePairs.add(new BasicNameValuePair("data", getData()));

				returned = test.sendPostRequest(nameValuePairs);

				Log.d("Medicine", returned);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			publishProgress(returned);
			return returned;
		}

		@Override
		protected void onPostExecute(String result) {
			Intent i = new Intent(Order.this, OrderPlaced.class);
			startActivity(i);
			Order.this.finish();
		}

		@Override
		protected void onProgressUpdate(String... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
			Toast.makeText(getApplicationContext(), values[0],
					Toast.LENGTH_SHORT).show();
			
		}

	}
	
	private String getData()
	{
		String data = null;
		data+="MEDS " + meds + ";";
		data+="TYPE " + type + ";";
		data+="DAYS " + days.getText().toString() + ";";
		data+="ADDRESS " + address.getText().toString() + ";";
		data+="CONTACT " + number.getText().toString() + ";";
		return data;
	}

}
