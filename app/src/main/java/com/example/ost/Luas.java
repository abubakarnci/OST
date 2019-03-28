package com.example.ost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Luas extends AppCompatActivity {

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
    }
}
