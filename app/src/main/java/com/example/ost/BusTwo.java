package com.example.ost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BusTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_two);

        //for moving to another activity Bus2
        Button webBtn =(Button) findViewById(R.id.webBtn);
        webBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent=new Intent(getApplicationContext(), WebBus.class);
                startIntent.putExtra("com.example.ost.SOMETHING","");
                startActivity(startIntent);
            }
        });

    }
}
