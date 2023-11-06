/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

/**
 *
 * @author PEDRO VINUEZA
 */
public class Cliente extends Usuario{
    private String numeroTarjetaCredito;
    public Cliente(String numeroCedula, String nombre, String apellidos, String usuario, String contraseña, String numeroCelular, int edad, TipoUsuario tipoUsuario) {
        super(numeroCedula, nombre, apellidos, usuario, contraseña, numeroCelular, edad, tipoUsuario);
    }
    public void setNumeroTarjetaCredito(String numeroTarjetaCredito){
        this.numeroTarjetaCredito = numeroTarjetaCredito;
    }
    public String getNumeroTarjetaCredito(){
        return numeroTarjetaCredito;
    }
}
