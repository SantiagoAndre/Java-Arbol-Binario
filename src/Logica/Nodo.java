/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import static java.lang.Math.max;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class Nodo {
    private Comparable dato;
    private Nodo izq;
    private Nodo der;
    public Nodo(Comparable dato){
        this.dato= dato;
    }
    private Comparable info() {
      return dato;
    }
    public Nodo getIzq(){
        return izq;
    }
    public Nodo getDer(){
        return der;
    }
    private void setDato(Comparable dato){
        this.dato= dato;
    }
    private void setIzq(Nodo subArbol){
        izq = subArbol;
    }
    private void setDer(Nodo subArbol){
        der = subArbol;
    }
    private int numeroHijos(){
        int numeroHijos = 0;
        if(existeIzq())
            numeroHijos++;
        if(existeDer())
            numeroHijos++;
        return numeroHijos;
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
    public boolean existeIzq(){
        return izq!= null;
    }
    public boolean existeDer(){
        return der!= null;
    }
    public Nodo insertar(Nodo nodo, Comparable dato){
        if(nodo == null)//mandaron un hijo nulo
            return new Nodo(dato);//se retorna un nuevo nodo
       int comparacion= dato.compareTo(nodo.info());
       if(comparacion< 0){
           Nodo nuevoHijo = insertar(nodo.getIzq(),dato);
           nodo.setIzq(nuevoHijo);
       }else if(comparacion > 0){
           Nodo nuevoHijo = insertar(nodo.getDer(),dato);
           nodo.setDer(nuevoHijo);
       }
       return nodo;           
    }
    public Nodo  eliminar(Comparable dato){
        if(this.dato==dato){
            if(esHoja()){
                this.dato = null;
                return null;
            }
            if(numeroHijos() ==1){
                if(existeIzq())
                    return getIzq();
                else if(existeDer())
                    return getDer();                
            }else{
                this.setDato(izq.info());
                Nodo nuevaIzq = izq.eliminar(this.info());
                setIzq(nuevaIzq);
                return this; // hacia arriba del arbol queda igual entonces se devuevle el mismo hijo.
            }
        }
        if(existeIzq() && dato.compareTo(this.dato)<0){
            Nodo nuevaIzq = getIzq().eliminar(dato);
            setIzq(nuevaIzq);
        }else if(existeDer()){
            Nodo nuevaDer = getDer().eliminar(dato);
            setDer(nuevaDer);
        }
        return this;
    }
    public Nodo eliminar(boolean parte/*true = derecha, false = izq  */, Comparable dato){
        if(this.dato==dato){
            if(esHoja())
                return null;
            if(numeroHijos() == 2){
                Nodo nuevo;
                if(parte){//viene de la derecha                    
                    nuevo = getIzq().nodoMasDer();
                    setDato(nuevo.info());
                    getIzq().eliminar(false,nuevo.info());
                }                
                nuevo = getDer().nodoMasIzq();
                setDato(nuevo.info());
                Nodo nuevoHijo = getDer().eliminar(true,nuevo.info());
                setDer(nuevoHijo);
                return this;
            }
            if(existeIzq())
                return getIzq();
            return getDer();
        }       
        Nodo nuevoHijo;
        if(existeIzq() && dato.compareTo(this.dato)<0){
            nuevoHijo = getIzq().eliminar(false,dato);
            setIzq(nuevoHijo);
        }else if(existeDer()){
            nuevoHijo = getDer().eliminar(true,dato);
            setDer(nuevoHijo);
        }
        return this;
    }

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

}
