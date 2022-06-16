
package Services;

import Entity.Client;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DemoDom {
    
    public List<Client> listClient = new LinkedList<>();
    
    public void readXMLByDom(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(CreaterXML.file);
            Element root = document.getDocumentElement();
            NodeList clients = root.getChildNodes();
            for (int i = 0; i < clients.getLength(); i++) {
                Node node = clients.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE 
                        && node.getNodeName().equals("client")) {
                    Element element = (Element) node;
                    Client client = new Client();
                    client.setIdclient(Integer.parseInt(element.getAttribute("idClient")));
                    client.setType(element.getAttribute("type"));
                    client.setModel(element.getAttribute("model"));
                    client.setIp(element.getAttribute("ip"));
                    listClient.add(client);
                }
            }
        } catch (Exception ex) {
            System.out.println("Exception Error: " + ex.getMessage());
        }
    }    
}
