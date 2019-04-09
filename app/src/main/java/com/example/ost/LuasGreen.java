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

        String text= parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();

        String tfi = "http://luasforecasts.rpa.ie/analysis/view.aspx?id=";

        //Broombridge
        Uri Broombridge = Uri.parse(tfi+"71");
        Intent gotoBroombridge = new Intent(Intent.ACTION_VIEW, Broombridge);

        //Cabra
        Uri Cabra = Uri.parse(tfi+"70");
        Intent gotoCabra = new Intent(Intent.ACTION_VIEW, Cabra);

        //Grange
        Uri Grange = Uri.parse(tfi+"68");
        Intent gotoGrange = new Intent(Intent.ACTION_VIEW, Grange);

        //Dominick
        Uri Dominick = Uri.parse(tfi+"66");
        Intent gotoDominick = new Intent(Intent.ACTION_VIEW, Dominick);

        //Parnell
        Uri Parnell = Uri.parse(tfi+"65");
        Intent gotoParnell = new Intent(Intent.ACTION_VIEW, Parnell);

        //Phibsborough
        Uri Phibsborough = Uri.parse(tfi+"69");
        Intent gotoPhibsborough = new Intent(Intent.ACTION_VIEW, Phibsborough);

        //DIT
        Uri DIT = Uri.parse(tfi+"67");
        Intent gotoDIT = new Intent(Intent.ACTION_VIEW, DIT);

        //Marlborough
        Uri Marlborough = Uri.parse(tfi+"62");
        Intent gotoMarlborough = new Intent(Intent.ACTION_VIEW, Marlborough);

        //Trinity
        Uri Trinity = Uri.parse(tfi+"60");
        Intent gotoTrinity = new Intent(Intent.ACTION_VIEW, Trinity);

        //Dawson
        Uri Dawson = Uri.parse(tfi+"59");
        Intent gotoDawson = new Intent(Intent.ACTION_VIEW, Dawson);

        //Harcourt
        Uri Harcourt = Uri.parse(tfi+"25");
        Intent gotoHarcourt = new Intent(Intent.ACTION_VIEW, Harcourt);


        if (gotoBroombridge.resolveActivity(getPackageManager()) != null) {

            if(text.equals("Broombridge")) {

                startActivity(gotoBroombridge);
            }
            else if(text.equals("Cabra")){
                startActivity(gotoCabra);

            }
            else if(text.equals("Grange")){
                startActivity(gotoGrange);

            }
            else if(text.equals("Dominick")){
                startActivity(gotoDominick);

            }
            else if(text.equals("Parnell")){
                startActivity(gotoParnell);

            }
            else if(text.equals("Phibsborough")){
                startActivity(gotoPhibsborough);

            }
            else if(text.equals("Marlborough")){
                startActivity(gotoMarlborough);

            }
            else if(text.equals("DIT")){
                startActivity(gotoDIT);

            }
            else if(text.equals("Trinity")){
                startActivity(gotoTrinity);

            }
            else if(text.equals("Harcourt")){
                startActivity(gotoHarcourt);

            }
            else if(text.equals("Dawson")){
                startActivity(gotoDawson);

            }
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
