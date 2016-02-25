package com.example.trafficsystem.ui.activity;

import java.util.ArrayList;

import com.example.trafficsystem.R;
import com.example.trafficsystem.R.layout;
import com.example.trafficsystem.R.menu;
import com.example.trafficsystem.ui.fragment.BusFragment;
import com.example.trafficsystem.ui.fragment.EnvironmentFragment;
import com.example.trafficsystem.ui.fragment.MyCarFragment;
import com.example.trafficsystem.ui.fragment.ParkFragment;
import com.example.trafficsystem.ui.fragment.RoadFragment;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity implements OnItemClickListener{

	private String fragmentTags[] = {"MyCarFragment","RoadFragment","RoadFragment","BusFragment","EnvironmentFragment"};

	private LayoutInflater layoutInflater;
	private DrawerLayout drawerLayout;
	private ListView listView;
	private ArrayList<String> itemSrts = new ArrayList<String>();
	private ArrayAdapter<String> adapter;
	private ActionBarDrawerToggle drawerToggle;
	private String title;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		layoutInflater = LayoutInflater.from(this);
		title = (String) getTitle();
		
		
		drawerLayout = (DrawerLayout) findViewById(R.id.drawlayout);
		listView = (ListView) findViewById(R.id.left_drawer);
		
		
		initdate();
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemSrts);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
		
		
		
		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_drawer, R.string.draw_open, R.string.draw_close){
			@Override
			public void onDrawerOpened(View drawerView) {
				// TODO Auto-generated method stub
				getActionBar().setTitle("请选择");
				super.onDrawerOpened(drawerView);
			}
			
			@Override
			public void onDrawerClosed(View drawerView) {
				// TODO Auto-generated method stub
				getActionBar().setTitle(title);
				super.onDrawerClosed(drawerView);
			}
		};
		
		
		
		drawerLayout.setDrawerListener(drawerToggle);
		
	}

	private void initdate() {
		// TODO Auto-generated method stub
		itemSrts.add("我的座驾");
		itemSrts.add("我的路况");
		itemSrts.add("停车查询");
		itemSrts.add("公交查询");
		itemSrts.add("道路环境");
	}
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}





	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Bundle args = new Bundle();
		args.putString("text", itemSrts.get(position));

		
		FragmentManager fragmentManager = getFragmentManager();
		
		FragmentTransaction transaction =  fragmentManager.beginTransaction();
		
		Fragment targetFragment = null;
		
		switch (position) {
		case 0:
			targetFragment = new MyCarFragment();
			targetFragment.setArguments(args);
			break;
		case 1:
			targetFragment = new RoadFragment();
			targetFragment.setArguments(args);
			break;
		case 2:
			targetFragment = new ParkFragment();
			targetFragment.setArguments(args);
			break;
		case 3:
			targetFragment = new BusFragment();
			targetFragment.setArguments(args);
			break;
		case 4:
			targetFragment = new EnvironmentFragment();
			targetFragment.setArguments(args);
			break;	
		}
		
		transaction.replace(R.id.content_frame, targetFragment);
		transaction.commit();
		drawerLayout.closeDrawer(listView);
	}

}
