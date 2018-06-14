
package datamodel;

import java.io.File;

public class DataLoaderXml implements DataLoader {
    private String description = null;
    private String imageFileName = null;
    private String resolution = null;
    private String resolutionValue = null;
    private String resolutionUnit = null;


    public DataLoaderXml() {
    }

    public DataModel loadData(File file) {
        return new DataModel(description, imageFileName, resolution, resolutionValue, resolutionUnit);
    }
}