import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by mael on 13/04/15.
 */
public class MyClientObject extends UnicastRemoteObject implements ClientService {

    private int val;

    protected MyClientObject(int v) throws RemoteException {
        val=v;
    }

    @Override
    public void facturer(Facture f){
        val-=f.getFacture();
    }

    public int getVal(){
        return val;
    }

}
