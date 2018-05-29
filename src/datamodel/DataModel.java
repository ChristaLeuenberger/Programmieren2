package datamodel;

import java.awt.Image;
import java.util.List;

public class DataModel {
    private String description;
    private String imageFileName;
    private String resolution;

    public DataModel(String description, String imageFileName, String resolution) {
        this.description = description;
        this.imageFileName = imageFileName;
        this.resolution = resolution;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImageFileName() {
        return this.imageFileName;
    }

    public String getResolution() {
        return this.resolution;
    }

    public String toString() {
        return this.description + this.imageFileName + this.resolution;
    }
}