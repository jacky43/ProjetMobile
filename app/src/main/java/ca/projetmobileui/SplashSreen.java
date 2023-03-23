package ca.projetmobileui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashSreen extends AppCompatActivity {

    private ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_sreen);

        logo = findViewById(R.id.logo);
        logo.startAnimation(AnimationUtils.loadAnimation(this, R.anim.side_slide));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent y = new Intent(SplashSreen.this, MainActivity.class);
                startActivity(y);
                finish();
            }
        }, 5000);
    }
}