package com.dawailelo;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class SendSms extends Activity {

	Button bRequest, bAdd;
	EditText etName, etQty;
	ListView list;
	String url;
	String data;
	ArrayList<String> items;
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.medicines);
		bRequest = (Button) findViewById(R.id.bmedicine);
		etName = (EditText) findViewById(R.id.etmedicine);
		bAdd = (Button) findViewById(R.id.badd);
		etQty = (EditText) findViewById(R.id.etmedquantity);
		list = (ListView) findViewById(R.id.medlist);
		url = "https://morning-retreat-6720.herokuapp.com/checkpost.php";

		items = new ArrayList<String>();
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, items);
		list.setAdapter(adapter);

		bAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (!etName.getText().toString().trim().equalsIgnoreCase("")
						&& !etQty.getText().toString().trim()
								.equalsIgnoreCase("")) {
					items.add(etName.getText().toString() + " - "
							+ etQty.getText().toString());
					adapter.notifyDataSetChanged();
					etName.setText("");
					etQty.setText("");
				}
			}
		});

		bRequest.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.d("Medicine", "Clicked");

				if (items.size() > 0)
					sendSMSMessage();
				else
					Toast.makeText(SendSms.this, "Add item to the Cart",
							Toast.LENGTH_LONG).show();
				// new PostRequest().execute("");
				// if(et.getText().toString().equalsIgnoreCase(""))
				// {
				// // url+=data;
				// Log.d("Medicine", "Started");
				// // url+="?id=1&name=Mayank";
				// }
			}
		});

	}

	private String getData() {
		String data = "";
		if (items != null) {
			for (int i = 0; i < items.size(); i++) {
				data += items.get(i);
				data += ";\n";
			}
			return data;
		}
		return null;
	}

	// private class GetRequest extends AsyncTask<String, String, String> {
	//
	// String returned = null;
	//
	// @Override
	// protected String doInBackground(String... params) {
	//
	// Request test = new Request(url);
	// try {
	// returned = test.sendGetRequest();
	//
	// Log.d("Medicine", returned);
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return returned;
	// }
	//
	// @Override
	// protected void onPostExecute(String result) {
	// }
	//
	// }
	//
	// private class PostRequest extends AsyncTask<String, String, String> {
	//
	// String returned = null;
	//
	// @Override
	// protected String doInBackground(String... params) {
	// publishProgress("Making request.");
	//
	// Request test = new Request(url);
	// try {
	// ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
	// 2);
	// nameValuePairs.add(new BasicNameValuePair("data", getData()));
	//
	// returned = test.sendPostRequest(nameValuePairs);
	//
	// Log.d("Medicine", returned);
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// publishProgress(returned);
	// return returned;
	// }
	//
	// @Override
	// protected void onPostExecute(String result) {
	// }
	//
	// @Override
	// protected void onProgressUpdate(String... values) {
	// // TODO Auto-generated method stub
	// super.onProgressUpdate(values);
	// Toast.makeText(getApplicationContext(), values[0],
	// Toast.LENGTH_SHORT).show();
	//
	// }
	//
	// }

	private void sendSMSMessage() {

		String phoneNo = "07599119365";
		String message = getData();

		try {
			SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendTextMessage(phoneNo, null, message, null, null);
			Toast.makeText(getApplicationContext(), "SMS sent.",
					Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(),
					"SMS failed, Please try again.", Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
	}

}
