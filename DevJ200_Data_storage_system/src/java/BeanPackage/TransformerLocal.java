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
public interface TransformerLocal {
    
    public List <Client> getClientListSAX();
    public List <Client> getClientListDOM();
    public List <Client> filterModel(HttpServletRequest request, List <Client> clients);
    public void transform();
    
}
