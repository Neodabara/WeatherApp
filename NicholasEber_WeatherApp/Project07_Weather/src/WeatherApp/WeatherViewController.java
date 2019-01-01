/*
 */
package WeatherApp;


import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.util.Date;
import javafx.scene.image.*;

/**
 *
 * @author Nicholas.Eber
 */
public class WeatherViewController implements Initializable {

    //WeatherView.fxml Fields
    @FXML
    private Label tempHigh, tempLow, city, state, date, conditions;

    @FXML
    private void changeLocationAction(ActionEvent event) {

        //Changes to ChangeLocationView
        showView2();
    }
    
    @FXML
    private ImageView background;
    private ImageView highsymbol;
    private ImageView lowsymbol; 
    private ImageView calender;
    private ImageView citysymbol;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Sets the Date in the view
        date.setText(currentDate());
        
        //Gets the current dates weather condition from DataBase.
        WeatherRSS.Forcast daliy = WeatherSQL.WeatherSQL.DBdaliyRead(Weather.city,
                Weather.state, currentDate());

        //Checks if a location was returned.
        if (!"".equals(daliy.getCity()) && !"".equals(daliy.getState())) {
            city.setText(daliy.getCity());
            state.setText(daliy.getState());
            tempHigh.setText(daliy.getHigh());
            tempLow.setText(daliy.getLow());
            conditions.setText(daliy.getText().toUpperCase());

        } else {
            city.setText("NO");
            state.setText("LOCATION");
            tempHigh.setText("--");
            tempLow.setText("--");
            conditions.setText("-----");
        }
        
        //Images
       Image img = new Image("file:Background.png");
       background = new ImageView(img);
       
       Image img2 = new Image("file:Calender.png");
       calender = new ImageView(img2);
       
       Image img3 = new Image("file:City.png");
       citysymbol = new ImageView(img3);
       
       Image img4 = new Image("file:High.png");
       highsymbol = new ImageView(img4);
       
       Image img5 = new Image("file:Low.png");
       lowsymbol = new ImageView(img5);
       
    }

    public String currentDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        Date toDayDate = new Date();
        
        return dateFormat.format(toDayDate);
        
    }
    public void showView2() {
        try {
            URL url = getClass().getResource("fxml_ChangeLocation.fxml");
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);

            Stage stage = startWeather.getStage();
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
        }
    }

}
