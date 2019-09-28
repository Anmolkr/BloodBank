package com.example.bloodbank;



import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Registration extends Activity {
	
	String[] cities={"City","Durgapur",
			"Kolkata",
			"Mumbai",
			"Pune",
			"Chennai",
	};
	String[] bloodgrp={"Blood Group","A+","A-",
			"B+",
			"B-",
			"AB+",
			"AB-","O+","O-"
			
	};
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registration_layout);
		if(android.os.Build.VERSION.SDK_INT>9)
		{
			StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder()
			.permitAll().build();
			StrictMode.setThreadPolicy(policy);
			
		}
		
		
		Spinner spcities=(Spinner)findViewById(R.id.sp1);
		ArrayAdapter<String> ads=new  ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,cities);
		spcities.setAdapter(ads);
		Spinner spbldgrp=(Spinner)findViewById(R.id.sp2);
		ArrayAdapter<String> ads2=new  ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,bloodgrp);
		spbldgrp.setAdapter(ads2);
	}
	
	
	
	
public void register_click(View v)
{
	String res="";
	String name=((EditText)findViewById(R.id.name)).getText().toString();
	String phone=((EditText)findViewById(R.id.phone)).getText().toString();
	String email=((EditText)findViewById(R.id.email)).getText().toString();
	String Gender="";
	RadioButton male=(RadioButton)findViewById(R.id.male);
	RadioButton female=(RadioButton)findViewById(R.id.female);
	if(male.isChecked())
	{
		 Gender="Male";
	}
	else
	{
		 Gender="Female";
	}
	String address=((EditText)findViewById(R.id.address)).getText().toString();
	String username=((EditText)findViewById(R.id.username)).getText().toString();
	String password=((EditText)findViewById(R.id.password)).getText().toString();
	
	
	Spinner sp1=(Spinner)findViewById(R.id.sp1);
String city=sp1.getSelectedItem().toString();
Spinner sp2=(Spinner)findViewById(R.id.sp2);
String bgrp=sp2.getSelectedItem().toString();
	
	
	String link="http://androidapp.flexonlabs.com/8001444098/putregister.aspx?Name="+Uri.encode(name)+"&Gender="+Gender+"&email="+email+"&Phone="+phone+"&address="+Uri.encode(address)+"&City="+city+"&username="+Uri.encode(username)+"&password="+password+"&Bloodgrp="+bgrp;
	Cloudconnecting cd=new Cloudconnecting();
	 res=cd.getData(link);
	
	 
	 if(res.contains("success"))
	{
		//Intent ob=new Intent("com.example.bloodbank.MainActivity");
		//startActivity(ob);
		Toast.makeText(this, "Registration successful", Toast.LENGTH_LONG).show();
		finish();
	}
	else
	{
		Toast.makeText(this, "Registration Unsuccessful", Toast.LENGTH_LONG).show();
	}
}





}
	
	