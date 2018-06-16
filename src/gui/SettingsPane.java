package gui;

import calculations.LineAngleCalculation;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

import java.awt.*;
import java.beans.EventHandler;

public class SettingsPane extends StackPane {

    private Slider thicknessSlider = new Slider(0.0D, 20.0D, 2.0D);
    private Label thicknessLabel = new Label("Choose line thickness:");
    private Label colorLabel = new Label("Choose line color:");
    private RadioButton linearButton = new RadioButton();
    private ToggleGroup measurementToggleGroup = new ToggleGroup();
    private RadioButton angleButton = new RadioButton();
    private Label measurementLabel = new Label("Choose measurement:");
    private Label linearLabel = new Label("linear: ");
    private Label angleLabel = new Label("angle: ");
    private ColorPicker colorPicker = new ColorPicker();
    private Button clearButton = new Button("clear all");
    Button getClearButton() {return clearButton;}

    Slider getThicknessSlider() {
        return thicknessSlider;
    }

    Label getThicknessLabel() {
        return thicknessLabel;
    }

    Label getColorLabel() {
        return colorLabel;
    }


    RadioButton getLinearButton() {
        return linearButton;
    }


    ToggleGroup getMeasurementToggleGroup() {
        return measurementToggleGroup;
    }

    RadioButton getAngleButton() {
        return angleButton;
    }

    Label getMeasurementLabel() {
        return measurementLabel;
    }

    Label getLinearLabel() {
        return linearLabel;
    }

    Label getAngleLabel() {
        return angleLabel;
    }
    ColorPicker getColorPicker() {return colorPicker; }

    SettingsPane() {

        thicknessSlider.setShowTickLabels(true);
        thicknessSlider.setShowTickMarks(true);
        thicknessSlider.setMajorTickUnit(5);
        colorPicker.setStyle("-fx-color-label-visible: false ;");
        linearButton.setToggleGroup(measurementToggleGroup);
        angleButton.setToggleGroup(measurementToggleGroup);
        VBox thicknessVBox = new VBox();
        thicknessVBox.getChildren().addAll(thicknessLabel, thicknessSlider);
        thicknessVBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        VBox colorVBox = new VBox();
        colorVBox.getChildren().addAll(colorLabel, colorPicker);
        colorVBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        HBox measurementsHBox = new HBox();
        measurementsHBox.getChildren().addAll(linearLabel, linearButton, angleLabel, angleButton);
        measurementsHBox.setSpacing(10.0D);
        measurementsHBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        VBox measurementVBox = new VBox();
        measurementVBox.getChildren().addAll(measurementLabel, measurementsHBox,clearButton);
        measurementVBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        VBox settingsVBox = new VBox();
        settingsVBox.getChildren().addAll(thicknessVBox, colorVBox, measurementVBox);
        settingsVBox.setAlignment(Pos.CENTER);
        settingsVBox.setSpacing(10.0D);
        settingsVBox.setPadding(new Insets(5.0E00, 5.0E00, 5.0D, 5.0D));
        getChildren().add(settingsVBox);
    }

}