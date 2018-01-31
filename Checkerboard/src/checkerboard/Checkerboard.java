
package checkerboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Connor Penrod
 */
public class Checkerboard extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CheckerboardFXML.fxml"));

        Scene scene = new Scene((Parent)loader.load());
        stage.setScene(scene);
        
        stage.show();
        
        Startable controller = loader.getController();
        
        controller.start(stage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
