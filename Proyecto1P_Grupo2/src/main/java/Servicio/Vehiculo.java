/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Usuario.TipoVehiculo;

/**
 *
 * @author Paula
 */
public class Vehiculo {
    private String placa;
    private String modelo;
    private String marca;
    private TipoVehiculo tipo;
    
    public Vehiculo(String placa, String modelo, String marca, TipoVehiculo tipo){
        this.placa=placa;
        this.modelo=modelo;
        this.marca=marca;
        this.tipo=tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }
    

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    /**
    * Sobrescribe el método equals para comparar si dos objetos Vehiculo son iguales.
    * Dos vehículos son considerados iguales si tienen la misma placa, modelo, marca y tipo.
    * 
    * @param o Objeto a ser comparado con el Vehiculo actual.
    * @return true si el objeto pasado es igual al Vehiculo actual, false en caso contrario.
    */
    @Override
    public boolean equals(Object o){
      if (o == this){
        return true;
      }
      if (o != null && this.getClass() == o.getClass()){
        Vehiculo otro = (Vehiculo)o;
        return otro.placa.equals(this.placa) && otro.modelo.equals(this.modelo) && otro.marca.equals(this.marca) && otro.tipo == this.tipo;
      }else{
        return false;
      }
    }

    /**
     * Presentará la informacion del vehiculo del usuario que pregunte.
     * @return Una cadena con las datos del vehiculo
     */
    @Override
    public String toString() {
        return "\nPlaca=" + placa + "\nModelo=" + modelo + "\nMarca=" + marca + "\nTipo=" + tipo+"\n";
    }
}
