import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by mael on 13/04/15.
 */
public interface Service extends Remote {

    int getInt() throws RemoteException;
    void multInt(int n) throws RemoteException;
    String getThreadName() throws RemoteException;
    void printThreadName(String s) throws RemoteException;
    int setVal(int v,ClientService name) throws RemoteException;
}
