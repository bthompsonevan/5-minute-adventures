package com.example.a5_minute_adventures;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class ParseHandler extends DefaultHandler {
    //Will hold the parsed data
    private ArrayList<AdventureItem> adventureItems;

    private AdventureItem item;

    //setting constants for elements in adventure xml files
    private final static String SCENARIO = "scenario";
    private final static String TEXT_BOX = "textBox";
    private final static String YES = "yes";
    private final static String NO = "no";
    private final static String LOCATIONIDX = "locationIdX";
    private final static String LOCATIONIDY = "locationIdY";
    private final static String CHOICE_YES = "choiceYes";
    private final static String CHOICE_NO = "choiceNo";

    //setting up boolean variables for characters method
    private boolean isTextBox = false;
    private boolean isYes = false;
    private boolean isNo = false;
    private boolean isLocationIdX = false;
    private boolean isLocationIdY = false;
    private boolean isChoiceYes = false;
    private boolean isChoiceNo = false;


    public ArrayList<AdventureItem> getItems(){
        return adventureItems;
    }


    @Override
    public void startDocument() throws SAXException {
        adventureItems = new ArrayList<AdventureItem>();

    }

    @Override
    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes atts) throws SAXException {

        if (qName.equals(SCENARIO)) {
            item = new AdventureItem();
            return;
        }
        else if (qName.equals(TEXT_BOX)) {
            isTextBox = true;
            return;
        }
        else if (qName.equals(YES)) {
            isYes = true;
            return;
        }
        else if (qName.equals(NO)) {
            isNo = true;
            return;
        }
        else if (qName.equals(LOCATIONIDX)) {
            isLocationIdX = true;
            return;
        }
        else if (qName.equals(LOCATIONIDY)) {
            isLocationIdY = true;
            return;
        }
        else if (qName.equals(CHOICE_YES)) {
            isChoiceYes = true;
        }
        else if (qName.equals(CHOICE_NO)) {
            isChoiceNo = true;
        }
    }

    @Override
    public void characters(char ch[], int start , int length) {
        //print out the attributes' value
        String valueString = new String(ch, start, length);

        if (isTextBox) {
            item.setTextBox(valueString);
            isTextBox = false;
        } else if (isYes) {
            item.setYes(valueString);
            isYes = false;
        }else if (isNo) {
            item.setNo(valueString);
            isNo = false;
        }else if (isLocationIdX) {
            item.setLocationIdX(Integer.parseInt(valueString));
            isLocationIdX = false;
        }else if (isLocationIdY) {
            item.setLocationIdY(Integer.parseInt(valueString));
            isLocationIdY = false;
        }else if (isChoiceYes) {
            item.setChoiceYes(valueString);
            isChoiceYes = false;
        }else if (isChoiceNo) {
            item.setChoiceNo(valueString);
            isChoiceNo = false;
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName,
                           String qName) throws SAXException
    {
        if (qName.equals(SCENARIO)) {
            adventureItems.add(item);
        }
    }

}