import java.io.Serializable;

/**
 * Created by mael on 07/04/15.
 */
public class MyObject implements Serializable{
    String s = "felix";

    public MyObject(){}

    public String getFelix(){
        return s;
    }

    @Override
    public String toString() {
        return super.toString()+"felix";
    }
}
