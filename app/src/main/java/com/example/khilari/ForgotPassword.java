package com.example.khilari;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        Button sub = findViewById(R.id.submit);
        TextInputEditText em = findViewById(R.id.emailforgottxt);
        TextInputEditText ph = findViewById(R.id.phoneforgottxt);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = em.getText().toString() + " " + ph.getText().toString();
                Toast.makeText(ForgotPassword.this,s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}