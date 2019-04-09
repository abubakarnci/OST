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

public class LuasRed extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luas_red);

        Spinner spinner1=findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.red, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text= parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();

        String tfi = "http://luasforecasts.rpa.ie/analysis/view.aspx?id=";

        //Tallaght
        Uri Tallaght = Uri.parse(tfi+"1");
        Intent gotoTallaght = new Intent(Intent.ACTION_VIEW, Tallaght);

        //Saggart
        Uri Saggart = Uri.parse(tfi+"53");
        Intent gotoSaggart = new Intent(Intent.ACTION_VIEW, Saggart);

        //Citywest
        Uri Citywest = Uri.parse(tfi+"51");
        Intent gotoCitywest = new Intent(Intent.ACTION_VIEW, Citywest);

        //Belgard
        Uri Belgard = Uri.parse(tfi+"4");
        Intent gotoBelgard = new Intent(Intent.ACTION_VIEW, Belgard);

        //Kingswood
        Uri Kingswood = Uri.parse(tfi+"5");
        Intent gotoKingswood = new Intent(Intent.ACTION_VIEW, Kingswood);

        //Bluebell
        Uri Bluebell = Uri.parse(tfi+"8");
        Intent gotoBluebell = new Intent(Intent.ACTION_VIEW, Bluebell);

        //Fatima
        Uri Fatima = Uri.parse(tfi+"14");
        Intent gotoFatima = new Intent(Intent.ACTION_VIEW, Fatima);

        //Heuston
        Uri Heuston = Uri.parse(tfi+"16");
        Intent gotoHeuston = new Intent(Intent.ACTION_VIEW, Heuston);

        //Jervis
        Uri Jervis = Uri.parse(tfi+"20");
        Intent gotoJervis = new Intent(Intent.ACTION_VIEW, Jervis);

        //NCI
        Uri NCI = Uri.parse(tfi+"55");
        Intent gotoNCI = new Intent(Intent.ACTION_VIEW, NCI);

        //ThePoint
        Uri ThePoint = Uri.parse(tfi+"57");
        Intent gotoThePoint = new Intent(Intent.ACTION_VIEW, ThePoint);


        if (gotoTallaght.resolveActivity(getPackageManager()) != null) {

            if(text.equals("Tallaght")) {

                startActivity(gotoTallaght);
            }
            else if(text.equals("Saggart")){
                startActivity(gotoSaggart);

            }
            else if(text.equals("Citywest")){
                startActivity(gotoCitywest);

            }
            else if(text.equals("Belgard")){
                startActivity(gotoBelgard);

            }
            else if(text.equals("Kingswood")){
                startActivity(gotoKingswood);

            }
            else if(text.equals("Bluebell")){
                startActivity(gotoBluebell);

            }
            else if(text.equals("Fatima")){
                startActivity(gotoFatima);

            }
            else if(text.equals("Heuston")){
                startActivity(gotoHeuston);

            }
            else if(text.equals("Jervis")){
                startActivity(gotoJervis);

            }
            else if(text.equals("NCI")){
                startActivity(gotoNCI);

            }
            else if(text.equals("ThePoint")){
                startActivity(gotoThePoint);

            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
