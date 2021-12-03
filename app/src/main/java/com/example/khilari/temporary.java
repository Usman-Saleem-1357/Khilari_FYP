package com.example.khilari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class temporary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temporary);
        Fragment fragment = new MapsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.temp_container,fragment).commit();
        ChipNavigationBar chipNavigationBar = findViewById(R.id.temp_chip);
        chipNavigationBar.setItemSelected(R.id.bottom_nav_map,true);
    }
}