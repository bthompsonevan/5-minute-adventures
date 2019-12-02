package com.example.a5_minute_adventures;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;


public class ParseHandler extends DefaultHandler {
    private AdventureItems adventureItems;
    private AdventureItem item;
    private boolean isCity = false;
    private boolean isDate = false;
    private boolean isDescription = false;
    private boolean isMorningLow = false;
    private boolean isDaytimeHigh = false;
    private boolean isDayPrecip = false;
    private boolean isNightPrecip = false;

    public WeatherItems getItems() {
        return weatherItems;
    }

    @Override
    public void startDocument() throws SAXException {
        weatherItems = new WeatherItems();
        item = new WeatherItem();
    }

    @Override
    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes atts) throws SAXException {

        if (qName.equals(CITY)) {
            isCity = true;;
        }
        else if (qName.equals(FORECAST)) {
            item = new WeatherItem();
        }
        else if (qName.equals(DATE)) {
            isDate = true;
        }
        else if (qName.equals(DESCRIPTION)) {
            isDescription = true;
        }
        else if (qName.equals(MORNING_LOW)) {
            isMorningLow = true;
        }
        else if (qName.equals(DAYTIME_HIGH)) {
            isDaytimeHigh = true;
        }
        else if (qName.equals(NIGHT_PRECIP)) {
            isNightPrecip = true;
        }else if (qName.equals(DAY_PRECIP)) {
            isDayPrecip = true;
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName,
                           String qName) throws SAXException
    {
        if (qName.equals(FORECAST)) {
            weatherItems.add(item);
        }
    }

    @Override
    public void characters(char ch[], int start, int length)
    {
        String s = new String(ch, start, length);
        if (isCity) {
            weatherItems.setCity(s);
            isCity = false;
        }
        else if (isDate) {
            item.setForecastDate(s);
            isDate = false;
        }
        else if (isDescription) {
            item.setDescription(s);
            isDescription = false;
        }
        else if (isMorningLow) {
            item.setLowTemp(s);
            isMorningLow = false;
        }
        else if (isDaytimeHigh) {
            item.setHighTemp(s);
            isDaytimeHigh = false;
        }
        else if (isNightPrecip) {
            item.setNightPrecip(s);
            isNightPrecip = false;
        }
        else if (isDayPrecip) {
            item.setDayPrecip(s);
            isDayPrecip = false;
        }
    }
}