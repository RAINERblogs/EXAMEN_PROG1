
package examen_progiii;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PROVEEDOR implements Serializable {
    static final long serialVersionUID=1L;
    
    private String razonSocial;
    private String direccion;
    private int nroTelefono;
    
    private List<PRODUCTO> listaProd;
    public PROVEEDOR() {
        
        listaProd = new ArrayList<>();
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNroTelefono() {
        return nroTelefono;
    }

    public void setNroTelefono(int nroTelefono) {
        this.nroTelefono = nroTelefono;
    }

    public List<PRODUCTO> getListaProd() {
        return listaProd;
    }

    public void setListaProd(List<PRODUCTO> listaProd) {
        this.listaProd = listaProd;
    }
    
    
   
}
