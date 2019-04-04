package com.example.ost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Bike extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike);

        final EditText searchTF=(EditText) findViewById(R.id.searchTF);
        Button searchBtn = (Button) findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), BikeTwo.class);
                int input= (int) Integer.parseInt(String.valueOf(searchTF.getText()));
                startIntent.putExtra("com.example.ost.SOMETHING", input);
                startActivity(startIntent);
            }
        });

    }
}
