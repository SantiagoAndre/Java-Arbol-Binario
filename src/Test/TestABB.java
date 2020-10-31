/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
import Logica.*;
import java.util.ArrayList;
/**
 *
 * @author root
 */
public class TestABB {
    private ABB arbol = new ABB();
    public void iniciar(){
        llenarArbol();
        imprimirRecorridos();
        eliminarElementos();
    }
    private void llenarArbol(){
                
        arbol.insertar(10);
        arbol.insertar(11);
        arbol.insertar(13);
        arbol.insertar(0);
        arbol.insertar(15);
        arbol.insertar(-3);
        arbol.insertar(-4);
        arbol.insertar(-1);
        arbol.insertar(-2);        
        arbol.insertar(2);
        arbol.insertar(5);
        arbol.insertar(17);
        arbol.insertar(12);
        arbol.insertar(16);
    }
    
    private void eliminarElementos() {
        System.out.println("\nEiminar -3:");
        arbol.eliminar(-3);
        imprimirRecorridos();
        System.out.println("\nEiminar 10:");
        arbol.eliminar(10);
        imprimirRecorridos();
        System.out.println(" \nEiminar 0:");
        arbol.eliminar(0);
        imprimirRecorridos();
        System.out.println("\nEiminar 17:");
        arbol.eliminar(17);
        imprimirRecorridos();
        System.out.println("\nEiminar 16:");
        arbol.eliminar(16);
        imprimirRecorridos();
    }
    private void imprimirRecorridos(){
        ArrayList<ArrayList<Comparable>> datos;
        datos = arbol.recorridoNiveles();
        System.out.print("\n\nRecorrido niveles\n");
        imprimirListaDoble(datos);
        
        ArrayList<Comparable> recorrido;
        recorrido = arbol.inorden();
        System.out.print("\nRecorrido inorden\n");
        imprimirLista(recorrido);
        
        recorrido= arbol.preorden();
        System.out.print("\nRecorrido preorden\n");
        imprimirLista(recorrido);
             
        recorrido = arbol.posorden();
        System.out.print("\nRecorrido posorden\n");
        imprimirLista(recorrido);
        
        
    }
    private void imprimirLista(ArrayList<Comparable> lista){
        int size = lista.size();
        for(int i =0; i<size;i++){
            System.out.print(lista.get(i )+ " ");
        }    
    }
    private void imprimirListaDoble(ArrayList<ArrayList<Comparable>> listadoble){
        int size = listadoble.size();
        for(int i =0; i<size;i++){
            imprimirLista(listadoble.get(i));
            System.out.print("\n");
        }
    }

}
