package com.example.khilari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class profview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profview);
        Intent intent = this.getIntent();
        if(intent != null)
        {
            int id = intent.getIntExtra("Image",0);
            String name = intent.getStringExtra("Name");
            String inter = intent.getStringExtra("Interests");
            String ph = intent.getStringExtra("Phone");

            ImageView img = findViewById(R.id.imginprof);
            TextView name1 = findViewById(R.id.nameprof);
            TextView phone = findViewById(R.id.phoneprof);
            TextView interest = findViewById(R.id.interestsprof);

            img.setImageResource(id);
            name1.setText(name);
            interest.setText(inter);
            phone.setText(ph);
        }
    }
}