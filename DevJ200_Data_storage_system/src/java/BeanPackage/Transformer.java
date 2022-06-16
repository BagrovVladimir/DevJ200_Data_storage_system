/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanPackage;

import Entity.Client;
import Services.CreaterXML;
import Services.DemoDom;
import ServletPackage.DemoSAX;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Владимир
 */
@Stateless
public class Transformer implements TransformerLocal {
    
    @EJB
    RepositoryBeanLocal repositoryBeanLocal;
    
//    @PersistenceContext
//                EntityManager em;
//    
    

    @Override
    public List<Client> getClientListSAX() {
        List<Client> list = repositoryBeanLocal.getAllClient();
        CreaterXML.createXML(list);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser;
        DemoSAX demoSAX = new DemoSAX();
            try {
                parser = factory.newSAXParser();
                try {
                    
                    parser.parse("Clients.xml", demoSAX);
                } catch (IOException ex) {
                    System.out.println("IOException Error: " + ex.getMessage());
                }
            } catch (ParserConfigurationException ex) {
                System.out.println("ParserConfigurationException Error: " + ex.getMessage());
            } catch (SAXException ex) {
                System.out.println("SAXException: " + ex.getMessage());
            }
        list = demoSAX.listClient;
        return list;
        
//        return em.createNamedQuery("Client.findAll").getResultList();
    }
    
    @Override
    public List<Client> getClientListDOM() {
        List<Client> list = repositoryBeanLocal.getAllClient();
        CreaterXML.createXML(list);
        DemoDom demoDom = new DemoDom();
        demoDom.readXMLByDom();
        list = demoDom.listClient;
        list.forEach(System.out::println);
        return list;
    }
    
    @Override
    public List<Client> filterModel(HttpServletRequest request, List<Client> clients) {
        String model = Objects.toString(request.getParameter("modelFilter"), "");
        List<Client> temp = new LinkedList<>();
        for (Client client : clients) {
            if (client.getModel().toLowerCase().contains(model)) {
                temp.add(client);
            }  
        }
        if (!temp.isEmpty()) {
            clients = new ArrayList<>(temp);  
        } else {
            request.setAttribute("msg", "Model not founded");
            clients = null;
        }
        return clients;
    }

    @Override
    public void transform() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
