package com.example.bloodbank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Nhospital extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	//	setContentView(R.layout.doner_activity);
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
