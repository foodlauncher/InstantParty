package com.example.instantparty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentSender;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.skyfishjy.library.RippleBackground;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private PlacesClient placesClient;
    private Location mLastKnownLocation;
    private LocationCallback locationCallback;
    private Button btnFind, btnNearby;
    private RippleBackground rippleBg;
    private View mapView;
    private double latitude;
    private double longitude;
    private float DEFAULT_ZOOM = 16;

    AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String apiKey = "AIzaSyDNSYlMnfy-MUNl3MUoRjZDZWYD3WLg8AQ";

        autoCompleteTextView = findViewById(R.id.autocomplete);
        autoCompleteTextView.setAdapter(new PlaceAutoSuggestAdapter(MainActivity.this, android.R.layout.simple_list_item_1));

        btnNearby = findViewById(R.id.btn_nearby_find);
        btnFind = findViewById(R.id.btn_find);
        rippleBg = findViewById(R.id.ripple_bg);

        btnFind.setVisibility(View.INVISIBLE);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mapView = mapFragment.getView();

        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(MainActivity.this);

        if(!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), apiKey);
        }

        placesClient = Places.createClient(this);

        btnNearby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rippleBg.startRippleAnimation();
                getDeviceLocation();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        rippleBg.stopRippleAnimation();
                        Intent intent = new Intent(MainActivity.this, RestaurantResultsActivity.class);
                        intent.putExtra("latitude", latitude);
                        intent.putExtra("longitude", longitude);
                        startActivity(intent);
                        finish();
                    }
                }, 2000);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        if (mapView != null && mapView.findViewById(Integer.parseInt("1")) != null) {
            View locationButton = ((View) mapView.findViewById(Integer.parseInt("1")).getParent()).findViewById(Integer.parseInt("2"));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) locationButton.getLayoutParams();
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, 0);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
            layoutParams.setMargins(0, 0, 40, 180);
        }

        // Check if GPS is enabled or not and then request user to enable it
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(5000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);

        SettingsClient settingsClient = LocationServices.getSettingsClient(MainActivity.this);
        Task<LocationSettingsResponse> task = settingsClient.checkLocationSettings(builder.build());

        task.addOnSuccessListener(MainActivity.this, new OnSuccessListener<LocationSettingsResponse>() {
            @Override
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                getDeviceLocation();
            }
        });

        task.addOnFailureListener(MainActivity.this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if(e instanceof ResolvableApiException) {
                    ResolvableApiException resolvable = (ResolvableApiException) e;
                    try {
                        resolvable.startResolutionForResult(MainActivity.this, 51);
                    } catch (IntentSender.SendIntentException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        init();
    }

    private void init() {
        Log.d("TAG", "init: Initializing");

        autoCompleteTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_DONE || event.getAction() == KeyEvent.ACTION_DOWN || event.getAction() == KeyEvent.KEYCODE_ENTER) {
                    // execute our method for searching
                    geoLocate();
                }
                return false;
            }
        });

        mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
            @Override
            public boolean onMyLocationButtonClick() {
                btnNearby.setVisibility(View.VISIBLE);
                btnFind.setVisibility(View.INVISIBLE);
                getDeviceLocation();
                return true;
            }
        });

        hideSoftKeyboard();
    }

    private void geoLocate() {
        Log.d("TAG", "geoLocate: geolocating");

        String searchString = autoCompleteTextView.getText().toString();

        Geocoder geocoder= new Geocoder(MainActivity.this);
        List<Address> list = new ArrayList<>();
        try {
            list = geocoder.getFromLocationName(searchString, 1);
        } catch (IOException e) {
            Log.e("TAG", "geoLocate: IOException: " + e.getMessage() );
        }

        if(list.size() > 0) {
            Address address = list.get(0);

            Log.d("TAG", "geoLocate: found a location: " + address.toString());

            moveCamera(new LatLng(address.getLatitude(), address.getLongitude()), DEFAULT_ZOOM, address.getAddressLine(0));

            btnNearby.setVisibility(View.INVISIBLE);
            btnFind.setVisibility(View.VISIBLE);

            btnFind.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rippleBg.startRippleAnimation();
                    latitude = address.getLatitude();
                    longitude = address.getLongitude();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            rippleBg.stopRippleAnimation();
                            Intent intent = new Intent(MainActivity.this, RestaurantResultsActivity.class);
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            startActivity(intent);
                            finish();
                        }
                    }, 2000);
                }
            });
        }
    }

    private void moveCamera (LatLng latlng, float zoom, String title) {
        Log.d("TAG", "moveCamera: Moving the camera to: lat: " + latlng.latitude + ", lng: " + latlng.longitude);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, zoom));

        if(!title.equals("My location")){
            MarkerOptions options = new MarkerOptions()
                    .position(latlng)
                    .title(title);
            mMap.addMarker(options);
        }

        hideSoftKeyboard();
    }

    private void getDeviceLocation() {
        mFusedLocationProviderClient.getLastLocation()
                .addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        if (task.isSuccessful()) {
                            mLastKnownLocation = task.getResult();
                            if(mLastKnownLocation != null) {
                                Log.d("TAG", "onComplete: ID: " + mLastKnownLocation.getLatitude() + " " + mLastKnownLocation.getLongitude());
                                moveCamera(new LatLng(mLastKnownLocation.getLatitude(), mLastKnownLocation.getLongitude()), DEFAULT_ZOOM, "Current Location");
                                latitude = mLastKnownLocation.getLatitude();
                                longitude = mLastKnownLocation.getLongitude();
                            } else {
                                final LocationRequest locationRequest = LocationRequest.create();
                                locationRequest.setInterval(10000);
                                locationRequest.setFastestInterval(5000);
                                locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
                                locationCallback = new LocationCallback() {
                                    @Override
                                    public void onLocationResult(LocationResult locationResult) {
                                        super.onLocationResult(locationResult);
                                        if (locationResult == null) {
                                            return;
                                        }
                                        mLastKnownLocation = locationResult.getLastLocation();
                                        Log.d("TAG", "onComplete: ID: " + mLastKnownLocation.getLatitude() + " " + mLastKnownLocation.getLongitude());
                                        moveCamera(new LatLng(mLastKnownLocation.getLatitude(), mLastKnownLocation.getLongitude()), DEFAULT_ZOOM, "Current Location");
                                        latitude = mLastKnownLocation.getLatitude();
                                        longitude = mLastKnownLocation.getLongitude();
                                        mFusedLocationProviderClient.removeLocationUpdates(locationCallback);
                                    }
                                };
                                mFusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, null);
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Unable to get current location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void hideSoftKeyboard() {
        Log.d("TAG", "hideSoftKeyboard: yes");
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if(imm != null) {
            imm.hideSoftInputFromWindow(autoCompleteTextView.getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
        }
    }
}
