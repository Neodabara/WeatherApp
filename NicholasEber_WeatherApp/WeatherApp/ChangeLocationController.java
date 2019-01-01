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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/*
 * @author: Nicholas.Eber
 * @created: Apr 18, 2017
 */
public class ChangeLocationController implements Initializable {
    
    //ChangeLocation.fxml Fields
    @FXML
    private TextField city, state;
    @FXML
    private Button change;


    @FXML
    private void changeButtonAction(ActionEvent event) {

        Weather.cityName = city.getText();
        Weather.stateName = state.getText();
        Weather.tempHigh = "200";
        Weather.tempLow = "-200";

        if (Weather.cityName.isEmpty() || Weather.stateName.isEmpty()) {
            city.setPromptText("City must be Entered");
            state.setPromptText("State must be Entered");
        } else {
            showView1();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void showView1(){       
         try{
             URL url = getClass().getResource("fxml_WeatherView.fxml");
             Parent root = FXMLLoader.load(url);
             Scene scene = new Scene(root);
             
             Stage stage = startWeather.getStage();
             stage.setScene(scene);
             stage.show();
        } catch (IOException e) {
        }
    }
}
