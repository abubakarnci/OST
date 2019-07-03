package com.example.ost;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Bus extends AppCompatActivity {
    //private RequestQueue queue;
    //Button seaBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        final EditText searchTF=(EditText) findViewById(R.id.searchTF);
        Button seaBtn = (Button) findViewById(R.id.seaBtn);
        seaBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), BusTwo.class);
                String input=searchTF.getText().toString();
                startIntent.putExtra("com.example.ost.SOMETHING", input);
                startActivity(startIntent);
            }
        });


    }





}