package ejb;

import javax.ejb.Remote;
import java.io.Serializable;

@Remote
public interface EJBTestRemote extends Serializable {
    public String getName (String name);
}
