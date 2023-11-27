/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;
import java.util.Scanner;
import SistemaServicio.*;
import Usuario.*;
import java.util.ArrayList;
import manejoArchivos.ManejoArchivo;
import java.text.DecimalFormat;
/**
 *
 * @author Paula
 */
public class Encomienda extends Servicio{
    private TipoEncomienda tipoEncomienda;
    private int cantidadProducto;
    private Double peso;
    
    public Encomienda(){}
    
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
/**
 * Calcula el valor a pagar para el servicio de encomienda.
 * @param costo El costo del servicio.
 * @param distancia La distancia del servicio.
 * @return El valor a pagar.
 */
    @Override
    public double calcularValorPagar(double costo, int distancia) {
        return 0.0;
    }
/**
 * Calcula el valor a pagar para el servicio de encomienda con un subtotal y tipo de pago.
 * @param subtotal El subtotal del valor a pagar.
 * @param tipoPago El tipo de pago (TC o E).
 * @return El valor a pagar calculado.
 */
    public double calcularValorPagar(double subtotal, TipoPago tipoPago){
        if(tipoPago == tipoPago.TC){
            return subtotal*1.15;
        }
        else{
            return subtotal;
        }       
    }
/**
 * Solicita el servicio de encomienda para un cliente.
 * @param cliente El cliente que solicita el servicio.
 */
    @Override 
    public void solicitarServicio(Cliente cliente){
        DecimalFormat df = new DecimalFormat("#.##");
        Scanner sc = new Scanner(System.in);
        super.solicitarServicio(cliente);
        boolean validacion;
        String encomienda;
        do{
            System.out.print("Tipo de encomienda: (MEDICAMENTOS/DOCUMENTOS): ");
            encomienda = sc.nextLine().toUpperCase();
            validacion = encomienda.equals("MEDICAMENTOS") || encomienda.equals("DOCUMENTOS");
            if (validacion == false){
                System.out.println("ERROR, INGRESE UNA OPCION VALIDA 'MEDICAMENTOS' O 'DOCUMENTOS'!!!\n");
            }
        }while(!validacion);
        tipoEncomienda = TipoEncomienda.valueOf(encomienda);
        boolean condicion;
        String cn;
        do{
            System.out.print("Cantidad de producto: ");
            cn = sc.nextLine();
            condicion = SistemaServicio.validarTipoDato(cn).equals("entero") ;
            if(condicion == false){
                System.out.println("ERROR, INGRESE UN NUMERO ENTERO!!!\n");
            }
        }while(!condicion);
        cantidadProducto = Integer.parseInt(cn);
        boolean condicion1;
        String cn1;
        do{
            System.out.print("Peso del producto [Kg]: ");
            cn1 = sc.nextLine();
            condicion = SistemaServicio.validarTipoDato(cn1).equals("double") ;
            if(condicion == false){
            System.out.println("ERROR, INGRESE UN NUMERO decimal (EL SEAPARADOR DECIMAL ES EL PUNTO)!!!\n");
            }
        }while(!condicion);
        peso = Double.parseDouble(cn1);
        tipoServicio = TipoServicio.E;
        this.cliente = cliente; 
        double subtotal = cantidadProducto+4;
        System.out.println("El subtotal del valor a pagar por el servicio de encomienda es de: "+subtotal);
        boolean v;
        String continuar;
        do{
            System.out.print("Desea confirmar el viaje(SI/NO): ");
            continuar = sc.nextLine().toUpperCase();
            v = continuar.equals("SI") || continuar.equals("NO");
            if (v == false){
                System.out.println("ERROR, INGRESE UNA OPCION CORRECTA 'SI' O 'NO'!!!\n");
            }
        }while(!v);
        if(continuar.equals("SI")){
            double valorPagar = calcularValorPagar(subtotal, tipoPago);
            ArrayList<Usuario> usuarios = SistemaServicio.crearListaUsuarios();
            conductor = Conductor.seleccionarConductorDisponibleM(usuarios);
            String linea1 = "\n"+(ManejoArchivo.LeeFichero("Encomiendas.txt").size())+","+tipoEncomienda+","+cantidadProducto+","+peso+","+subtotal;
            ManejoArchivo.EscribirArchivo("Encomiendas.txt",linea1);
            setNumServicio((ManejoArchivo.LeeFichero("Servicios.txt").size()));
            escribirServicio();
            SistemaServicio.getServicios().add(this);
            Pago p = new Pago();
            p.escribirPago(this, subtotal, valorPagar);
            System.out.println(this);
        }else{
            System.out.println("\nLA ENCOMIENDA HA SIDO CANCELADA\n");
        }
    }
    
    @Override
    public String toString(){
        return "/*********************************************/ \nTipo: Encomienda \nTipo encomienda: "+String.valueOf(tipoEncomienda)+"\nCantidad: "+cantidadProducto+"\nFecha: "+fecha
                +"\nHora: "+hora+"\nDesde: "+origen+"\nHasta: "+destino+"\n";
    }
}

