

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
            props.put(Context.PROVIDER_URL, "http-remoting://<host-address>:8080/");

            /*
            If the wildfly-server is running on a remote host, we have to create a
            Wildfly Application-User on host -> $WILDFLY_HOME/add-user.sh
            and provide the credentials of the created user as below
            */
            props.put(Context.SECURITY_PRINCIPAL, "username");
            props.put(Context.SECURITY_CREDENTIALS, "password");

            Context context = new InitialContext(props);
            EJBTestRemote etr = (EJBTestRemote) context.lookup("ejb:/TestEJB/EJBTest!ejb.EJBTestRemote");
            System.out.println(etr.getName("Team A"));

        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }
}