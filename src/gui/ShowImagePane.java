package gui;

import calculations.Coordinates;
import calculations.ImageRation;
import calculations.LineAngleCalculation;
import datamodel.DataLoader;
import datamodel.DataLoaderTxt;
import datamodel.DataLoaderXml;
import datamodel.DataModel;


import java.io.File;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ShowImagePane extends Pane {

    private Pane drawPane = new Pane();
    private MainGui mainGui;
    private static Stage mainStage;
    private DataLoader dataLoader;
    private DataModel dataModel;
    private LineAngleCalculation lineAngleCalculation = new LineAngleCalculation();
    private double[] imageRationValue;
    private boolean draw = false;
    private boolean clicked = false;
    private boolean calculated = false;
    private Button loadButton = new Button("Load image");
    private HBox loadHBox = new HBox();

    Button getLoadButton() {
        return loadButton;
    }

    public boolean isClicked() {
        return clicked;
    }

    public HBox getLoadHBox() {
        return loadHBox;
    }

    public ShowImagePane(MainGui mainGui, Stage mainStage, SettingsPane settingsPane, ResultsPane resultsPane) {
        this.mainGui = mainGui;
        this.mainStage = mainStage;
        ImageView imageView = new ImageView();
        Polyline polyline = new Polyline();

        polyline.strokeWidthProperty().bind(settingsPane.getFontSlider().valueProperty());
        settingsPane.getColorPicker().setOnAction((ActionEvent) -> {
            polyline.setStroke(settingsPane.getColorPicker().getValue());
        });
        loadButton.setOnAction((ActionEvent event) -> {

            clearAll(polyline, resultsPane);

            try {

                FileChooser fileChooser = new FileChooser();
                File metaFile = fileChooser.showOpenDialog(mainStage);
                if (metaFile.getName().endsWith(".txt")) {
                    dataLoader = new DataLoaderTxt();
                } else {
                    dataLoader = new DataLoaderXml();
                }
                dataModel = dataLoader.loadData(metaFile);
                Image image = new Image("file:" + metaFile.getParent() + File.separator + dataModel.getImageFileName());
                imageView.setImage(image);
                resultsPane.setImageDescription(dataModel.getDescription());

                double trueImageWidth = imageView.getImage().getWidth();
                double trueImageHeight = imageView.getImage().getHeight();
                String aspectRationValue = dataModel.getResolutionValue();
                String aspectRationUnit = dataModel.getResolutionUnit();
                resultsPane.getAspectRationValueLabel().setText((Math.round(trueImageWidth *
                        Double.parseDouble(aspectRationValue))) + " " + aspectRationUnit + " x " + (Math.round(trueImageHeight *
                        Double.parseDouble(aspectRationValue))) + " " + aspectRationUnit);
                resultsPane.getResolutionValueLabel().setText(dataModel.getResolution());
                ImageRation imageRation = new ImageRation(imageView.boundsInParentProperty().getValue(), trueImageWidth, trueImageHeight);
                imageRationValue = imageRation.calculateImageRation();
                imageView.setFitWidth(600.0D);
                imageView.setPreserveRatio(true);

            } catch (Exception e) {
                System.out.println("reading file failed: " + e.getMessage());
            }
        });

        ToggleGroup toggleGroup = settingsPane.getMeasurementToggleGroup();
        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                drawPolyline(polyline);
                if (settingsPane.getLinearButton().isSelected()) {
                    drawPolyline(polyline);
                    resultsPane.getResultsPaneButton().setOnAction(event -> {

                        Double length = lineAngleCalculation.calculateLength(imageRationValue);
                        length *= Double.parseDouble(dataModel.getResolutionValue());
                        resultsPane.getLengthValueLabel().setText(String.valueOf(Math.round(length * 10.0) / 10.0) + " " + dataModel.getResolutionUnit());

                    });
                } else if (settingsPane.getAngleButton().isSelected()) {

                    drawPolyline(polyline);
                    resultsPane.getResultsPaneButton().setOnAction(event -> {

                        if (3 >= lineAngleCalculation.getTotalCoordinates().size()) {
                            Double angle = lineAngleCalculation.calculateAngle();
                            resultsPane.getAngleValueLabel().setText(String.valueOf(angle) + " °");
                        } else {
                            resultsPane.getAngleValueLabel().setText("only one angle accepted");
                        }
                    });


                }
            }
        });

        settingsPane.getClearButton().setOnAction((ActionEvent) -> {
            clearAll(polyline, resultsPane);

        });

        drawPane.getChildren().addAll(imageView, polyline);
        getChildren().add(drawPane);
    }

    private void drawPolyline(Polyline polyline) {

        drawPane.setOnMouseClicked(event -> {
            double pointX = event.getX();
            double pointY = event.getY();
            polyline.getPoints().addAll(pointX, pointY);
            Coordinates coordinates = new Coordinates(pointX, pointY);
            lineAngleCalculation.addCoordinates(coordinates);
        });
    }

    private void clearAll(Polyline polyline, ResultsPane resultsPane) {
        if (lineAngleCalculation != null) {
            polyline.getPoints().clear();
            lineAngleCalculation.removeCoordinates();

            resultsPane.getLengthValueLabel().setText(" ");
            resultsPane.getAngleValueLabel().setText(" ");
            clicked = false;
        }
        calculated = false;
        draw = false;

    }

}





