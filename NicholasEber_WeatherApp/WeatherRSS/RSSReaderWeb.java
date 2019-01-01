package WeatherRSS;

import WeatherRSS.Forcast;
import WeatherRSS.YahooXMLHandler;
import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;
import java.net.*;

public class RSSReaderWeb {

    public static void main(String[] args) {
        
        String city = "baltimore";
        String state = "md";
        
        String s= "https://query.yahooapis.com/v1/public/yql?q=select%20item.forecast"
                + "%20from%20weather.forecast%20where%20%20woeid%20in%20(select%20woeid%20from%20geo."
                + "places(1)%20where%20text%3D%22"+city+"%2C%20"+state+"%22)"
                + "&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";

        
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            // sp is a SAXParser
            XMLReader xr = sp.getXMLReader();

            // create a content handler
            YahooXMLHandler myXH = new YahooXMLHandler();
            xr.setContentHandler(myXH);

            URL url = new URL(s);
            InputStream is = url.openStream();
            InputSource source = new InputSource(is);
            xr.parse(source);

            ArrayList<Forcast> forcasts = myXH.getNews();
            
            for (Forcast item : forcasts) {
                System.out.println(item);
            }
        } catch (Exception e) {

        }
    }
}
