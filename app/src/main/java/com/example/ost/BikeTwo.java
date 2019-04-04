package com.example.ost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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

public class BikeTwo extends AppCompatActivity {

    private RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_two);
        final OkHttpClient clint = new OkHttpClient();
        mQueue = Volley.newRequestQueue(this);





        if (getIntent().hasExtra("com.example.ost.SOMETHING")) {

            String input=getIntent().getExtras().getString("com.example.ost.SOMETHING");
            final String url = "https://api.jcdecaux.com/vls/v1/stations/"+input+"?contract=dublin&apiKey=71ad3cfc15ee4188cb493ea4977da1dd242e94dd";


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

                       /* final String myres=response.body().string();

                        BikeTwo.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                final TextView infoTV=(TextView) findViewById(R.id.infoTV);
                                infoTV.setText(myres);
                            }
                        });*/

                        jsonParse();


                    } else {
                        final TextView infoTV=(TextView) findViewById(R.id.infoTV);

                        infoTV.setText("Something wrong. Please try again");


                    }
                }
            });
        }




    }




    private void jsonParse() {

        String input=getIntent().getExtras().getString("com.example.ost.SOMETHING");
        final String url = "https://api.jcdecaux.com/vls/v1/stations/"+input+"?contract=dublin&apiKey=71ad3cfc15ee4188cb493ea4977da1dd242e94dd";



        JsonObjectRequest request = new JsonObjectRequest(com.android.volley.Request.Method.GET, url, null,

                new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            final TextView bikeTV=(TextView) findViewById(R.id.bikeTV);
                            final TextView subTV=(TextView) findViewById(R.id.subTV);
                            int number=response.getInt("number");
                            int tStands=response.getInt("bike_stands");
                            int aStands=response.getInt("available_bike_stands");
                            int aBikes=response.getInt("available_bikes");
                            String name=response.getString("name");
                            boolean banking=response.getBoolean("banking");
                            String status=response.getString("status");

                            subTV.setText("Total Stands  Available Stands  Available Bikes");
                            bikeTV.setText("Stop Number: "+number+"\nStop Name: "+name+"\nStatus: "+status+"\nBanking Available: "+banking);












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
