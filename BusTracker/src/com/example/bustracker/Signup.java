package com.example.bustracker;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends Activity {
String str="Data.db";
SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);
		db=openOrCreateDatabase(str,Context.MODE_PRIVATE,null);
		db.execSQL("create table if not exists signup(name varchar,password varchar,mobilno number(10),place varchar)");
		//Toast.makeText(getApplicationContext(), "Table created",Toast.LENGTH_LONG).show();
		Button b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EditText e1=(EditText)findViewById(R.id.editText1);
				EditText e2=(EditText)findViewById(R.id.editText2);
				EditText e3=(EditText)findViewById(R.id.editText3);
				EditText e4=(EditText)findViewById(R.id.editText4);
				String un=e1.getText().toString();
				String pw=e2.getText().toString();
				String mn=e3.getText().toString();
				String pl=e4.getText().toString();
			    db.execSQL("insert into signup(name,password,mobilno,place) values ('"+un+"','"+pw+"','"+mn+"','"+pl+"')");
			    Toast.makeText(getApplicationContext(),"Registered please Login",Toast.LENGTH_LONG).show();
			    Cursor cr=db.rawQuery("select * from signup", null);
			    if(cr!=null)
				{
					if(cr.moveToFirst())
					{
						Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_LONG).show();
						do
						{
							String un1=cr.getString(cr.getColumnIndex("name"));
							String pw1=cr.getString(cr.getColumnIndex("password"));
							//String mb1=cr.getString(cr.getColumnIndex("mobilno"));
							//String pl1=cr.getString(cr.getColumnIndex("place"));
						    Toast.makeText(getApplicationContext(),un1+" "+pw1+" "+mb1+" "+pl1,Toast.LENGTH_LONG).show();
					   }while(cr.moveToNext());
					}
					
				}
			    startActivity(new Intent(Signup.this,MainActivity.class));
				
		}
			
		});
	}

  @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.signup, menu);
		return true;
	}

}
