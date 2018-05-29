package gui;

import datamodel.DataLoader;
import datamodel.DataLoaderTxt;
import datamodel.DataLoaderXml;
import datamodel.DataModel;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polyline;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ShowImagePane extends Pane {

    private Stage mainStage;
    private DataLoader dataLoader;
    private DataModel dataModel;

    public ShowImagePane(Stage mainStage) {
        this.mainStage = mainStage;
        ImageView imageView = new ImageView();
        imageView.setFitWidth(600.0D);
        imageView.setPreserveRatio(true);
        Polyline polyline = new Polyline();
        Button loadButton = new Button("load image");
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

        HBox hBox = new HBox();
        hBox.getChildren().addAll(imageView, loadButton);
        VBox vBox = new VBox();
        vBox.getChildren().add(hBox);
        getChildren().add(vBox);
    }

    public ShowImagePane getShowImagePane() {
        return this;
    }
}
