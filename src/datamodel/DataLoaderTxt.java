package datamodel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class DataLoaderTxt implements DataLoader {


    public DataLoaderTxt() {
    }

    public DataModel loadData(File file) {
        List<String> dataLoader = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                dataLoader.add(scanner.nextLine());
            }
        } catch (FileNotFoundException var10) {
            System.out.println("reading file failed: " + var10.getMessage());
        }

        String description = null;
        String imageFileName = null;
        String resolution = null;
        Iterator iterator = dataLoader.iterator();

        while (iterator.hasNext()) {
            String dataList = (String) iterator.next();
            if (dataList.contains(":")) {
                if (dataList.startsWith("description")) {
                    description = dataList.substring(dataList.indexOf(":") + 1);
                    description = description.trim();

                } else if (dataList.startsWith("image-file")) {
                    imageFileName = dataList.substring(dataList.indexOf(":") + 1);
                    imageFileName = imageFileName.trim();

                } else if (dataList.startsWith("resolution")) {
                    resolution = dataList.substring(dataList.indexOf(":") + 1);
                    resolution = resolution.trim();

                }
            }
        }
        String resolutionValue = null;
        String resolutionUnit = null;
        if (resolution != null) {
            String[] resolutionSplit = resolution.split("(?i)(?=[a-z])", 2);
            System.out.println(resolutionSplit.length);
            resolutionValue = resolutionSplit[0];
            resolutionUnit = resolutionSplit[1];
        }

        return new DataModel(description, imageFileName, resolutionValue, resolutionUnit);
    }
}
