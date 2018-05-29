

package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainGui extends Application {

    public MainGui() {
    }

    @Override
    public void start(Stage mainStage) throws Exception {
        ResultsPane resultsPane = new ResultsPane();
        SettingsPane settingsPane = new SettingsPane();
        ShowImagePane showImagePane = new ShowImagePane(mainStage);
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(settingsPane);
        mainPane.setBottom(resultsPane);
        mainPane.setRight(showImagePane);
        Scene scene = new Scene(mainPane, 1000, 1000);
        mainStage.setScene(scene);
        mainStage.setTitle("Image Viewing Application");
        mainStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

