package com.example.bloodbank;



import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if(android.os.Build.VERSION.SDK_INT>9)
		{
			StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder()
			.permitAll().build();
			StrictMode.setThreadPolicy(policy);
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void reg_click(View v)
	{
		Intent ob=new Intent("com.example.bloodbank.Registration");
		startActivity(ob);
	}
	public void log_click(View v)
	{
		String res="";
		
		
		String username=((EditText)findViewById(R.id.usr)).getText().toString();
		String password=((EditText)findViewById(R.id.pwd)).getText().toString();
		String link="http://androidapp.flexonlabs.com/8001444098/getregister.aspx?username="+Uri.encode(username)+"&password="+password;
		Cloudconnecting cd=new Cloudconnecting();
		 res=cd.getData(link);
		 Toast.makeText(this,link,Toast.LENGTH_LONG).show();
		 if(res.contains("success"))
			{
			 Toast.makeText(this, "login successful", Toast.LENGTH_LONG).show();
				Intent ob1=new Intent("com.example.bloodbank.Bloodbank");
				ob1.putExtra("uname", username);
				startActivity(ob1);
				
				
			}
			else
			{
				Toast.makeText(this, "login Unsuccessful", Toast.LENGTH_LONG).show();
			}
	}

}