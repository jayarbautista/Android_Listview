package com.android.exercises.simplelistview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageArrayAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;
 
	public ImageArrayAdapter(Context context, String[] values) {
		super(context, R.layout.image_listview, values);
		this.context = context;
		this.values = values;
	}
 
	@SuppressLint("ViewHolder")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View rowView = inflater.inflate(R.layout.image_listview, parent, false);
		TextView imageText = (TextView) rowView.findViewById(R.id.label);
		ImageView image = (ImageView) rowView.findViewById(R.id.logo);
		imageText.setText(values[position]);
 
		// Change icon based on name
		String s = values[position];
 
		System.out.println(s);
 
		if (s.equals("Github")) {
			image.setImageResource(R.drawable.git);
		} else if (s.equals("Java")) {
			image.setImageResource(R.drawable.java);
		} else if (s.equals("PHP")) {
			image.setImageResource(R.drawable.php);
		}
 
		return rowView;
	}
}
