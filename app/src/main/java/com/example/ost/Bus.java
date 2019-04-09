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

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Bus extends AppCompatActivity {
    private RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
        /*String input=searchTf.getText().toString();*/
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






        ImageButton tfiBtn=(ImageButton) findViewById(R.id.tfiBtn);
        tfiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String google="https://www.transportforireland.ie/";
                Uri webaddress= Uri.parse(google);
                Intent gotogoole=new Intent(Intent.ACTION_VIEW, webaddress);
                if(gotogoole.resolveActivity(getPackageManager()) != null){
                    startActivity(gotogoole);
                }

            }
        });

    /*
    How to get information from Dublin Bus API if API works.
        final OkHttpClient clint = new OkHttpClient();
        queue = Volley.newRequestQueue(this);
        final TextView title=(TextView) findViewById(R.id.title);
        final TextView result=(TextView) findViewById(R.id.result);

        if(getIntent().hasExtra("com.example.bus.SOMETHING")){
            title.setText("Please Wait");
            String input=getIntent().getExtras().getString("com.example.bus.SOMETHING");
            final String url="https://data.smartdublin.ie/cgi-bin/rtpi/busstopinformation?"+input+"&format=json";
            Request request=new Request.Builder()
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
                }
            });



        }

    }
    private void jsonParse() {

        String input=getIntent().getExtras().getString("com.example.ost.SOMETHING");
        final String url = "https://data.smartdublin.ie/cgi-bin/rtpi/busstopinformation?\"+input+\"&format=json";



        JsonObjectRequest request = new JsonObjectRequest(com.android.volley.Request.Method.GET, url, null,

                new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            final TextView title=(TextView) findViewById(R.id.title);
                            final TextView result=(TextView) findViewById(R.id.result);
                            String destination=response.getString("destination");


                            result.setText("Bus Destination"+destination);


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

        queue.add(request);

        */

    }
}
