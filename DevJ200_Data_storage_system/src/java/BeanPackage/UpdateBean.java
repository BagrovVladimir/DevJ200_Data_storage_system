/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanPackage;

import Entity.Address;
import Entity.Client;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Владимир
 */
@Stateless
public class UpdateBean implements UpdateBeanLocal {
    
    @PersistenceContext
            EntityManager em;
    
//    Address address;
//    Client client;
    

//    List <Address> addresses = Client.listAddress;
//    List <Client> clients = Client.listClient;
    
    List <Address> addresses;
    List <Client> clients;

    

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
    public boolean checkParametersAddress(String city, String street, int num, String extra, HttpServletRequest request) {
                boolean rez = false;
        String regex = "[А-Яа-я0-9 -]*";
        
//        if (idAddress == 0 || idAddress <=0) {
//            request.setAttribute("msg", "Поле \"idAddress\" не должно равняться нулю/быть меньше нуля");
//            return rez;
//        }
        
        if (city.trim().isEmpty()) {
            request.setAttribute("msg", "Поле \"city\" должно быть заполнено");
            return rez;
        }
        if (!city.matches(regex)) {
                    request.setAttribute("msg", "В поле \"city\" должны быть символы только русского алфавита");
                    return rez;
        }
        if (city.length()>100) {
                    request.setAttribute("msg", "В поле \"city\" не должно быть больше 100 символов");
                    return rez; 
        }
         
        if (street.trim().isEmpty()) {
           request.setAttribute("msg", "Поле \"street\" должно быть заполнено");
           return rez;
        } 
        if (!street.matches(regex)) {
           request.setAttribute("msg", "В поле \"street\" должны быть символы только русского алфавита");
           return rez;
        }
        if (street.length()>100) {
           request.setAttribute("msg", "В поле \"street\" не должно быть больше 100 символов");
           return rez; 
        }
 
        if (num == 0 || num <=0 ) {
            request.setAttribute("msg", "Поле \"num\" не должно равняться нулю/быть меньше нуля");
            return rez;
        }
        
        if (!extra.matches(regex)) {
           request.setAttribute("msg", "В поле \"extra\" должны быть символы только русского алфавита");
           return rez;
        }
        if (extra.length()>200) {
           request.setAttribute("msg", "В поле \"extra\" не должно быть больше 200 символов");
           return rez;
        }
        
        return rez = true;
    }

    @Override
    public boolean checkParametersClient(String type, String model, String ip, HttpServletRequest request) {
            boolean rez = false;
    String regex = "[A-Za-z0-9 -/.]*";
    
//    if (idClient == 0 || idClient <=0) {
//            request.setAttribute("msg", "Поле \"idClient\" не должно равняться нулю/быть меньше нуля");
//            return rez;
//    }
    
    if (type.trim().isEmpty()) {
            request.setAttribute("msg", "Поле \"type\" должно быть заполнено");
            return rez;
    }
    if (!type.matches(regex)) {
             request.setAttribute("msg", "В поле \"type\" должны быть символы только латинского алфавита");
             return rez;
    }
    if (type.length()>100) {
             request.setAttribute("msg", "В поле \"type\" не должно быть больше 100 символов");
             return rez; 
    }
    
    if (model.trim().isEmpty()) {
            request.setAttribute("msg", "Поле \"model\" должно быть заполнено");
            return rez;
    }
    if (!model.matches(regex)) {
             request.setAttribute("msg", "В поле \"model\" должны быть символы только латинского алфавита");
             return rez;
    }
    if (model.length()>100) {
             request.setAttribute("msg", "В поле \"model\" не должно быть больше 100 символов");
             return rez; 
    }
    
    if (ip.trim().isEmpty()) {
            request.setAttribute("msg", "Поле \"ip\" должно быть заполнено");
            return rez;
    }
    String regexIp = "^(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[0-9]{2}|[0-9])(\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[0-9]{2}|[0-9])){3}$";
    if (!ip.matches(regexIp)) {
             request.setAttribute("msg", "Некорректно введён IP");
             return rez;
    }
    if (ip.length()>25) {
             request.setAttribute("msg", "В поле \"ip\" не должно быть больше 25 символов");
             return rez; 
    }
    
    return rez = true;
    }

    @Override
    public List<Address> addressList(String city, String street, int num, int subnum, int flat, String extra, Client client) {
        Address address = new Address(city, street, num, subnum, flat, extra, client);
        em.persist(address);
       
//        addresses = Client.listAddress;
//        addresses.add(address);
        return em.createNamedQuery("Address.findAll").getResultList();
        
    }

    @Override
    public List<Client> clientList(String type, String model, String ip) {
        Client client = new Client(type, model, ip);
        em.persist(client);
//        clients = Client.listClient;
//        clients.add(client);
        return em.createNamedQuery("Client.findAll").getResultList();
    }

//    @Override
//    public List<Address> removeAddress(int id) {
//        Address temp = null;
//        addresses = em.createNamedQuery("Address.findAll").getResultList();
//        for (Address address : addresses) {
//            if(address.getIdaddress()==id)
//                temp = address;
//        }
//       addresses.remove(temp);
//       return addresses;
//    }

