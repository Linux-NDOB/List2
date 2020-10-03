import javax.swing.*;

public class Probador {

    public static void main(String args[]){
        int op, cod;
        String nom;
        Lista miListArticulos = new Lista();
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog(
                    "Menú principal \n"+
                            "1. Registrar al final. \n"+
                            "2. Registrar al inicio. \n"+
                            "3. Buscar por código. \n"+
                            "4. Eliminar por código. \n"+
                            "5. Buscar por nombre. \n"+
                            "6. Mayor edad primero y quinto. \n"+
                            "7. Mujeres de quinto.\n"+
                            "8. Informe primer grado.\n"+
                            "9. Salir. \n"+
                            "Entre su opción: ?"
            ));

            switch(op){
                case 1:
                    miListArticulos.setAddFin();
                    break;
                case 2:
                    miListArticulos.setAddInicio();
                    break;
                case 3:
                    cod=Integer.parseInt(JOptionPane.showInputDialog(
                            "Entre el código a buscar: "));
                    miListArticulos.getSeeInfo(cod);
                    break;
                case 4:
                    cod=Integer.parseInt(JOptionPane.showInputDialog(
                            "Entre el código a eliminar: "));
                    miListArticulos.setEliminNodo(cod);
                    break;
                case 5:
                    nom =JOptionPane.showInputDialog(
                            "Entre el nombre a buscar: ");
                    miListArticulos.getSeeInfo2(nom);
                    break;
                case 6:
                    //miListArticulos.getSeeAll();
                    miListArticulos.setMayorPrimero();
                    miListArticulos.simple();
                    miListArticulos.setMayorQuinto();
                    miListArticulos.getSeeInfo3();
                    break;
                case 7:
                    miListArticulos.getseeMujeresQuinto();
                    break;
                case 8:
                    miListArticulos.getseeMujeresPrimero();
                    miListArticulos.getseeHombresPrimero();
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Adios!!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "Opción invalida!!!");
            }
        }while(op!=9);
        System.exit(0);
    }
}
