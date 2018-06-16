package gui;

import calculations.LineAngleCalculation;
import datamodel.DataLoaderTxt;
import datamodel.DataModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polyline;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ResultsPane extends Pane {
    private Button resultsButton = new Button("Results");
    private Label lengthLabel = new Label("Length: ");
    private Label lengthValueLabel = new Label();
    private Label angleLabel = new Label("Angle: ");
    private Label angleValueLabel = new Label();
    private Label imageNameLabel = new Label("Image: ");
    private Label imageNameValueLabel = new Label();
    private Label aspectRationLabel = new Label("Real aspect ration: ");
    private Label aspectRationValueLabel = new Label();
    private Label resolutionLabel = new Label("Resolution: ");
    private Label resolutionValueLabel = new Label();
    private String imageFileName;


    Button getResultsPaneButton() {return resultsButton;}
    Label getLengthLabel() {return  lengthLabel;}
    Label getLengthValueLabel() {return lengthValueLabel;}
    Label getAngleLabel() {return angleLabel;}
    Label getAngleValueLabel() {return angleValueLabel;}
    String getImageFileName () {return imageFileName;}
    Label getAspectRationValueLabel() {return aspectRationValueLabel;}
    Label getAspectRationLabel() {return aspectRationLabel;}
    Label getResolutionLabel() { return resolutionLabel; }
    Label getResolutionValueLabel() { return resolutionValueLabel; }

    ResultsPane() {
        HBox resultButtonHBox = new HBox();
        resultButtonHBox.getChildren().add(resultsButton);
        resultButtonHBox.setSpacing(10.0D);
        resultButtonHBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        HBox nameHBox = new HBox();
        nameHBox.getChildren().addAll(imageNameLabel,imageNameValueLabel);
        nameHBox.setSpacing(10.0D);
        nameHBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        HBox lengthHBox = new HBox();
        lengthHBox.getChildren().addAll(lengthLabel, lengthValueLabel);
        lengthHBox.setSpacing(10.0D);
        lengthHBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        HBox angleHBox = new HBox();
        angleHBox.getChildren().addAll(angleLabel, angleValueLabel);
        angleHBox.setSpacing(10.0D);
        angleHBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        HBox aspectRationHBox = new HBox();
        aspectRationHBox.getChildren().addAll(aspectRationLabel, aspectRationValueLabel);
        aspectRationHBox.setSpacing(10.0D);
        aspectRationHBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        HBox resolutionHBox = new HBox();
        resolutionHBox.getChildren().addAll(resolutionLabel, resolutionValueLabel);
        resolutionHBox.setSpacing(10.0D);
        resolutionHBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        VBox resultsVBox = new VBox();
        resultsVBox.getChildren().addAll(resultButtonHBox,nameHBox,lengthHBox, angleHBox, aspectRationHBox, resolutionHBox);
        resultsVBox.setAlignment(Pos.CENTER);
        resultsVBox.setSpacing(10.0D);
        resultsVBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        getChildren().add(resultsVBox);
    }
    void setImageDescription(String description) {
        imageNameValueLabel.setText(description);

    }
}
