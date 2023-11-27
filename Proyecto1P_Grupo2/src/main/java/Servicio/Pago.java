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
    public void escribirPago(Servicio t, double subtotal, double valorPagar){
        Pago p = new Pago();
        idPago = t.getNumServicio();
        String linea = "\n"+idPago+","+t.getFecha()+","+t.getNumServicio()+","+t.getTipoPago()+","+t.getCliente().getNumeroCedula()+","+subtotal+","+valorPagar;
        ManejoArchivo.EscribirArchivo("Pagos.txt",linea);
       
    }
}


