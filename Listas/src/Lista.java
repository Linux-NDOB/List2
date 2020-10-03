import javax.swing.JOptionPane;

public class Lista {
    //Atributo
    int cont1;
    nodo cab;

    //Método constructor: Crea la lista.
    public Lista(){ cab=null; }

    //Determinar el número de elementos de una lista.
    public int getLonglista(){
        int cont=0;
        nodo p=cab;
        if(cab==null)
            return 0;
        else{
            while(p!=null){
                cont++;
                p=p.sig;
            }
            return cont;
        }
    }

    //Este método retorna un apuntador donde se encuentre
    //un código de producto dado.
    public nodo getBuscarCodP(int id){
        nodo buscar=null;
        if(cab==null)
            return null;
        else{
            buscar=cab;
            while(buscar!=null){
                if( buscar.id == id )
                    return buscar;
                buscar = buscar.sig;
            }
            return null;
        }
    }

    public nodo getBuscarN(String nom){
        nodo buscar=null;
        if(cab==null)
            return null;
        else{
            buscar=cab;
            while(buscar!=null){
                if( buscar.nom.equals(nom) )
                    return buscar;
                buscar = buscar.sig;
            }
            return null;
        }
    }

    public nodo getCrearNodo(){
        int id;
        String nom;
        String sexo;
        int edad , grado;
        String acudiente;
        int numAcu;
        nodo b=null;
        do{
            id=Integer.parseInt(JOptionPane.showInputDialog(
                    "Entre id estudiante: "));
            b=getBuscarCodP(id);
            if(b!=null)
                JOptionPane.showMessageDialog(null,
                        "El código ya existe en la lista, intente nuevamente!");

            edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad (mayor que 6)"));

        }while(b!=null && edad < 6);
        nom = JOptionPane.showInputDialog("Entre nombre del estudiante: ");
        sexo = JOptionPane.showInputDialog("Entre sexo del estudiante (M o F): ");
        grado =Integer.parseInt(JOptionPane.showInputDialog(
                "Entre grado a cursar estudiante: "));
        acudiente = JOptionPane.showInputDialog("Entre nombre del acudiente estudiante: ");
        numAcu =Integer.parseInt(JOptionPane.showInputDialog(
                "Entre numero de acuendite estudiante: "));
        if (grado == 5 && sexo.equals("F"))
            cont1++;

        nodo info = new nodo(id, nom, sexo , edad, grado , acudiente , numAcu);
        return info;

    }

    public void setAddInicio(){
        nodo info = getCrearNodo();
        if(cab==null){
            cab=info;
            JOptionPane.showMessageDialog(null,
                    "Elemento agregado, la lista estaba vacía!");
        }else{
            info.sig = cab;
            cab = info;
            JOptionPane.showMessageDialog(null,
                    "Elemento agregado al incio de la lista!");
        }
    }

    public void setAddFin(){
        nodo info=getCrearNodo();
        nodo p=null;
        if(cab==null){
            cab=info;
            JOptionPane.showMessageDialog(null,
                    "Elemento agregado, la lista estaba vacía!");
        }else{
            p=cab;
            while(p.sig!=null)
                p=p.sig;
            p.sig=info;
            JOptionPane.showMessageDialog(null,
                    "Elemento agregado al final de la lista!");
        }
    }

    public boolean getEsVacia(){
        return cab==null?true:false;
    }

    public void getSeeAll(){
        nodo p=null;
        if(getEsVacia())
            JOptionPane.showMessageDialog(null,
                    "La lista no tiene elementos!");
        else{
            p=cab;
            while(p!=null){
                p.getseeNodo();
                p=p.sig;
            }
            JOptionPane.showMessageDialog(null,
                    "Se mostraron todos los elementos de la lista, "
                            + "la lista tiene: "+getLonglista()+" elementos.");
        }
    }

    public void getSeeInfo(int cod){
        if(cab==null)
            JOptionPane.showMessageDialog(null,
                    "La lista esta vacía!!!");
        else{
            nodo p=getBuscarCodP(cod);
            if(p==null)
                JOptionPane.showMessageDialog(null,
                        "El elemento consultado no existe!!");
            else
                p.getseeNodo();
        }
    }

