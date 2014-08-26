package com.android.exercises.simplelistview;

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
	
	static class ViewHolder {
		TextView imageText;
		ImageView image;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		
		if(convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 
			convertView = inflater.inflate(R.layout.image_listview, parent, false);
			
			holder = new ViewHolder();
			holder.imageText = (TextView) convertView.findViewById(R.id.label);
			holder.image = (ImageView) convertView.findViewById(R.id.logo);
			holder.imageText.setText(values[position]);
			convertView.setTag(holder);
	 
			// Change icon based on name
			String s = values[position];
	 
			if (s.equals("Github")) {
				holder.image.setImageResource(R.drawable.git);
			} else if (s.equals("Java")) {
				holder.image.setImageResource(R.drawable.java);
			} else if (s.equals("PHP")) {
				holder.image.setImageResource(R.drawable.php);
			}
		} else {
			holder = (ViewHolder)convertView.getTag();
		}
 
		return convertView;
	}
}
