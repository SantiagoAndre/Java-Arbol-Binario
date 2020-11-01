
package ArbolNario;


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
   @Override
   public String toString(){
       if(raiz == null){
           return "Arbol vacio";
       }
       return raiz.toString();
   }
}
