/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaServicio;

import Usuario.TipoUsuario;
import Usuario.Usuario;
import manejoArchivos.*;
import java.util.ArrayList;
import java.util.Scanner;
import Servicio.*;

/**
 *
 * @author Paula
 */
public class SistemaServicio{
    private Scanner sc;
    private static ArrayList<Usuario> usuarios;
    
    public SistemaServicio(){
        sc = new Scanner(System.in);
        usuarios = new ArrayList<>();
    }
    
    public static ArrayList<Usuario> listaUsuarios(){
        ArrayList <Usuario> arreglo = new ArrayList<>();
        ArrayList<String> linea = ManejoArchivo.LeeFichero("usuarios.txt");
        for (int i = 0; i<linea.size();i++){
            if (i > 0){
                String[] partes = (linea.get(i)).split(",");
                Usuario usuario = new Usuario(partes[0],partes[1],partes[2],partes[3],partes[4],partes[5],0,TipoUsuario.valueOf(partes[6]));
                arreglo.add(usuario);
                }
            }
        return arreglo;
    }
    
    
    public TipoUsuario validarUsuario(ArrayList<Usuario> arreglo, String user, String contrasena){
        for(int i=0; i<arreglo.size(); i++){
            if(user.equals(arreglo.get(i).getUsuario()) && contrasena.equals(arreglo.get(i).getContrasena())){
                TipoUsuario tipo = arreglo.get(i).getTipoUsuario();
                return tipo;
            }
        }
        return null;
    }
    
    public void presentarMenuCliente(){
        System.out.println("/*******************MENU**********************/");
        System.out.println("/*                                           */");
        System.out.println("/*********************************************/");
        System.out.println("1. Solicitar servicio de taxi");
        System.out.println("2. Solicitar entrega encomienda");
        System.out.println("3. Consultar servicios");
        System.out.print("\n");
    }
    
    public void presentarMenuConductor(){
        System.out.println("/**************MENU CONDUCTOR*****************/");
        System.out.println("/*                                           */");
        System.out.println("/*********************************************/");
        System.out.println("1. Consultar Servicio Asignado");
        System.out.println("2. Datos de su vehiculo");
        System.out.print("\n");
    }
     
    public void iniciar(){
        String user;
        String contrasena;
        String opcion;
        
        usuarios = listaUsuarios();
        
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("            BIENVENIDO AL SISTEMA              ");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.print("USUARIO: ");
        user = sc.next();
        System.out.print("CONTRASENA: ");
        contrasena = sc.next();
        
        if(TipoUsuario.C == validarUsuario(usuarios, user, contrasena)){
            presentarMenuCliente();
            System.out.print("Elija una opcion: ");
            opcion = sc.next();
            if(opcion.equals("1")){
                Taxi taxi = new Taxi();
                taxi.solicitarTaxi();
                System.out.println("hola");
                
            }
        }else if(TipoUsuario.R == validarUsuario(usuarios, user, contrasena)){
            presentarMenuConductor();
            System.out.print("Elija una opcion: ");
            opcion = sc.next();
        }
        
      
    }
}
     
     
     