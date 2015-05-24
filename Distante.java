import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by mael on 30/03/15.
 */
public interface Distante extends Remote {
    public void echo() throws RemoteException;
    public MyObject getObject() throws RemoteException;
    public Service getService() throws RemoteException;
}
