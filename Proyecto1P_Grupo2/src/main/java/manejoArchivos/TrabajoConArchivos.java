/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejoArchivos;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class TrabajoConArchivos {
    public static void main(String[] arg) {
        ManejoArchivo.EscribirArchivo("archivosalida.txt","Hola!");
        ManejoArchivo.EscribirArchivo("archivosalida.txt","Afios!");
        ManejoArchivo.EscribirArchivo("archivosalida.txt","NUevo!");
        ManejoArchivo.LeeFichero("archivo.txt");
        Date today = Calendar.getInstance().getTime();
         System.out.println(today);
        
        
    }
}
