package com.example.ost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RailTwo extends AppCompatActivity   {

    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rail_two);
        final OkHttpClient clint = new OkHttpClient();
        mQueue = Volley.newRequestQueue(this);
        final TextView infoTV = (TextView) findViewById(R.id.infoTV);



        if (getIntent().hasExtra("com.example.ost.SOMETHING")) {
            //TextView oneTV=(TextView)findViewById(R.id.oneTV);
            String input = getIntent().getExtras().getString("com.example.ost.SOMETHING");
            //infoTV.setText(input);



        String url = "https://rail.danshub.online/api/station?name=" + input + "&minutes=30&format=json";

        Request request = new Request.Builder()
                .url(url)
                .build();
        clint.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (response.isSuccessful()) {

                    jsonParse();



                } else {

                    infoTV.setText("Something wrong. Please try again");


                }
            }
        });
    }

}




     private void jsonParse() {

        String input=getIntent().getExtras().getString("com.example.ost.SOMETHING");




        String url= "https://rail.danshub.online/api/station?name="+input+"&minutes=30&format=json";



        JsonObjectRequest request = new JsonObjectRequest(com.android.volley.Request.Method.GET, url, null,

                new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {



                            final TextView trainTV=(TextView) findViewById(R.id.trainTV);
                            final TextView infoTV=(TextView) findViewById(R.id.infoTV);
                            final TextView outputTV=(TextView) findViewById(R.id.outputTV);

                            trainTV.setText("");
                            JSONArray array = response.getJSONArray("objStationData");

                            JSONObject info=array.getJSONObject(0);
                            String time=info.getString("Querytime");
                            String station=info.getString("Stationfullname");
                            String code=info.getString("Stationcode");
                            String date=info.getString("Traindate");
                            infoTV.setText("Data Refreshed: "+time+"\n\n"+"Date: "+date+"\n\n"+"Station Name: "+station+"\n\n"+"Station Code: "+code+"\n\n");
                            trainTV.setText("\n Code   Origin  Destination Arrival Depart");
                            outputTV.setText("");
                            for(int i =0; i< array.length();i++){

                                JSONObject stationData=array.getJSONObject(i);


                                String tCode=stationData.getString("Traincode");
                                String origin=stationData.getString("Origin");
                                String dest=stationData.getString("Destination");
                                String arr=stationData.getString("Exparrival");
                                String dep=stationData.getString("Expdepart");

                                outputTV.append(tCode+"  "+origin+"  "+dest+"  "+ arr+"  "+dep+"\n\n");

                                //outputTV.append("helloe");
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
                , new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();
            }
        });

        mQueue.add(request);




    }


}
