

package datamodel;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class DataLoaderXml implements DataLoader {


        private static final Logger logger = Logger.getLogger( DataLoader.class.getName() );

        public DataLoaderXml() {
        }

        public DataModel loadDataXml(File file) {
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
            String resolutionValue = null;
            String resolutionUnit = null;

           /* DocumentBuilderFactory documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document document = documentBuilder.parse(imageFileName);
            NodeList elements = document.getDocumenttElement().getE




*/



    /*public DataModel loadData (File file) {*/
            return new DataModel(description, imageFileName, resolution, resolutionValue, resolutionUnit);
        }
        }
