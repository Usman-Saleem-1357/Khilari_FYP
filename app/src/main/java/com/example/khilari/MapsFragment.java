package com.example.khilari;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

public class MapsFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng sydney = new LatLng(-34, 151);
            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_maps,container,false);
        ListView listView = view.findViewById(R.id.list1);
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
        listAdapter adapter = new listAdapter(getActivity(),R.layout.listitem,userData);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(),profview.class);
                intent.putExtra("Image",imgId[position]);
                intent.putExtra("Name",names[position]);
                intent.putExtra("Phone",PhoneNo[position]);
                intent.putExtra("Interests",interest[position]);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}