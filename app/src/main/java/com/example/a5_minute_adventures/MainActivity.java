package com.example.a5_minute_adventures;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.ArrayList;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;  // Used for testing in this app.


public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, OnItemSelectedListener {

    ArrayList<AdventureItem> adventureItems;

    //Setting up constant for asset file names
    public static final String ADVENTURE_1 = "adventure1.xml";

    //Constants for intent data passing
    public static final String PASSED_DATA = "passedData";
    public static final String PASSED_X = "passedX";
    public static final String PASSED_Y = "passedY";
    public static final Integer REQUEST_CODE = 1;

    //Game Text Constants
    public static final String NO_MOVE_MESSAGE = "The nature growth does not allow you to move in that direction";

    //Variables to hold the current area data
    //private String yes = "";

    //Shared Pref variable
    private SharedPreferences savedValues;

    //Shared Pref callback constants
    public static final String SAVED_VALUES = "savedValues";
    public static final String TEXT_BOX = "textBox";
    public static final String X_COORD = "xCoord";
    public static final String Y_COORD = "yCoord";

    //variables to hold current values of the game state
    public String currentTextBox;

    //variables to hold information from the widgets
    TextView questTextBox;
    Button yesButton;
    Button noButton;
    Button moveButton;
    Spinner directionSpinner;

    //variables to hold current position of user
    public Integer xcoord;
    public Integer ycoord;

    String selectedItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questTextBox = findViewById(R.id.questTextBox);
        yesButton = findViewById(R.id.yesButton);
        noButton = findViewById(R.id.noButton);
        moveButton = findViewById(R.id.moveButton);
        directionSpinner = findViewById(R.id.directionSpinner);

        directionSpinner.setOnItemSelectedListener(this);

        Dal dal = new Dal(this);
        adventureItems = dal.parseXmlFile(ADVENTURE_1);

        //USE THIS FORMAT WHEN PULLING DATA OUT OF THE ARRAY LIST
        // questTextBox.setText(adventureItems.get(0).getTextBox());

        //Getting game start values
        xcoord = 5;
        ycoord = 0;

        currentTextBox = adventureItems.get(GetAdventureItemBasedOnCoord(xcoord,ycoord)).getTextBox();
        questTextBox.setText(currentTextBox);

        savedValues = getSharedPreferences(SAVED_VALUES,MODE_PRIVATE);

    }

    @Override
    public void onPause(){
        // Saving values to be restored
    //    Editor editor = savedValues.edit();
    //    editor.putString(TEXT_BOX, questTextBox.getText().toString());
    //  editor.putInt(X_COORD, xcoord);
    //    editor.putInt(Y_COORD, ycoord);
    //    editor.commit();
        super.onPause();
    }

    @Override
    public void onResume(){
        super.onResume();
        //Getting savedValues from onPause

        //Putting value back into app
      //  currentTextBox = savedValues.getString(TEXT_BOX,"");
      // questTextBox.setText(savedValues.getString(TEXT_BOX,""));
     //  xcoord = savedValues.getInt(X_COORD, 0);
     //  ycoord = savedValues.getInt(Y_COORD, 0);
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(TEXT_BOX, questTextBox.getText().toString());
        outState.putInt(X_COORD, xcoord);
        outState.putInt(Y_COORD, ycoord);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        questTextBox.setText(savedInstanceState.getString(TEXT_BOX));
        xcoord = savedInstanceState.getInt(X_COORD);
        ycoord = savedInstanceState.getInt(Y_COORD);
    }

    @Override
    public void onClick(View v) {

        //create intent so data can be passed to second activity
        Intent intent = new Intent(this, SecondActivity.class);

        //variable to hold the integer of the array location
        Integer currentLocation = null;
        String passedData = null;
        Integer passedX = xcoord;
        Integer passedY = ycoord;

        switch(v.getId()){
            case R.id.yesButton:
                currentLocation = GetAdventureItemBasedOnCoord(xcoord,ycoord);
                passedData = adventureItems.get(currentLocation).getYes();
                intent.putExtra(PASSED_DATA, passedData);
                intent.putExtra(PASSED_X, passedX);
                intent.putExtra(PASSED_Y, passedY);
                startActivity(intent);
                break;

            case R.id.noButton:
                 currentLocation = GetAdventureItemBasedOnCoord(xcoord,ycoord);
                 passedData = adventureItems.get(currentLocation).getNo();
                intent.putExtra(PASSED_DATA, passedData);
                intent.putExtra(PASSED_X, xcoord);
                intent.putExtra(PASSED_Y, ycoord);
                startActivity(intent);
                break;

            case R.id.moveButton:
                if (selectedItem == "North"){
                    if(CheckValidMove(xcoord,ycoord + 1)){
                        ycoord += 1;
                        Toast toast = Toast.makeText(this, "x= " + xcoord.toString()+ " " + "y= " + ycoord.toString(), Toast.LENGTH_LONG);
                        toast.show();
                       currentLocation = GetAdventureItemBasedOnCoord(xcoord, ycoord);
                       questTextBox.setText(adventureItems.get(currentLocation).getTextBox());
                    }else{
                        Toast toast = Toast.makeText(this, "You cannot move in the direction", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
                if (selectedItem == "South") {
                    if(CheckValidMove(xcoord, ycoord - 1)){
                        ycoord -= 1;
                        Toast toast = Toast.makeText(this, "x= " + xcoord.toString()+ " " + "y= " + ycoord.toString(), Toast.LENGTH_LONG);
                        toast.show();
                        currentLocation = GetAdventureItemBasedOnCoord(xcoord, ycoord);
                        questTextBox.setText(adventureItems.get(currentLocation).getTextBox());
                    }
                    else{
                        Toast toast = Toast.makeText(this, "You cannot move in the direction", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
                if (selectedItem == "East") {
                    if(CheckValidMove(xcoord +1, ycoord)){
                        xcoord += 1;
                        Toast toast = Toast.makeText(this, "x= " + xcoord.toString()+ " " + "y= " + ycoord.toString(), Toast.LENGTH_LONG);
                        toast.show();
                        currentLocation = GetAdventureItemBasedOnCoord(xcoord, ycoord);
                        questTextBox.setText(adventureItems.get(currentLocation).getTextBox());
                    }else{
                        Toast toast = Toast.makeText(this, "You cannot move in the direction", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
                if (selectedItem == "West") {
                    if(CheckValidMove(xcoord -1, ycoord)){
                        xcoord -= 1;
                        Toast toast = Toast.makeText(this, "x= " + xcoord.toString()+ " " + "y= " + ycoord.toString(), Toast.LENGTH_LONG);
                        toast.show();
                        currentLocation = GetAdventureItemBasedOnCoord(xcoord, ycoord);
                        questTextBox.setText(adventureItems.get(currentLocation).getTextBox());
                    }else{
                        Toast toast = Toast.makeText(this, "You cannot move in the direction", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
            }
        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch(position){
                case 0:
                    selectedItem = "North";
                    break;
                case 1:
                    selectedItem = "South";
                    break;
                case 2:
                    selectedItem = "East";
                    break;
                case 3:
                    selectedItem = "West";
            }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //At this time nothing is not an option.
        //do not need to implement
    }

    //Setting the coordinates from the intent return
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                xcoord = data.getIntExtra(PASSED_X,0);
                ycoord = data.getIntExtra(PASSED_Y,0);
                Integer resetLocation =  GetAdventureItemBasedOnCoord(xcoord,ycoord);
                questTextBox.setText(adventureItems.get(resetLocation).toString());
            }
        }
    }

    //for use with future refactoring?
    public void UpdatePlayerPosition(Spinner directionSpinner, Integer xcoord, Integer ycoord){

    }

    public boolean CheckValidMove(Integer xcoord, Integer ycoord) {
        //Handling the area outside the possible move as a catch all
        if (xcoord >= 8 || xcoord <= 3 || ycoord <= -1  || ycoord >= 5){
            return false;
        }
        //Handling areas that contain a mix of possible and not possible moves
        if(xcoord == 4 && ycoord == 0 || xcoord == 6 && ycoord == 0 ||
           xcoord == 4 && ycoord == 1 || xcoord == 6 && ycoord == 1 ||
           xcoord == 6 && ycoord == 2 || xcoord == 4 && ycoord == 3 ||
           xcoord == 6 && ycoord == 3 || xcoord == 4 && ycoord == 4 ||
           xcoord == 7 && ycoord == 0 || xcoord == 7 && ycoord == 1 ||
           xcoord == 7 && ycoord == 2 || xcoord == 7 && ycoord == 3){
            return false;
        }else {
            return true;
        }
    }

    public Integer GetAdventureItemBasedOnCoord(Integer xcoord, Integer ycoord){
        if(xcoord == 5 && ycoord == 0){
            return 0;
        }
        if (xcoord == 5 && ycoord == 1){
            return 1;
        }
        if (xcoord == 5 && ycoord == 2){
            return 2;
        }
        if (xcoord == 4 && ycoord == 2){
            return 3;
        }
        if (xcoord == 5 && ycoord == 3){
            return 4;
        }
        if (xcoord == 5 && ycoord == 4){
            return 5;
        }
        if (xcoord == 6 && ycoord == 4){
            return 6;
        }
        if (xcoord == 7 && ycoord == 4){
            return 7;
        }
        return null;
    }

    //Use for testing values with a toast message
    public void TestToaster(String message){
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.show();
    }
}
