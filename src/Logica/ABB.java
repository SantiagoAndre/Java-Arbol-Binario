/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * @author root
 */
public class ABB{
   Nodo raiz;

   public void insertar(Comparable dato){
       if(raiz == null){
           raiz = new Nodo(dato);
           return;
       }
       raiz.insertar(raiz, dato);
   }
   public void eliminar(Comparable dato){
       if(raiz == null)
           return;
       raiz = raiz.eliminar(false,dato);
   }
   public int profundidad(){
       if(raiz == null)
           return 0;
       return raiz.profundidad();
   }
   public ArrayList<Comparable> inorden(){
       
       if(raiz == null)
           return null;
       ArrayList<Comparable> datos = new ArrayList<>();
       raiz.inorden(datos,raiz);
       return datos;
   }
   public ArrayList<Comparable> preorden(){  
       if(raiz == null)
           return null;
       ArrayList<Comparable> datos = new ArrayList<>();
       raiz.preorden(datos,raiz);
       return datos;
      }
   public ArrayList<Comparable> posorden(){
       
       if(raiz == null)
           return null;
       ArrayList<Comparable> datos = new ArrayList<>();
       raiz.posorden(datos,raiz);
       return datos;
   }
   public ArrayList<ArrayList<Comparable>> recorridoNiveles(){
       if(raiz == null)
           return null;
       ArrayList<ArrayList<Comparable>> datos = new ArrayList<ArrayList<Comparable>>();
       raiz.RecorridoNiveles(0, raiz, datos);
       return datos;       
   }
}
