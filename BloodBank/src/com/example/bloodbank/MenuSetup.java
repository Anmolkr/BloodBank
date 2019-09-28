package com.example.bloodbank;

import android.view.Menu;

public class MenuSetup {
  public  static void CreateMenuItems(Menu menu)
  {
	  menu.add(0,0,0,"Search");
	  menu.add(0,1,1,"Update");
	  menu.add(0,2,2,"Nearest Blood Bank");
	  menu.add(0,3,3,"Nearest Hospital");
	  menu.add(0,4,4,"Nearest Pathologycenter");
  }
/*  public  static void CreateContextMenuItems(Menu menu)
  {
	  menu.add(0,4,4,"Cut");
	  menu.add(0,5,5,"Copy");
	  menu.add(0,6,6,"Paste");
	  menu.add(0,7,7,"Search");
  }*/
  public static String getMenuActivity(int menuId)
  {
	  String AtUrl="";
	  switch(menuId)
	  {
	  
	  
	  case 0:
		  AtUrl="com.example.bloodbank.Bloodbank";
		  break;
	  case 1: 
		  AtUrl="com.example.bloodbank.UpdateActivity";
		  break;
	  case 2:
		  AtUrl="com.example.bloodbank.Nbloodbank";
		  break;
	  case 3:
		  AtUrl="com.example.bloodbank.Nhospital";
		  break;
	  case 4:
		  AtUrl="com.example.bloodbank.Npathology";
		  break;
  }
	  return AtUrl;
}}
