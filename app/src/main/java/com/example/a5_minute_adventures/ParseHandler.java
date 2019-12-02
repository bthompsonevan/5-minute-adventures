package com.example.a5_minute_adventures;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import java.util.ArrayList;


public class ParseHandler extends DefaultHandler {
    private AdventureItems adventureItems;
    private AdventureItem item;

    //setting constants for elements in adventure xml files
    private final static String TEXT_BOX = "textBox";
    private final static String YES = "yes";
    private final static String NO = "no";
    private final static String LOCATIONIDX = "locationIdX";
    private final static String LOCATIONIDY = "locationIdY";

    public AdventureItems getItems() {return adventureItems;}


    @Override
    public void startDocument() throws SAXException {
        adventureItems = new AdventureItems();

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
    public void endElement(String namespaceURI, String localName,
                           String qName) throws SAXException
    {
        if (qName.equals(TEXT_BOX)) {
            adventureItems.add(item);
        }
    }

}