package com.example.instantparty;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.radiobutton.MaterialRadioButton;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestaurantResultsActivity extends AppCompatActivity {

    private TextView textViewResult;
    private final String apiKey = "08990901fb962c7394216bd47b7a613a";
    private double latitude, longitude;
    private int DEFAULT_COUNT = 25;
    private String sortByRealDistance = "real_distance";
    private String sortByRating = "rating";
    private String sortByCost = "cost";
    RecyclerView recyclerView;
    List<Restaurant> restaurants1;
    List<Restaurant> restaurants2;

    MaterialRadioButton radioRating, radioDistance;
    RadioGroup radioGroup;
    Call<Search> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_results);
        Bundle extras = getIntent().getExtras();

        radioGroup = findViewById(R.id.radio_group);
        radioDistance = findViewById(R.id.radio_distance);
        radioRating = findViewById(R.id.radio_rating);

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

        if(radioRating.isChecked()) {
            call = searchApi.getResultBy(apiKey, latitude, longitude, DEFAULT_COUNT, sortByRating);
            callEnqueue(call);
        } else {
            call = searchApi.getResultBy(apiKey, latitude, longitude, DEFAULT_COUNT, sortByRealDistance);
            callEnqueue(call);
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(radioRating.isChecked()) {
                    call = searchApi.getResultBy(apiKey, latitude, longitude, DEFAULT_COUNT, sortByRating);
                } else {
                    call = searchApi.getResultBy(apiKey, latitude, longitude, DEFAULT_COUNT, sortByRealDistance);
                }
                callEnqueue(call);
            }
        });

        Call<Search> call2 = searchApi.getResultBy(apiKey, latitude, longitude, DEFAULT_COUNT, sortByRating);



//        call2.enqueue(new Callback<Search>() {
//            @Override
//            public void onResponse(Call<Search> call, Response<Search> response) {
//                if (!response.isSuccessful()) {
//                    textViewResult.setText("Response code: " + response.code());
//                    return;
//                }
//                Search search = response.body();
//
//                restaurants2 = search.getRestaurants();
//            }
//
//            @Override
//            public void onFailure(Call<Search> call, Throwable t) {
//                textViewResult.setText(t.getMessage());
//            }
//        });

        //sortRestaurants(restaurants1, restaurants2);

    }
//
//    private void sortRestaurants(List<Restaurant> restaurants1, List<Restaurant> restaurants2) {
//        List<Restaurant> finalRestaurants;
//
//        for(int i=0; i<)
//    }

    private void callEnqueue(Call call) {
        call.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Response code: " + response.code());
                    return;
                }
                Search search = response.body();

                restaurants1 = search.getRestaurants();

                recyclerView.setAdapter(new Adapter(restaurants1, R.layout.adapter, RestaurantResultsActivity.this));
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}