package datamodel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class DataLoaderTxt implements DataLoader {

    private static final Logger logger = Logger.getLogger( DataLoader.class.getName() );

    public DataLoaderTxt() {
    }

    public DataModel loadData(File file) {
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
        return new DataModel(description, imageFileName, resolution);
    }
}
