/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;
import Usuario.Cliente;
import Usuario.Conductor;
import manejoArchivos.ManejoArchivo;
/**
 *
 * @author Paula
 */
public abstract class Servicio {
    protected int numServicio;
    protected TipoServicio tipoServicio;
    protected Cliente cliente;
    protected Conductor conductor;
    protected String origen;
    protected String destino;
    protected String fecha;
    protected String hora;
    protected TipoPago tipoPago;
    
    public Servicio(){
        
    }
    
    public Servicio(TipoServicio tipoServicio, Cliente cliente, Conductor conductor, String origen, String destino, String fecha, String hora, TipoPago tipoPago){
        this.numServicio++;
        this.tipoServicio = tipoServicio;
        this.cliente = cliente;
        this.conductor = conductor;
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
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
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
    
    public Conductor getConductor(){
        return conductor;
    }
    
    public void setConductor(Conductor conductor){
        this.conductor = conductor;
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

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }
     /**
     * Calcula el valor a pagar por el servicio basado en el costo y la distancia.
     * Este método debe ser implementado por las subclases concretas.
     * 
     * @param costo El costo por unidad de distancia.
     * @param distancia La distancia recorrida o medida del servicio.
     * @return El valor total a pagar por el servicio.
     */
    public abstract double calcularValorPagar(double costo,int distancia);
    /**
     * Escribe los detalles del servicio en un archivo.
     * Los detalles incluyen información como el número de servicio, tipo, cliente, conductor, origen, destino, fecha y hora.
     * 
     * Este método se utiliza para almacenar los detalles generales del servicio en un archivo de registro.
     */    
    public void escribirServicio(){
        String linea2 = ""+numServicio+","+tipoServicio+","+cliente.getNumeroCedula()+","+conductor.getNombre()+","+origen+","+destino+","+fecha+","+hora;
            ManejoArchivo.EscribirArchivo("Servicios.txt",linea2);
    }
    /**
     * Solicita un servicio concreto.
     * Este método debe ser implementado por las subclases concretas para definir cómo se solicita un servicio específico.
     * 
     * @param cliente El cliente que solicita el servicio.
     */
    public abstract void solicitarServicio(Cliente cliente);
    
}


