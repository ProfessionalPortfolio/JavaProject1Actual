package com.example.javaproject1actual;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Dictionary;

import java.util.Hashtable;

import java.util.ArrayList;


public class GestureExamplePlayer extends AppCompatActivity {

    //private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gesture_example_player);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });Dictionary<String, Integer> dict = new Hashtable<>();
        dict.put("Turn on lights", R.raw.lighton);
        dict.put("Turn off lights", R.raw.lightoff);
        dict.put("Turn on fan", R.raw.lightoff);
        dict.put("Turn off fan", R.raw.lightoff);
        dict.put("Increase fan speed", R.raw.fanup);
        dict.put("decrease fan speed", R.raw.fandown);
        dict.put("Set Thermostat to specified temperature", R.raw.setthermo);
        dict.put("number 0", R.raw.num0);
        dict.put("Number 1", R.raw.num1_);
        dict.put("Number 2", R.raw.num2);
        dict.put("Number 3", R.raw.num3);
        dict.put("Number 4", R.raw.num4);
        dict.put("Number 5", R.raw.num5);
        dict.put("Number 6", R.raw.num6);
        dict.put("Number 7", R.raw.num7);
        dict.put("Number 8", R.raw.num8);
        dict.put("Number 9", R.raw.num9);


        Bundle extras = getIntent().getExtras();
        String value = "";
        if (extras != null) {
            value = extras.getString("Gesture");

        }




        VideoView videoView;
        String path = "android.resource://" + getPackageName() + "/" + dict.get(value);
        videoView = findViewById(R.id.videoView);
        Uri uri = Uri.parse(path);
        videoView.setVideoURI(uri);

        videoView.start();

        videoView.setOnErrorListener((mp, what, extra) -> {
            System.out.println("Video playback error: what=" + what + ", extra=" + extra);
            return true;


        });

        Button retar= findViewById(R.id.button3);
        retar.setOnClickListener(v ->{

            videoView.start();

        });

        Button retar1= findViewById(R.id.button2);
        retar1.setOnClickListener(v -> {


            Intent intent = new Intent(this, VideoUploader.class);
            String carry = "";
            if (extras != null) {
                carry = extras.getString("Gesture");

            }
            assert extras != null;
            ArrayList<Integer> attempts = extras.getIntegerArrayList("Attempts");
            intent.putExtra("Gesture", carry);
            intent.putIntegerArrayListExtra("Attempts",attempts);
            startActivity(intent);


        });
    }










}