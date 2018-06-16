package datamodel;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class DataLoaderTxt implements DataLoader {

    private static final Logger logger = Logger.getLogger( DataLoader.class.getName() );

    public DataLoaderTxt() {
    }

    public DataModel loadDataXml(File file) {
        List<String> dataLoader = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()) {
                dataLoader.add(scanner.nextLine());
            }
        } catch (FileNotFoundException var10) {
            System.out.println("reading file failed: " + var10.getMessage());
        }

        String description = null;
        String imageFileName = null;
        String resolution = null;
        Iterator iter = dataLoader.iterator();

        while(iter.hasNext()) {
            String dataList = (String)iter.next();
            if (dataList.contains(":")) {
                if (dataList.startsWith("description")) {
                    description = dataList.substring(dataList.indexOf(":") + 1);
                     description = description.trim();
                     logger.info("description: " + description);
                } else if (dataList.startsWith("image-file")) {
                    imageFileName = dataList.substring(dataList.indexOf(":") + 1);
                    imageFileName = imageFileName.trim();
                    logger.info("FileName :" + imageFileName);
                } else if (dataList.startsWith("resolution")) {
                    resolution = dataList.substring(dataList.indexOf(":") + 1);
                    resolution = resolution.trim();
                    logger.info("Resolution :" + resolution);
                }
            }
        }
        String [] resolutionSplit = resolution.split("(?i)(?=[a-z])");
        String resolutionValue = resolutionSplit[0];
        String resolutionUnit = resolutionSplit [1];
        resolutionUnit = resolutionUnit + resolutionSplit[2];

        return new DataModel(description, imageFileName, resolution, resolutionValue, resolutionUnit);
    }
}
