package com.example.khilari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    Animation leftAnim,rightAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.login_screen_button);
        TextView signUp = findViewById(R.id.txtSignUp);
        TextView forgot = findViewById(R.id.forget);
        EditText email = findViewById(R.id.login_email);
        EditText pass = findViewById(R.id.login_pass);
        ImageView logo = findViewById(R.id.login_logo);
        TextView dontHave = findViewById(R.id.donthave);
        TextView logintxt = findViewById(R.id.login_txt);

        leftAnim= AnimationUtils.loadAnimation(this,R.anim.left_animation);
        rightAnim= AnimationUtils.loadAnimation(this,R.anim.right_animation);

        logo.setAnimation(leftAnim);
        logintxt.setAnimation(rightAnim);
        email.setAnimation(leftAnim);
        pass.setAnimation(rightAnim);
        forgot.setAnimation(leftAnim);
        btnLogin.setAnimation(rightAnim);
        dontHave.setAnimation(leftAnim);
        signUp.setAnimation(leftAnim);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, temporary.class);
                startActivity(i);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i2);
            }
        });

        forgot.setClickable(true);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(LoginActivity.this,ForgotPassword.class);
                startActivity(i3);
            }
        });



    }
}