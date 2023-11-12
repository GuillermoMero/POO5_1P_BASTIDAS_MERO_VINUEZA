/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;
import Servicio.Vehiculo;
import manejoArchivos.ManejoArchivo;
import java.util.ArrayList;
import SistemaServicio.SistemaServicio;
/**
 *
 * @author PEDRO VINUEZA
 */
public class Conductor extends Usuario{
    private String numeroLicencia;
    private EstadoConductor estado;
    private Vehiculo vehiculo;

    public Conductor(String numeroCedula, String nombre, String apellidos, String usuario, String contraseña, String numeroCelular, int edad, TipoUsuario tipoUsuario, String numeroLicencia, EstadoConductor estado, Vehiculo vehiculo) {
        super(numeroCedula, nombre, apellidos, usuario, contraseña, numeroCelular, edad, tipoUsuario);
        this.numeroLicencia = numeroLicencia;
        this.estado = estado;
        this.vehiculo = vehiculo;
    }
    public void setNumeroLicencia(String numeroLicencia){
        this.numeroLicencia = numeroLicencia;
    }
    public void setEstadoConductor(EstadoConductor estado){
        this.estado = estado;
    }
    public void setVehiculo(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }
    public String getNumeroLicencia(){
        return numeroLicencia;
    }
    public EstadoConductor getEstadoConductor(){
        return estado;
    }
    public Vehiculo getVehiculo(){
        return vehiculo;
    }
    
    public static Conductor seleccionarConductorDisponible(ArrayList<String> arregloLineas){
        ArrayList<Usuario> usuarios = SistemaServicio.listaUsuarios();
        ArrayList<String> linea = ManejoArchivo.LeeFichero("conductor.txt");
        for(int i=0; i<usuarios.size(); i++){
            for(int j=0; j<linea.size(); j++){
                if(i>0){
                    String [] partes = linea.get(j).split(",");
                    if (partes[0]==usuarios.get(i).getNumeroCedula()){
                        Usuario conductor = new Conductor();
                    }
                }
                
                
            }
        }
        for(int i=0; i<arregloLineas.size(); i++){
            if(i>0){
                String [] partes = arregloLineas.get(i).split(",");
                Conductor conductor = new Conductor(partes[0], partes[1], partes[2], partes[3], partes[4], partes[5]]);
            }
        } 
    }
}
