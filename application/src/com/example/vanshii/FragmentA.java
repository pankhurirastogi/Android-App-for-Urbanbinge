package com.example.vanshii;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//Events Description fragment...
public class FragmentA extends Fragment {
	/*
	 * Fragment for event discription.
	 */
	TextView x, y, z;
	 String eventdiscription="";
	  String costincludes="";
	  
	//String user="";
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View contentView = inflater.inflate(R.layout.fragment_a, container,
				false);
		Bundle bundle = this.getArguments();
        //user = bundle.getString("nameof");
		eventdiscription=bundle.getString("eventdiscription");
		costincludes=bundle.getString("costincludes")
;		x = (TextView) contentView.findViewById(R.id.text);
		y = (TextView) contentView.findViewById(R.id.costInc);
		z = (TextView) contentView.findViewById(R.id.xtraIns);

		return contentView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 //a = "<div><span>&nbsp; &nbsp;&nbsp;</span><span>At our camp nature is at your service,\nthe instant you reach the place you would be a victim of amnesia, you would\nforget everything and everyone as u set your sight on mother nature's beauty...\nwhich stretches more than 500 acres and is surrounded by lush green forest\nwhich is inhabited by thin wildlife and to add to the beauty stands the huge\nsingle rock formation.</span><br></div><div><span><div><span>&nbsp; &nbsp; &nbsp;Trekking,&nbsp;</span><span>Camping,&nbsp;</span><span>Rappelling,&nbsp;</span><span>Zip line/Fox Flying,&nbsp;</span><span>High Rope travel,&nbsp;</span><span>Commando bridge,&nbsp;</span><span>Paintball,&nbsp;</span><span>ATV,&nbsp;</span><span>Dirt Karting,&nbsp;</span><span>Obstacle courses,&nbsp;</span><span>Archery,&nbsp;</span><span>Target shooting,&nbsp;</span><span>Target Hunting</span></div></span></div>";
		Document doc = Jsoup.parse(eventdiscription);
		String b = doc.text();
		String c=Jsoup.parse(costincludes).text();
		x.setText(b);
		//y.setText("Breakfast, Lunch &amp; Tea along with the acitivities mentioned. Para sailing &amp; Hot Air Ballooning will cost 450 extra each.");
		//z.setText("transportation, if required, will be at an additional cost of INR 250");
		y.setText(c);
		//z.setText(user);

		super.onActivityCreated(savedInstanceState);
	}
}
