    package com.jarvis.mohammad.spinthebottle;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

    public class MainActivity extends AppCompatActivity {
    Random r;
    ImageView imageView;
    Button b_spin;
    int ramdom;
    int i;
    int lastDir;
    TextView textView;
        float pivotX;
        float pivotY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        final MediaPlayer mp= MediaPlayer.create(this,R.raw.sound);

        r= new Random();
        imageView=findViewById(R.id.img_bottle);
        b_spin=findViewById(R.id.button_spin);

        b_spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 pivotX=(imageView.getWidth())/2;
                 pivotY=(imageView.getHeight())/2;
                   ramdom=r.nextInt(3600);
                   i= (int) (Math.random()*10);
                RotateAnimation rotateAnimation= new RotateAnimation(lastDir,ramdom,pivotX,pivotY);
                textView.setText(getResources().getStringArray(R.array.bubble)[i]);

                rotateAnimation.setFillAfter(true);
                rotateAnimation.setDuration(4000);
                rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                imageView.startAnimation(rotateAnimation);
                mp.start();
                lastDir=ramdom;


            }
        });
    }
}