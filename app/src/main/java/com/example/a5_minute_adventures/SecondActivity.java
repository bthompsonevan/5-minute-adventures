package com.example.a5_minute_adventures;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;  // Is used for periodic testing
import androidx.appcompat.app.AppCompatActivity;

import static com.example.a5_minute_adventures.MainActivity.OUTCOME;
import static com.example.a5_minute_adventures.MainActivity.PASSED_DATA;
import static com.example.a5_minute_adventures.MainActivity.PASSED_X;
import static com.example.a5_minute_adventures.MainActivity.PASSED_Y;

public class SecondActivity extends AppCompatActivity implements
        View.OnClickListener {

    //Setting up widget variables
    TextView choiceTextBox;
    Button returnButton;
    Button newGameButton;

    //Constants for returning data through intent
    public static final String RETURN_X = "returnXValue";
    public static final String RETURN_Y = "returnYValue";

    //high scope variable to access in switch statement
    public Integer passedXCoord = null;
    public Integer passedYCoord = null;
    public Integer passedOutcome = null;

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

        //Getting values from the passed intent
        Intent intent = getIntent();
        String passedString = intent.getStringExtra(PASSED_DATA);
        passedXCoord = intent.getIntExtra(PASSED_X, 0);
        passedYCoord = intent.getIntExtra(PASSED_Y, 0);
        passedOutcome = intent.getIntExtra(OUTCOME, 0);

       // Toast toast = Toast.makeText(this, passedString, Toast.LENGTH_LONG);
       // toast.show();

        choiceTextBox.setText(passedString);

        if (passedOutcome == -1){
            returnButton.setVisibility(View.INVISIBLE);
        }



    }

    public void onClick(View v){

        if(v.getId() == R.id.returnButton){
            Intent returnIntent = new Intent();
            returnIntent.putExtra(RETURN_X, passedXCoord);
            returnIntent.putExtra(RETURN_Y, passedYCoord);
            setResult(RESULT_OK, returnIntent);
            finish();
        }
        if (v.getId() == R.id.newGameButton){
            Intent returnIntent = new Intent();
            returnIntent.putExtra(RETURN_X, 5);
            returnIntent.putExtra(RETURN_Y, 0);
            setResult(RESULT_OK, returnIntent);
            finish();
        }

    }
}



