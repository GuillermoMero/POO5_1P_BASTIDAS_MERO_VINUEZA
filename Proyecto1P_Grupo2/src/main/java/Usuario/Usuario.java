/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

/**
 *
 * @author Paula
 */
public class Usuario {
    protected String numeroCedula;
    protected String nombre;
    protected String apellidos;
    protected String usuario;
    protected String contraseña;
    protected String numeroCelular;
    protected int edad;
    protected TipoUsuario tipoUsuario;
    
    public Usuario(String numeroCedula,String nombre, String apellidos, String usuario, String contraseña, String numeroCelular, int edad, TipoUsuario tipoUsuario){
        this.numeroCedula=numeroCedula;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.usuario=usuario;
        this.contraseña=contraseña;
        this.numeroCelular=numeroCelular;
        this.tipoUsuario=tipoUsuario;
    }

    
    public void consultarServicio(){
        
    }
    
}
