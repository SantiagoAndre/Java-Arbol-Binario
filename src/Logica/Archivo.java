package Logica;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Archivo {
    private File archivo;
    private BufferedWriter texto;
    private BufferedReader lectura;

    public Archivo()
    {	
    }

    public boolean abrirArchivo(String nombreArchivo)
    {
        try {
            File fichero=new File(nombreArchivo);
            if(fichero.exists())
            {
                archivo=fichero;
                lectura =new BufferedReader(new FileReader(archivo));
                return true;
            }
            else{
                System.out.println(nombreArchivo+": El archivo esta vacio o no existe. Verifique su contenido.");
                return false;}
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    public void crearArchivo(String nombreArchivo){
        FileWriter fichero;
        try {
            fichero = new FileWriter(nombreArchivo);
            texto = new BufferedWriter(fichero);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public String LeerLinea(){	
        try {
            if(archivo.exists())
                 return lectura.readLine();
            else
                System.out.println("El archivo esta vacio o no existe. Verifique su contenido.");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public String leerHasta(char cfinal){
        String cadena = new String();
        cadena = leerHasta(cadena,cfinal);
        return cadena;
    }

    private String leerHasta(String cadena, char cfinal)  {
        try {
            int actual = lectura.read();
            char cactual = (char)actual;
            if(actual == -1 || cactual ==cfinal )
                return cadena;
            cadena = cadena + cactual;
            return leerHasta(cadena,cfinal);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cadena;        
    }

    public void escribir(String texto){
        try {
            texto= texto.substring(0,texto.length()-1);
            this.texto.write(texto);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void cerrar(){
        try {
            if(texto!=null)
                texto.close();
            if(lectura!=null)
                lectura.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}