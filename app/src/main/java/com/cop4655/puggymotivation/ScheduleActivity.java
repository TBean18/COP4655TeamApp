package com.cop4655.puggymotivation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ScheduleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Schedule button toast
         Button ScheduleButton = findViewById(R.id.ScheduleBtn);
         ScheduleButton.setOnClickListener(view -> {
             Toast.makeText(this, " Quote Scheduled", Toast.LENGTH_SHORT).show();
         });



    }
}