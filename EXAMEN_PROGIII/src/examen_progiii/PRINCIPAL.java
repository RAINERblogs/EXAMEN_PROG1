
package examen_progiii;

import java.util.Scanner;

public class PRINCIPAL {
     public static void main(String[] args) {
        Scanner leer =new Scanner (System.in);
        boolean continuar = true;
        int x;
        ACCIONES oper = new ACCIONES();
        do{
            System.out.println("=====================================");
            System.out.println("            MENU DE OPCIONES");
            System.out.println("======================================");
            System.out.println("   1. REGISTRAR PROVEEDOR Y PRODUCTO ");
            System.out.println("   2. LISTAR PRODUCTOS ");
            System.out.println("   3. ADICIONAR STOCK ");
            System.out.println("   4. COMPRAR UN PRODUCTO");
            System.out.println("   5. LISTAR PROVEEDORES ");
            System.out.println("   6. SALIR ");
            System.out.println("-------------------------------");
            System.out.println("");
            System.out.print("    Elija una opcion : ");
            x = leer.nextInt();
            System.out.println("");
            switch(x){

                case 1:
                    oper.REGISTRARprovee();
                    oper.guardarDATOS();
                    break;
                case 2:
                    oper.leerDATOS();
                    oper.BUSCARprovee();
                    break;
                case 3:
                    oper.leerDATOS();
                    oper.AÑADIRstock();
                    oper.guardarDATOS();
                  
                    break;
                case 4:
                   oper.leerDATOS();
                   oper.COMPRA();
                   oper.guardarDATOS();
                  
                    break;
                case 5:
                    oper.leerDATOS();
                    oper.LISTARProveedores();
                    break;
                case 6:

                    continuar = false;
                    break;
                default:
                    System.out.println("Digite una opcion nuevamente...");
                    break;
            }
        }while (continuar);
    }
}
