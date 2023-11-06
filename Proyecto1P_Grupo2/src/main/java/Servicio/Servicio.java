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
public class Servicio {
    protected String fecha;
    protected Cliente cliente;
    protected String origen;
    protected String destino;
    protected Conductor conductor;
    protected TipoServicio tipoServicio;
    
    public Servicio(String fecha, Cliente cliente, String origen, String destino, Conductor conductor, TipoServicio tipoServicio){
        this.fecha = fecha;
        this.cliente = cliente;
        this.origen = origen;
        this.destino = destino;
        this.conductor = conductor;
        this.tipoServicio = tipoServicio;
    }
    
    public String getFecha(){
        return this.fecha;
    }
    
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    public Cliente getCliente(){
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    public String getOrigen(){
        return this.origen;
    }
    
    public void setOrigen(String origen){
        this.origen = origen;
    }
    
    public String getDestino(){
        return this.destino;
    }
    
    public void setDestino(String destino){
        this.destino = destino;
    }
    
    public Conductor getConductor(){
        return this.conductor;
    }
    
    public void setConductor(Conductor conductor){
        this.conductor = conductor;
    }
    
    public TipoServicio GetTipoServicio(){
        return this.tipoServicio;
    }
    
    public void setTipoServicio(TipoServicio tipoServicio){
        this.tipoServicio = tipoServicio;
    }
}
