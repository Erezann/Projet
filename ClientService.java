import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by mael on 13/04/15.
 */
public interface ClientService extends Remote {
    public void facturer(Facture f)throws RemoteException;
    public int getVal() throws RemoteException;
}
