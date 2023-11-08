/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaServicio;

import Usuario.Usuario;
import manejoArchivos.*;
import java.util.ArrayList;

/**
 *
 * @author Paula
 */
public class SistemaServicio {
    
    private String opcion;
    
    
    ManejoArchivo manArch = new ManejoArchivo();
    ArrayList<String> usuarios = manArch.LeeFichero("usuarios.txt");
    
    public SistemaServicio(String opcion){
        this.opcion = opcion;
        
    }
     
     
     
     



    

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
    

}
