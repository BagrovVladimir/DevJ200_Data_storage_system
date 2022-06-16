
package Services;

import BeanPackage.RepositoryBeanLocal;
import Entity.Client;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;

public class CreaterXML {
    
//   List<Client> clientList = new ArrayList<>(); 
//    
//    @EJB
//    RepositoryBeanLocal repositoryBeanLocal;
    
    public static final File file = new File("Clients.xml");
    static {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error of creating file: " + ex.getMessage());
            }  
        }
    }
    
//    public void transform(){
//        clientList = repositoryBeanLocal.getAllClient();
//        createXML(clientList);
//    }
    
    public static void createXML(List<Client> clientList){
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sb.append("<clients>\n");
        for (Client c : clientList) {
            sb.append("<client ");
            sb.append("idClient=\"").append(c.getIdclient()).append("\" ");
            sb.append("type=\"").append(c.getType()).append("\" ");
            sb.append("model=\"").append(c.getModel()).append("\" ");
            sb.append("ip=\"").append(c.getIp()).append("\"/>\n");
        }
        sb.append("</clients>");
        try (FileWriter writer = new FileWriter(file);){ 
            writer.write(sb.toString());
        } catch (IOException ex) {
            System.out.println("Erorr of writing file: " + ex.getMessage());
        }  
    } 
}
