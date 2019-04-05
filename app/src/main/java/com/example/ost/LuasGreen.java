package com.example.ost;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class LuasGreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luas_green);

        Spinner spinner1=findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.green, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);




    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //String input="";
        String text= parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();

        String tfi = "http://luasforecasts.rpa.ie/analysis/view.aspx?id=";

        //Broombridge
        Uri Broombridge = Uri.parse(tfi+"71");
        Intent gotoBroombridge = new Intent(Intent.ACTION_VIEW, Broombridge);

        //Cabra
        Uri Cabra = Uri.parse(tfi+"70");
        Intent gotoCabra = new Intent(Intent.ACTION_VIEW, Cabra);


        if (gotoBroombridge.resolveActivity(getPackageManager()) != null) {

            if(text.equals("Broombridge")) {

                startActivity(gotoBroombridge);
            }
            else if(text.equals("Cabra")){
                startActivity(gotoCabra);

            }
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
