package com.android.exercises.simplelistview;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends ListActivity {

	static final String[] GADGETS = new String[] { "Show List with Images", "Laptop", "Ipod", "Cellphone", "Smartphone",
		"PSP", "PS4", "Tablet", "Phablet"};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_list_gadgets,
				GADGETS));

		ListView listView = getListView();
		listView.setTextFilterEnabled(true);

		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// When clicked, show a toast with the TextView text
				Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
				
				if(position == 0) {
					Intent i = new Intent(ListViewActivity.this, ImageListView.class);
					startActivity(i);
				}
			}
		});
	}
}
