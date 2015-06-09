package com.dawailelo;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class TheList extends Activity {

	ListView l;
	TextView header;
	ArrayList<String> n, p, a, d;

	String head;

	private static final String HEADING = "HEADING";
	private static final String NAMES = "NAMES";
	private static final String PHONES = "PHONES";
	private static final String ADDRESS = "ADDRESS";
	private static final String DESCRIPTION = "DESCRIPTION";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thelist);
		l = (ListView) findViewById(R.id.thelist);
		header = (TextView) findViewById(R.id.thelistheading);

		// getting the things
		Bundle b = getIntent().getExtras();

		if (b != null) {
			head = b.getString(HEADING, "");
			n = b.getStringArrayList(NAMES);
			p = b.getStringArrayList(PHONES);
			a = b.getStringArrayList(ADDRESS);
			d = b.getStringArrayList(DESCRIPTION);
		}
		
		header.setText(head);

//		initialize();

		CustomAdapter adapter = new CustomAdapter(this, n, p, a, d);
		l.setAdapter(adapter);

		l.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent i = new Intent(TheList.this, CallUs.class);
				startActivity(i);
			}
		});
	}

	private void initialize() {
		n = new ArrayList<String>();
		p = new ArrayList<String>();
		a = new ArrayList<String>();
		d = new ArrayList<String>();

		n.add("name1");
		n.add("name2");

		p.add("phone1");
		p.add("phone2");

		a.add("add1");
		a.add("add2");

		d.add("desc1");
		d.add("desc2");
	}

}
