package com.example.bloodbank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.update_activity);
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
	public void update_click(View v)
	{
		String  res="";
		String nphone=((EditText)findViewById(R.id.newphone)).getText().toString();
		String nemail=((EditText)findViewById(R.id.newemail)).getText().toString();	
		
		String link="http://androidapp.flexonlabs.com/8001444098/udateprofile.aspx?Phone="+nphone+"&email="+nemail;
		Cloudconnecting cd=new Cloudconnecting();
		 res=cd.getData(link);
		
		 
		 if(res.contains("success"))
		{
			//Intent ob=new Intent("com.example.bloodbank.MainActivity");
			//startActivity(ob);
			Toast.makeText(this, "profile udated", Toast.LENGTH_LONG).show();
			finish();
		}
		else
		{
			Toast.makeText(this, "failed to update", Toast.LENGTH_LONG).show();
		}
	}





	
		
		
	}
	

