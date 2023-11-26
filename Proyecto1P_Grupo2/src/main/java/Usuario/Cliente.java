/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import java.util.Scanner;
import manejoArchivos.ManejoArchivo;
import Servicio.*;
import java.util.ArrayList;
/**
 *
 * @author PEDRO VINUEZA
 */
public class Cliente extends Usuario{
    private int edad;
    private String numeroTarjeta;
    public Cliente(String numeroCedula, String nombre, String apellidos, String usuario, String contraseña, String numeroCelular, TipoUsuario tipoUsuario, int edad, String numeroTajerta) {
        super(numeroCedula, nombre, apellidos, usuario, contraseña, numeroCelular,tipoUsuario);
        this.numeroTarjeta = numeroTarjeta;
    }
    public void setNumeroTarjeta(String numeroTarjeta){
        this.numeroTarjeta = numeroTarjeta;
    }
    public String getNumeroTarjeta(){
        return numeroTarjeta;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    @Override
    public boolean equals(Object o){
      if(this == o){
        return true;
      }
      if(o != null && o.getClass() == this.getClass()){
        Cliente otro = (Cliente) o;
        return  super.equals(otro);
      }else{
        return false;
      }
    }

    @Override
    public void consultarServicio(ArrayList<Servicio> servicios) {
        for(int i=0; i<servicios.size();i++){
            System.out.println(servicios.get(i));
        }
    }
    
    public void llenarDatos(){
        
        Scanner sc = new Scanner(System.in);
        int validar = 0;
        for (String i:ManejoArchivo.LeeFichero("Clientes.txt")){
            if(i.split(",")[0].equals(this.numeroCedula)){
                validar = validar + 1;
            }
        }
        if (validar == 0){
           System.out.print("Edad: ");
           edad = sc.nextInt();
           setEdad(edad);
           sc.nextLine();
           System.out.print("Numero de tarjeta de credito: ");
           numeroTarjeta = sc.nextLine();
           setNumeroTarjeta(numeroTarjeta);
           String linea = ""+numeroCedula+","+edad+","+numeroTarjeta;
           ManejoArchivo.EscribirArchivo("Clientes.txt",linea);
        }
    }
}
