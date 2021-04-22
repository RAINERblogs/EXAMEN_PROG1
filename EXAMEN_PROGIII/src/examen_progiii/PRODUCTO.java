
package examen_progiii;

import java.io.Serializable;
import java.util.Scanner;

public class PRODUCTO  implements Serializable{
     static final long serialVersionUID=1L;

    private String NOMprod;
    private float COSTOunit;
    private int stock;

    public String getNOMprod() {
        return NOMprod;
    }

    public void setNOMprod(String NOMprod) {
        this.NOMprod = NOMprod;
    }

    public float getCOSTOunit() {
        return COSTOunit;
    }

    public void setCOSTOunit(float COSTOunit) {
        this.COSTOunit = COSTOunit;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
   

    
}