    public void getSeeInfo2(String nom){
        if(cab==null)
            JOptionPane.showMessageDialog(null,
                    "La lista esta vacía!!!");
        else{
            nodo p=getBuscarN(nom);
            if(p==null)
                JOptionPane.showMessageDialog(null,
                        "El elemento consultado no existe!!");
            else
                p.getseeNodoA();
        }
    }

    //Este método retonar un nodo apuntando detrás de p.
    public nodo getBack(nodo p){
        nodo q=cab;
        while(q.sig!=p)
            q=q.sig;
        return q;
    }

    public void setEliminNodo(int id){
        if(getEsVacia())
            JOptionPane.showMessageDialog(null,
                    "La lista esta vacía!");
        else{
            nodo q=null;
            nodo p=getBuscarCodP(id);
            if(p==null)
                JOptionPane.showMessageDialog(null,
                        "El elemento no existe!!");
            else{
                if((p==cab)&&(cab.sig==null)){
                    cab=null;
                    JOptionPane.showMessageDialog(null,
                            "Se eliminó el único elemento de la lista,"
                                    + " la lista esta vacía!!");
                }
                else if((cab.sig!=null)&&(p==cab)){
                    cab=cab.sig;
                    p.sig=null;
                    p=null;
                    JOptionPane.showMessageDialog(null,
                            "Elemento eliminado al inicio de la lista!!");
                }
                else if(p.sig==null){
                    q=getBack(p);
                    q.sig=null;
                    p=null;
                    JOptionPane.showMessageDialog(null,
                            "Elemento eliminado al final de la lista!!");
                }else{
                    q=getBack(p);
                    q.sig=p.sig;
                    p.sig=null;
                    p=null;
                    JOptionPane.showMessageDialog(null,
                            "Elemento eliminado entre dos nodos!!");
                }
            }
        }
    }

    public float getSuma(){
        float sum;
        nodo q;
        if(getEsVacia())
            return 0;
        else{
            sum=0;
            q=cab;
            while(q!=null){
                if (q.grado == 5 && q.sexo.equals("F")) {
                    sum += q.edad;
                }
                q=q.sig;
            }
            return sum;
        }
    }

    public float getPromedio(){
        if(cab==null)
            return 0;
        else{
            float tam=(float) getLonglista();
            return getSuma()/tam;
        }
    }

    public void setMayorPrimero( ){
        nodo temp=null;
        if(getEsVacia())
            JOptionPane.showMessageDialog(null,
                    "Lista vacía!!!");
        else{
            nodo p,q;
            p=cab;
            while(p!=null){
                q=cab;
                while(q.sig!=null){
                    if(q.grado == 1 && q.edad < q.sig.edad){
                        temp=new nodo(
                                q.id,
                                q.nom,
                                q.sexo,
                                q.edad,
                                q.grado,
                                q.acudiente,
                                q.numAcu
                        );
                        //Empieza el intercambio


                        q.id = q.sig.id;
                        q.nom = q.sig.nom;
                        q.sexo = q.sig.sexo;
                        q.edad = q.sig.edad;
                        q.grado =  q.sig.grado;
                        q.acudiente = q.sig.acudiente;
                        q.numAcu = q.sig.numAcu;


                        q.sig.id = temp.id;
                        q.sig.nom = temp.nom;
                        q.sig.sexo = temp.sexo;
                        q.sig.edad = temp.edad;
                        q.sig.grado= temp.grado;
                        q.sig.acudiente = temp.acudiente;
                        q.sig.numAcu= temp.numAcu;
                    }
                    q=q.sig;
                }
                p=p.sig;

            }
        }
    }



