/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaServicio;

import Usuario.TipoUsuario;
import Usuario.*;
import manejoArchivos.*;
import java.util.ArrayList;
import java.util.Scanner;
import Servicio.*;
import java.util.Arrays;

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
    
    public static ArrayList crearListaUsuarios(){
        ArrayList<Usuario> arreglo = new ArrayList<>();
        ArrayList<String[]> listasUsuarios = new ArrayList<>();
        ArrayList<String[]> listasConductores = new ArrayList<>();
        ArrayList<String[]> listasVehiculos = new ArrayList<>();
        listasUsuarios= enpaquetar(ManejoArchivo.LeeFichero("usuarios.txt"));
        for(int i=0; i<listasUsuarios.size(); i++){
            if("C".equals(listasUsuarios.get(i)[6])){
                Usuario usuario = new Cliente(listasUsuarios.get(i)[0],listasUsuarios.get(i)[1],listasUsuarios.get(i)[2],listasUsuarios.get(i)[3],listasUsuarios.get(i)[4],listasUsuarios.get(i)[5],0,TipoUsuario.valueOf(listasUsuarios.get(i)[6]), "");
                arreglo.add(usuario);
            }else{
                listasConductores = 
                
            }
        }
        
        
        ArrayList<String> linea = ManejoArchivo.LeeFichero("usuarios.txt");
        for (int i = 0; i<linea.size();i++){
            if (i > 0){
                String[] partes = (linea.get(i)).split(",");
                if("C".equals(partes[6])){
                    Usuario usuario = new Cliente(partes[0],partes[1],partes[2],partes[3],partes[4],partes[5],0,TipoUsuario.valueOf(partes[6]), "");
                    arreglo.add(usuario);
                }else{
                    listasConductores = enpaquetar(ManejoArchivo.LeeFichero("conductores.txt"));
                    listasVehiculos = enpaquetar(ManejoArchivo.LeeFichero("vehiculos.txt"));
                    for(int j=0; j<listasConductores.size(); j++){
                        for(int k=0; k<listasVehiculos.size(); k++){
                            if(listasConductores.get(j)[-1].equals(listasVehiculos.get(k)[0])){
                                Usuario usuario = new Conductor(partes[0],partes[1],partes[2],partes[3],partes[4],partes[5],0,TipoUsuario.valueOf(partes[6]), )
                            }
                        }
                    }
                    
                    
                    
                    Usuario usuario = new Conductor(partes[0],partes[1],partes[2],partes[3],partes[4],partes[5],0,TipoUsuario.valueOf(partes[6]),"",);
                    arreglo.add(usuario);
                }
            }
        return arreglo;
    }
        
   return null;
    }
    
    public static ArrayList<String []> enpaquetar(ArrayList<String> arreglo){
        ArrayList<String []> lista = new ArrayList<>();
        for(int i=0; i<arreglo.size(); i++){
            if(i>0){
                String [] partes = arreglo.get(i).split(",");
                lista.add(partes);
            }
            
        }
        return lista;
     }
    
    
    public Usuario validarUsuario(ArrayList<Usuario> arreglo, String user, String contrasena){
        for(int i=0; i<arreglo.size(); i++){
            if(user.equals(arreglo.get(i).getUsuario()) && contrasena.equals(arreglo.get(i).getContrasena())){
                return arreglo.get(i);
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
        Usuario usuario;
        int edad;
        usuarios = crearListaUsuarios();
        
        
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("            BIENVENIDO AL SISTEMA              ");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.print("USUARIO: ");
        user = sc.next();
        System.out.print("CONTRASENA: ");
        contrasena = sc.next();
        
        usuario = validarUsuario(usuarios, user, contrasena);
        if(usuario.getEdad() == 0){
            System.out.println("Edad: ");
            edad = sc.nextInt();
            usuario.setEdad(edad);
            
            if(TipoUsuario.C == usuario.getTipoUsuario()){
                presentarMenuCliente();
                System.out.print("Elija una opcion: ");
                opcion = sc.next();
                if(opcion.equals("1")){
                    Taxi taxi = new Taxi();
                    //taxi.solicitarTaxi(usuario);
                }
            }else if(TipoUsuario.R == usuario.getTipoUsuario()){
                presentarMenuConductor();
                System.out.print("Elija una opcion: ");
                opcion = sc.next();
        }
            
        }
        
        
        
      
    }
}
     
     
     