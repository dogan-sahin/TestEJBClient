import ejb.EJBTestRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Main {

    public static void main(String a[]) {
        try {
            Properties props = new Properties();

            props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
            props.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

            Context context = new InitialContext(props);

            EJBTestRemote etr = (EJBTestRemote)context.lookup("ejb:/TestEJB-1.0-SNAPSHOT/EJBTest!ejb.EJBTestRemote");
            System.out.println(etr.getName("Dokksen"));

        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }
}