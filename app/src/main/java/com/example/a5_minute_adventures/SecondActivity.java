package com.example.a5_minute_adventures;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import static com.example.a5_minute_adventures.MainActivity.PASSED_DATA;

public class SecondActivity extends AppCompatActivity implements
        View.OnClickListener {

    //Setting up widget variables
    TextView choiceTextBox;
    Button returnButton;
    Button newGameButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        //Getting values for widgets
        choiceTextBox = findViewById(R.id.choiceTextBox);
        returnButton = findViewById(R.id.returnButton);
        newGameButton = findViewById(R.id.newGameButton);

        //Setting listener for buttons
        returnButton.setOnClickListener(this);
        newGameButton.setOnClickListener(this);

        Intent intent = getIntent();
        String passedString = intent.getStringExtra(PASSED_DATA);
        Toast toast = Toast.makeText(this, passedString, Toast.LENGTH_LONG);
        toast.show();

        choiceTextBox.setText(passedString);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.returnButton:

                break;
            case R.id.newGameButton:
                
                break;

        }
    }



}