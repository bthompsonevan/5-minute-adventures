package com.example.a5_minute_adventures;

import androidx.appcompat.app.AppCompatActivity;
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


        Dal dal = new Dal(this);

        adventureItems = dal.parseXmlFile(ADVENTURE_1);

        //USE THIS FORMAT WHEN PULLING DATA OUT OF THE ARRAYLIST
        // questTextBox.setText(adventureItems.get(0).getTextBox());
        questTextBox.setText(adventureItems.get(0).getTextBox());

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            
        }

    }
}
