package com.dawailelo;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.PopupMenu.OnMenuItemClickListener;

public class OptionSelector extends Activity {

	Spinner option;
	Spinner location;
	Button okay;

	ArrayList<String> locations;
	ArrayList<String> options;

	private static final String OPTIONSELECTION = "OPTIONSELECTION";
	private static final String LOCATIONSELECTION = "LOCATIONSELECTION";

	// THE LIST
	private static final String HEADING = "HEADING";
	private static final String NAMES = "NAMES";
	private static final String PHONES = "PHONES";
	private static final String ADDRESS = "ADDRESS";
	private static final String DESCRIPTION = "DESCRIPTION";

	ArrayAdapter<String> optionadapter;
	ArrayAdapter<String> locationadapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.optionselector);

		option = (Spinner) findViewById(R.id.option);
		location = (Spinner) findViewById(R.id.location);
		okay = (Button) findViewById(R.id.optionselectorokay);

		Button bsupport = (Button) findViewById(R.id.support);
		bsupport.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				View back = findViewById(R.id.support);
				PopupMenu pop = new PopupMenu(OptionSelector.this, back);
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
				        	Intent i = new Intent(OptionSelector.this, CallUs.class);
							startActivity(i);
							return true;

				        case R.id.menu_sms:
				        	Toast.makeText(OptionSelector.this, "SMS", Toast.LENGTH_SHORT).show();
				            return true;


				        default:
				            return false;
				        }
					}
				});
			    pop.show();

			}
		});
		

		
//		 getting the things
		 Bundle b = getIntent().getExtras();
		
		 if (b != null) {
		 options = b.getStringArrayList(OPTIONSELECTION);
		 locations = b.getStringArrayList(LOCATIONSELECTION);
		 }

		optionadapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, android.R.id.text1);
		optionadapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		option.setAdapter(optionadapter);

		locationadapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, android.R.id.text1);
		locationadapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		location.setAdapter(locationadapter);
		initialize();

		okay.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Toast.makeText(
//						OptionSelector.this,
//						option.getSelectedItem().toString() + "  "
//								+ location.getSelectedItem().toString(),
//						Toast.LENGTH_LONG).show();
				
				if(option.getSelectedItemPosition()>0 && location.getSelectedItemPosition()>0)
				showTheList(option.getSelectedItem().toString() + "  "
								+ location.getSelectedItem().toString());
				else
					Toast.makeText(OptionSelector.this, "Select an Option", Toast.LENGTH_SHORT).show();
				
			}
		});
	}

	private void initialize() {
		// optionadapter.add("name1");
		// optionadapter.add("name2");
		// optionadapter.add("name1");
		// optionadapter.add("name2");
		// optionadapter.add("name1");
		// optionadapter.add("name2");
		// optionadapter.notifyDataSetChanged();
		//
		// locationadapter.add("phone1");
		// locationadapter.add("phone1");
		// locationadapter.add("phone1");
		// locationadapter.add("phone1");
		// locationadapter.add("phone1");
		// locationadapter.add("phone1");
		// locationadapter.add("phone1");
		// locationadapter.notifyDataSetChanged();

		for (int i = 0; i < options.size(); i++) {
			optionadapter.add(options.get(i));
		}
		optionadapter.notifyDataSetChanged();

		for (int i = 0; i < locations.size(); i++) {
			locationadapter.add(locations.get(i));
		}
		locationadapter.notifyDataSetChanged();

	}

	private void showTheList(String heading) {
		Intent i = new Intent(OptionSelector.this, TheList.class);
		// Get the data from the server
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> phone = new ArrayList<String>();
		ArrayList<String> address = new ArrayList<String>();
		ArrayList<String> description = new ArrayList<String>();

		name.add("Name 1");
		name.add("Name 2");
		name.add("Name 3");
		name.add("Name 4");
		name.add("Name 5");
		name.add("Name 6");
		name.add("Name 7");
		name.add("Name 8");
		
		phone.add("Phone 1");
		phone.add("Phone 2");
		phone.add("Phone 3");
		phone.add("Phone 4");
		phone.add("Phone 5");
		phone.add("Phone 6");
		phone.add("Phone 7");
		phone.add("Phone 8");
		
		address.add("Address 1");
		address.add("Address 2");
		address.add("Address 3");
		address.add("Address 4");
		address.add("Address 5");
		address.add("Address 6");
		address.add("Address 7");
		address.add("Address 8");
		
		description.add("Description 1");
		description.add("Description 2");
		description.add("Description 3");
		description.add("Description 4");
		description.add("Description 5");
		description.add("Description 6");
		description.add("Description 7");
		description.add("Description 8");
		
		i.putExtra(HEADING, heading);
		i.putStringArrayListExtra(NAMES, name);
		i.putStringArrayListExtra(PHONES, phone);
		i.putStringArrayListExtra(ADDRESS, address);
		i.putStringArrayListExtra(DESCRIPTION, description);
		startActivity(i);

	}

}
