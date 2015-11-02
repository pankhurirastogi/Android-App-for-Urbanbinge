package com.example.vanshii;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;

public class EventBooking extends FragmentActivity implements TabListener{
	/*
	 * following activity comes up on the click of the list item.
	 */
	ViewPager vw;
	static ActionBar action;
	String eventDescription, place, aboutOrganizer;
	ImageView eventimage;
	ImageLoader imageLoader;
	//String nameof="";
	String flag;
	Bundle data;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.booking);
		eventimage=(ImageView)findViewById(R.id.imageMain);
		imageLoader=new ImageLoader(this);
		vw = (ViewPager) findViewById(R.id.pager);
		vw.setAdapter(new MyAdapter(getSupportFragmentManager()));
         data = getIntent().getExtras();
         flag = data.getString("flag");
         imageLoader.DisplayImage(flag, eventimage);

         

        // nameof= data.getString("nameof");
//		place = data.getString("PL");
//		aboutOrganizer = data.getString("AO");
		
		super.onCreate(savedInstanceState);
		
		vw.setOffscreenPageLimit(2);
		

		vw.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				action.setSelectedNavigationItem(arg0);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});

		action = getActionBar();
		action.setDisplayShowHomeEnabled(false);
		action.setDisplayShowTitleEnabled(false);
		action.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		ActionBar.Tab tab1 = action.newTab();
		tab1.setText("Event Description");
		tab1.setTabListener(this);

		ActionBar.Tab tab2 = action.newTab();
		tab2.setText("About Organizer");
		tab2.setTabListener(this);

		ActionBar.Tab tab3 = action.newTab();
		tab3.setText("Location");
		tab3.setTabListener(this);

		action.addTab(tab1);
		action.addTab(tab2);
		action.addTab(tab3);
		
		
	}

	class MyAdapter extends FragmentPagerAdapter {

		public MyAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int arg0) {
			switch (arg0) {
			case 0:
			{    // Bundle bundle = new Bundle();
	       // String myMessage = "Stackoverflow is cool!";
	       // bundle.putString("nameof",nameof );
	        FragmentA fragInfo = new FragmentA();
	        fragInfo.setArguments(data);
				return fragInfo;
			}
			case 1:
				return new FragmentB();
			case 2:
				return new FragmentC();
			}
			Log.d("hsdbcjasn", "NULL NULL NULL NULL NULL NULL NULL NULL ");
			return null;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 3;
		}

	}

	@SuppressWarnings("deprecation")
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

}
