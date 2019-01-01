package WeatherRSS;

public class Forcast {

    private String city;
    private String state;
    private String code;
    private String date;
    private String day;
    private String high;
    private String low;
    private String text;

    public Forcast() {
        this.city = "";
        this.state = "";
        this.code = "";
        this.date = "";
        this.day = "";
        this.high = "";
        this.low = "";
        this.text = "";
    }

    public Forcast(String city, String state, String code, String date,
            String day, String high, String low, String text) {
        this.city = city;
        this.state = state;
        this.code = code;
        this.date = date;
        this.day = day;
        this.high = high;
        this.low = low;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        String forcast = "";

        forcast += city + ", " + state + "\n";
        forcast += "code: " + this.code + "\n";
        forcast += "date: " + this.date + "\n";
        forcast += "day: " + this.day + "\n";
        forcast += "high: " + this.high + "\n";
        forcast += "low: " + this.low + "\n";
        forcast += "text: " + this.text + "\n";

        return forcast;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
