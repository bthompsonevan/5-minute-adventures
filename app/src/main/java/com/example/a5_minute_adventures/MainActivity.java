package com.example.a5_minute_adventures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.ArrayList;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;  // Used for testing in this app.


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

    //Shared Pref variable
    private SharedPreferences savedValues;

    //Shared Pref callback constants
    public static final String SAVED_VALUES = "savedValues";
    public static final String TEXT_BOX = "textBox";

    //variables to hold current values of the game state
    public String currentTextBox;

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

        //USE THIS FORMAT WHEN PULLING DATA OUT OF THE ARRAY LIST
        // questTextBox.setText(adventureItems.get(0).getTextBox());

        currentTextBox = adventureItems.get(0).getTextBox();
        questTextBox.setText(currentTextBox);

        savedValues = getSharedPreferences(SAVED_VALUES,MODE_PRIVATE);

    }

    @Override
    public void onPause(){
        // Saving values to be restored
        Editor editor = savedValues.edit();
        editor.putString(TEXT_BOX, currentTextBox);
        editor.commit();
        super.onPause();
    }

    @Override
    public void onResume(){
        super.onResume();
        //Getting savedValues from onPause
        currentTextBox = savedValues.getString(TEXT_BOX,"");

        //Putting value back into app
        questTextBox.setText(currentTextBox);
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
                currentTextBox = "No button pressed";
                questTextBox.setText(currentTextBox);
                break;

            case R.id.moveButton:
                currentTextBox = "Move button pressed";
                questTextBox.setText(currentTextBox);
                break;
        }

    }


}
