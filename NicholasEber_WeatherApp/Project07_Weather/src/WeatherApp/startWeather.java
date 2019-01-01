/*
 */
package WeatherApp;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/*
 * @author: Nicholas.Eber
 * @created: Apr 15, 2017
 */
public class startWeather extends Application {

    private static Stage mainStage;

    public static Stage getStage() {
        return mainStage;
    }

    @Override
    public void start(Stage stage) throws Exception {

        try {

            mainStage = stage;

            Parent root = FXMLLoader.load(getClass().getResource("fxml_ChangeLocation.fxml"));

            Scene scene = new Scene(root);

            stage.setTitle("WeatherApp");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
