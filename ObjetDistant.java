import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by mael on 30/03/15.
 */
public class ObjetDistant implements Distante {

    private MyObject object = new MyObject();
    private Service myService = new MyService();

    protected ObjetDistant() throws RemoteException {
    }

    public MyObject getObject() throws RemoteException{
        return object;
    }

    @Override
    public Service getService() throws RemoteException {
        return myService;
    }


    public void echo() throws RemoteException{
        System.out.println("echo");
    }

    public static void main(String args[]) {
        System.out.println("serveur");
        try {
            ObjetDistant obj = new ObjetDistant();
            Distante stub = (Distante) UnicastRemoteObject.exportObject(obj,6666);
            Registry registry = java.rmi.registry.LocateRegistry.createRegistry(1098);
            registry.rebind("HelloWorld",stub);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("fin serveur");
    }

}
