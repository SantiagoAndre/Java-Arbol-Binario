/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
import Logica.Archivo;
/**
 *
 * @author root
 */
public class TestArchivo {
    private Archivo a = new Archivo();
    public void iniciar(){
        a.crearArchivo("nuevo.txt");

        String cadena = "asdasd\nasdsa asd a2123123 asdperro'lamealcanino";
        a.escribir(cadena);
        System.out.print("hasta: v:  "+cadena);
        a.cerrar();
    }
}
