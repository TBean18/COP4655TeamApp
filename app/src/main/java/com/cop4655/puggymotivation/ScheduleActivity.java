package com.cop4655.puggymotivation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}