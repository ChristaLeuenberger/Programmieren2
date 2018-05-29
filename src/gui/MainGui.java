

package gui;

import java.util.logging.*;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainGui extends Application {

    private static final Logger logger = Logger.getLogger( MainGui.class.getName() );

    public MainGui() {
    }

    @Override
    public void start(Stage mainStage) throws Exception {
        logger.info("MainStage von Main: " +  mainStage.toString());
        ResultsPane resultsPane = new ResultsPane();
        SettingsPane settingsPane = new SettingsPane();
        ShowImagePane showImagePane = new ShowImagePane(mainStage);
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(settingsPane);
        mainPane.setBottom(resultsPane);
        mainPane.setRight(showImagePane);

        logger.info(settingsPane.toString());
        Scene scene = new Scene(mainPane, 1000, 1000);
        mainStage.setScene(scene);
        mainStage.setTitle("Image Viewing Application aka super duper image viewer");
        mainStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

