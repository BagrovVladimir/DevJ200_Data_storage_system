
package BeanPackage;

import Entity.Client;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RepositoryBeanLocal {
    List <Client> getAllClient();
}
