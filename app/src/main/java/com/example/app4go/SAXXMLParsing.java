package com.example.app4go;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXXMLParsing extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saxxmlparsing);

        textView = this.findViewById(R.id.textView14);

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();

            SAXParser saxParser = factory.newSAXParser();


            DefaultHandler handler = new DefaultHandler() {

                boolean name = false;

                boolean salary = false;


                public void startElement(String uri, String localName,String qName,
                                         Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("name"))
                    {
                        name = true;
                    }
                    if (qName.equalsIgnoreCase("salary"))
                    {
                        salary = true;
                    }
                }//end of startElement method
                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {
                }

                public void characters(char ch[], int start, int length) throws SAXException {
                    if (name) {

                        textView.setText(textView.getText()+"\n\n Name : " + new String(ch, start, length));
                        name = false;
                    }
                    if (salary) {
                        textView.setText(textView.getText()+"\n Salary : " + new String(ch, start, length));
                        salary = false;
                    }
                }//end of characters method
            };//end of DefaultHandler object

            InputStream is = getAssets().open("file.xml");
            saxParser.parse(is, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
