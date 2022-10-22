package com.example.martoo.poultry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.MenuItem;

public class Grid_item extends AppCompatActivity {


    TextView name;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_grid_item);
       // name= findViewById(R.id.griddata);
        //image=findViewById(R.id.imageView);


        Intent intent= getIntent();
        name.setText(intent.getStringExtra("name"));
      //image.setImageResource(intent.getIntExtra("image",defaultValue:0) );



    }
}
