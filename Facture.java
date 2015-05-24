import java.io.Serializable;

/**
 * Created by mael on 13/04/15.
 */
public class Facture implements Serializable {
    int facture;

    public Facture(int f){
        facture=f;
    }

    public int getFacture() {
        return facture;
    }

    public void setFacture(int facture) {
        this.facture = facture;
    }
}
