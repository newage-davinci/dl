package com.dawailelo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends Activity implements OnClickListener {

	EditText emailid, password;
	Button login, signup;
	SessionMan s;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		// EditTexts
		emailid = (EditText) findViewById(R.id.emailid);
		password = (EditText) findViewById(R.id.password);

		// Buttons
		login = (Button) findViewById(R.id.login);
		signup = (Button) findViewById(R.id.signup);

		// onClick
		login.setOnClickListener(this);
		signup.setOnClickListener(this);

	}

	// onClick
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == login.getId()) {
			if (emailid != null && password != null)
				if (!emailid.getText().toString().trim().equals("")
						&& !password.getText().toString().trim().equals("")) {
					//Valid for request
					Toast.makeText(LoginPage.this, "Valid for Request", Toast.LENGTH_SHORT).show();
					String email = emailid.getText().toString().trim();
					String pass = password.getText().toString().trim();
					
					//check for a valid email address including @
					
					if(email.equals("mayank") && pass.equals("1234"))
					{
						//onSuccess
						s = new SessionMan(LoginPage.this);
						s.setSessionId("VALID");
						s.setUserid(email);
						s.setUsername("mayank");
						
//						s.closeTheSession();
						//start the new activity
						Intent i = new Intent(LoginPage.this,PostSplash.class);
						startActivity(i);
					}
					else
					{
						//onFailure
						Toast.makeText(LoginPage.this, "Invalid ID or Password", Toast.LENGTH_SHORT).show();
					}
				}
		} else if (v.getId() == signup.getId()) {
			Intent i = new Intent(LoginPage.this, SignUp.class);
			startActivity(i);

		}
	}

	// End of onClick

	// PostRequest
//	private class PostRequest extends AsyncTask<String, String, String> {
//
//		String returned = null;
//
//		@Override
//		protected String doInBackground(String... params) {
//			publishProgress("Making request.");
//
//			Request test = new Request(url);
//			try {
//				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
//						2);
//				nameValuePairs
//						.add(new BasicNameValuePair("username", getData()));
//
//				returned = test.sendPostRequest(nameValuePairs);
//
//				Log.d("Medicine", returned);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			publishProgress(returned);
//			return returned;
//		}
//
//		@Override
//		protected void onPostExecute(String result) {
//		}
//
//		@Override
//		protected void onProgressUpdate(String... values) {
//			// TODO Auto-generated method stub
//			super.onProgressUpdate(values);
//			Toast.makeText(getApplicationContext(), values[0],
//					Toast.LENGTH_SHORT).show();
//
//		}
//
//	}
	// End of PostRequest

}
