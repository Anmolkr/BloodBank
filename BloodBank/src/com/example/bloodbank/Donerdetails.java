package com.example.bloodbank;





import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Donerdetails extends Activity {
	String names,res="";
	String details[];
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.donerdetails);
		
		if(android.os.Build.VERSION.SDK_INT>9)
		{
			StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder()
			.permitAll().build();
			StrictMode.setThreadPolicy(policy);
			
		}
		
		names=getIntent().getStringExtra("position");
		
		String link1="http://androidapp.flexonlabs.com/8001444098/getperson.aspx?username="+names;
						Cloudconnecting cd1=new Cloudconnecting();
		res=cd1.getData(link1);
		Toast.makeText(this,res,Toast.LENGTH_LONG).show();
		 details=res.split("#");
		
		TextView t1=(TextView)findViewById(R.id.dname);
		TextView t2=(TextView)findViewById(R.id.dphone);
		TextView t3=(TextView)findViewById(R.id.dmail);
		TextView t4=(TextView)findViewById(R.id.daddress);
		
		t1.setText(details[0]);
		t2.setText(details[1]);
		t3.setText(details[2]);
		t4.setText(details[3]);
				
	}
	
public void	btnsms_click(View v)
{
	String phoneno=((TextView)findViewById(R.id.dphone)).getText().toString();
	SmsManager sms=SmsManager.getDefault();
	sms.sendTextMessage(phoneno,null,"i need blood please contact me",null,null);
}
	public void btncall_click(View v){
		String ph=((TextView)findViewById(R.id.dphone)).getText().toString();
		
		Intent ob=new Intent(android.content.Intent.ACTION_DIAL,Uri.parse("tel:"+ph));
		startActivity(ob);
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
