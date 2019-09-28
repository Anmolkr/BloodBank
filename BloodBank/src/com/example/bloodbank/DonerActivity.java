package com.example.bloodbank;

import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DonerActivity extends ListActivity{
	String username="";
	String bloodgr="",res="";
	String names[];
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.donor_activity);
		
		if(android.os.Build.VERSION.SDK_INT>9)
		{
			StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder()
			.permitAll().build();
			StrictMode.setThreadPolicy(policy);
			
		}
		
		username=getIntent().getStringExtra("uname");
		bloodgr=getIntent().getStringExtra("bloodgrp");
		String link1="http://androidapp.flexonlabs.com/8001444098/getlist.aspx?username="+username+"&Bloodgr="+bloodgr;
						Cloudconnecting cd1=new Cloudconnecting();
		res=cd1.getData(link1);
		 names=res.split("#");

		ListView lv = getListView();
		lv.setChoiceMode(ListView.CHOICE_MODE_NONE);
		lv.setTextFilterEnabled(true);
		
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names));
	
	//Toast.makeText(this,link1, Toast.LENGTH_LONG).show();
	}	
	public void onListItemClick(ListView parent,View view,int position,long id)
	
	{
		Toast.makeText(this,names[position],Toast.LENGTH_LONG).show();

		Intent ob1=new Intent("com.example.bloodbank.Donerdetails");
		
		ob1.putExtra("position",names[position]);
		startActivity(ob1);
	
	}
		
		
		
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuSetup.CreateMenuItems(menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id=item.getItemId();
		Intent ob=new Intent(MenuSetup.getMenuActivity(id));
		startActivity(ob);
			return true;
		}
	
	
	
}
