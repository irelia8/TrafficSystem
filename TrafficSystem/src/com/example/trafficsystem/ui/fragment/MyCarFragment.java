package com.example.trafficsystem.ui.fragment;


import java.util.ArrayList;

import com.example.trafficsystem.R;

import com.example.trafficsystem.bean.Car;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.GridView;

public class MyCarFragment extends BaseFragment {
	
	private ArrayList<Car> allCars = new ArrayList<Car>();

	private GridView gridview;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initCars();
		
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
	}
	

	private void initCars() {
		for (int i = 1 ; i < 5 ; i++) {
			Car car = new Car(i);
			car.setBalance(i*100);
			
			car.setSpeed(i*20+3*i);
			allCars.add(car);
		}
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_car, container, false);
	}
}
