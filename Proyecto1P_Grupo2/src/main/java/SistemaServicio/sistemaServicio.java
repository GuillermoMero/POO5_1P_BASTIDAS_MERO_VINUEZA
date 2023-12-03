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
        servicios = crearListaServicios();
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    public static ArrayList<Servicio> getServicios() {
        return servicios;
    }
     /**
     * Crea una lista de servicios a partir de archivos de texto.
     *
     * @return ArrayList de objetos Servicio con la información obtenida de archivos de texto.
     */
    public static ArrayList<Servicio> crearListaServicios(){ //Este metodo lee el archivo Servicios, Viajes, Encomienda para crear un ArrayList de Servicio
        ArrayList<Servicio> arreglo = new ArrayList<>();
        ArrayList<String[]> listasServicios;
        ArrayList<String[]> listasViajes;
        ArrayList<String[]> listasEncomiendas;
        listasServicios = enpaquetar(ManejoArchivo.LeeFichero("Servicios.txt")); //Lee archivo y con el metodo enpaquetar crear una lista donde sus elementos son las lineas del archivo pero ya separados por ",".
        listasViajes = enpaquetar(ManejoArchivo.LeeFichero("Viajes.txt"));
        listasEncomiendas= enpaquetar(ManejoArchivo.LeeFichero("Encomiendas.txt"));
        Cliente cli = null;
        Conductor c = null;
        for(int i=0; i<listasServicios.size(); i++){ //Realizar una indexación a las listas y asginarlas a una variable
            int numSer = Integer.parseInt(listasServicios.get(i)[0]);
            TipoServicio ts = TipoServicio.valueOf(listasServicios.get(i)[1]);
            String origen = listasServicios.get(i)[4];
            String destino = listasServicios.get(i)[5];
            String fecha = listasServicios.get(i)[6];
            String hora = listasServicios.get(i)[7];
            for(Usuario j : crearListaUsuarios()){
                if (j instanceof Cliente){ // Validacion para revisar el tipo de usuario usando el "instanceof"
                    Cliente cli1 = (Cliente) j; //Dowcasting
                    if (cli1.getNumeroCedula().equals(listasServicios.get(i)[2])){ //Validar si el numero de cedula de cl1 es igual al de un cliente de los archivos
                        cli = cli1;
                    }
                }else{
                    Conductor c1 = (Conductor) j; //Dowcasting
                    if(c1.getNombre().equals(listasServicios.get(i)[3])){
                        c = c1;
                    }
                }
            }
            if(ts == TipoServicio.T){ //Validacion para ver si el servicio es de tipo Taxi o Encomienda
                for (int k = 0; k<listasViajes.size();k++){
                    if (listasViajes.get(k)[0].equals(listasServicios.get(i)[0])){
                        int numpasa = Integer.parseInt(listasViajes.get(k)[1]);                  
                        Taxi taxi = new Taxi(numSer,ts,cli,c,origen,destino,fecha,hora,null,numpasa);
                        arreglo.add(taxi); 
                    }
                }
            }else{
                for (int k = 0; k<listasEncomiendas.size();k++){
                    if (listasEncomiendas.get(k)[0].equals(listasServicios.get(i)[0])){
                        TipoEncomienda te = TipoEncomienda.valueOf(listasEncomiendas.get(k)[1]); 
                        int cp = Integer.parseInt(listasEncomiendas.get(k)[2]);  
                        double p = Double.parseDouble(listasEncomiendas.get(k)[3]);  
                        Encomienda encomienda = new Encomienda(numSer,ts,cli,c,origen,destino,fecha,hora,null,te,cp,p);
                        arreglo.add(encomienda);
                    }
                }
            }
        }
    return arreglo;
    }
    /**
    * Crea una lista de usuarios a partir de la lectura de archivos de usuarios, conductores y vehículos.
    * @return ArrayList de usuarios con la información obtenida de los archivos.
    */
    public static ArrayList<Usuario> crearListaUsuarios(){
        ArrayList<Usuario> arreglo = new ArrayList<>();
        ArrayList<String[]> listasUsuarios;
        ArrayList<String[]> listasConductores;
        ArrayList<String[]> listasVehiculos;
        listasUsuarios= enpaquetar(ManejoArchivo.LeeFichero("usuarios.txt"));
        for(int i=0; i<listasUsuarios.size(); i++){
            if("C".equals(listasUsuarios.get(i)[6])){ //Validacion para ver si el usuario es de tipo Cliente o Conductor
                //
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
    public static ArrayList<String []> enpaquetar(ArrayList<String> arreglo){ //metodo creado para ahorro de codigo.
        ArrayList<String []> lista = new ArrayList<>();
        for(int i=0; i<arreglo.size(); i++){
            if(i>0){
                String [] partes = arreglo.get(i).split(","); //Separar la cadena por el caracter "," y guardarlas en una lista.
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
     * Pregunta si el usuario desea volver al menu
     * @return la elección que ingresa el usuario SI o NO
     */
    public String volverMenu(){
        Scanner sc = new Scanner(System.in);
        String eleccion;
        boolean condicion;
        do{
            System.out.print("¿Volver al menú? (SI/NO): ");
            eleccion = sc.nextLine().toUpperCase();
            condicion = eleccion.equals("SI") || eleccion.equals("NO");
            if (condicion == false){
                System.out.println("ERROR, INGRESE UNA OPCION VALIDA, PUEDE INGRESAR 'SI' O 'NO'!!!\n");
            }
        }while(!(eleccion.equals("SI") || eleccion.equals("NO")));
        return eleccion;
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
        usuarios = crearListaUsuarios();
        String continuar = "SI";
        String cerrar = "SI";
        
        do{
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("            BIENVENIDO AL SISTEMA              ");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        
        /**
         * Bucle de iniciar sesion para verificar si el usuario ingresado sea correcto y esté en el archivo usuarios.txt
         */
        do{
            System.out.print("USUARIO: ");
            user = sc.nextLine();
            System.out.print("CONTRASENA: ");
            contrasena = sc.nextLine();
            usuarioSistema = SistemaServicio.validarUsuario(usuarios, user, contrasena); //Valida si el usuario y contraseña son correctos con el metodo validadUsuario
            if (usuarioSistema == null){
                System.out.println("ERROR, INGRESE UN USUARIO Y CONTRASEÑA QUE SE ENCUENTREN EN LA BASE DE DATOS!!!\n");
            }
        }while(usuarioSistema == null); //Estructura de control que hace obligar que se ingrese datos.
        
        /**
         * Validacion de si el usuario ingresado es de tipo Cliente(C) o Conductor (R)
         */
        if(TipoUsuario.C == usuarioSistema.getTipoUsuario()){
            Cliente clienteSistema = (Cliente) usuarioSistema; //Dowcasting
            clienteSistema.llenarDatos();
            
            do{
                presentarMenuCliente();
                boolean condicion;
                do{
                    System.out.print("Elija una opcion: ");
                    opcion = sc.nextLine();
                    condicion = opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals("4");
                    if (condicion == false){
                        System.out.println("ERROR, INGRESE UNA OPCION VALIDA, ESTAS VAN DEL 1 AL 4!!!\n");
                    }
                }while(!condicion);
                System.out.println("\n");
                if(opcion.equals("1")){
                    Taxi t = new Taxi();
                    t.solicitarServicio(clienteSistema); //Aqui se hace el ingresado de los datos para la solicitud de un Servicio
                    System.out.println("\n");
                    continuar = volverMenu();
                }else if(opcion.equals("2")){
                    Encomienda e = new Encomienda();
                    e.solicitarServicio(clienteSistema);
                    System.out.println("\n");
                    continuar = volverMenu();
                }else if(opcion.equals("3")){
                    clienteSistema.consultarServicio(servicios); //Muestra por consola todas los servecios que haya solicitado el usuario ingresado.
                    continuar = volverMenu();
                }else if(opcion.equals("4")){
                    continuar = "NO";
                }
                System.out.println("\n");
            }while(continuar.equals("SI"));
            if (cerrar.equals("SI"))
                cerrar = cerrarSistema(continuar,cerrar);
        }else if(TipoUsuario.R == usuarioSistema.getTipoUsuario()){
            Conductor conductorSistema = (Conductor)usuarioSistema; //Dowcasting
            
            do{
                presentarMenuConductor();
                boolean condicion;
                do{
                    System.out.print("Elija una opcion: ");
                    opcion = sc.nextLine();
                    condicion = opcion.equals("1") || opcion.equals("2") || opcion.equals("3");
                    if (condicion == false){
                        System.out.println("ERROR, INGRESE UNA OPCION VALIDA, ESTAS VAN DEL 1 AL 3!!!\n");
                    }
                }while(!condicion);
                System.out.println("\n");
                if(opcion.equals("1")){
                    conductorSistema.consultarServicio(servicios);
                    continuar = volverMenu();
                }else if(opcion.equals("2")){
                    System.out.println("/*********************************************/ \nVEHICULO DEL CONDUCTOR: "+conductorSistema.getNombre()+" "+conductorSistema.getApellidos());
                    System.out.println(conductorSistema.getVehiculo().toString()); //Llamar el metodo toString con el metodo getter de vehiculo de la clase conductor.
                    continuar = volverMenu();
                }else if(opcion.equals("3")){
                    continuar = "NO";
                }
                System.out.println("\n");
            }while(continuar.equals("SI"));
            if (cerrar.equals("SI"))
                cerrar = cerrarSistema(continuar,cerrar);
        }
        }while(cerrar.equals("SI"));
        sc.close();
    }
  
    /**
     * Este método pregunta al usuario si desea cerrar sesión para cambiar de cuenta.
     * @param continuar variable que se le asignara el valor de SI o NO, sirve para mantener la sesión con el usuario actual
     * @param cerrar determinara si el sesión actual se cierra o se mantiene.
     * @return 
     */
    public static String cerrarSistema(String continuar, String cerrar){
        Scanner sc = new Scanner(System.in);
        boolean validacion;
            do{
                System.out.print("¿Desea ingresar con otro usuario? (SI/NO): ");
                cerrar = sc.nextLine().toUpperCase();
                validacion = cerrar.equals("SI") || cerrar.equals("NO");
                if (validacion == false){
                    System.out.println("ERROR, INGRESE UNA OPCION VALIDA, PUEDE INGRESAR 'SI' O 'NO'!!!\n");
                }
            }while(!validacion);
        return cerrar;
  }  
    /**
     * Método creado para las validaciones de los datos ingresados por la clase Scanner
     * @param cadena
     * @return 
     */
    public static String validarTipoDato(String cadena) {
      try {
          Integer.parseInt(cadena);
          return "entero";
      } catch (NumberFormatException e1) {
          try {
              Double.parseDouble(cadena);
              return "double";
          } catch (NumberFormatException e2) {
              if (cadena.length() == 1) {
                  return "caracter";
              } else {
                  return "No válido";
              }
          }
      }
  }
}

     
     
     