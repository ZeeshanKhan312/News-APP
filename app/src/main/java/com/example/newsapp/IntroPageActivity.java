package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

public class IntroPageActivity extends AppCompatActivity {

    private LottieAnimationView lottieView;
    private TextView getStartedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_page);

        lottieView = findViewById(R.id.lottieView);
        getStartedBtn=findViewById(R.id.getStartedBtn);

            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    lottieView.setAnimation(R.raw.animation_1);
                    lottieView.playAnimation();
                }
            },  4000);



        getStartedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroPageActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // if press back so this will not reappear
            }
        });
    }
}