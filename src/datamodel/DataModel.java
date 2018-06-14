package datamodel;

import java.awt.Image;
import java.io.File;
import java.util.List;

public class DataModel {
    private String description;
    private String imageFileName;
    private String resolution;
    private String resolutionValue;
    private String resolutionUnit;

   
    public DataModel(String description, String imageFileName, String resolution, String resolutionValue, String resolutionUnit) {
        this.description = description;
        this.imageFileName = imageFileName;
        this.resolution = resolution;
        this.resolutionValue = resolutionValue;
        this.resolutionUnit = resolutionUnit;
    }

    public DataModel(File metaFile) {
    }

    public String getDescription() {
        return this.description;
    }

    public String getImageFileName() {
        return this.imageFileName;
    }

    public String getResolution() {
        return this.resolutionValue + this.resolutionUnit; }

    public String getResolutionUnit() {
        return resolutionUnit;
    }

    public String getResolutionValue() {
        return resolutionValue;
    }
    @Override
    public String toString() {
        return this.description + this.imageFileName + this.resolution;
    }


}