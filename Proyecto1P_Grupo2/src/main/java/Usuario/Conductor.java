/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;
import Servicio.*;
import manejoArchivos.ManejoArchivo;
import java.util.ArrayList;
import SistemaServicio.SistemaServicio;
/**
 *
 * @author PEDRO VINUEZA
 */
public class Conductor extends Usuario{
    private EstadoConductor estado;
    private Vehiculo vehiculo;

    public Conductor(String numeroCedula, String nombre, String apellidos, String usuario, String contraseña, String numeroCelular, TipoUsuario tipoUsuario, EstadoConductor estado, Vehiculo vehiculo) {
        super(numeroCedula, nombre, apellidos, usuario, contraseña, numeroCelular, tipoUsuario);
        this.estado = estado;
        this.vehiculo = vehiculo;
    }
    public void setEstadoConductor(EstadoConductor estado){
        this.estado = estado;
    }
    public void setVehiculo(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }
    public EstadoConductor getEstadoConductor(){
        return estado;
    }
    public Vehiculo getVehiculo(){
        return vehiculo;
    }
    /**
    * Compara el Conductor actual con otro objeto para verificar si son iguales.
    * @param o El objeto a comparar con el Conductor actual.
    * @return true si los objetos son iguales, false en caso contrario.
    */
    @Override
    public boolean equals(Object o){
      if(this == o){
        return true;
      }
      if(o != null && o.getClass() == this.getClass()){
        Conductor otro = (Conductor) o;
        return  super.equals(otro) && otro.estado == this.estado && otro.vehiculo.equals(this.vehiculo);
      }else{
        return false;
      }
    }
    /**
    * Busca y devuelve un conductor disponible del conjunto de usuarios.
    * @param usuarios La lista de usuarios entre los cuales se busca al conductor disponible.
    * @return El conductor disponible, o null si no se encuentra ninguno.
    */
    public static Conductor seleccionarConductorDisponible(ArrayList<Usuario> usuarios){
        for (Usuario u:usuarios){
            if (u instanceof Conductor){
                Conductor c = (Conductor) u;
                if(c.estado == EstadoConductor.valueOf("D") && c.vehiculo.getTipo() == TipoVehiculo.A){
                    return c;
                }
            }
        }
        return null; 
    }
    public static Conductor seleccionarConductorDisponibleM(ArrayList<Usuario> usuarios){
        for (Usuario u:usuarios){
            if (u instanceof Conductor){
                Conductor c = (Conductor) u;
                if(c.estado == EstadoConductor.valueOf("D") && c.vehiculo.getTipo() == TipoVehiculo.M){
                    return c;
                }
            }
        }
        return null; 
    }
    /**
     * Consulta y muestra en la consola los detalles de los servicios asignados al conductor.
    * @param servicios La lista de servicios a consultar y mostrar.
    */
    @Override
    public void consultarServicio(ArrayList<Servicio> servicios) {
        for(int i=0; i<servicios.size();i++){
            if(servicios.get(i).getConductor().getNombre().equals(getNombre())){
                System.out.println(servicios.get(i));
            }else{
                System.out.println("No tiene asignado algun servicio");
            }
        }
    }
    
}
    