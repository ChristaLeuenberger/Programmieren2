package gui;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class SettingsPane extends StackPane {

    private Slider fontSlider = new Slider(0.0D, 20.0D, 2.0D);
    private Label fontLabel = new Label("Choose font:");
    private Label colorLabel = new Label("Choose color:");
    private RadioButton linearButton = new RadioButton();
    private ToggleGroup measurementToggleGroup = new ToggleGroup();
    private RadioButton angleButton = new RadioButton();
    private Label measurementLabel = new Label("Choose measurement typ:");
    private Label lengthLabel = new Label("Length: ");
    private Label angleLabel = new Label("Angle: ");
    private ColorPicker colorPicker = new ColorPicker(Color.BLACK);
    private Button clearButton = new Button("Clear all");

    Button getClearButton() {
        return clearButton;
    }

    Slider getFontSlider() {
        return fontSlider;
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

    ColorPicker getColorPicker() {
        return colorPicker;
    }

    SettingsPane() {

        fontSlider.setShowTickLabels(true);
        fontSlider.setShowTickMarks(true);
        fontSlider.setMajorTickUnit(5);
        colorPicker.setStyle("-fx-color-label-visible: false ;");
        linearButton.setToggleGroup(measurementToggleGroup);
        angleButton.setToggleGroup(measurementToggleGroup);
        VBox thicknessVBox = new VBox();
        thicknessVBox.getChildren().addAll(fontLabel, fontSlider);
        thicknessVBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        VBox colorVBox = new VBox();
        colorVBox.getChildren().addAll(colorLabel, colorPicker);
        colorVBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        HBox measurementHBox = new HBox();
        measurementHBox.getChildren().addAll(lengthLabel, linearButton, angleLabel, angleButton);
        measurementHBox.setSpacing(3.0D);
        measurementHBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        VBox measurementVBox = new VBox();
        measurementVBox.getChildren().addAll(measurementLabel, measurementHBox);
        measurementVBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        HBox clearHBox = new HBox();
        clearHBox.getChildren().add(clearButton);
        clearHBox.setPadding(new Insets(5.0D, 5.0D, 5.0D, 5.0D));
        VBox settingsVBox = new VBox();
        settingsVBox.getChildren().addAll(thicknessVBox, colorVBox, measurementVBox, clearHBox);
        settingsVBox.setAlignment(Pos.CENTER);
        settingsVBox.setSpacing(10.0D);
        settingsVBox.setPadding(new Insets(5.0E00, 5.0E00, 5.0D, 5.0D));
        getChildren().add(settingsVBox);
    }

}