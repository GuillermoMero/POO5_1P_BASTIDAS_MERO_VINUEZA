/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;
import java.util.Scanner;
import SistemaServicio.*;
import Usuario.*;
import java.util.ArrayList;
import manejoArchivos.ManejoArchivo;
/**
 *
 * @author Paula
 */
public class Encomienda extends Servicio{
    private TipoEncomienda tipoEncomienda;
    private int cantidadProducto;
    private double peso;
    
    public Encomienda(){}
    
    public Encomienda(TipoServicio tipoServicio, Cliente cliente, Conductor conductor, String origen, String destino, String fecha, String hora, TipoPago tipoPago, TipoEncomienda tipoEncomienda, int cantidadProducto, double peso){
        super(tipoServicio,cliente,conductor,origen,destino,fecha,hora,tipoPago);
        this.tipoEncomienda = tipoEncomienda;
        this.cantidadProducto = cantidadProducto;
        this.peso = peso;
    }
    public void setTipoEcomienda(TipoEncomienda tipoEncomienda){
        this.tipoEncomienda=tipoEncomienda;
    }
    public TipoEncomienda gettipoEncomienda(){
        return tipoEncomienda;
    }
    public void setcantidadProducto(int cantidadProducto){
        this.cantidadProducto=cantidadProducto;
    }
    public int getcantidadProducto(){
        return cantidadProducto;
    }
    public void setpeso(double peso){
        this.peso=peso;
    }
    public double getpeso(){
        return peso;
    }
/**
 * Calcula el costo del servicio de encomienda.
 */
    public void calcularcosto(){
        
    }
/**
 * Calcula el valor a pagar para el servicio de encomienda.
 * @param costo El costo del servicio.
 * @param distancia La distancia del servicio.
 * @return El valor a pagar.
 */
    @Override
    public double calcularValorPagar(double costo, int distancia) {
        return 0.0;
    }
/**
 * Calcula el valor a pagar para el servicio de encomienda con un subtotal y tipo de pago.
 * @param subtotal El subtotal del valor a pagar.
 * @param tipoPago El tipo de pago (TC o E).
 * @return El valor a pagar calculado.
 */
    public double calcularValorPagar(double subtotal, TipoPago tipoPago){
        if(tipoPago == tipoPago.TC)
            return subtotal*1.15;
        return subtotal;
    }
/**
 * Solicita el servicio de encomienda para un cliente.
 * @param cliente El cliente que solicita el servicio.
 */
    @Override 
    public void solicitarServicio(Cliente cliente){
        Scanner sc = new Scanner(System.in);
        System.out.println("/*************DETALLES DE LA RUTA*************/");
        System.out.print("Origen: ");
        origen = sc.nextLine();
        System.out.print("Destino: ");
        destino = sc.nextLine();
        System.out.print("Fecha (dd/mm/aa): ");
        fecha = sc.nextLine();
        System.out.print("Hora (hh:mm): ");
        hora = sc.nextLine();
        System.out.print("Forma de Pago (TC/E): ");
        String tipo = sc.nextLine();
        tipoPago = TipoPago.valueOf(tipo);
        System.out.print("Tipo de encomienda: (MEDICAMENTOS/DOCUMENTOS): ");
        String encomienda = sc.nextLine();
        tipoEncomienda = TipoEncomienda.valueOf(encomienda);
        System.out.print("Cantidad de producto: ");
        cantidadProducto = sc.nextInt();
        sc.nextLine();
        System.out.print("Peso del producto [Kg]: ");
        peso = sc.nextDouble();
        sc.nextLine();
        tipoServicio = TipoServicio.E;
        this.cliente = cliente;
        
        double subtotal = cantidadProducto+4;
        System.out.println("El subtotal del valor a pagar por el servicio de encomienda es de: "+subtotal);
        
        System.out.print("Desea confirmar el viaje(SI/NO): ");
        String continuar = sc.nextLine().toUpperCase();
        if(continuar.equals("SI")){
            double valorPagar = calcularValorPagar(subtotal, tipoPago);
            ArrayList<Usuario> usuarios = SistemaServicio.crearListaUsuarios();
            conductor = Conductor.seleccionarConductorDisponible(usuarios);
            String linea1 = "\n"+(ManejoArchivo.LeeFichero("Encomiendas.txt").size())+","+tipoEncomienda+","+cantidadProducto+","+peso+","+subtotal;
            ManejoArchivo.EscribirArchivo("Encomiendas.txt",linea1);
            setNumServicio((ManejoArchivo.LeeFichero("Servicios.txt").size()));
            escribirServicio();
            SistemaServicio.getServicios().add(this);
            Pago p = new Pago();
            p.escribirPago(this, subtotal, valorPagar);
        }
    }
    
    @Override
    public String toString(){
        return "/*********************************************/ \nTipo: Encomienda \nTipo encomienda: "+String.valueOf(tipoEncomienda)+"\nCantidad: "+cantidadProducto+"\nFecha: "+fecha
                +"\nHora: "+hora+"\nDesde: "+origen+"\nHasta: "+destino+"\n";
    }
}

