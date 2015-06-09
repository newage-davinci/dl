package com.dawailelo;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Photo extends Activity {

	private static final String TAG = "Photo";
	ImageView medimage;
	Button capture;
	Button send;
	int reqCode = 1234;
	ImageMan im;
	String url;
	boolean isimageset = false;
	Bitmap bmp;
	
	private static final String MEDS = "MEDS";
	private static final String TYPE = "TYPE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);
		url = "https://morning-retreat-6720.herokuapp.com/checkimage.php";
		capture = (Button) findViewById(R.id.capture);
		send = (Button) findViewById(R.id.sendrequest);
		isimageset = false;
		medimage = (ImageView) findViewById(R.id.medimage);

		im = new ImageMan();
		capture.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(
						android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(i, reqCode);
			}
		});

		// new PostRequest().execute("");

		send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (isimageset) {
					Log.d(TAG, "About to start.");
//					new PostRequest().execute("");
					Intent i = new Intent(Photo.this, Order.class);
					i.putExtra(MEDS, im.bmptostring(bmp));
					i.putExtra(TYPE, "Image");
					startActivity(i);
					Photo.this.finish();

				} else
					Toast.makeText(getBaseContext(), "Please Select an Image",
							Toast.LENGTH_LONG).show();
			}
		});
		// send.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// // TODO Auto-generated method stub
		// Log.d(TAG, "About to start.");
		// new PostRequest().execute("");
		// }
		// });
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Bundle extras = data.getExtras();
			bmp = (Bitmap) extras.get("data");
			BitmapDrawable d = new BitmapDrawable(getResources(), bmp);
			medimage.setBackground(d);
			medimage.setImageAlpha(0);
			isimageset = true;
		}
	}

	private class PostRequest extends AsyncTask<String, String, String> { // doinback
																			// progress
																			// post

		String returned = null;

		@Override
		protected String doInBackground(String... params) {
			Log.d(TAG, "Inside post req");
			publishProgress("Started");
			Request test = new Request(url);
			try {
				Log.d(TAG, "setting keyvalue pair.");
				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
						2);
				nameValuePairs.add(new BasicNameValuePair("image", im
						.bmptostring(bmp)));
				// nameValuePairs.add(new BasicNameValuePair("image", "image"));
				nameValuePairs.add(new BasicNameValuePair("stringdata", "Hi"));

				Log.d(TAG, "Sending the message");
				publishProgress("Placing Order");
				returned = test.sendPostRequest(nameValuePairs);
				Log.d(TAG, "got an answer");

				if (returned != null) {
					Log.d("Medicine", returned);
					publishProgress("Order Place \n" + returned);
				} else {
					Log.d("Medicine", "returned is null");
					publishProgress("Something went wrong !");
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return returned;
		}

		@Override
		protected void onProgressUpdate(String... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
			Toast.makeText(getApplicationContext(), values[0],
					Toast.LENGTH_SHORT).show();

		}

		@Override
		protected void onPostExecute(final String result) {
			// Log.d("Result", result);

			// if (result != null)
			// {
			// if (result.contains("OKAY")) {
			// runOnUiThread(new Runnable() {
			//
			// @Override
			// public void run() {
			// // TODO Auto-generated method stub
			// Toast.makeText(getBaseContext(),
			// "Order Made", Toast.LENGTH_LONG)
			// .show();
			// }
			// });
			// Log.d("Post", "Order made");
			// } else {
			// runOnUiThread(new Runnable() {
			//
			// @Override
			// public void run() {
			// // TODO Auto-generated method stub
			// Toast.makeText(getBaseContext(),
			// "Something Went Wrong !!",
			// Toast.LENGTH_LONG).show();
			// }
			// });
			// Log.d("Post", "Something went wrong. !!");
			// }
			// // dialog.dismiss();
			// }else
			// Log.d("Medicine", "result is null");
		}

	}

}
