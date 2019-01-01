/*
 */
package WeatherApp;

import java.io.IOException;
import java.net.URL;
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

/**
 *
 * @author Nicholas.Eber
 */
public class WeatherViewController implements Initializable {

    //WeatherView.fxml Fields
    @FXML
    private Label tempHigh, tempLow, city, state, date;
    @FXML
    private Button changeLocation; // on Weather view .fxml


    @FXML
    private void changeLocationAction(ActionEvent event){
       
        showView2();
    }

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        city.setText(Weather.cityName);
        state.setText(Weather.stateName);
        date.setText(Weather.date);
        tempHigh.setText(Weather.tempHigh);
        tempLow.setText(Weather.tempLow);

    }

    public void showView2(){
        try{
             URL url = getClass().getResource("fxml_ChangeLocation.fxml");
             Parent root = FXMLLoader.load(url);
             Scene scene = new Scene(root);
             
             Stage stage = startWeather.getStage();
             stage.setScene(scene);
             stage.show();
         }catch(IOException e){
         }
    }
    
}
