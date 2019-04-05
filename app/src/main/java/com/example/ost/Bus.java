package com.example.ost;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Bus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
        //Hi
        /*
        Button seaBtn=(Button) findViewById(R.id.seaBtn);
        seaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText( Bus.this,"Service Unavailable",Toast.LENGTH_SHORT).show();
                    }
                },5000);
            }
        });
        */
       /*Button seaBtn =(Button) findViewById(R.id.seaBtn);
        seaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent=new Intent(getApplicationContext(), Bus2.class);
                startIntent.putExtra("org.metorschools.quicklauncher.SOMETHING","");
                startActivity(startIntent);
            }
        });*/





        ImageButton tfiBtn=(ImageButton) findViewById(R.id.tfiBtn);
        tfiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String google="http://www.dublinbus.ie/";
                Uri webaddress= Uri.parse(google);
                Intent gotogoole=new Intent(Intent.ACTION_VIEW, webaddress);
                if(gotogoole.resolveActivity(getPackageManager()) != null){
                    startActivity(gotogoole);
                }

            }
        });

    }
}
