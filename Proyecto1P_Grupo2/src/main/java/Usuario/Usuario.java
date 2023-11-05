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

    public String getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public TipoUsuario getTipoUsuario(){
        return tipoUsuario;
    }
    
    public void setTipoUsuario(TipoUsuario tipoUsuario){
        this.tipoUsuario=tipoUsuario;
    }
    
    public void consultarServicio(){
        
    }
    
}
