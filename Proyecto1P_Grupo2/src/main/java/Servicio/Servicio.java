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
public class Servicio {
    protected int numServicio;
    protected TipoServicio tipoServicio;
    protected String cedulaCliente;
    protected String nombreConductor;
    protected String origen;
    protected String destino;
    protected String fecha;
    protected String hora;
    protected TipoPago tipoPago;
    
    public Servicio(){
        
    }
    
    public Servicio(TipoServicio tipoServicio, String cedulaCliente, String nombreConductor, String origen, String destino, String fecha, String hora, TipoPago tipoPago){
        this.numServicio++;
        this.tipoServicio = tipoServicio;
        this.cedulaCliente = cedulaCliente;
        this.nombreConductor = nombreConductor;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.hora = hora;
        this.tipoPago = tipoPago;
    }
    
    public String getFecha(){
        return fecha;
    }
    
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    
    public String getHora(){
        return hora;
    }
    
    public void setHora(){
        this.hora = hora;
    }
    
    public String getCedulaCliente(){
        return cedulaCliente;
    }
    
    public void setCliente(Cliente cliente){
        this.cedulaCliente = cedulaCliente;
    }
    
    public String getOrigen(){
        return origen;
    }
    
    public void setOrigen(String origen){
        this.origen = origen;
    }
    
    public String getDestino(){
        return destino;
    }
    
    public void setDestino(String destino){
        this.destino = destino;
    }
    
    public String getNombreConductor(){
        return nombreConductor;
    }
    
    public void setConductor(Conductor conductor){
        this.nombreConductor = nombreConductor;
    }
    
    public TipoServicio GetTipoServicio(){
        return tipoServicio;
    }
    
    public void setTipoServicio(TipoServicio tipoServicio){
        this.tipoServicio = tipoServicio;
    }
    
    public int getNumServicio(){
        return numServicio;
    }
    
    public void setNumServicio(int numServicio){
        this.numServicio = numServicio;
    }
    
    
}
