import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static java.lang.Thread.sleep;

/**
 * Created by mael on 30/03/15.
 */
public class Client {

    public static void main(String args[]) {
        System.out.println("Client");
        try {
            System.out.println("\n ### Partie sérialisation ###");

            Registry reg = LocateRegistry.getRegistry(1098);
            Remote o = reg.lookup("HelloWorld");
            Distante obj = (Distante) o;
            obj.echo();
            String s = obj.getObject().getFelix();
            System.out.println(s);

            System.out.println("\n ### Partie service ####");

            Service serv = obj.getService();
            System.out.println(serv.getInt());
            serv.multInt(5);
            System.out.println(serv.getInt());
            System.out.println(serv.getThreadName());
            sleep(1000);
            serv.printThreadName("Thread name: "+Thread.currentThread().getName());

            System.out.println("\n ### Partie remote client ####");
            ClientService clientService = new MyClientObject(1000);
            System.out.println(clientService.getVal());
            serv.setVal(5,clientService);
            System.out.println(clientService.getVal());


        }
        catch(Exception e){
            System.err.println(e);
        }
        System.out.println("\n Fin client");
    }

    public void facturer(Facture f){
        System.out.println("Tu viens de te faire voler : "+f.getFacture());
    }
}
