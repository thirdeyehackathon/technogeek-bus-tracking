package com.example.bustracker;

import android.os.Bundle;
//import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	String str="Data.db";
	SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1=(Button)findViewById(R.id.button1);
        Button b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
        	@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			startActivity(new Intent(MainActivity.this,Signup.class));
			}
		});
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				EditText e1=(EditText)findViewById(R.id.editText1);
				EditText e2=(EditText)findViewById(R.id.editText2);
				String strun= e1.getText().toString();
				String strpw= e2.getText().toString();
				/*Cursor cr= db.rawQuery("select name,password from signup",null);
				if(cr!=null)
				{
					if(cr.moveToFirst())
					{
						do
						{
							Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_LONG).show();
							String un=cr.getString(cr.getColumnIndex("name"));
							String pw=cr.getString(cr.getColumnIndex("password"));
							if(un!=strun)
							{
								Toast.makeText(getApplicationContext(),"Please Sign up",Toast.LENGTH_LONG).show();
							}
							if((un==strun)&&(pw==strpw))
							{
								startActivity(new Intent(MainActivity.this,Login.class));
							}
							else
							{
								Toast.makeText(getApplicationContext(), "Wrong Username and Password",Toast.LENGTH_LONG).show();
							}
						}while(cr.moveToNext());
					}
				}*/
				startActivity(new Intent(MainActivity.this,Login.class));
			}
		});
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
