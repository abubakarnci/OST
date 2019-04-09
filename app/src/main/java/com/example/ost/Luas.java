package com.example.ost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Luas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luas);

        ImageButton greenBtn =(ImageButton) findViewById(R.id.greenBtn);
        greenBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent=new Intent(getApplicationContext(),LuasGreen.class);
                startIntent.putExtra("com.example.ost.SOMETHING","");
                startActivity(startIntent);


            }
        });

        ImageButton redBtn =(ImageButton) findViewById(R.id.redBtn);
        redBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent=new Intent(getApplicationContext(),LuasRed.class);
                startIntent.putExtra("com.example.ost.SOMETHING","");
                startActivity(startIntent);


            }
        });




    }
}