    public void setMayorQuinto( ){
        nodo temp=null;
        if(getEsVacia())
            JOptionPane.showMessageDialog(null,
                    "Lista vacía!!!");
        else{
            nodo p,q;
            p=cab;
            while(p!=null){
                q=cab;
                while(q.sig!=null){
                    if(q.grado == 5 && q.edad < q.sig.edad){
                        temp=new nodo(
                                q.id,
                                q.nom,
                                q.sexo,
                                q.edad,
                                q.grado,
                                q.acudiente,
                                q.numAcu
                        );
                        //Empieza el intercambio


                        q.id = q.sig.id;
                        q.nom = q.sig.nom;
                        q.sexo = q.sig.sexo;
                        q.edad = q.sig.edad;
                        q.grado =  q.sig.grado;
                        q.acudiente = q.sig.acudiente;
                        q.numAcu = q.sig.numAcu;


                        q.sig.id = temp.id;
                        q.sig.nom = temp.nom;
                        q.sig.sexo = temp.sexo;
                        q.sig.edad = temp.edad;
                        q.sig.grado= temp.grado;
                        q.sig.acudiente = temp.acudiente;
                        q.sig.numAcu= temp.numAcu;
                    }
                    q=q.sig;
                }
                p=p.sig;

            }
        }
    }
    public void simple() {

        nodo p=null;
        if(getEsVacia())
            JOptionPane.showMessageDialog(null,
                    "La lista no tiene elementos!");
        else{
            p=cab;
            while(p!=null){
                if (p.grado == 1)
                    p.getseeSimple();
                p=p.sig;
            }
            JOptionPane.showMessageDialog(null,
                    "Se mostraron los estudiantes de 5to de mayor a menor edad, "
                            + "la lista tiene: "+getLonglista()+" elementos.");
        }
    }
    public void getSeeInfo3(){
        nodo p=null;
        if(getEsVacia())
            JOptionPane.showMessageDialog(null,
                    "La lista no tiene elementos!");
        else{
            p=cab;
            while(p!=null){
                if (p.grado == 5)
                p.getseeSimple();
                p=p.sig;
            }
            JOptionPane.showMessageDialog(null,
                    "Se mostraron los estudiantes de 5to de mayor a menor edad, "
                            + "la lista tiene: "+getLonglista()+" elementos.");
        }
    }

    public void getseeHombresPrimero () {

        nodo p = null;
        if (getEsVacia())
            JOptionPane.showMessageDialog(null,
                    "La lista no tiene elementos!");
        else {
            p = cab;
            while (p != null) {
                String info = "La información del Acudiente  es: \n";
                if (p.sexo.equals("M") && p.grado == 1)
                    info += "Id: " + p.id + "\n";
                    info += "Nombre: " + p.nom + "\n";
                    info += "Edad: " + p.edad + "\n";
                    info += "sexo: " + p.sexo + "\n";

                JOptionPane.showMessageDialog(null, info);
                p = p.sig;
            }
            JOptionPane.showMessageDialog(null,
                    "Se mostraron todos los elementos de la lista, "
                            + "la lista tiene: " + getLonglista() + " elementos.");
        }


    }
    public void getseeMujeresPrimero () {

        nodo p = null;
        if (getEsVacia())
            JOptionPane.showMessageDialog(null,
                    "La lista no tiene elementos!");
        else {
            p = cab;
            while (p != null) {
                String info = "La información del Acudiente  es: \n";
                if (p.sexo.equals("F") && p.grado == 1)
                    info += "Id: " + p.id + "\n";
                info += "Nombre: " + p.nom + "\n";
                info += "Edad: " + p.edad + "\n";
                info += "sexo: " + p.sexo + "\n";

                JOptionPane.showMessageDialog(null, info);
                p = p.sig;
            }
            JOptionPane.showMessageDialog(null,
                    "Se mostraron todos los elementos de la lista, "
                            + "la lista tiene: " + getLonglista() + " elementos.");
        }


    }

        public void getseeMujeresQuinto () {

            nodo p = null;
            if (getEsVacia())
                JOptionPane.showMessageDialog(null,
                        "La lista no tiene elementos!");
            else {
                p = cab;
                while (p != null) {
                    String info = "La información del Acudiente  es: \n";
                    if (p.sexo.equals("F") && p.grado == 5)
                        info += "Id: " + p.id + "\n";
                    info += "Nombre: " + p.nom + "\n";
                    info += "Edad: " + p.edad + "\n";
                    info += "sexo: " + p.sexo + "\n";
                    info += "Cantidad: " + cont1 + "\n";
                    info += "Promedio edad: " + getPromedio() + "\n";

                    JOptionPane.showMessageDialog(null, info);
                    p = p.sig;
                }
                JOptionPane.showMessageDialog(null,
                        "Se mostraron todos los elementos de la lista, "
                                + "la lista tiene: " + getLonglista() + " elementos.");
            }


        }
    }


