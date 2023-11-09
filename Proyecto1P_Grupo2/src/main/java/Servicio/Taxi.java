/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;
import Usuario.Cliente;
import Usuario.Conductor;
import java.util.Scanner;
/**
 *
 * @author Paula
 */
public class Taxi extends Servicio{
    private int numeroPasajero;
    private Vehiculo tipoVehiculo;
    private double tarifa;
    private Scanner sc;
    
    public Taxi(){
       sc = new Scanner(System.in);
        
    }
    
    public Taxi(String fecha, String hora, Cliente cliente, String origen, String destino, Conductor conductor, TipoServicio tipoServicio){
        super(fecha, hora, cliente, origen, destino, conductor, tipoServicio); 
        sc = new Scanner(System.in);
    }

    public int getNumeroPasajero() {
        return numeroPasajero;
    }

    public void setNumeroPasajero(int numeroPasajero) {
        this.numeroPasajero = numeroPasajero;
    }

    public Vehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(Vehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
    
    public void solicitarTaxi(){
        System.out.println("DETALLES DE LA RUTA");
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
        //Taxi taxi = new Taxi(origen, destino, fecha, hora, tipoPago, );
    }
    
    
}
