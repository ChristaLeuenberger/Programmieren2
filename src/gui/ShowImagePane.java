package gui;

import calculations.Coordinates;
import calculations.ImageRation;
import calculations.LineAngleCalculation;
import datamodel.DataLoader;
import datamodel.DataLoaderTxt;
import datamodel.DataLoaderXml;
import datamodel.DataModel;

import java.util.logging.Logger;

import java.io.File;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polyline;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ShowImagePane extends Pane {
    private static final Logger logger = Logger.getLogger(DataLoader.class.getName());

    private Pane drawPane = new Pane();
    private Stage mainStage;
    private DataLoader dataLoader;
    private DataModel dataModel;
    private LineAngleCalculation lineAngleCalculation = new LineAngleCalculation();
    private double[] imageRationValue;
    private boolean draw = false;
    private boolean clicked = false;
    private boolean imageLoaded = false;
    private boolean doubleClicked = false;
    private boolean calculated = false;
    private Button loadButton = new Button("load image");

    Button getLoadButton() {
        return loadButton;
    }

    public ShowImagePane getShowImagePane() {
        return this;
    }

    public boolean isClicked() {
        return clicked;
    }

    public ShowImagePane(Stage mainStage, SettingsPane settingsPane, ResultsPane resultsPane) {
        this.mainStage = mainStage;
        ImageView imageView = new ImageView();
        imageView.setFitWidth(600.0D);
        imageView.setPreserveRatio(true);
        Polyline polyline = new Polyline();

        polyline.strokeWidthProperty().bind(settingsPane.getThicknessSlider().valueProperty());
        settingsPane.getColorPicker().setOnAction((ActionEvent) -> {
            polyline.setStroke(settingsPane.getColorPicker().getValue());
        });
        loadButton.setOnAction((ActionEvent event) -> {

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
                logger.info("Resolution: " + dataModel.getResolutionUnit());
                double trueImageWidth = imageView.getImage().getWidth();
                double trueImageHeight = imageView.getImage().getHeight();
                ImageRation imageRation = new ImageRation(imageView.boundsInParentProperty().getValue(), trueImageWidth, trueImageHeight);
                imageRationValue = imageRation.calculateImageRation();
                imageView.setFitWidth(600.0D);
                imageView.setPreserveRatio(true);
            } catch (Exception var8) {
                System.out.println("reading file failed: " + var8.getMessage());
            }
        });

        ToggleGroup toggleGroup = settingsPane.getMeasurementToggleGroup();
        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                if (settingsPane.getLinearButton().isSelected()) {
                    drawPolyline(polyline);
                } else if (settingsPane.getAngleButton().isSelected()) {

                }
            }
        });

        settingsPane.getClearButton().setOnAction((ActionEvent) -> {
            if (lineAngleCalculation != null) {
                polyline.getPoints().clear();
                lineAngleCalculation.removeCoordinates();
                resultsPane.getLengthValueLabel().setText("0");
                clicked = false;
                doubleClicked = false;
            }
            doubleClicked = false;
            calculated = false;
            draw = false;

        });


        resultsPane.getResultsPaneButton().setOnAction(event -> {

            Double distance = lineAngleCalculation.calculateLength(imageRationValue);
            resultsPane.getLengthValueLabel().setText(String.valueOf(Math.round(distance * 10.0) / 10.0) + " " + dataModel.getResolutionUnit());
        });


        drawPane.setOnMouseMoved(event -> {

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



/*        draw = true;
        doubleClicked = false;


        if (imageLoaded && !calculated && draw) {
            clicked = true;
            double pointX = eventClicked.getX();
            double pointY = eventClicked.getY();
            lineAngleCalculation = new LineAngleCalculation(pointX, pointY, imageRation.calculateImageRation());
            lineAngleCalculation.addCoordinates();
            polylineA.getPoints().addAll(pointX, pointY);
            if (2 == eventClicked.getClickCount()) {
                polylineB.getPoints().clear();
                doubleClicked = true;
                draw = false;
                logger.info("draw: " + draw);
            }
        }


        if (clicked && !doubleClicked && draw) {
            int index = lineAngleCalculation.getTotalCoordinates().size() - 1;
            polylineA.getPoints().clear();
            polylineB.getPoints().addAll(lineAngleCalculation.getTotalCoordinates().get(index).getX(),
                    lineAngleCalculation.getTotalCoordinates().get(index).getY(),
                    eventMoved.getX(), eventMoved.getY());
            Path showLinePath = new Path();
            showLinePath.getElements().add(new LineTo(getScaleX(), getScaleY()));
        }

        if (imageLoaded && clicked) {
            double pixelValue = lineAngleCalculation.calculateLength();
            String resolutionValue = dataModel.getResolutionValue();
            String resolutionUnit = dataModel.getResolutionUnit();
            if (resolutionUnit != null && resolutionValue != null) {
                double calculatedValue = pixelValue * Double.parseDouble(resolutionValue);
                resultsPane.getLengthValueLabel().setText(String.valueOf(
                        Math.round(calculatedValue * 10.0) / 10.0) + " " + resolutionUnit);
            }
            calculated = true;
        }

        if (imageLoaded && clicked) {
            if (3 == lineAngleCalculation.getTotalCoordinates().size()) {
                double calculatedAngle = lineAngleCalculation.calculateAngle();
                resultsPane.getLengthValueLabel().setText(String.valueOf(Math.round(calculatedAngle * 10.0) / 10.0) + " °");
            }
            calculated = true;
        }*/


}

