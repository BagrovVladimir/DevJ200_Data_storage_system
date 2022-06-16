
package BeanPackage;

import Entity.Client;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RepositoryBean implements RepositoryBeanLocal {
    @PersistenceContext
        EntityManager em;

    @Override
    public List<Client> getAllClient() {
        return em.createNamedQuery("Client.findAll").getResultList();
    }   
}
