import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by mael on 13/04/15.
 */
public class MyService extends UnicastRemoteObject implements Service {

    int n=1;
    int val=3;

    protected MyService() throws RemoteException {
    }

    @Override
    public int getInt() throws RemoteException {
        return n;
    }

    @Override
    public void multInt(int m) throws RemoteException {
        n*=m;
    }

    @Override
    public String getThreadName(){
        return Thread.currentThread().getName();
    }

    @Override
    public void printThreadName(String s){
        System.out.println(s);
    }

    @Override
    public  synchronized int setVal(int v, ClientService cname) throws RemoteException {
        val=val*v;
        System.out.println("Thread:"+Thread.currentThread().getName()+" val renvoyée : " + val + "au Client "+cname);
        Facture f= new Facture(v); // prix à payer pour cette opération
        try {
            cname.facturer(f); // délivre la facture à cname !
        } catch (java.rmi.RemoteException e) {}
        return val;
    }
}
