package com.example.martoo.poultry;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewData  extends Activity {
    ListView lst;
    SQLiteDatabase mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewdata);
        ListView lst=(ListView)findViewById(R.id.lst);

        mydb=openOrCreateDatabase("cocacoladb",Context.MODE_PRIVATE,null );
        //use raw query function to select all data from our table
        Cursor c=mydb.rawQuery("SELECT * FROM cocatbl",null);

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
        //get our list view
        lst.setAdapter(adapter);
    }
}
