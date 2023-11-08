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
public class Encomienda extends Servicio{
    private TipoEncomienda tipoEncomienda;
    private int cantidadProducto;
    private double peso;
    public Encomienda(String fecha, Cliente cliente, String origen, String destino, Conductor conductor, TipoServicio tipoServicio ){
        super(fecha, cliente, origen, destino, conductor, tipoServicio);
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
    public void calcularcosto(){
        
    }
}

