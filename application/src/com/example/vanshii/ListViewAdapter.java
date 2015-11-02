package com.example.vanshii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.sax.StartElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {
	/*
	 * class responsible for customized adapter.
	 * @pankhuri.
	 */

	// Declare Variables
	
	Context context;
	LayoutInflater inflater;
	List<Eventss> data;
	ImageLoader imageLoader;

	Eventss resultp=new Eventss();

	public ListViewAdapter(Context context,
			List<Eventss> arraylist) {
		this.context = context;
		data = arraylist;
		imageLoader = new ImageLoader(context);
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		// Declare Variables
		TextView evvid;
		//TextView country;
		// population;
		TextView Venue;
		ImageView flag;
		TextView eDate;

		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View itemView = inflater.inflate(R.layout.newadapter, parent, false);
		// Get the position
		resultp = data.get(position);

		// Locate the TextViews in listview_item.xml
		
		evvid=(TextView)itemView.findViewById(R.id.head);
		Venue=(TextView)itemView.findViewById(R.id.place);
		eDate=(TextView)itemView.findViewById(R.id.date);
		

		// Locate the ImageView in listview_item.xml
		flag = (ImageView) itemView.findViewById(R.id.image);

		// Capture position and set results to the TextViews
		evvid.setText(resultp.eventTitle);
		Venue.setText(resultp.eventVenue);
		eDate.setText(resultp.startDate);
	
		// Capture position and set results to the ImageView
		// Passes flag images URL into ImageLoader.class
		imageLoader.DisplayImage(resultp.ei.imageURL, flag);
		// Capture ListView item click
		itemView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Get the position
			resultp = data.get(position);
				Intent intent = new Intent(context, EventBooking.class);
				// Pass all data rank
				intent.putExtra("eventdiscription", resultp.eventDiscription);
				// Pass all data country
				intent.putExtra("costincludes", resultp.costIncludes);
				// Pass all data population
				//intent.putExtra("nameof","yoyyo");
				// Pass all data flag
				intent.putExtra("flag", resultp.ei.imageURL);
				// Start SingleItemView Class
				context.startActivity(intent);
			      

			}
		});
		return itemView;
	}
}
