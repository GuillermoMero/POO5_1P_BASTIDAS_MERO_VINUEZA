/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaServicio;

import Usuario.TipoUsuario;
import Usuario.Usuario;
import manejoArchivos.*;
import java.util.ArrayList;

/**
 *
 * @author Paula
 */
public class SistemaServicio {  
    private static ArrayList<Usuario> usuarios = new ArrayList<>(); 
    public static void main(String[] args){
        ArrayList<String> linea = ManejoArchivo.LeeFichero("usuarios.txt");
        System.out.println(linea);
        for (int i = 0; i<linea.size();i++){
            if (i > 0){
                String[] partes = (linea.get(i)).split(",");
                Usuario usuario = new Usuario(partes[0],partes[1],partes[2],partes[3],partes[4],partes[5],0,TipoUsuario.valueOf(partes[6]));
                usuarios.add(usuario);
                }
            }
        System.out.println(usuarios.get(0).getApellidos());
    }
}
     
     
     
     




    


