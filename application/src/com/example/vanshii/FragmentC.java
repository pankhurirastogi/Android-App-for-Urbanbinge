package com.example.vanshii;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentC extends Fragment {
	/*
	 * fragment for loaction.
	 * @pankhuri
	 */

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View x=inflater.inflate(R.layout.fragment_c, container, false);
		
		return x;
	}
}
