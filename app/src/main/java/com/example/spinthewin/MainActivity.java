package com.example.spinthewin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView bottle;
    private Random random = new Random();
    private int lastDir;
    private boolean spinning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottle = findViewById(R.id.bottle);
    }

    public void spin(View v){
        if(!spinning) {
            int newDir = random.nextInt(2400);
            float x = bottle.getWidth() / 2;
            float y = bottle.getHeight() / 2;

            Animation rotation = new RotateAnimation(lastDir, newDir, x, y);
            rotation.setDuration(2500);
            rotation.setFillAfter(true);
            rotation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            lastDir = newDir;
            bottle.startAnimation(rotation);
        }

    }
}
