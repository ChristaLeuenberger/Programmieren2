package gui;

import com.sun.prism.Graphics;
import datamodel.DataLoader;
import datamodel.DataLoaderTxt;
import datamodel.DataLoaderXml;
import datamodel.DataModel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polyline;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;


public class ShowImagePane extends Pane {

    private final MouseEvent mouseEvent = new MouseEvent() {


    };
    private Stage mainStage;
    private DataLoader dataLoader;
    private DataModel dataModel;
    private Polyline polylineA = new Polyline();
    private Polyline polylineB = new Polyline();
    private boolean draw = false;
    private boolean doubleClicked = false;
    private boolean calculated = false;
    private boolean imageLoaded = false;
    private boolean clicked = false;

    //private PolylineCalculation polylineCalculator;


    Polyline getPolylineA() {
        return polylineA;
    }

    Polyline getPolylineB() {
        return polylineB;
    }

    public ShowImagePane(Stage mainStage) {
        SettingsPane settingsPane = null;
        this.mainStage = mainStage;
        ImageView imageView = new ImageView();
        imageView.setFitWidth(600.0D);
        imageView.setPreserveRatio(true);
        Polyline polylineA = new Polyline();
        Polyline polylineB = new Polyline();
        Button loadButton = new Button("load image");
        polylineA.strokeWidthProperty().bind(settingsPane.getThicknessSlider().valueProperty());
        polylineB.strokeWidthProperty().bind(settingsPane.getThicknessSlider().valueProperty());

        settingsPane.getColorPicker().setOnAction((ActionEvent) -> {
            polylineA.setStroke(settingsPane.getColorPicker().getValue());
            polylineB.setStroke(settingsPane.getColorPicker().getValue());
        });
        loadButton.setOnAction((event) -> {

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
                imageView.setFitWidth(600.0D);
                imageView.setPreserveRatio(true);
            } catch (Exception iter) {
                System.out.println("reading file failed: " + iter.getMessage());
            }
        });
         /* settingsPane.getLinearButton().setOnAction((ActionEvent event) -> {
            draw = true;
            doubleClicked = false;
          if (calculated) {
                deletePolyline(polylineA, polylineB, resultPane.getResult());
                calculated = false;}
        });
        this.setOnMouseClicked(eventClicked -> {
            if (imageLoaded && !calculated && draw) {
                clicked = true;
                double mouseX = eventClicked.getX();
                double mouseY = eventClicked.getY();
                /*polylineCalculation = new PolylineCalculation(mouseX, mouseY, imageRatio.calculateImageRatio());
                polylineCalculation.addCoordinates();
                polyline1.getPoints().addAll(mouseX, mouseY);
                if (2 == eventClicked.getClickCount()) {
                    polyline2.getPoints().clear();
                    polylineCalculation.removeLastCoordinate();
                    doubleClicked = true;
                    draw = false;
                }


    /*}private void deletePolyline(Polyline polylineOne, Polyline polylineTwo, Label result) {
        if (polylineCalculator != null) {
            polylineOne.getPoints().clear();
            polylineTwo.getPoints().clear();
            polylineCalculation.removeCoordinates();
            result.setText("");
            clicked = false;
            doubleClicked = false;}}*/

        HBox hBox = new HBox();
        hBox.getChildren().addAll(imageView, loadButton, polylineA, polylineB);
        VBox vBox = new VBox();
        vBox.getChildren().add(hBox);
        getChildren().add(vBox);
    }






    public ShowImagePane getShowImagePane() {
        return this;
    }
}
