/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanPackage;

import Entity.Address;
import Entity.Client;
import java.util.List;
import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Владимир
 */
@Local
public interface UpdateBeanLocal {
    
    public List <Address> addressList(String city, String street, int num, int subnum, int flat, String extra, Client client);
    public List <Client> clientList(String type, String model, String ip);
    
    public boolean checkParametersAddress(String city, String street, int num, String extra, HttpServletRequest request);
    public boolean checkParametersClient(String type, String model, String ip, HttpServletRequest request);
    
    public boolean checkParametersAddressUpdate(int idAddress, String city, String street, int num, String extra, HttpServletRequest request);
    public boolean checkParametersClientUpdate(int idClient, String type, String model, String ip, HttpServletRequest request);
//    
//    public List <Address> removeAddress(int id);
    public List <Client> removeClient(int id);
//    
    public List <Address> updateAddress(int idAddress, String city, String street, int num, int subnum, int flat, String extra, Client client);
    public List <Client> updateClient(int idClient, String type, String model, String ip);
    
    public int toInt(String s);
    
    public Client getClientById(int id);
    
}
