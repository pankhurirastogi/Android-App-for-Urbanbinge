package com.example.vanshii;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleItemView extends Activity {
	/*
	 * class is responsible for setting data into single item of list view.
	 * @pankhuri.
	 */
	// Declare Variables
	String eventdiscription;
	String costincludes;
	String flag;
	String position;
	ImageLoader imageLoader ;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from singleitemview.xml
		setContentView(R.layout.singleitemview);
		imageLoader=new ImageLoader(this);

		Intent i = getIntent();
		// Get the result of eventdiscription
		eventdiscription = i.getStringExtra("eventdiscription");
		// Get the result of costincludes
		costincludes= i.getStringExtra("costincludes");
		// Get the result of image
		//population = i.getStringExtra("population");
		// Get the result of flag
		flag = i.getStringExtra("flag");

		// Locate the TextViews in singleitemview.xml
		TextView txtrank = (TextView) findViewById(R.id.rank);
		TextView txtcountry = (TextView) findViewById(R.id.country);
		TextView txtpopulation = (TextView) findViewById(R.id.population);

		// Locate the ImageView in singleitemview.xml
		ImageView imgflag = (ImageView) findViewById(R.id.flag);

		// Set results to the TextViews
		txtrank.setText(eventdiscription);
		txtcountry.setText(costincludes);
		//txtpopulation.setText(population);

		// Capture position and set results to the ImageView
		// Passes flag images URL into ImageLoader.class
		imageLoader.DisplayImage(flag, imgflag);
	}
}