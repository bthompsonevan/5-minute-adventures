package com.example.a5_minute_adventures;

import android.content.Context;
import android.util.Log;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Dal {

    private Context context = null;

    public Dal(Context c)
    {
        context = c;
    }

    public ArrayList<AdventureItem> parseXmlFile(String fileName) {
        try {
            // get the XML reader
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader xmlreader = parser.getXMLReader();
            // set content handler
            ParseHandler handler = new ParseHandler();
            xmlreader.setContentHandler(handler);
            // read the file from internal storage
            InputStream in = context.getAssets().open(fileName);
            // parse the data
            InputSource is = new InputSource(in);
            xmlreader.parse(is);
            // set the feed in the activity
            ArrayList<AdventureItem> items = handler.getItems();
            return items;
        }
        catch (Exception e) {
            Log.e("Advtre item parse error", e.toString());
            return null;
        }
    }
}
