package com.example.a5_minute_adventures;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.a5_minute_adventures.MainActivity.YES_DATA;
import static com.example.a5_minute_adventures.MainActivity.NO_DATA;

public class SecondActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Intent intent = getIntent();
        String testString1 = intent.getStringExtra(YES_DATA);
        Toast toast = Toast.makeText(this, testString1, Toast.LENGTH_LONG);
        toast.show();

    }



}