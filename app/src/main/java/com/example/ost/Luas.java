package com.example.ost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class Luas extends AppCompatActivity {

    private ImageButton redButton;
    private ImageButton greenButton;

    public void addToFav(View view){
        Log.i("Info", "addToFav Button Pressed");

    }
    

    public void menuIcon(View view){
        Log.i("Info", "MenuIcon Pressed");

    }

    public void redLineBtnClick(View view){
        Log.i("Info", "Red Button Pressed");

    }
    public void greenLineBtnClick(View view){
        Log.i("Info", "Green Button Pressed");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luas);
        redButton = (ImageButton) findViewById(R.id.redLineBtn);
        greenButton = (ImageButton) findViewById(R.id.greenLineBtn);

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Luas.this,LuasRed.class);
                startActivity(intentLoadNewActivity);
            }
        });
        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Luas.this,LuasGreen.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }
}