    @Override
    public List<Client> removeClient(int id) {
//        String s = "DELETE c FROM CLIENT c WHERE c.IDCLIENT = " + id;
//        em.createQuery(s);
        Client temp2 = null;
        clients = em.createNamedQuery("Client.findAll").getResultList();
        for (Client client : clients) {
            if(client.getIdclient()==id)
                temp2 = client;  
        }
        em.remove(temp2);
//       clients.remove(temp2);
       return em.createNamedQuery("Client.findAll").getResultList();
    }
//
    @Override
    public boolean checkParametersAddressUpdate(int idAddress, String city, String street, int num, String extra, HttpServletRequest request) {
               boolean rez = false;
        String regex = "[А-Яа-я0-9 -]*";
        
        if (idAddress == 0 || idAddress <=0) {
            request.setAttribute("msg", "Поле \"idAddress\" не должно равняться нулю/быть меньше нуля");
            return rez;
        }
        
        if (!city.matches(regex)) {
                    request.setAttribute("msg", "В поле \"city\" должны быть символы только русского алфавита");
                    return rez;
        }
        if (city.length()>100) {
                    request.setAttribute("msg", "В поле \"city\" не должно быть больше 100 символов");
                    return rez; 
        }
         
        if (!street.matches(regex)) {
           request.setAttribute("msg", "В поле \"street\" должны быть символы только русского алфавита");
           return rez;
        }
        if (street.length()>100) {
           request.setAttribute("msg", "В поле \"street\" не должно быть больше 100 символов");
           return rez; 
        }
        
        if (!extra.matches(regex)) {
           request.setAttribute("msg", "В поле \"extra\" должны быть символы только русского алфавита");
           return rez;
        }
        if (extra.length()>200) {
           request.setAttribute("msg", "В поле \"extra\" не должно быть больше 200 символов");
           return rez;
        }
        
        return rez = true; 
    }
//
    @Override
    public boolean checkParametersClientUpdate(int idClient, String type, String model, String ip, HttpServletRequest request) {
                boolean rez = false;
        String regex = "[A-Za-z0-9 -/.]*";

        if (idClient == 0 || idClient <=0) {
                request.setAttribute("msg", "Поле \"idClient\" не должно равняться нулю/быть меньше нуля");
                return rez;
        }

        if (!type.matches(regex)) {
                 request.setAttribute("msg", "В поле \"type\" должны быть символы только латинского алфавита");
                 return rez;
        }
        if (type.length()>100) {
                 request.setAttribute("msg", "В поле \"type\" не должно быть больше 100 символов");
                 return rez; 
        }

        if (!model.matches(regex)) {
                 request.setAttribute("msg", "В поле \"model\" должны быть символы только латинского алфавита");
                 return rez;
        }
        if (model.length()>100) {
                 request.setAttribute("msg", "В поле \"model\" не должно быть больше 100 символов");
                 return rez; 
        }

        String regexIp = "^(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[0-9]{2}|[0-9])(\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[0-9]{2}|[0-9])){3}$";
        if (!ip.matches(regexIp)) {
                 request.setAttribute("msg", "Некорректно введён IP");
                 return rez;
        }
        if (ip.length()>25) {
                 request.setAttribute("msg", "В поле \"ip\" не должно быть больше 25 символов");
                 return rez; 
        }

        return rez = true;
    }
//
    @Override
    public List<Address> updateAddress(int idAddress, String city, String street, int num, int subnum, int flat, String extra, Client client) {
        addresses = em.createNamedQuery("Address.findAll").getResultList();
        
//        Address tempAddress = null;
        for (Address address : addresses) {
            if(address.getIdaddress() == idAddress){
//                tempAddress = address;
//            }
                if(!city.trim().isEmpty()){
                  address.setCity(city);  
                }
                if(!street.trim().isEmpty()){
                  address.setStreet(street); 
                }
                if(num!=0){
                  address.setNum(num); 
                }
                if(subnum!=0){
                  address.setSubnum(subnum);
                }
                if(flat!=0){
                  address.setFlat(flat);
                }
                if(!extra.trim().isEmpty()){
                  address.setExtra(extra);
                }
                if(client!=null){
                  address.setClient(client);
                }
            }
        }
        em.flush();
//        Address addressUpdate = tempAddress;
//        addresses.add(addressUpdate);
//        addresses.remove(tempAddress);
        return em.createNamedQuery("Address.findAll").getResultList();
    }
//
    @Override
    public List<Client> updateClient(int idClient, String type, String model, String ip) {
        clients = em.createNamedQuery("Client.findAll").getResultList();
//        Client tempClient = null;
        for (Client client : clients) {
            if(client.getIdclient() == idClient){
//                tempClient = client;
//            }
                if(!type.trim().isEmpty()){
                  client.setType(type);  
                }
                if(!model.trim().isEmpty()){
                  client.setModel(model); 
                }
                if(!ip.trim().isEmpty()){
                  client.setIp(ip); 
                }
            }
        }
        em.flush();
//        Client clientUpdate = tempClient;
//        clients.add(clientUpdate);
//        clients.remove(tempClient);
        return em.createNamedQuery("Client.findAll").getResultList();
    }

    @Override
    public Client getClientById(int id) {
       return em.find(Client.class, id);
    }

 
    
    

}
