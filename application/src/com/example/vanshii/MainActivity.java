package com.example.vanshii;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.Toast;
import android.os.Build;


public class MainActivity extends ActionBarActivity {
	/*
	 * activity that appears after the splash screen.Comprise of city selection and category selection.
	 * 
	 */
	  public static String cityid="";
	  public static String categoryid="1";
	    Context contextt;
	   static String city="";
	   
   
	 private static final String[] COUNTRIES = new String[] { "banglore",
         "chennai", "delhi", "mumbai", "hyderabad", "Ahemdabad" };
	 AutoCompleteTextView textView;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.categories);
		
		
		android.app.ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        // actionBar.setDisplayShowTitleEnabled(false);
        // actionBar.setIcon(R.drawable.ic_action_search);

        LayoutInflater inflator = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.actionbar, null);

        actionBar.setCustomView(v);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
         textView = (AutoCompleteTextView) v
                .findViewById(R.id.editText1);
        textView.setAdapter(adapter);
        ImageButton searchbutton=(ImageButton)findViewById(R.id.imageButton1);
        searchbutton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 city=textView.getText().toString();
				   if(city!=null)
				   {
					   Toast.makeText(MainActivity.this, city, Toast.LENGTH_LONG).show();
					    if(city.equals("banglore"))
					    {   
					    	cityid="1";
					    	//Toast.makeText(MainActivity.this, cityid,Toast.LENGTH_LONG).show();
					    }
					   
				   }
				
			}
        	
        } );
        ImageButton ib1=(ImageButton)findViewById(R.id.button1);
        ib1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				categoryid="1";
			    //cityid="1";
				//Toast.makeText(MainActivity.this,cityid+"yo", Toast.LENGTH_LONG).show();
				//Intent i=new Intent(MainActivity.this,conectt.class);
				startEvents();
				
				
				
			}} );
        ImageButton ib2=(ImageButton)findViewById(R.id.button2);
        ib2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				categoryid="2";
				startEvents();
			    
				//startEvents();
				
				
				
			}} );
        
        ImageButton ib3=(ImageButton)findViewById(R.id.button3);
        ib3.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				categoryid="3";
				startEvents();
			    
				
				
				
				
			}} );
        ImageButton ib4=(ImageButton)findViewById(R.id.Button4);
        ib4.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				categoryid="4";
				startEvents();
			    
				
				
				
				
			}} );
        ImageButton ib5=(ImageButton)findViewById(R.id.Button5);
        ib5.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				categoryid="5";
				startEvents();
			    
				
				
				
				
			}} );

        ImageButton ib6=(ImageButton)findViewById(R.id.Button6);
        ib6.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				categoryid="6";
				startEvents();
			    
				
				
				
				
			}} );
        ImageButton ib7=(ImageButton)findViewById(R.id.Button7);
        ib7.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				categoryid="7";
				startEvents();
			    
				
				
				
				
			}} );
        ImageButton ib8=(ImageButton)findViewById(R.id.Button8);
        ib8.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				categoryid="8";
				startEvents();
			    
				
				
				
				
			}} );
        ImageButton ib9=(ImageButton)findViewById(R.id.Button9);
        ib9.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				categoryid="9";
				startEvents();
			    
				
				
				
				
			}} );
        ImageButton ib10=(ImageButton)findViewById(R.id.Button10);
        ib10.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				categoryid="10";
				startEvents();
			    
				
				
				
				
			}} );
        ImageButton ib11=(ImageButton)findViewById(R.id.Button11);
        ib11.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				categoryid="11";
				startEvents();
			    
				
				
				
				
			}} );
        ImageButton ib12=(ImageButton)findViewById(R.id.Button12);
        ib12.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				categoryid="12";
				startEvents();
			    
				
				
				
				
			}} );
          contextt=this.getBaseContext();
        ConnectivityManager check = (ConnectivityManager) this.contextt.
        	      getSystemService(Context.CONNECTIVITY_SERVICE);
        	      if (check != null) 
        	      {
        	         NetworkInfo[] info = check.getAllNetworkInfo();
        	        Toast.makeText(this,info.toString(),Toast.LENGTH_LONG).show();
        	         if (info != null) 
        	            for (int i = 0; i <info.length; i++) 
        	            if (info[i].getState() == NetworkInfo.State.CONNECTED)
        	            {
        	               Toast.makeText(contextt, "Internet is connected",
        	               Toast.LENGTH_SHORT).show();
        	            }
        	            
        	      }
        	      else{
        	         Toast.makeText(contextt, "not conencted to internet",
        	         Toast.LENGTH_SHORT).show();
        	          }

      


        

        



		/*if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}*/
	}
	 void startEvents()
	{
		Intent i=new Intent(MainActivity.this,conectt.class);
		
		i.putExtra("cityy", cityid);
		i.putExtra("category",categoryid);
		startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	/*public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}*/

}
