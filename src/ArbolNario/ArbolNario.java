
package ArbolNario;
import java.util.ArrayList;

public class ArbolNario{
   Nodo raiz;

   public void insertar(Comparable dato){
       if(raiz == null){
           raiz = new Nodo(dato);
           return;
       }
   }
    public void insertar(Comparable padre, Comparable hijo){
       if(raiz != null){
           Nodo nodoPadre =raiz.buscarNodo(padre);
           if(nodoPadre != null)
            nodoPadre.agregarHijo(hijo);
           return;
       }
   }
   public ArrayList<Comparable> obtenerElementosDeUnNivel(int nivel){
       ArrayList<Comparable> datos = null;
       if(raiz != null){
           datos = new ArrayList<>();
           raiz.obtenerElementosDeUnNivel(nivel,0,datos);
       }
       return datos;
   }
   @Override
   public String toString(){
       if(raiz == null){
           return "Arbol vacio";
       }
       return raiz.toString();
   }
   public ArrayList<ArrayList<Comparable>> recorridoNiveles(){
       if(raiz == null)
           return null;
       ArrayList<ArrayList<Comparable>> datos = new ArrayList<ArrayList<Comparable>>();
       raiz.recorridoNiveles(0, datos);
       return datos;       
   }
   public boolean podarArbol(int nivel){
       if(raiz!=null)
            return raiz.podarArbol(nivel,0);
        return false;
   }
   public ArrayList<ArrayList<Comparable>> ramas(){
       if(raiz == null)
           return null;
       ArrayList<ArrayList<Comparable>> ramas = new ArrayList<ArrayList<Comparable>>();
       raiz.ramas(0, ramas);
       return ramas;       
   }

}
