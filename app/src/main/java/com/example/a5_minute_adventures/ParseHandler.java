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
    private final static String TEXT_BOX = "textBox";
    private final static String YES = "yes";
    private final static String NO = "no";
    private final static String LOCATIONIDX = "locationIdX";
    private final static String LOCATIONIDY = "locationIdY";

    //setting up boolean variables for characters method
    private boolean isTextBox = false;
    private boolean isYes = false;
    private boolean isNo = false;
    private boolean isLocationIdX = false;
    private boolean isLocationIdY = false;


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

        if (qName.equals(TEXT_BOX)) {
            item = new AdventureItem();
            item.setTextBox(atts.getValue(0));
        }
        else if (qName.equals(YES)) {
            item = new AdventureItem();
            item.setYes(atts.getValue(0));
        }
        else if (qName.equals(NO)) {
            item = new AdventureItem();
            item.setNo(atts.getValue(0));
        }
        else if (qName.equals(LOCATIONIDX)) {
            item = new AdventureItem();
            item.setLocationIdX(Integer.parseInt(atts.getValue(0)));
        }
        else if (qName.equals(LOCATIONIDY)) {
            item = new AdventureItem();
            item.setLocationIdY(Integer.parseInt(atts.getValue(0)));
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
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName,
                           String qName) throws SAXException
    {
        if (qName.equals(TEXT_BOX)) {
            adventureItems.add(item);
        }
    }

}