

package gui;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainGui extends Application {


    ResultsPane resultsPane = new ResultsPane();
    SettingsPane settingsPane = new SettingsPane();
    BorderPane mainPane = new BorderPane();


    public MainGui() {
    }

    @Override
    public void start(Stage mainStage) throws Exception {

        ShowImagePane showImagePane = new ShowImagePane(this, mainStage, settingsPane, resultsPane);
        showImagePane.getLoadHBox().getChildren().add(showImagePane.getLoadButton());
        showImagePane.getLoadHBox().setPadding(new Insets(30.0D, 5.0D, 5.0D, 15.0D));
        showImagePane.getLoadButton().setScaleX(1.2);
        showImagePane.getLoadButton().setScaleY(1.2);
        mainPane.setLeft(settingsPane);
        mainPane.setBottom(resultsPane);
        mainPane.setRight(showImagePane);
        mainPane.setTop(showImagePane.getLoadHBox());


        Scene scene = new Scene(mainPane, 1100, 770);
        mainStage.setScene(scene);
        mainStage.setTitle("Measure Image APP");
        mainStage.setMinWidth(1000);
        mainStage.setMinHeight(770);
        mainStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

