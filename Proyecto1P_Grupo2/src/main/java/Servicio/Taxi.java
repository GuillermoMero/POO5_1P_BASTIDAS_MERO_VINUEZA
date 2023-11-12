/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;
import Usuario.Cliente;
import Usuario.Conductor;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Paula
 */
public class Taxi extends Servicio{
    private int numeroPasajero;
    private Scanner sc;
    
    public Taxi(){
       sc = new Scanner(System.in);
        
    }
    
    public Taxi(String cedulaCliente, String nombreConductor, String origen, String destino, String fecha, String hora, TipoPago tipoPago, int numeroPasajero){
        super(TipoServicio.valueOf("T"), cedulaCliente, nombreConductor, origen, destino, fecha, hora, tipoPago);
        this.numeroPasajero = numeroPasajero;
        Random rd = new Random();
        final double DISTANCIA = rd.nextInt(40) + 5;
        sc = new Scanner(System.in);
    }

    public int getNumeroPasajero() {
        return numeroPasajero;
    }

    public void setNumeroPasajero(int numeroPasajero) {
        this.numeroPasajero = numeroPasajero;
    }


    
    public void solicitarTaxi(Cliente cliente, Conductor conductor){
        System.out.println("/*************DETALLES DE LA RUTA*************/");  
        System.out.print("Origen: ");
        origen = sc.next();
        System.out.print("Destino: ");
        destino = sc.next();
        System.out.print("Fecha (dd/mm/aa): ");
        fecha = sc.next();
        System.out.print("Hora: ");
        hora = sc.next();
        System.out.print("Forma de Pago (TC/E): ");
        String tipo = sc.next();
        tipoPago = TipoPago.valueOf(tipo);
        System.out.print("Numero de pasajeros: ");
        numeroPasajero = sc.nextInt();
        Taxi taxi = new Taxi(cliente.getNumeroCedula(), conductor.getNombre(), origen, destino, fecha, hora, tipoPago, numeroPasajero);
    }  
}
