
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
       ArrayList<Comparable> datos = new ArrayList<>();
       if(raiz != null){
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
}
