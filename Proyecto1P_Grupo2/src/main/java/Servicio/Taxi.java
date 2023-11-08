/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;
import Usuario.Cliente;
import Usuario.Conductor;
/**
 *
 * @author Paula
 */
public class Taxi extends Servicio{
    private int numeroPasajero;
    private Vehiculo tipoVehiculo;
    private double tarifa;
    
    public Taxi(String fecha, Cliente cliente, String origen, String destino, Conductor conductor, TipoServicio tipoServicio){
        super(fecha, cliente, origen, destino, conductor, tipoServicio);   
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
    
    public void calcularcosto(){
        
    }
    
}
