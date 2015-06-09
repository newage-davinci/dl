package com.dawailelo;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String>{

	Context context;
	ArrayList<String> n,p,a,d;
	
	public CustomAdapter(Context c, ArrayList<String> n, ArrayList<String> p, ArrayList<String> a, ArrayList<String> d)
	{
//		super(c, R.layout.thelistblock, R.id.blockname, titles);
		super(c, R.layout.thelistblock, n);
		this.context = c;
		this.n = n;
		this.p = p;
		this.a = a;
		this.d = d;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Log.d("CustomAdapter", "getView Called");
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row = inflater.inflate(R.layout.thelistblock, parent,false);
		
		TextView name = (TextView) row.findViewById(R.id.blockname);
		TextView phone = (TextView) row.findViewById(R.id.blockphone);
		TextView address = (TextView) row.findViewById(R.id.blockaddress);
		TextView description = (TextView) row.findViewById(R.id.blockdescription);
		
		Log.d("CustomAdapter", "View " + n.get(0));
		name.setText(n.get(position));
		phone.setText(p.get(position));
		address.setText(a.get(position));
		description.setText(d.get(position));
		
		return row;
	}	

}
