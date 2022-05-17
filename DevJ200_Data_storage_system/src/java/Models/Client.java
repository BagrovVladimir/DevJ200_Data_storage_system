
package Models;

import java.util.ArrayList;
import java.util.List;

public class Client {
    
    private int idClient;
    private String type;
    private String model;
    private String ip;
    
    public List<Address> listAddressC;
    
    public static List <Client> listClient;
    
    static{
        listClient = new ArrayList<>();
    }

    public Client(int idClient, String type, String model, String ip) {
        this.idClient = idClient;
        this.type = type;
        this.model = model;
        this.ip = ip;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    
    
}
