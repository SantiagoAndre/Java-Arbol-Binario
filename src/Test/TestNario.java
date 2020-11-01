/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
//import java.util.Scanner; 

import Lista.*;
import java.util.ArrayList;
import java.util.Comparator;
import ArbolNario.ArbolNario;

import Logica.Archivo;
/**
 *
 * @author root
 */
public class TestNario {
    //private ABB arbol = new ABB();
    //Scanner input = new Scanner(System.in);
    private ArbolNario arbol;
    private int tipoArbol ;
    public void iniciar(){
        arbol = new ArbolNario();
        try{
            
            String nombreArchivo  = "../files/nario.txt";
            cargarDeArchivo(nombreArchivo,arbol);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        obtenerElementosDeUnNivel(arbol);
        recorridoNiveles(arbol);
        
        ramas(arbol);
        podar(arbol);
    }
    private void llenarArbol(ArbolNario arbol){
           
                
        arbol.insertar('A');
        arbol.insertar('A','E');
        arbol.insertar('A','L');
        arbol.insertar('A','T');
        arbol.insertar('E','B');
        arbol.insertar('E','F');
        arbol.insertar('E','H');
        
        arbol.insertar('F','N');arbol.insertar('F','M');
        arbol.insertar('T','W');
        arbol.insertar('W','Y');
        arbol.insertar('W','X');


    }
    private void cargarDeArchivo(String nombreArchivo,ArbolNario arbol)throws Exception{
        /*Punto 1, cargar el arbol de un archivo*/
        System.out.println("-----------------------------------------------------");
        System.out.println("Ejecucion del punto 1, cargar elementos de un archivo");
        Archivo a = new Archivo();
        a.abrirArchivo(nombreArchivo);
        String linea  = a.LeerLinea();
        //1. La primera linea es el tipo de arbol
                //1. Numeros
                //2. Caracteres
        tipoArbol= Integer.parseInt(linea);
        //2. la Segunda linea es la raix
        linea  = a.LeerLinea();
        arbol.insertar(linea);
        //3. En adelante son relaciones PADRE-HIJO
           //Importante se hace split con el caracter "-"
        linea  = a.LeerLinea();
        while(linea != null){
            String[] split = linea.split("-",2);//3.1 se hace un split de la cadena
                    // el vecotr quedara con dos elementos 0:Padre, 1:Hijo
            //3.2 se extrae el padre y se prepara 
            Comparable padre = prepararElemento(split[0]);//posicion 0
            //3.3 Se extrae el hijo y se prepara
            Comparable hijo = prepararElemento(split[1]);//posicion 1
            //3,4 Se agreg el hijo al arbol
            arbol.insertar(padre,hijo);
            linea  = a.LeerLinea();
        }
        System.out.println("Fin del metodo, resultado de la ejecucion:");
        System.out.println(arbol.toString());
        System.out.println("-----------------------------------------------------");
    }
    
    private void obtenerElementosDeUnNivel(ArbolNario arbol){
        System.out.println("-----------------------------------------------------");
        System.out.println("Ejecucion del punto 2, elementos de un nivel, por cuestiones de prueba se ejecuta el metodo en cada nivel empleando in for");
         //2. Punto dos, todos los elementos de un nivel
        int nivel = 0;
        ArrayList elementos= arbol.obtenerElementosDeUnNivel(nivel);
        while(!elementos.isEmpty()){//Mientras no sea vacio el nivel
            System.out.println("Todos los elementos del nivel " + String.valueOf(nivel)+ " son: "+ elementos.toString());
            nivel++;
            elementos= arbol.obtenerElementosDeUnNivel(nivel);
        }
        System.out.println("-----------------------------------------------------");
    }
    private void recorridoNiveles(ArbolNario arbol){
         
        //2. PUNTO DOS RECORRIDO NIVELES
        System.out.println("-----------------------------------------------------");
        System.out.println("Ejecucion del punto 3, recorrdo por niveles");
        ArrayList<ArrayList<Comparable>> datos;
        datos = arbol.recorridoNiveles();
    
        imprimirListaDoble(datos," ");
        System.out.println("\n-----------------------------------------------------");
    }
    private void podar(ArbolNario arbol){
         
        //2. PUNTO 4, Podar arbol
        System.out.println("-----------------------------------------------------");
        System.out.println("Ejecucion del punto 4, podar arbol");
        System.out.println("Este metodo modifica el arbol por lo tanto se mostrara antes y despues");
        System.out.println("       --------------------- Antes ------------      ");
        System.out.println(arbol.toString());
        int nivel = 3;
        if(nivel == 0 ){
            System.out.println("No se puede realizar la acción ya que se eliminaría el árbol");
        }else if(arbol.podarArbol(nivel)){// Se podo el arbol        
            
        }else{
            System.out.println("Este nivel no existe en el árbol.");
        }
        System.out.println("       ----------------- -- Despues ------------      ");
            System.out.println(arbol.toString());
            System.out.println("-----------------------------------------------------");
       
    }
    private void ramas(ArbolNario arbol){
         
        System.out.println("-----------------------------------------------------");
        System.out.println("Ejecucion del punto 5, ramas");
        ArrayList<ArrayList<Comparable>> datos;
        datos = arbol.ramas();
    
        imprimirListaDoble(datos, "   Bitch\n ");
        System.out.println("\n-----------------------------------------------------");
    }

//------------ UTLIIDADES ------------
    
    private Comparable prepararElemento(String str) throws Exception{
        Comparable elemento ;
        if(tipoArbol== 1){//Numeros
            try{
                elemento = Integer.parseInt(str);
            }catch(Exception e){
                //si no se puede hacer el parseo se lanxa una excepcion
               elemento = null;
            }
        }else{ // Caracter, debe tener logitud 1
            if(str.length() != 1)
                elemento = null;
            else
            // debe ser un caracter, un caracter debe tener logitud 1
                elemento = str;
        }
        if(elemento == null){//es null solo si no es valido
            throw new  Exception("El elemento " + str + " No es un elemento valido");
        }
        return elemento;
    }


    private void imprimirLista(ArrayList<Comparable> lista){
        int size = lista.size();
        for(int i =0; i<size;i++){
            System.out.print(lista.get(i )+ " ");
        }    
    }
     private void imprimirListaDoble(ArrayList<ArrayList<Comparable>> listadoble,String end){
        int size = listadoble.size();
        for(int i =0; i<size;i++){
            imprimirLista(listadoble.get(i));
            System.out.print(end);
        }
    }

}
