package com.dawailelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public class Request {

	String url;

	public Request(String url) {
		super();
		this.url = url;
	}

	public String sendGetRequest() {
		System.out.println("Inside the method");
		HttpClient client = new DefaultHttpClient();
		URI website;
		try {
			website = new URI(url);
			HttpGet request = new HttpGet();
			request.setURI(website);

			HttpResponse response = client.execute(request);
			System.out.println("Got the string");
			return responseToString(response);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String sendPostRequest(ArrayList<NameValuePair> nameValuePairs) {
		// Create a new HttpClient and Post Header
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(url);

		try {
			// Add your data
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			// Execute HTTP Post Request
			HttpResponse response = httpclient.execute(httppost);
			if (response != null)
				return responseToString(response);
			else
			{
				Log.e("Request", "response is null");
				return null;
			}

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return null;
	}

	private String responseToString(HttpResponse response) {
		BufferedReader in = null;
		String data = null;

		response.getStatusLine().getStatusCode();

		try {
			in = new BufferedReader(new InputStreamReader(response.getEntity()
					.getContent()));
			StringBuffer sb = new StringBuffer("");
			String l = "";
			String nl = System.getProperty("line.separator");
			while ((l = in.readLine()) != null) {
				sb.append(l + nl);
			}
			in.close();
			data = sb.toString();

			return data;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
					return data;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			return null;
		}
	}

}