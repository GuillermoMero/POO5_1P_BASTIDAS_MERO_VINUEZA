/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;
import SistemaServicio.SistemaServicio;
import Usuario.Cliente;
import Usuario.Conductor;
import Usuario.Usuario;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import manejoArchivos.ManejoArchivo;
/**
 *
 * @author Paula
 */
public class Taxi extends Servicio{
    private int numeroPasajero;
    
    public Taxi(){}
    
    public Taxi(TipoServicio tipoServicio, Cliente cliente, Conductor conductor, String origen, String destino, String fecha, String hora, TipoPago tipoPago, int numeroPasajero){
        super(TipoServicio.valueOf("T"), cliente, conductor, origen, destino, fecha, hora, tipoPago);
        this.numeroPasajero = numeroPasajero;
    }
    
    public int getNumeroPasajero() {
        return numeroPasajero;
    }

    public void setNumeroPasajero(int numeroPasajero) {
        this.numeroPasajero = numeroPasajero;
    }

    @Override
    public void solicitarServicio(Cliente cliente){
        Random rd = new Random();
        final double COSTO = 0.50;        
        int DISTANCIA = rd.nextInt(5, 46);
        double subtotal = (COSTO*DISTANCIA);
        Scanner sc = new Scanner(System.in); 
        System.out.println("\n");
        System.out.println("/*************DETALLES DE LA RUTA*************/");  
        System.out.print("Origen: ");
        origen = sc.nextLine();
        System.out.print("Destino: ");
        destino = sc.nextLine();
        System.out.print("Fecha (dd/mm/aa): ");
        fecha = sc.nextLine();
        System.out.print("Hora (hh:mm) ");
        hora = sc.nextLine();
        System.out.print("Forma de Pago (TC/E): ");
        String tipo = sc.nextLine();
        tipoPago = TipoPago.valueOf(tipo);
        System.out.print("Numero de pasajeros: ");
        numeroPasajero = sc.nextInt();
        sc.nextLine();
        tipoServicio = TipoServicio.T;
        this.cliente = cliente;
        System.out.println("El subtotal del valor a pagar por el servicio de taxi es de: "+subtotal);
        System.out.print("Desea confirmar el viaje(SI/NO): ");
        String continuar = sc.nextLine().toUpperCase();
        if (continuar.equals("SI")){
            double valorPagar = calcularValorPagar(COSTO,DISTANCIA,tipoPago);
            ArrayList<Usuario> usuarios = SistemaServicio.crearListaUsuarios();
            Conductor conductorTaxi = Conductor.seleccionarConductorDisponible(usuarios);
            conductor = conductorTaxi;
            String linea1 = "\n"+(ManejoArchivo.LeeFichero("Viajes.txt").size())+","+numeroPasajero+","+DISTANCIA+","+subtotal;
            ManejoArchivo.EscribirArchivo("Viajes.txt",linea1);
            setNumServicio((ManejoArchivo.LeeFichero("Servicios.txt").size()));
            escribirServicio();
            SistemaServicio.getServicios().add(this);
            Pago p = new Pago();
            p.escribirPago(this, subtotal, valorPagar);
        }
    }
    
    @Override
    public double calcularValorPagar(double costo,int distancia) {
        return costo*distancia;
    }
    
    public double calcularValorPagar(double costo,int distancia,TipoPago tipoPago){
        if (tipoPago == TipoPago.TC)
            return (calcularValorPagar( costo, distancia))*1.15;
        return calcularValorPagar( costo, distancia);
    }
    
    @Override
    public String toString(){
        return "/*********************************************/ \nTipo: Viaje \nCantidad pasajeros: "+numeroPasajero+"\nFecha: "+fecha+"\nHora: "+hora+"\nDesde: "+origen+"\nHasta: "+destino+"\n";
    }
    
}
