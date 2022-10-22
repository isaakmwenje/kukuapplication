package com.example.martoo.poultry;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar toolbar;
    private Button btnMM,btnNN,btnKK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMM = (Button) findViewById(R.id.btnMM);
        btnNN = (Button) findViewById(R.id.btnNN);
        btnKK=(Button) findViewById(R.id.btnKK);

        btnMM.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(MainActivity.this, Batch.class);
                startActivity(intent);
                finish();
            }
        });
        btnNN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(MainActivity.this, Main5.class);
                startActivity(intent);
                finish();
            }
        });
        btnKK.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(MainActivity.this, Batch6.class);
                startActivity(intent);
                finish();
            }
        });
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        //adding a listener
       /* mDrawerLayout.addDrawerListener(mToggle);
        toolbar = (Toolbar) findViewById(R.id.tool);
        mToggle.syncState();
        //method to create a toolbar setdisplay creates a home botton
        setSupportActionBar(toolbar);*/
       mDrawerLayout.addDrawerListener(mToggle);
mToggle.syncState();
getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }






    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){

            return true;}
        return super.onOptionsItemSelected(item);
    }




    }





