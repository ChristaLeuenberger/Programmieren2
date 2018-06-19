
package datamodel;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public interface DataLoader {
    DataModel loadData(File file) throws ParserConfigurationException, IOException, SAXException;

}
