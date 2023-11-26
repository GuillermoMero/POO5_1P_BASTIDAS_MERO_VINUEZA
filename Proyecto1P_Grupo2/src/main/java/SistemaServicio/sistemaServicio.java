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
    
    /**
    * Crea una lista de usuarios a partir de la lectura de archivos de usuarios, conductores y vehículos.
    * @return ArrayList de usuarios con la información obtenida de los archivos.
    */
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
    /**
    * Convierte una lista de cadenas en un ArrayList de arreglos de cadenas.
    * @param arreglo La lista de cadenas a ser convertida.
    * @return ArrayList de arreglos de cadenas obtenidos de la lista de cadenas.
    */
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
    
    /**
    * Valida y autentica al usuario basándose en el nombre de usuario y la contraseña proporcionados.
    * @param users La lista de usuarios a ser validada.
    * @param user El nombre de usuario a ser validado.
    * @param contra La contraseña asociada al usuario.
    * @return El objeto Usuario si la validación es exitosa, de lo contrario, null.
    */
    public static Usuario validarUsuario(ArrayList<Usuario> users, String user,String contra){
        for(int i=0; i<users.size(); i++){
            if(users.get(i).getUsuario().equals(user) && users.get(i).getContrasena().equals(contra)){
                return users.get(i);
            }
        }
        return null;
    }
    /**
    * Presenta el menú para un cliente en la consola.
    */
    public void presentarMenuCliente(){
        System.out.println("/*******************MENU**********************/");
        System.out.println("/*                                           */");
        System.out.println("/*********************************************/");
        System.out.println("1. Solicitar servicio de taxi");
        System.out.println("2. Solicitar entrega encomienda");
        System.out.println("3. Consultar servicios");
        System.out.println("4. Cerrar sesion");
        System.out.print("\n");
    }
    /**
    * Presenta el menú para un conductor en la consola.
    */
    public void presentarMenuConductor(){
        System.out.println("/**************MENU CONDUCTOR*****************/");
        System.out.println("/*                                           */");
        System.out.println("/*********************************************/");
        System.out.println("1. Consultar Servicio Asignado");
        System.out.println("2. Datos de su vehiculo");
        System.out.println("3. Cerrar sesion");
        System.out.print("\n");
    }
    /**
    * Inicia el sistema, permitiendo que los usuarios inicien sesión y accedan a las funcionalidades del sistema.
    */
    public void iniciar(){
        Scanner sc = new Scanner(System.in);
        String user;
        String contrasena;
        String opcion;
        Usuario usuarioSistema;
        int edad;
        String tarjetaCredito;
        usuarios = crearListaUsuarios();
        String continuar = "SI";
        
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("            BIENVENIDO AL SISTEMA              ");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        
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
            
            do{
                presentarMenuCliente();
                System.out.print("Elija una opcion: ");
                opcion = sc.next();
                System.out.println("\n");
                if(opcion.equals("1")){
                    Taxi t = new Taxi();
                    t.solicitarServicio(clienteSistema);
                    System.out.println("\n");
                    System.out.println(t);
                }else if(opcion.equals("2")){
                    Encomienda e = new Encomienda();
                    e.solicitarServicio(clienteSistema);
                    System.out.println("\n");
                    System.out.println(e);
                }else if(opcion.equals("3")){
                    clienteSistema.consultarServicio(servicios);
                }  
                System.out.print("¿Volver al menú? (SI/NO): ");
                continuar = sc.next();
                System.out.println("\n");
            }while(continuar.equals("SI"));
            
        }else if(TipoUsuario.R == usuarioSistema.getTipoUsuario()){
            Conductor conductorSistema = (Conductor)usuarioSistema;
            
            do{
                presentarMenuConductor();
                System.out.print("Elija una opcion: ");
                opcion = sc.next();
                System.out.println("\n");
                if(opcion.equals("1")){
                    conductorSistema.consultarServicio(servicios);
                }
                System.out.print("¿Volver al menú? (SI/NO): ");
                continuar = sc.next();
                System.out.println("\n");
            }while(continuar.equals("SI"));    
        }
    }
             
}

     
     
     