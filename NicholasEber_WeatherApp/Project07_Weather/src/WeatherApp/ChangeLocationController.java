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
import javafx.scene.image.*;
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
    private ImageView background;


    @FXML
    private void changeButtonAction(ActionEvent event) {

        Weather.city = city.getText().toUpperCase();
        Weather.state = state.getText().toUpperCase();

        //checks for input
        if (Weather.city.isEmpty() || Weather.state.isEmpty()) {
            city.setPromptText("City must be Entered");
            state.setPromptText("State must be Entered");
        } else {
            //Delete any previous entrey in DataBase for location
            WeatherSQL.WeatherSQL.DBdelete(Weather.city, Weather.state);
            
            //Fetches info for new location.
            WeatherRSS.RSSReaderWeb.yahooRSSReader(Weather.city, Weather.state);
            
            //Changes to WeatherView
            showView1();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       Image img = new Image("file:Background.png");
       background = new ImageView(img);
       
    }

    public void showView1() {
        try {
            URL url = getClass().getResource("fxml_WeatherView.fxml");
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
