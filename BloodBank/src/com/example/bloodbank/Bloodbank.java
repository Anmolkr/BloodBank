package com.example.bloodbank;





import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;



public class Bloodbank extends Activity {
	String username="",res="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bloodbank_activity);
		if(android.os.Build.VERSION.SDK_INT>9)
		{
			StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder()
			.permitAll().build();
			StrictMode.setThreadPolicy(policy);
			
			

			//String link2="http://androidapp.flexonlabs.com/8001444098/getcount.aspx?City="+username+"&Bloodgrp=A-";
			
			
			
		}
		
		username=getIntent().getStringExtra("uname");
		String link1="http://androidapp.flexonlabs.com/8001444098/getcount.aspx?username="+username+"&Bloodgrp=A+";
		TextView t1=(TextView)findViewById(R.id.NA1);
		Cloudconnecting cd1=new Cloudconnecting();
		res=cd1.getData(link1);		
		t1.setText(res);
		String link2="http://androidapp.flexonlabs.com/8001444098/getcount.aspx?username="+username+"&Bloodgrp=A-";
		TextView t2=(TextView)findViewById(R.id.NA2);
		res=cd1.getData(link2);		
		t2.setText(res);
		String link3="http://androidapp.flexonlabs.com/8001444098/getcount.aspx?username="+username+"&Bloodgrp=O+";
		TextView t3=(TextView)findViewById(R.id.NO1);
		res=cd1.getData(link3);		
		t3.setText(res);
		String link4="http://androidapp.flexonlabs.com/8001444098/getcount.aspx?username="+username+"&Bloodgrp=O-";
		TextView t4=(TextView)findViewById(R.id.NO2);
		res=cd1.getData(link4);		
		t4.setText(res);
		String link5="http://androidapp.flexonlabs.com/8001444098/getcount.aspx?username="+username+"&Bloodgrp=B+";
		TextView t5=(TextView)findViewById(R.id.NB1);
		res=cd1.getData(link5);		
		t5.setText(res);
		String link6="http://androidapp.flexonlabs.com/8001444098/getcount.aspx?username="+username+"&Bloodgrp=B-";
		TextView t6=(TextView)findViewById(R.id.NB2);
		res=cd1.getData(link6);		
		t6.setText(res);
		String link7="http://androidapp.flexonlabs.com/8001444098/getcount.aspx?username="+username+"&Bloodgrp=AB+";
		TextView t7=(TextView)findViewById(R.id.NAB1);
		res=cd1.getData(link7);		
		t7.setText(res);
		String link8="http://androidapp.flexonlabs.com/8001444098/getcount.aspx?username="+username+"&Bloodgrp=A-";
		TextView t8=(TextView)findViewById(R.id.NAB2);
		res=cd1.getData(link8);		
		t8.setText(res);
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
	
	


	
	
	public void btnA1_click(View v)
	{
		
		
		
		
		
		
		Intent ob1=new Intent("com.example.bloodbank.DonerActivity");
		ob1.putExtra("uname", username);
		ob1.putExtra("bloodgrp", "A+");
		startActivity(ob1);
		
	}
	public void btnA2_click(View v)
	{
		
		
		
		Intent ob1=new Intent("com.example.bloodbank.DonerActivity");
		ob1.putExtra("uname", username);
		ob1.putExtra("bloodgrp", "A-");
		startActivity(ob1);
		
		
		
	}
	public void btnO1_click(View v)
	{
		
		
		Intent ob1=new Intent("com.example.bloodbank.DonerActivity");
		ob1.putExtra("uname", username);
		ob1.putExtra("bloodgrp", "O+");
		startActivity(ob1);
		
		
		
		
	}
	public void btnO2_click(View v)
	{
		
		
		Intent ob1=new Intent("com.example.bloodbank.DonerActivity");
		ob1.putExtra("uname", username);
		ob1.putExtra("bloodgrp", "O-");
		startActivity(ob1);
		
		
		
	}
	public void btnB1_click(View v)
	{
		
		
		Intent ob1=new Intent("com.example.bloodbank.DonerActivity");
		ob1.putExtra("uname", username);
		ob1.putExtra("bloodgrp", "B+");
		startActivity(ob1);
		
		
		
	}
	public void btnB2_click(View v)
	{
		
		
		Intent ob1=new Intent("com.example.bloodbank.DonerActivity");
		ob1.putExtra("uname", username);
		ob1.putExtra("bloodgrp", "B-");
		ob1.putExtra("re", res);
		startActivity(ob1);
		
		
		
	}
	public void btnAB1_click(View v)
	{
		
		
		Intent ob1=new Intent("com.example.bloodbank.DonerActivity");
		ob1.putExtra("uname", username);
		ob1.putExtra("bloodgrp", "AB+");
		startActivity(ob1);
		
		
		
	}
	public void btnAB2_click(View v)
	{
		
		Intent ob1=new Intent("com.example.bloodbank.DonerActivity");
		ob1.putExtra("uname", username);
		ob1.putExtra("bloodgrp", "AB-");
		startActivity(ob1);
		
		
		
		
	}
	
}
