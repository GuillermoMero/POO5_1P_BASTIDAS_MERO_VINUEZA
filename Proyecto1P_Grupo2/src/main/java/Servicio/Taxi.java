/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;
import SistemaServicio.SistemaServicio;
import Usuario.Cliente;
import Usuario.Conductor;
import Usuario.Usuario;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import manejoArchivos.ManejoArchivo;
/**
 *
 * @author Paula
 */
public class Taxi extends Servicio{
    private int numeroPasajero;
    
    public Taxi(){}
    
    public Taxi(TipoServicio tipoServicio, Cliente cliente, Conductor conductor, String origen, String destino, String fecha, String hora, TipoPago tipoPago, int numeroPasajero){
        super(TipoServicio.valueOf("T"), cliente, conductor, origen, destino, fecha, hora, tipoPago);
        this.numeroPasajero = numeroPasajero;
    }
    
    public int getNumeroPasajero() {
        return numeroPasajero;
    }

    public void setNumeroPasajero(int numeroPasajero) {
        this.numeroPasajero = numeroPasajero;
    }
    /**
     * Método para solicitar el servicio de taxi.
     * Solicita detalles de la ruta y realiza cálculos para el valor a pagar.
     * Posteriormente, escribe la información del servicio en archivos.
     * @param cliente El cliente que solicita el servicio.
     */
    @Override
    public void solicitarServicio(Cliente cliente){
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        final double COSTO = 0.50;        
        int DISTANCIA = rd.nextInt(5, 46);
        double subtotal = COSTO*DISTANCIA;
        super.solicitarServicio(cliente);
        boolean condicion;
        String cn;
        do{
            System.out.print("Numero de pasajeros: ");
            cn = sc.nextLine();
            condicion = SistemaServicio.validarTipoDato(cn).equals("entero") ;
            if(condicion == false){
                System.out.println("ERROR, INGRESE UN NUMERO ENTERO!!!\n");
            }
        }while(!condicion);
        numeroPasajero = Integer.parseInt(cn);
        tipoServicio = TipoServicio.T;
        this.cliente = cliente;
        System.out.println("El subtotal del valor a pagar por el servicio de taxi es de: "+subtotal);
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
        if (continuar.equals("SI")){
            double valorPagar = calcularValorPagar(COSTO,DISTANCIA,tipoPago);
            ArrayList<Usuario> usuarios = SistemaServicio.crearListaUsuarios();
            Conductor conductorTaxi = Conductor.seleccionarConductorDisponible(usuarios);
            conductor = conductorTaxi;
            String linea1 = "\n"+(ManejoArchivo.LeeFichero("Viajes.txt").size())+","+numeroPasajero+","+DISTANCIA+","+subtotal;
            ManejoArchivo.EscribirArchivo("Viajes.txt",linea1);
            setNumServicio((ManejoArchivo.LeeFichero("Servicios.txt").size()));
            escribirServicio();
            SistemaServicio.getServicios().add(this);
            Pago p = new Pago();
            p.escribirPago(this, subtotal, valorPagar);
            System.out.println(this);
        } else{
            System.out.println("\nEL VIAJE HA SIDO CANCELADO\n");
        }
    }
    /**
     * Calcula el valor a pagar para el servicio de taxi basado en costo y distancia.
     * @param costo El costo por distancia.
     * @param distancia La distancia recorrida.
     * @return El valor a pagar por el servicio.
     */
    @Override
    public double calcularValorPagar(double costo,int distancia) {
        return costo*distancia;
    }
     /**
     * Calcula el valor a pagar para el servicio de taxi con un tipo de pago específico.
     * Aplica un incremento si el pago se realiza con tarjeta de crédito.
     * @param costo El costo por distancia.
     * @param distancia La distancia recorrida.
     * @param tipoPago El tipo de pago (TC o E).
     * @return El valor a pagar por el servicio con el tipo de pago aplicado.
     */
    public double calcularValorPagar(double costo,int distancia, TipoPago tipoPago){
        DecimalFormat df = new DecimalFormat("#.##");
        double vf;
        if(tipoPago == tipoPago.TC){
            vf = calcularValorPagar(costo,distancia)*1.15;
            return vf;
        }
        else{
            return calcularValorPagar(costo,distancia);
        }       
    }
    
    @Override
    public String toString(){
        return "/*********************************************/ \nTipo: Viaje \nCantidad pasajeros: "+numeroPasajero+"\nFecha: "+fecha+"\nHora: "+hora+"\nDesde: "+origen+"\nHasta: "+destino+"\n";
    }
    
}
