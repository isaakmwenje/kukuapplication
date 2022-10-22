package com.example.martoo.poultry;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Reportsclass extends Activity{
    EditText editText;
    Button button1;
    ListView listView1;
    SQLiteDatabase mydb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reports);

        editText=(EditText)findViewById(R.id.editText1);
        button1=(Button)findViewById(R.id.button1);
        listView1=(ListView)findViewById(R.id.listView1);


        button1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                mydb=openOrCreateDatabase("cocacoladb",Context.MODE_PRIVATE,null );
                //use raw query function to select all data from our table
                Cursor c=mydb.rawQuery("SELECT * FROM cocatbl WHERE id='"+editText.getText()+"'",null);

                ArrayList<String>arrayList=new ArrayList<String>();

                while (c.moveToNext()){

                    //array list to pick the values
                    arrayList.add(c.getString(0));
                    arrayList.add(c.getString(1));
                    arrayList.add(c.getString(2));
                    arrayList.add(c.getString(3));
                    arrayList.add("");



                }
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.suppo,arrayList);
                //get our list view used to find the id
                listView1.setAdapter(adapter);


            }
        });


    }

}
