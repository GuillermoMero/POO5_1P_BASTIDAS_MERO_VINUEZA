/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

/**
 *
 * @author Paula
 */
public class Pago {
    private int numeroPago;
    private String fechaPago;
    private int numeroServicio;
    private String formaPago;
    private String cedulaCliente;
    private double valorPago;
    
    public Pago(int numeroPago, String fechaPago, int numeroServicio, String formaPago, String cedulaCliente, double valorPago){
      this.numeroPago=numeroPago;
      this.fechaPago=fechaPago;
      this.numeroServicio=numeroServicio;
      this.formaPago=formaPago;
      this.cedulaCliente=cedulaCliente;
      this.valorPago=valorPago;
    }

    public int getNumeroPago() {
        return numeroPago;
    }

    public void setNumeroPago(int numeroPago) {
        this.numeroPago = numeroPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getNumeroServicio() {
        return numeroServicio;
    }

    public void setNumeroServicio(int numeroServicio) {
        this.numeroServicio = numeroServicio;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
    
}


