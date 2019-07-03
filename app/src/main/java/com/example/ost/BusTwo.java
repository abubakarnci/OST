package com.example.ost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BusTwo extends AppCompatActivity {

    private RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_two);
        final OkHttpClient clint = new OkHttpClient();
        mQueue = Volley.newRequestQueue(this);
        final TextView headTV=(TextView) findViewById(R.id.headTV);
        final TextView busTV=(TextView) findViewById(R.id.busTV);

        if (getIntent().hasExtra("com.example.ost.SOMETHING")) {

            headTV.setText("Loading");
            String input = getIntent().getExtras().getString("com.example.ost.SOMETHING");
            final String url = "https://data.smartdublin.ie/cgi-bin/rtpi/realtimebusinformation?stopid=" + input + "&format=json";


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
                    }
                    else {
                        headTV.setText("        Dublin Bus");
                        busTV.setText("Something wrong. Please try again");


                    }
                }
            });


        }

    }





    private void jsonParse() {

        String input = getIntent().getExtras().getString("com.example.ost.SOMETHING");
        final String url = "https://data.smartdublin.ie/cgi-bin/rtpi/realtimebusinformation?stopid=" + input + "&format=json";



        JsonObjectRequest request = new JsonObjectRequest(com.android.volley.Request.Method.GET, url, null,

                new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            ListView listView=(ListView)findViewById(R.id.listView);

                            final TextView busTV=(TextView) findViewById(R.id.busTV);
                            final TextView infoTV=(TextView) findViewById(R.id.infoTV);
                            final TextView headTV=(TextView) findViewById(R.id.headTV);



                            headTV.setText("        Dublin Bus");
                            int number=response.getInt("stopid");
                            String time=response.getString("timestamp");
                            String massage=response.getString("errormessage");




                            //subTV.setText(" Total Stands  Available Stands  Available Bikes");
                            //infoTV.setText("  "+tStands+"                "+aStands+"                  "+aBikes);
                            busTV.setText("Stop Number: "+number+"\nTime: "+time+"\nStatus: "+massage);

                            JSONArray array = response.getJSONArray("results");

                            JSONObject info=array.getJSONObject(0);

                            infoTV.setText("Bus   Destination                                  Time");



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