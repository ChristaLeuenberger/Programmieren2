package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ResultsPane extends Pane {
    private Button resultsPaneBotton;
    private Label lengthLabel = new Label("Length:");
    private Label lengthValueLabel = new Label();
    private Label angleLabel = new Label("Angle");
    private Label angleValueLabel = new Label();
    private Button clearButton = new Button("clear all");

    Button getResultsPaneBotton() {return resultsPaneBotton;}
    Label getLengthLabel() {return  lengthLabel;}
    Label getLengthValueLabel() {return lengthValueLabel;}
    Label getAngleLabel() {return angleLabel;}
    Button getClearButton() {return clearButton;}

    ResultsPane() {

        HBox lengthHBox = new HBox();
        lengthHBox.getChildren().addAll(lengthLabel, lengthValueLabel);
        lengthHBox.setSpacing(10.0D);
        lengthHBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        HBox angleHBox = new HBox();
        angleHBox.getChildren().addAll(angleLabel, angleValueLabel);
        angleHBox.setSpacing(10.0D);
        angleHBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        VBox resultsVBox = new VBox();
        resultsVBox.getChildren().addAll(lengthHBox, angleHBox, clearButton);
        resultsVBox.setAlignment(Pos.CENTER);
        resultsVBox.setSpacing(10.0D);
        resultsVBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        getChildren().add(resultsVBox);
    }
}
