import javax.swing.*;

public class nodo {

    public int id;
    public String nom;
    public String sexo;
    public int edad;
    public int grado;
    public String acudiente;
    public int numAcu;


    //Apuntador
    nodo sig;

    public nodo(int id, String nom, String sexo, int edad,int grado, String acudiente, int numAcu) {
        this.id = id;
        this.nom = nom;
        this.sexo = sexo;
        this.edad = edad;
        this.grado = grado;
        this.acudiente = acudiente;
        this.numAcu = numAcu;
    }

    public void getseeNodo(){
        String info="La información del estudiante es: \n";
        info += "Id: "+id+"\n";
        info += "Nombre: "+nom+"\n";
        info += "Edado: "+edad+"\n";
        info += "sexo: "+sexo+"\n";
        JOptionPane.showMessageDialog(null, info);
    }

    public void getseeNodoA(){
        String info="La información del Acudiente  es: \n";

        info += "Nombre: "+acudiente+"\n";
        info += "Numero: "+numAcu+"\n";

        JOptionPane.showMessageDialog(null, info);
    }

    public void getseeSimple(){
        String info="La información del Acudiente  es: \n";

        info += "Nombre: "+acudiente+"\n";
        info += "Numero: "+numAcu+"\n";

        JOptionPane.showMessageDialog(null, info);
    }


}
