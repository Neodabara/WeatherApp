package WeatherRSS;

import org.xml.sax.helpers.*;
import org.xml.sax.*;
import java.util.ArrayList;

public class YahooXMLHandler extends DefaultHandler {

    private ArrayList<Forcast> weather;
    private Forcast forcast = new Forcast();

    

    public YahooXMLHandler() {
        weather = new ArrayList<Forcast>();
    }

    public ArrayList<Forcast> getNews() {
        return weather;
    }

    @Override
    public void startElement(String uri,
            String localName,
            String qName,
            Attributes attr) {

        if (qName.equals("yweather:forecast")) {
            forcast = new Forcast();
            forcast.setCode(attr.getValue(1));
            forcast.setDate(attr.getValue(2));
            forcast.setDay(attr.getValue(3));
            forcast.setHigh(attr.getValue(4));
            forcast.setLow(attr.getValue(5));
            forcast.setText(attr.getValue(6));
            weather.add(forcast);
        }
    }

}
