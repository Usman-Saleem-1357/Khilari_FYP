package com.example.khilari;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splashscreen extends AppCompatActivity {
    Animation topAnim,bottomAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        ImageView imageView = findViewById(R.id.splash_logo);
        TextView welcText = findViewById(R.id.welcome_splash);
        TextView bottomtxt = findViewById(R.id.bottom_splash);

        imageView.setAnimation(topAnim);
        welcText.setAnimation(bottomAnim);
        bottomtxt.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(splashscreen.this,MainActivity.class);
                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View,String>(imageView,"logo_img");
                pairs[1] = new Pair<View,String>(welcText,"welcometxt");
                pairs[2] = new Pair<View,String>(bottomtxt,"createnewtxt");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(splashscreen.this,pairs);
                startActivity(i,options.toBundle());
            }
        },3000);

    }
}