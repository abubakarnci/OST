package com.example.ost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

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
        final TextView infoTV = (TextView) findViewById(R.id.infoTV);




        if (getIntent().hasExtra("com.example.ost.SOMETHING")) {

            int input = Integer.parseInt(getIntent().getExtras().getString("com.example.ost.SOMETHING"));




            String url = "https://api.jcdecaux.com/vls/v1/stations/"+input+"?contract=dublin&apiKey=71ad3cfc15ee4188cb493ea4977da1dd242e94dd";


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

                        //jsonParse();



                    } else {

                        infoTV.setText("Something wrong. Please try again");


                    }
                }
            });
        }




    }
}
