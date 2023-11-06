/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;
import Vehiculo.Vehiculo;
/**
 *
 * @author PEDRO VINUEZA
 */
public class Conductor extends Usuario{
    private String numeroLicencia;
    private EstadoConductor estadoConductor;
    private Vehiculo vehiculo;

    public Conductor(String numeroCedula, String nombre, String apellidos, String usuario, String contraseña, String numeroCelular, int edad, TipoUsuario tipoUsuario) {
        super(numeroCedula, nombre, apellidos, usuario, contraseña, numeroCelular, edad, tipoUsuario);
    }
    public void setNumeroLicencia(String numeroLicencia){
        this.numeroLicencia = numeroLicencia;
    }
    public void setEstadoConductor(EstadoConductor estadoConductor){
        this.estadoConductor = estadoConductor;
    }
    public void setVehiculo(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }
    public String getNumeroLicencia(){
        return numeroLicencia;
    }
    public EstadoConductor getEstadoConductor(){
        return estadoConductor;
    }
    public Vehiculo getVehiculo(){
        return vehiculo;
    }
}
