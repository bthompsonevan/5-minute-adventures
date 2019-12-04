package com.example.a5_minute_adventures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    ArrayList<AdventureItem> adventureItems;

    //Setting up constant for asset file names
    public static final String ADVENTURE_1 = "adventure1.xml";

    //Constants for intent data passing
    public static final String YES_DATA = "yes";
    public static final String NO_DATA = "no";

    //Variables to hold the current area data
    private String yes = "test";

    //variables to hold information from the widgets
    TextView questTextBox;
    Button yesButton;
    Button noButton;
    Button moveButton;
    Spinner directionSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questTextBox = findViewById(R.id.questTextBox);
        yesButton = findViewById(R.id.yesButton);
        noButton = findViewById(R.id.noButton);
        moveButton = findViewById(R.id.moveButton);
        directionSpinner = findViewById(R.id.directionSpinner);


        Dal dal = new Dal(this);

        adventureItems = dal.parseXmlFile(ADVENTURE_1);

        //USE THIS FORMAT WHEN PULLING DATA OUT OF THE ARRAYLIST
        // questTextBox.setText(adventureItems.get(0).getTextBox());
        questTextBox.setText(adventureItems.get(0).getTextBox());

    }

    @Override
    public void onClick(View v) {

        //create intent so data can be passed to second activity
        Intent intent = new Intent(this, SecondActivity.class);

        switch(v.getId()){
            case R.id.yesButton:
                intent.putExtra(YES_DATA, yes);
                startActivity(intent);
                break;

            case R.id.noButton:

                break;

            case R.id.moveButton:

                break;
        }

    }
}
