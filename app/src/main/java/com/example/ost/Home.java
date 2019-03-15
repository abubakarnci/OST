package com.example.ost;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Bus Button
        ImageButton busBtn=(ImageButton) findViewById(R.id.busBtn);
        busBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent=new Intent(getApplicationContext(),Bus.class);
                startIntent.putExtra("org.metorschools.quicklauncher.SOMETHING","");
                startActivity(startIntent);


            }
        });


        //Bike button
        ImageButton bikeBtn=(ImageButton) findViewById(R.id.bikeBtn);
        bikeBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent=new Intent(getApplicationContext(),Bike.class);
                startIntent.putExtra("org.metorschools.quicklauncher.SOMETHING","hi");
                startActivity(startIntent);


            }
        });


        //Rail button
        ImageButton railBtn=(ImageButton) findViewById(R.id.railBtn);
        railBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent=new Intent(getApplicationContext(),Rail.class);
                startIntent.putExtra("org.metorschools.quicklauncher.SOMETHING","hi");
                startActivity(startIntent);


            }
        });

        //Luas button
        ImageButton luasBtn =(ImageButton) findViewById(R.id.luasBtn);
        luasBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent=new Intent(getApplicationContext(),Luas.class);
                startIntent.putExtra("org.metorschools.quicklauncher.SOMETHING","");
                startActivity(startIntent);


            }
        });

        ImageButton tfiBtn = (ImageButton) findViewById(R.id.tfiBtn);
        tfiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tfi = "https://www.transportforireland.ie/";
                Uri webaddress = Uri.parse(tfi);
                Intent gotoTfi = new Intent(Intent.ACTION_VIEW, webaddress);

                if (gotoTfi.resolveActivity(getPackageManager()) != null) {

                    startActivity(gotoTfi);
                }
            }

        });


        if(getIntent().hasExtra("org.metorschools.quicklauncher.SOMETHING")){
            TextView oneTV=(TextView)findViewById(R.id.oneTV);
            String text=getIntent().getExtras().getString("org.metorschools.quicklauncher.SOMETHING");
            oneTV.setText(text);
        }
    }
}
