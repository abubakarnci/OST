package com.example.ost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class Luas extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luas);
        ImageButton redButton=(ImageButton) findViewById(R.id.redLineBtn);
        redButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent=new Intent(getApplicationContext(),LuasRed.class);
                startIntent.putExtra("com.exemple.ost.SOMETHING","");
                startActivity(startIntent);


            }
        });


        ImageButton greenButton=(ImageButton) findViewById(R.id.greenLineBtn);
        greenButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent=new Intent(getApplicationContext(),LuasGreen.class);
                startIntent.putExtra("com.exemple.ost.SOMETHING","");
                startActivity(startIntent);


            }
        });


    }
}
