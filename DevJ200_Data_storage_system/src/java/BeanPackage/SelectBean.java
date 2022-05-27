/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanPackage;

import Entity.Address;
import Entity.Client;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Владимир
 */
@Stateless
public class SelectBean implements SelectBeanLocal {
    
    @PersistenceContext
    EntityManager em;
    
    
//    @EJB
//            UpdateBeanLocal updateBeanLocal;
    
//    List <Address> addresses = Client.listAddress;
//    List <Client> clients = Client.listClient;
    


    @Override
    public List <Address> filterStreet(HttpServletRequest request, List <Address> addresses) {
        System.out.println("filterStreet!!!!!!!!!!ну иииии!!");
        String street = Objects.toString(request.getParameter("streetFilter"), "");
//        List <Address> addresses;
//        addresses = Client.listAddress;
        List<Address> temp = new LinkedList<>();
        for (Address address : addresses) {
            if (address.getStreet().contains(street)) 
                temp.add(address);
        }
        if(!temp.isEmpty()) 
            addresses = new ArrayList<>(temp);
        System.out.println(addresses + " size: "+addresses.size() + street + temp + "sizetemp: "+ temp.size());
        
        return addresses;  
    }

    @Override
    public List<Address> filterNum(HttpServletRequest request, List <Address> addresses) {
        String numString = Objects.toString(request.getParameter("numFilter"), "");
        int num = toInt(numString);
//        List <Address> addresses;
//        addresses = Client.listAddress;
        List<Address> temp = new LinkedList<>();
        for (Address address : addresses) {
            if (address.getNum()==num) 
                temp.add(address);
        }
        if(!temp.isEmpty()) 
            addresses = new ArrayList<>(temp);
        return addresses;
    }
//
    @Override
    public List<Address> filterCity(HttpServletRequest request, List <Address> addresses) {
        String city = Objects.toString(request.getParameter("cityFilter"), "");
//        List <Address> addresses;
//        addresses = Client.listAddress;
        List<Address> temp = new LinkedList<>();
        for (Address address : addresses) {
            if (address.getCity().contains(city)) 
                temp.add(address);
        }
        if(!temp.isEmpty()) 
            addresses = new ArrayList<>(temp);
        return addresses;
    }   

//    @Override
//    public List<Address> addressList() {
//        return addresses;
//    }
//
//    @Override
//    public List<Client> clientList() {
//        return clients;
//    }
    
    @Override
    public int toInt(String s) {
                try{
            int i = Integer.parseInt(s);
            return i;
        } catch (NumberFormatException nfe) { 
            System.out.println("NumberFormatException" + nfe.getMessage());
            return 0;
        }
    }

    @Override
    public List<Address> addressList() {
        return em.createNamedQuery("Address.findAll").getResultList();
    }

    @Override
    public List<Client> clientList() {
        return  em.createNamedQuery("lient.findAll").getResultList();
    }

}
