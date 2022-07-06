package com.example.cryptotrackerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CryptoActivity extends AppCompatActivity {
    private TextView txtSymbol, txtName, txtPrice, txtMaxSupply, txtCirculatingSupply, txtTotalSupply, txtTwitter;
    private String cryptoName;
    private RecyclerView TweetRec;
    private ArrayList<TweetsRecModel> tweetsArrayList;
    private TweetsRecAdapter tweetsRecAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto);
        initViews();

        TweetRec = findViewById(R.id.cryptoRec);
        tweetsArrayList = new ArrayList<>();
        tweetsRecAdapter = new TweetsRecAdapter(tweetsArrayList, this);
        TweetRec.setLayoutManager(new LinearLayoutManager(this));
        TweetRec.setAdapter(tweetsRecAdapter);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            cryptoName = extras.getString("coinName");
            txtName.setText(extras.getString("coinName"));
            txtSymbol.setText(extras.getString("coinSymbol"));
            txtPrice.setText(extras.getString("coinPrice"));
            txtMaxSupply.setText(extras.getString("coinMaxSupply"));
            txtCirculatingSupply.setText(extras.getString("coinCirculatingSupply"));
            txtTotalSupply.setText(extras.getString("coinTotalSupply"));
        }

        getTweets();


    }


    public void getTweets() {
        String url = "https://api.twitter.com/1.1/search/tweets.json?q=%23"+ cryptoName +"&result_type=popular";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray dataArray = response.getJSONArray("statuses");
                    for(int i=0; i<dataArray.length(); i++){
                        JSONObject dataObj = dataArray.getJSONObject(i);
                        int id = dataObj.getInt("id");
                        JSONObject userObj = dataObj.getJSONObject("user");
                        String name = userObj.getString("name");
                        String tweet = dataObj.getString("text");
                        //txtTwitter.setText(name);
                        tweetsArrayList.add(new TweetsRecModel(id, name, tweet));

                    }
                    tweetsRecAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(CryptoActivity.this, "Fail to extract json data", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CryptoActivity.this, "Fail to get data", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("APIkey", "dy9wkIag4g9fiinNzTJXcXJCf");
                headers.put("Authorization", "Bearer "+ "AAAAAAAAAAAAAAAAAAAAAEk2cgEAAAAAMjnJIPerbvxZpT%2BCbS%2F5LAygubQ%3DPEaqaF25cxaeSjoHT3wJfiRXoUzRyD4Lto8BoO2IAvagFqnpiP\n" );

                return headers;
            }
        };
        requestQueue.add(jsonObjectRequest);
    }

    private void initViews() {
        txtSymbol = findViewById(R.id.cryptoSymbol);
        txtName = findViewById(R.id.cryptoName);
        txtPrice = findViewById(R.id.cryptoPrice);
        txtMaxSupply = findViewById(R.id.cryptoMaxSupply);
        txtCirculatingSupply = findViewById(R.id.cryptoCirculatingSupply);
        txtTotalSupply = findViewById(R.id.cryptoTotalSupply);
        txtTwitter = findViewById(R.id.twitter);
    }





}