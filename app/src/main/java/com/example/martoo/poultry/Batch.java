package com.example.martoo.poultry;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Batch  extends Activity{

    //creating variables to store our objects
    Button filter,buttonReset,buttonDelete,buttonUpdate,buttonView,buttonHome,buttonAdd;
    EditText id,location,quantity,date,total,male,female,weight;
    SQLiteDatabase mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.batch);
        id=(EditText)findViewById(R.id.batchNumber);
        date=(EditText)findViewById(R.id.batchDate);
        quantity=(EditText)findViewById(R.id.batchWeight);
        total=(EditText)findViewById(R.id.batchTotal);
        male=(EditText)findViewById(R.id.batchMale);
        female=(EditText)findViewById(R.id.batchFemale);
        weight=(EditText)findViewById(R.id.batchWeight);


        buttonReset=(Button)findViewById(R.id.buttonReset);
        buttonAdd=(Button)findViewById(R.id.buttonAdd);
        buttonDelete=(Button)findViewById(R.id.buttonDelete);
        buttonUpdate=(Button)findViewById(R.id.buttonUpdatee);
        filter=(Button)findViewById(R.id.filter);
        buttonView=(Button)findViewById(R.id.buttonView);
        //filter=(Button)findViewById(R.id.filter);



        buttonView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Intent intent=new Intent(Batch.this,ViewData.class);
                startActivity(intent);
            }
        });


        filter.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Intent intent=new Intent(Batch.this, Reportsclass.class);
                startActivity(intent);
            }
        });


        //creating the database
        mydb=openOrCreateDatabase("cocadb",Context.MODE_PRIVATE,null );
        //creating a table called cocatbl,then all columns names
        mydb.execSQL("CREATE TABLE IF NOT EXISTS cocatbl(id VARCHAR,date VARCHAR,quantity VARCHAR,total VARCHAR,male VARCHAR,female VARCHAR,weight VARCHAR)");

        //to insert data into the table


        buttonAdd.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub


                if(id.getText().toString().trim().length()==0|| date.getText().toString().trim().length()==0||
                        total.getText().toString().trim().length()==0||male.getText().toString().trim().length()==0||
                        female.getText().toString().trim().length()==0 ||
                        weight.getText().toString().trim().length()==0)
                {
                    showMessage("sorry","you must fill all the fields");
                }
                else{
                    mydb.execSQL("INSERT INTO cocatbl VALUES('"+id.getText()+"','"+date.getText()+"','"+total.getText()+"','"+male.getText()+"','"+female.getText()+"','"+weight.getText()+"')");

                    showMessage("success", "Data was inserted successfully");

                }
            }
        });





    }



    //method to be called instead of toasting its access level should be public
    public void showMessage(String title,String message){

        Builder b=(new Builder(this));
        b.setCancelable(true); //meaning not always remaining at same position
        b.setTitle(title);
        b.setMessage(message);
        b.show();

    }




}
