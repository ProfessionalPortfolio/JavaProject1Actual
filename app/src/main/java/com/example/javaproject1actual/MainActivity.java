package com.example.javaproject1actual;



import static java.sql.DriverManager.println;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> attempts = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
        attempts.add(0);
        attempts.add(0);
        attempts.add(0);
        attempts.add(0);
        attempts.add(0);
        attempts.add(0);
        attempts.add(0);
        attempts.add(0);
        attempts.add(0);
        attempts.add(0);
        attempts.add(0);
        attempts.add(0);
        attempts.add(0);
        attempts.add(0);
        attempts.add(0);
        attempts.add(0);
        attempts.add(0);
        attempts.add(0);
        attempts.add(0);
        attempts.add(0);
        attempts.add(0);
        attempts.add(0);
        attempts.add(0);
        attempts.add(0);









        //get the spinner from the xml.
        Spinner dropdown = findViewById(R.id.spinner1);
        //create a list of items for the spinner.
        String[] items = new String[]{"Turn on lights", "Turn off lights", "Turn on fan", "Turn off fan", "Increase fan speed", "decrease fan speed", "Set Thermostat to specified temperature", "Number 0","Number 1","Number 2","Number 3","Number 4","Number 5","Number 6","Number 7","Number 8"," Number9"} ;
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.

        String selectedValue;
        dropdown.setAdapter(adapter);





        Button btnSecondScreen = findViewById(R.id.button);

        btnSecondScreen.setOnClickListener(v ->{

            Bundle extras = getIntent().getExtras();
            if (extras != null){
               attempts= extras.getIntegerArrayList("Attempts");

            }

            Intent intent = new Intent(this, GestureExamplePlayer.class);
            intent.putExtra("Gesture",dropdown.getSelectedItem().toString());
            intent.putIntegerArrayListExtra("Attempts",attempts);
            startActivity(intent);

        });



    }
}