/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import Servicio.*;
import java.util.ArrayList;

/**
 *
 * @author Paula
 */
public abstract class Usuario {
    protected String numeroCedula;
    protected String nombre;
    protected String apellidos;
    protected String usuario;
    protected String contrasena;
    protected String numeroCelular;
    protected TipoUsuario tipoUsuario;
    
    public Usuario(String numeroCedula,String nombre, String apellidos, String usuario, String contrasena, String numeroCelular, TipoUsuario tipoUsuario){
        this.numeroCedula=numeroCedula;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.usuario=usuario;
        this.contrasena=contrasena;
        this.numeroCelular=numeroCelular;
        this.tipoUsuario=tipoUsuario;
    }   

    public String getNumeroCedula() {
        return numeroCedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }


    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    @Override
    public boolean equals(Object o){
      if (o == this){
        return true;
      }
      if (o != null && this.getClass() == o.getClass()){
        Usuario otro = (Usuario)o;
        return otro.numeroCedula.equalsIgnoreCase(this.numeroCedula) && otro.nombre.equalsIgnoreCase(this.nombre) && otro.apellidos.equalsIgnoreCase(this.apellidos) && otro.usuario.equalsIgnoreCase(this.usuario) && otro.contrasena.equalsIgnoreCase(this.contrasena) && otro.numeroCelular.equalsIgnoreCase(this.numeroCelular) && String.valueOf(otro.tipoUsuario).equalsIgnoreCase(String.valueOf(this.tipoUsuario));
      }else{
        return false;
      }
    }
    
    public abstract void consultarServicio(ArrayList<Servicio> servicios);
}
