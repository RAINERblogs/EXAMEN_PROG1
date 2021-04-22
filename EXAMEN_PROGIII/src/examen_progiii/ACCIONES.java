
package examen_progiii;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ACCIONES {
private List<PROVEEDOR> listaProb;

    transient Scanner leer;
    
    public ACCIONES() {
        listaProb = new ArrayList<>();
        leer = new Scanner (System.in);
    }
    
     public void REGISTRARprovee() {
        PROVEEDOR prov = new PROVEEDOR();
        System.out.println("INTRODUZCA LOS SIGUIENTES DATOS DEL PROVEEDOR:");
        System.out.print("RAZON SOCIAL: ");
        prov.setRazonSocial(leer.nextLine());
        System.out.print("DIRECCION: ");
        prov.setDireccion(leer.nextLine());
        System.out.print("Nº DE TELEFONO: ");
        prov.setNroTelefono(leer.nextInt());

       
        boolean continuar = true;
        do {
            System.out.println("---------------------------");
            System.out.println("1 REGISTRAR PRODUCTOS ");
            System.out.println("2 SALIR");
            System.out.println("Digite una opcion");
            int opc = leer.nextInt();
            leer.nextLine();

            switch (opc) {
                case 1:
                    PRODUCTO pro = new PRODUCTO();
                    System.out.println("INTRODUZCA LOS SIGUIENTES DATOS DEL PRODUCTO");
                    System.out.print("NOMBRE DEL PRODUCTO: ");
                    pro.setNOMprod(leer.nextLine());
                    System.out.print("PRECIO UNITARIO: ");
                    pro.setCOSTOunit(leer.nextFloat());
                    System.out.print("STOCK:");
                    pro.setStock(leer.nextInt());
                    prov.getListaProd().add(pro);
                    break;

                default:
                    continuar = false;
                    break;
            }
        } while (continuar);
        
        listaProb.add(prov);

    }
     
        public PROVEEDOR BUSCAR(String na) {
        PROVEEDOR pro = null;
        for (PROVEEDOR ob : listaProb) {
            if (ob.getRazonSocial().equalsIgnoreCase(na)) {
                pro = ob;
                break;
            }
        }
        return pro;

    }
     
     public void BUSCARprovee() {
        System.out.println("DIGITE EL PROVEEDOR:");
        leer.nextLine();
        String title = leer.nextLine();
        if (listaProb.isEmpty()) {
            System.out.println("        NO HAY PROVEEDORES ! ");
        } else {

            PROVEEDOR encontrado = BUSCAR(title);
            if (encontrado == null) {
                System.out.println("NO EXISTE  EL PROVEEDOR " + title);
            } else {
         
                System.out.println("       LISTA DE PRODUCTOS    ");
                System.out.println("--------------------------------------");
                lISTARprod(encontrado);
            }

        }

    }

    public void lISTARprod(PROVEEDOR proved) {
        for (PRODUCTO produ : proved.getListaProd()) {
            System.out.println("NOMNRE DEL PRODUCTO: " + produ.getNOMprod());
            System.out.println("COSTO UNITARIO     : " + produ.getCOSTOunit());
            System.out.println("STOCK              : " + produ.getStock());
            System.out.println("=============================================");
        }

    }
    
        public void COMPRA() {
        System.out.println("¿QUE PRODUCTO DESEA COMPRAR? :");
        leer.nextLine();
        String npr = leer.nextLine();
        System.out.println("¿CUANTAS UNIDADES DESEA COMPRAR?: ");
        int uni = leer.nextInt();
        if (BUSCARprod(npr, uni)) {
            System.out.println("");
            System.out.println("        COMPRA REALIZADA...");

        } else {
            System.out.println("");
            System.out.println("        EL PRODUCTO NO EXISTE...");
        }

    }
        
           public boolean BUSCARprod(String namep, int can) {
        boolean sw = false;
        find:
        for (PROVEEDOR obj : listaProb) {
            for (PRODUCTO pr : obj.getListaProd()) {
                if (pr.getNOMprod().equalsIgnoreCase(namep)) {
                   
                    if (can<=pr.getStock()) {
                        pr.setStock(pr.getStock() - can);
                         sw = true;
                    }else{
                        System.out.println("");
                        System.out.println("        NO HAY SUFICIENTES.... ");
                         
                    }
                    
                    break find;
                }
            }
        }
        return sw;
    }
           
        public void LISTARProveedores(){
        System.out.println("       LISTA DE PROVEEDORES");
        System.out.println("-------------------------------------");
        listaProb.forEach((n)->System.out.println(" "+n.getRazonSocial()));
    }
        public List<PROVEEDOR> getSupplier() {
        return listaProb;
    }
    
    
        
        
        public void guardarDATOS() {
        String ruta = "E:\\PROGRAMACION3\\ALMACEN.txt";
        try {
            FileOutputStream archivo = new FileOutputStream(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(archivo);
            oos.writeObject(listaProb);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ACCIONES.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ACCIONES.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
        public void leerDATOS() {
        String ruta = "E:\\PROGRAMACION3\\ALMACEN.txt";
        try {

            FileInputStream archivo = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(archivo);

            if (ois != null) {
                listaProb = (List<PROVEEDOR>) ois.readObject();//realizamos un casteo
            } else {
                System.out.println("NULO...");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(ACCIONES.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex) {
            Logger.getLogger(ACCIONES.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ACCIONES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
       public void AÑADIRstock(){
           if(listaProb != null){
               int sw=0;
               int ss=0;    
               System.out.println("INGRESE EL PROVEEDOR: ");
               String nom=leer.nextLine();
               for(PROVEEDOR pp:listaProb){
                   if(pp.getRazonSocial().equalsIgnoreCase(nom)){
                       sw=1;
                       System.out.println("DIGITE EL NOMBRE DEL PRODUCTO: ");
                       String nomp=leer.nextLine();
                       for(PRODUCTO pr: pp.getListaProd()){
                           if(pr.getNOMprod().equalsIgnoreCase(nomp)){
                               ss=1;
                               System.out.println("DIGITE LA CANTIDAD");
                               int can=leer.nextInt();
                               int tt=can+pr.getStock();
                               pr.setStock(tt);
                               System.out.println("           STOCK AÑADIDO...");
                           }
                           
                       }
                   }
               }
           }
       }
}
