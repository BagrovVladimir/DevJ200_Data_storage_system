/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanPackage;

import Models.Address;
import Models.Client;
import java.util.List;
import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Владимир
 */
@Local
public interface SelectBeanLocal {
    
    public List <Address> addressList();
    public List <Client> clientList();
    
    public List <Address> filterStreet(HttpServletRequest request);
    public List <Address> filterNum(HttpServletRequest request);
    public List <Address> filterCity(HttpServletRequest request);
    
    public int toInt(String s);
}
