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
        String space = "\t";//tab
        String cadena = new String(new char[profundidad]).replace("\0", space)+ info().toString() + "\n";

        for(Nodo hijo: hijos){
            cadena = cadena + hijo.toString(profundidad+1);
        }
        return cadena;
    }

    /*
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
                X
    public int profundidad() {
        if(esHoja())
            return 1;
        int profIzq = 0, profDer = 0;
        if(existeIzq())
            profIzq = getIzq().profundidad();
        if(existeDer())
            profDer = getDer().profundidad();
        return max(profIzq,profDer);
        
    }    
        
    public Nodo nodoMasIzq(){
        if(!existeIzq())
            return this;
        return getIzq().nodoMasIzq();
    }    
        public Nodo nodoMasDer(){
        if(!existeDer())
            return this;
        return getDer().nodoMasDer();
    }    
    public void inorden(ArrayList<Comparable> datos,Nodo nodo){
        if(nodo == null)
            return;
        datos.add(nodo.info());
        inorden(datos,nodo.getIzq());
        inorden(datos,nodo.getDer());
    }
    public void preorden(ArrayList<Comparable> datos,Nodo nodo){
        if(nodo == null)
            return;
        preorden(datos,nodo.getIzq());
        datos.add(nodo.info());
        preorden(datos,nodo.getDer());
    } 
    public void posorden(ArrayList<Comparable> datos,Nodo nodo){
        if(nodo == null)
            return;
        posorden(datos,nodo.getIzq());
        posorden(datos,nodo.getDer());
        datos.add(nodo.info());
    }
    public void RecorridoNiveles(int nivel ,Nodo arbol, ArrayList<ArrayList<Comparable>> datos){
        if(arbol == null)
            return;
         ArrayList<Comparable> datosNivel;
        try{
            datosNivel = datos.get(nivel);
        }catch(java.lang.IndexOutOfBoundsException e){
            datosNivel = new ArrayList<>();
        }
            datosNivel.add(arbol.info());
        try{
            datos.set(nivel, datosNivel);
        }catch(java.lang.IndexOutOfBoundsException e){
            datos.add(datosNivel);
        }
        RecorridoNiveles(nivel+1,arbol.getIzq(),datos);
        RecorridoNiveles(nivel+1,arbol.getDer(),datos);
    }
*/
}
