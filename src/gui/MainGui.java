

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
    ResultsPane resultsPane = new ResultsPane();
    SettingsPane settingsPane = new SettingsPane();
    BorderPane mainPane = new BorderPane();

    public SettingsPane getSettingsPane() {
        return settingsPane;
    }

    public MainGui() {
    }

    @Override
    public void start(Stage mainStage) throws Exception {
        logger.info("MainStage von Main: " +  mainStage.toString());
        ShowImagePane showImagePane = new ShowImagePane(this, mainStage, settingsPane, resultsPane);
        mainPane.setLeft(settingsPane);
        mainPane.setBottom(resultsPane);
        mainPane.setRight(showImagePane);
        mainPane.setTop(showImagePane.getLoadButton());

        logger.info(settingsPane.toString());
        Scene scene = new Scene(mainPane, 1000, 700);
        mainStage.setScene(scene);
        mainStage.setTitle("measure image APP");
        mainStage.setMinWidth(1000);
        mainStage.setMinHeight(700);
        mainStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

