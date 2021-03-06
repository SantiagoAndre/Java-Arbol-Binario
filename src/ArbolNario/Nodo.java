package ArbolNario;


import static java.lang.Math.max;
import java.util.ArrayList;
import Lista.OrderSetWithoutDuplicates;
import java.util.Comparator;

/**
 *
 * @author root
 */
public class Nodo {
    private Comparable dato;
    private OrderSetWithoutDuplicates<Nodo> hijos;
    private static   Comparator<Nodo> comparador = new Comparator<Nodo>()
        {
            @Override
            public int compare(final Nodo o1, final Nodo o2)
            {
              
                int comparacion =  o1.info().compareTo(o2.info());
                //System.out.println(" = " + String.valueOf(comparacion));
                return comparacion;
            }
        };
    public Nodo(Comparable dato){
        this.dato= dato;
         
        hijos = new OrderSetWithoutDuplicates<>(comparador);
    }
    private Comparable info() {
      return dato;
    }
   
    private void setDato(Comparable dato){
        this.dato= dato;
    }
  
    private int numeroHijos(){
        
        return hijos.size();
    }
    public boolean esVacio(){
        return dato == null;
    }
    public boolean esHoja(){
        return numeroHijos() == 0;
    }
    public boolean esInterior(){
        return numeroHijos()>0;
    }
    public Nodo buscarNodo(Comparable dato){
        // Obtiene el nodo que alberga un dato
        if(dato.equals(this.info())){//1.  EL dato buscado el el de el nodo actual
        //1.1 retorna el nodo actual
           return this;
        }
        //2. Se recorren los hijos y se ejecuta recursivamente la funcion buscarNodo
        for(Nodo hijo: hijos){
            Nodo nodoBuscado = hijo.buscarNodo(dato);//2.1 Se ejecuta a cada hijo la funcion buscarNodo
            if(nodoBuscado != null) //2.2 Si la respuesta no es null es poque encontro el nodo bucado
            // lo retorna
                return nodoBuscado;
            
            //3.2 Continua con el sigiente hijo
        }
        //4. No existe el padre no se agrega el elemento
        return null;
       
    }
    public void agregarHijo(Comparable e){
        this.hijos.add(new Nodo(e));
    }
    @Override
    public String toString(){
        return toString(0);
    }
    private String toString(int profundidad){
         /*
         El metodo to String recibe un parametro que es la profundidad.
         Este repite tabs {profundidad} veces antes del nombre
         Por ejemplo el nodo de la raix  tiene profundidad 0 entonces no coloca espacios antes, quedando asi"
         "E"
         Un elemento del nivel uno tiene profundidad 1 entonces habria un espacio a su ixquierda quedando asi:
         "  E"
         Es la forma mas facil de imprimir un arbol n-ario, un ejemplo de recorrer este metodo es el siguiente:         
                A
                E
                        B
                        F
                            M
                            N
                        H
                    L
                    T
                        W
                            Y
                            Q
         B y F son hijos de E
         M y N son hijos de F
         */
    
        String space = "\t";//tab
        String cadena ="";
        for(int i = 0 ;i <profundidad;i++){
            cadena += "\t";
        }
        cadena += info().toString() + "\n";   
        for(Nodo hijo: hijos){
            cadena = cadena + hijo.toString(profundidad+1);
        }
        return cadena;
    }
    public  void obtenerElementosDeUnNivel(int nivel, int nivelActual, ArrayList<Comparable> datos){
        if(nivelActual == nivel){// Estamos en el nvl buscado, se agrega el elemento
            datos.add(this.info());
            return;// no hay necesidad de revisar los siguientes niveles
        }
        //se pasa al siguiente nivel(los hjos ) y se ejecura el metodo recursivamente
        for(Nodo hijo: hijos){
            hijo.obtenerElementosDeUnNivel(nivel,nivelActual+1,datos);
        }

    }
    public void recorridoNiveles(int nivel , ArrayList<ArrayList<Comparable>> datos){
        
         ArrayList<Comparable> datosNivel;
        try{
            datosNivel = datos.get(nivel);
        }catch(java.lang.IndexOutOfBoundsException e){
            datosNivel = new ArrayList<>();
        }
            datosNivel.add(info());
        try{
            datos.set(nivel, datosNivel);
        }catch(java.lang.IndexOutOfBoundsException e){
            datos.add(datosNivel);
        }
        //se pasa al siguiente nivel(los hjos ) y se ejecura el metodo recursivamente
        for(Nodo hijo: hijos){
            hijo.recorridoNiveles(nivel+1,datos);
        }
    }
    public boolean podarArbol(int nivel, int nivelActual){
        
          if((nivelActual+1) == nivel){// Estamos en el nvl anterior al buscado, se eliminan los hijos vaciando la lista y listo
            hijos.clear();//eliminar hijos
            
            return true;// no hay necesidad de revisar los siguientes niveles
        }
        //se pasa al siguiente nivel(los hjos ) y se ejecura el metodo recursivamente
        boolean sePodo = false;
        for(Nodo hijo: hijos){
            //se aplica el operador or, se Podo sera true si se elimino un nivel en alguno de sus hijos
          
            sePodo = hijo.podarArbol(nivel,nivelActual+1) || sePodo;

        }
        return sePodo;
    }

    public void ramas( int nrama, ArrayList<ArrayList<Comparable>> ramas){
          //1 tengo el numero de la rama en donde se agrego mi padre
        ArrayList<Comparable> rama;
        if(ramas.isEmpty()){
            rama = new ArrayList<>();
            nrama = 0;
            ramas.add(rama);
        }else{
            rama = ramas.get(nrama);
        }
        //en esa rama agrego el elemento de este nodo
        rama.add(info());

        //creo las nuevas ramas
        int nnuevasramas = hijos.size()-1;
        for(int i = 0 ;i<nnuevasramas;i++){
            ramas.add(new ArrayList<Comparable>(rama));
        }

        //recorro los hijos
        boolean  primero = true;
        int pos = ramas.size()-nnuevasramas;
        for(Nodo hijo: hijos){
        //les paso el numero de la rama
            //al primer hijo sera la misma del padre,
            //a los siguientes se les enviara una nueva rama, se copia la rrama del padre y se coloca de ultimo
            if(primero){//primer hijo
                hijo.ramas(nrama,ramas);
                primero = false;
            }else{
                //ramas.add(new ArrayList<Comparable>(rama));
                hijo.ramas(pos,ramas);
                pos++;
            }
            
        }
        
    }
}
