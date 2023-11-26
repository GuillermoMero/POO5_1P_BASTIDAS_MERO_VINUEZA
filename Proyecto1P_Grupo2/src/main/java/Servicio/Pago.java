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
     /**
     * Escribe la información del pago en un archivo de texto.
     * @param servicio El servicio del cual se realiza el pago.
     * @param subtotal El subtotal del pago.
     * @param valorPagar El valor total a pagar.
     */
    public void escribirPago(Servicio servicio, double subtotal, double valorPagar){
        if (servicio instanceof Taxi taxi){
            Pago p = new Pago();
            Taxi t = taxi;
            idPago = t.getNumServicio();
            String linea = ""+idPago+","+t.getFecha()+","+servicio.getNumServicio()+","+t.getTipoPago()+","+t.getCliente().getNumeroCedula()+","+subtotal+","+valorPagar;
            ManejoArchivo.EscribirArchivo("Pagos.txt",linea);
        }
    }
}


