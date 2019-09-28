package com.example.bloodbank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Cloudconnecting {

	
	
	public String getData(String link)
	{
		
		
			StringBuffer sb=new StringBuffer();
			try
			{
//				String link="http://androidapp.flexonlabs.com/confession/viewallposts.aspx";
				
				HttpClient client=new DefaultHttpClient();
		
				HttpGet request=new HttpGet();
				request.setURI(new URI(link));
				HttpResponse res= client.execute(request);
				InputStreamReader in=new InputStreamReader(res.getEntity().getContent());
				BufferedReader br=new BufferedReader(in);
				String line="";
				while((line=br.readLine())!=null){
					sb.append(line);
					sb.append("\n");
		
				}
			//	sb.append("End");
			in.close();
			br.close();
			}
			catch(Exception ex)
			{
				sb.append("---"+ex.getMessage());
			}
			return sb.toString();
		//	return "success";
	}
	}
	
