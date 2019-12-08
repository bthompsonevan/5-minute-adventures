package com.example.a5_minute_adventures;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import static com.example.a5_minute_adventures.MainActivity.PASSED_DATA;
//import static com.example.a5_minute_adventures.MainActivity.YES_DATA;
//import static com.example.a5_minute_adventures.MainActivity.NO_DATA;

public class SecondActivity extends AppCompatActivity {

    TextView choiceTextBox;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        choiceTextBox = findViewById(R.id.choiceTextBox);

        Intent intent = getIntent();
        String passedString = intent.getStringExtra(PASSED_DATA);
        Toast toast = Toast.makeText(this, passedString, Toast.LENGTH_LONG);
        toast.show();

        choiceTextBox.setText(passedString);

    }



}