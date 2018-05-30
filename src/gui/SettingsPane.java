package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SettingsPane extends StackPane {

    private Slider thicknessSlider = new Slider(0.0D, 100.0D, 10.0D);
    private Label thicknessLabel = new Label("Chose the thickness:");
    private Label colorLabel = new Label("Choose the linecolor:");
    private Label blackLabel = new Label("black: ");
    private RadioButton blackButton = new RadioButton();
    private Label whiteLabel = new Label("white: ");
    private RadioButton whiteButton = new RadioButton();
    private RadioButton linearButton = new RadioButton();
    private Label redLabel = new Label("red: ");
    private RadioButton redButton = new RadioButton();
    private ToggleGroup colorButtons = new ToggleGroup();
    private ToggleGroup measurementButtons = new ToggleGroup();
    private RadioButton angleButton = new RadioButton();
    private Label measurementLabel = new Label("Choose the measurement:");
    private Label linearLabel = new Label("linear: ");
    private Label angleLabel = new Label("angle: ");
    private ColorPicker colorPicker = new ColorPicker();

    Slider getThicknessSlider() {
        return thicknessSlider;
    }
    Label getThicknessLabel() {
        return thicknessLabel;
    }
    Label getColorLabel() {
        return colorLabel;
    }
    Label getBlackLabel() {
        return blackLabel;
    }
    RadioButton getBlackButton() {
        return blackButton;
    }
    Label getWhiteLabel() {
        return whiteLabel;
    }
    RadioButton getWhiteButton() {
        return whiteButton;
    }
    RadioButton getLinearButton() {
        return linearButton;
    }
    Label getRedLabel() {
        return redLabel;
    }
    RadioButton getRedButton() {
        return redButton;
    }
    ToggleGroup getColorButtons() {
        return colorButtons;
    }
    ToggleGroup getMeasurementButtons() {
        return measurementButtons;
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
    ColorPicker getColorPicker() {
        return colorPicker;
    }

    SettingsPane() {

        thicknessSlider.setShowTickLabels(true);
        thicknessSlider.setShowTickMarks(true);
        blackButton.setToggleGroup(colorButtons);
        whiteButton.setToggleGroup(colorButtons);
        redButton.setToggleGroup(colorButtons);
        linearButton.setToggleGroup(measurementButtons);
        angleButton.setToggleGroup(measurementButtons);
        VBox thicknessVBox = new VBox();
        thicknessVBox.getChildren().addAll(thicknessLabel, thicknessSlider);
        thicknessVBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        HBox colorsHBox = new HBox();
        colorsHBox.getChildren().addAll(blackLabel, blackButton, whiteLabel, whiteButton, redLabel, redButton);
        colorsHBox.setSpacing(10.0D);
        colorsHBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        VBox colorVBox = new VBox();
        colorVBox.getChildren().addAll(colorLabel, colorPicker);//.addAll(colorLabel, colorsHBox);
        //colorVBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        HBox measurementsHBox = new HBox();
        measurementsHBox.getChildren().addAll(linearLabel, linearButton, angleLabel, angleButton);
        measurementsHBox.setSpacing(10.0D);
        measurementsHBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        VBox measurementVBox = new VBox();
        measurementVBox.getChildren().addAll(measurementLabel, measurementsHBox);
        measurementVBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        VBox settingsVBox = new VBox();
        settingsVBox.getChildren().addAll(thicknessVBox, colorVBox, measurementVBox);
        settingsVBox.setAlignment(Pos.CENTER);
        settingsVBox.setSpacing(10.0D);
        settingsVBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        getChildren().add(settingsVBox);
    }
}