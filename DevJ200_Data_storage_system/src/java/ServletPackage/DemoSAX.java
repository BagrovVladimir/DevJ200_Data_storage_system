package ServletPackage;


import Entity.Client;
import Entity.ClientXML;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DemoSAX extends DefaultHandler{
    
    Client client;
//    ClientXML clientXML;
    String qName = "";
    
    public List <Client> listClient = new ArrayList<>();

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        client = null;
//        clientXML = null;
        qName = "";
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Begin startElement");
        this.qName = this.qName;
//        if(qName.equals("clientXML")
        if(qName.equals("client")){
            System.out.println("Before idClient startElement");
            String idStr = attributes.getValue("idClient");
            int id = Integer.parseInt(idStr);
            String type = attributes.getValue("type");
            String model = attributes.getValue("model");
            String ip = attributes.getValue("ip");
            System.out.println("Before new ClientXML startElement");
            client = new Client(id, type, model, ip);
//            clientXML = new ClientXML(id, type, model, ip);
            System.out.println("Before addListClient startElement");
            listClient.add(client);
//            ClientXML.listClient.add(clientXML);
            System.out.println("size: " + ClientXML.listClient.size());
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End SAX and XML");
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start SAX and XML");
    }
    
    
    
    
    
}
