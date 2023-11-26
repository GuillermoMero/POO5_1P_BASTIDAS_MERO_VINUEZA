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
    private static ArrayList<Usuario> usuarios;
    private static ArrayList<Servicio> servicios;
    public SistemaServicio(){
        usuarios = crearListaUsuarios();
        servicios = new ArrayList<>();
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    public static ArrayList<Servicio> getServicios() {
        return servicios;
    }
    
    
    public static ArrayList<Usuario> crearListaUsuarios(){
        ArrayList<Usuario> arreglo = new ArrayList<>();
        ArrayList<String[]> listasUsuarios = new ArrayList<>();
        ArrayList<String[]> listasConductores = new ArrayList<>();
        ArrayList<String[]> listasVehiculos = new ArrayList<>();
        listasUsuarios= enpaquetar(ManejoArchivo.LeeFichero("usuarios.txt"));
        for(int i=0; i<listasUsuarios.size(); i++){
            if("C".equals(listasUsuarios.get(i)[6])){
                Cliente usuario = new Cliente(listasUsuarios.get(i)[0],listasUsuarios.get(i)[1],listasUsuarios.get(i)[2],listasUsuarios.get(i)[3],listasUsuarios.get(i)[4],listasUsuarios.get(i)[5],TipoUsuario.valueOf(listasUsuarios.get(i)[6]),0, "");
                arreglo.add(usuario);
            }else{
                Conductor usuario = new Conductor(listasUsuarios.get(i)[0],listasUsuarios.get(i)[1],listasUsuarios.get(i)[2],listasUsuarios.get(i)[3],listasUsuarios.get(i)[4],listasUsuarios.get(i)[5],TipoUsuario.valueOf(listasUsuarios.get(i)[6]),null,null);
                listasConductores = enpaquetar(ManejoArchivo.LeeFichero("conductores.txt"));
                listasVehiculos = enpaquetar(ManejoArchivo.LeeFichero("vehiculos.txt"));
                for (int j = 0; j<listasConductores.size(); j++){
                    if (listasConductores.get(j)[0].equals(usuario.getNumeroCedula())){
                        usuario.setEstadoConductor(EstadoConductor.valueOf(listasConductores.get(j)[1]));
                        for (int k = 0; k<listasVehiculos.size(); k++){
                            if (listasVehiculos.get(k)[0].equals(listasConductores.get(j)[2])){
                                Vehiculo vehiculo = new Vehiculo(listasVehiculos.get(k)[1],listasVehiculos.get(k)[2],listasVehiculos.get(k)[3],TipoVehiculo.valueOf(listasVehiculos.get(k)[4]));
                                usuario.setVehiculo(vehiculo);
                            }           
                        }
                    }
                }
                arreglo.add(usuario);
                
            }
        } 
    return arreglo;
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
    
    
    public static Usuario validarUsuario(ArrayList<Usuario> users, String user,String contra){
        for(int i=0; i<users.size(); i++){
            if(users.get(i).getUsuario().equals(user) && users.get(i).getContrasena().equals(contra)){
                return users.get(i);
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
        Scanner sc = new Scanner(System.in);
        String user;
        String contrasena;
        String opcion;
        Usuario usuario;
        int edad;
        String tarjetaCredito;
        usuarios = crearListaUsuarios();
        
        
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("            BIENVENIDO AL SISTEMA              ");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        Usuario usuarioSistema;
        do{
            System.out.print("USUARIO: ");
            user = sc.next().toLowerCase();
            System.out.print("CONTRASENA: ");
            contrasena = sc.next().toLowerCase();
            usuarioSistema = SistemaServicio.validarUsuario(usuarios, user, contrasena);
        }while(usuarioSistema == null);
        if(TipoUsuario.C == usuarioSistema.getTipoUsuario()){
            Cliente clienteSistema = (Cliente) usuarioSistema;
            clienteSistema.llenarDatos();
            presentarMenuCliente();
            System.out.print("Elija una opcion: ");
            opcion = sc.next();
            if(opcion.equals("1")){
                Taxi taxi = new Taxi();
                taxi.solicitarTaxi(clienteSistema);
            }
        }else if(TipoUsuario.R == usuarioSistema.getTipoUsuario()){
            presentarMenuConductor();
            System.out.print("Elija una opcion: ");
            opcion = sc.next();
        }
            
    }
             
}

     
     
     