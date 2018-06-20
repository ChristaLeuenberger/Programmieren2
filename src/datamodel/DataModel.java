package datamodel;


public class DataModel {
    private String description;
    private String imageFileName;
    private String resolutionValue;
    private String resolutionUnit;


    public DataModel(String description, String imageFileName, String resolutionValue, String resolutionUnit) {
        this.description = description;
        this.imageFileName = imageFileName;
        this.resolutionValue = resolutionValue;
        this.resolutionUnit = resolutionUnit;
    }


    public String getDescription() {
        return this.description;
    }

    public String getImageFileName() {
        return this.imageFileName;
    }

    public String getResolution() {
        return this.resolutionValue + this.resolutionUnit;
    }

    public String getResolutionUnit() {
        return resolutionUnit;
    }

    public String getResolutionValue() {
        return resolutionValue;
    }

    @Override
    public String toString() {
        return this.description + this.imageFileName;
    }


}