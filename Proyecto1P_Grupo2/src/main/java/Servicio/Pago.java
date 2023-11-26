/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import manejoArchivos.ManejoArchivo;

/**
 *
 * @author Paula
 */
public class Pago {
    private int idPago;
    
    public void escribirPago(Servicio servicio, double subtotal, double valorPagar){
        if (servicio instanceof Taxi){
            Pago p = new Pago();
            Taxi t = (Taxi) servicio;
            idPago = t.getNumServicio();
            String linea = ""+idPago+","+t.getFecha()+","+servicio.getNumServicio()+","+t.getTipoPago()+","+t.getCliente().getNumeroCedula()+","+subtotal+","+valorPagar;
            ManejoArchivo.EscribirArchivo("Pagos.txt",linea);
        }
    }
}


