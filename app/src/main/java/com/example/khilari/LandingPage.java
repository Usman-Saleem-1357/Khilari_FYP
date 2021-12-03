package com.example.khilari;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LandingPage extends AppCompatActivity implements OnMapReadyCallback, LocationListener {
    MapView map;
    LatLng loc;
    LocationManager locationManager;
    LocationListener locationListener;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landingpage);

        ChipNavigationBar chipNavigationBar = findViewById(R.id.nav_menu);
        chipNavigationBar.setItemSelected(R.id.bottom_nav_map,true);


        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            String[] perms = {Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.INTERNET};
            requestPermissions(perms,1 );
        }
        else {
            Criteria criteria = new Criteria();
            criteria.setAccuracy(Criteria.ACCURACY_FINE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 50, this);
        }
        map = findViewById(R.id.map);
        map.onCreate(savedInstanceState);

        FrameLayout f = findViewById(R.id.sheet);
        BottomSheetBehavior.from(f).setPeekHeight(190);
        //BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(f.getContext());
        BottomSheetBehavior.from(f).addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                ImageView arrow = findViewById(R.id.arrow);
                arrow.setRotation(slideOffset * -180);
            }
        });
        ListView listView = findViewById(R.id.list);
        int[] imgId={R.drawable.aaa,R.drawable.bbb,R.drawable.ccc,R.drawable.ddd,R.drawable.eee};
        String[] names={"Usama Ahmad","Saad Ali","Usman Saleem","Waqas Bin Abbas","Muhammad Suleman"};
        String[] interest={"Circket,Football","Circket,Hockey","Online Gaming,Coding","AI,Data Science"
                ,"Holidays,Lecture Bunk"};
        String[] PhoneNo = {"03123450130","03123450130","03123450130","03123450130","03123450130"};
        String[] time={"4:48 PM","4:48 PM","4:48 PM","4:48 PM","4:48 PM"};
        ArrayList<Users> userData= new ArrayList<Users>();

        for(int i = 0;i<imgId.length;i++)
        {
            Users user= new Users(names[i],interest[i],PhoneNo[i],time[i],imgId[i]);
            userData.add(user);
        }
        listAdapter adapter = new listAdapter(this,R.layout.listitem,userData);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LandingPage.this,profview.class);
                intent.putExtra("Image",imgId[position]);
                intent.putExtra("Name",names[position]);
                intent.putExtra("Phone",PhoneNo[position]);
                intent.putExtra("Interests",interest[position]);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng pak = new LatLng(31.477364950213698, 74.32199188408663);
        googleMap.clear();
        googleMap.addMarker(new MarkerOptions()
        .position(loc)
        .title("In Pakistan"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pak,10.0f));
        List<Address> address = null;
        Geocoder geo = new Geocoder(this, Locale.getDefault());
        try { 
            address = geo.getFromLocation(loc.latitude,loc.longitude,1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "Current Location: " + address.get(0).getAddressLine(0) , Toast.LENGTH_SHORT).show();
    }



    @Override
    protected void onPause() {
        super.onPause();
        map.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        map.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        map.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        map.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        map.onLowMemory();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        map.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        map.onStart();
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        loc = new LatLng(location.getLatitude(),location.getLongitude());
        map.getMapAsync(this);
    }
}