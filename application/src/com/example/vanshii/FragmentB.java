package com.example.vanshii;

import org.jsoup.Jsoup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {
	TextView T;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View content = inflater.inflate(R.layout.fragment_b, container, false);
		T = (TextView) content.findViewById(R.id.aboutOrg);

		return content;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		String abt = Jsoup
				.parse("<p><span>Adventure Unlimited is a right place where we define adventure to be unlimited.</span><br><br><span>Wake up with chirping birds, see the sun rise, go in the midst of forest, climb the rocks, jump with a rope, fly high with para glide, want to hunt? Try archery, camp in the midst of jungle with camp fire-listen to the jungle whistle, Dirt kart, rappel, Trek, Just enjoy and get immersed in the valley of green.</span><br><br><span>Adventure Unlimited can find you the perfect adventure to fit your imagination. We cater specifically to our client's needs.</span><br><br><span>From fun, easy to more advanced and physically challenging activities we have it all.</span><br></p>")
				.text();
		T.setText(abt);
		super.onActivityCreated(savedInstanceState);
	}
}
