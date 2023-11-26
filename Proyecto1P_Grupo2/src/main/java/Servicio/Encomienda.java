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
    public void calcularcosto(){
        
    }

    @Override
    public double calcularValorPagar(double costo, int distancia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

