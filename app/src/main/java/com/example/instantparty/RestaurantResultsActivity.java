package com.example.instantparty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestaurantResultsActivity extends AppCompatActivity {

    private TextView textViewResult;
    private final String apiKey = "08990901fb962c7394216bd47b7a613a";
    private double latitude, longitude;
    private int DEFAULT_COUNT = 10;
    private String sortByRealDistance = "real_distance";
    private String sortByRating = "rating";
    private String sortByCost = "cost";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_results);
        Bundle extras = getIntent().getExtras();

        assert extras != null;
        latitude = extras.getDouble("latitude");
        longitude = extras.getDouble("longitude");
        Log.d("TAG", "onCreate: " + latitude + " " + longitude);

        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://developers.zomato.com/api/v2.1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiSearchInterface searchApi = retrofit.create(ApiSearchInterface.class);

        Call<Search> call = searchApi.getResultBy(apiKey, latitude, longitude, DEFAULT_COUNT, sortByRealDistance);

        call.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Response code: " + response.code());
                    return;
                }
                Search search = response.body();

                List<Restaurant> restaurants = search.getRestaurants();

                recyclerView.setAdapter(new Adapter(restaurants, R.layout.adapter, getApplicationContext()));

            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }
}