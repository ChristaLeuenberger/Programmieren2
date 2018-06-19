

package datamodel;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class DataLoaderXml implements DataLoader {


    private static final Logger logger = Logger.getLogger(DataLoader.class.getName());

    public DataLoaderXml() {
    }

    public DataModel loadData(File file) throws ParserConfigurationException, IOException, SAXException {

        String description = null, imageFileName = null, resolutionValue = null, resolutionUnit = null;

        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        NodeList elements = document.getElementsByTagName("image");
        for (int i = 0; i < elements.getLength(); i++) {
            Node nNode = elements.item(i);

            Element element = (Element) nNode;
            description = element.getElementsByTagName("description").item(0).getTextContent();
            imageFileName = element.getElementsByTagName("image-file").item(0).getTextContent();
            resolutionValue = element.getElementsByTagName("resolution").item(0).getTextContent();
        }
        elements = document.getElementsByTagName("resolution");
        Node nNode = elements.item(0);
        Element element = (Element) nNode;
        resolutionUnit = element.getAttribute("unit");

        return new DataModel(description, imageFileName, resolutionValue, resolutionUnit);
    }
}
