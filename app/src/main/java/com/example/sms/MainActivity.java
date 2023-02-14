package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    int images[]= new int[]{
            R.drawable.s1,
            R.drawable.s2,
            R.drawable.s3,
            R.drawable.s4

    };
    Button btn;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Timer().schedule(new changeWallpaper(),0,1000);

            }
        });
    }
    class changeWallpaper extends TimerTask
    {
        @Override
        public void run() {
            WallpaperManager wallpaperManager= WallpaperManager.getInstance(getBaseContext());

            try {
                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(),images[i]));
                i++;
                if(i==4){
                    i=0;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}