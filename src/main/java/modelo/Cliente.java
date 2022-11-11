package modelo;

import java.util.ArrayList;
import java.util.Objects;
/**
 * @author Keylor Gómez Rodríguez
 * @version 1.0
 * @since 10-11-2022
 *
 * En esta clase se gestionan todos los objetos cliente
 */

public class Cliente {
    private String nombre;
    private String identificacion;
    private String direccion;
    private ArrayList<Cuenta> cuentas;
    private ArrayList<CuentaCorriente> cuentasCorrientes;
    private ArrayList<CuentaAhorro> cuentasAhorro;
    private ArrayList<CuentaAhorroProgramado> cuentasAhorroProgramado;

    public ArrayList<CuentaCorriente> getCuentasCorrientes() {
        return cuentasCorrientes;
    }

    public void setCuentasCorrientes(ArrayList<CuentaCorriente> cuentasCorrientes) {
        this.cuentasCorrientes = cuentasCorrientes;
    }

    public ArrayList<CuentaAhorro> getCuentasAhorro() {
        return cuentasAhorro;
    }

    public void setCuentasAhorro(ArrayList<CuentaAhorro> cuentasAhorro) {
        this.cuentasAhorro = cuentasAhorro;
    }

    public ArrayList<CuentaAhorroProgramado> getCuentasAhorroProgramado() {
        return cuentasAhorroProgramado;
    }

    public void setCuentasAhorroProgramado(ArrayList<CuentaAhorroProgramado> cuentasAhorroProgramado) {
        this.cuentasAhorroProgramado = cuentasAhorroProgramado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    /**
     *
     * @param nombre es de tipo string y corresponde al nombre del cliente
     * @param identificacion es de tipo string y corresponde al número de cédula del cliente
     * @param direccion es de tipo String y cooresponde a la dirección de habitación del cliente
     * @param cuentas arraylist que almacena todas las cuentas del cliente
     * @param cuentasCorrientes arraylist que almacena todas las cuentas corrientes del cliente
     * @param cuentasAhorro arraylist que almacena todas las cuentas de ahorro del cliente
     * @param cuentasAhorroProgramado arraylist que almacena todas las cuentas de ahorro programado del cliente
     */
    public Cliente(String nombre, String identificacion, String direccion, ArrayList<Cuenta> cuentas, ArrayList<CuentaCorriente> cuentasCorrientes, ArrayList<CuentaAhorro> cuentasAhorro, ArrayList<CuentaAhorroProgramado> cuentasAhorroProgramado) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.cuentas = cuentas;
        this.cuentasCorrientes = cuentasCorrientes;
        this.cuentasAhorro = cuentasAhorro;
        this.cuentasAhorroProgramado = cuentasAhorroProgramado;
    }

    public Cliente(String nombre, String identificacion, String direccion, ArrayList<CuentaCorriente> cuentasCorrientes, ArrayList<CuentaAhorro> cuentasAhorro, ArrayList<CuentaAhorroProgramado> cuentasAhorroProgramado) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.cuentasCorrientes = cuentasCorrientes;
        this.cuentasAhorro = cuentasAhorro;
        this.cuentasAhorroProgramado = cuentasAhorroProgramado;
    }
    public Cliente(String nombre, String identificacion, String direccion){
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
    }

    /**
     * Constructor por defecto
     */
    public Cliente(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nombre, cliente.nombre) && Objects.equals(identificacion, cliente.identificacion) && Objects.equals(direccion, cliente.direccion) && Objects.equals(cuentas, cliente.cuentas) && Objects.equals(cuentasCorrientes, cliente.cuentasCorrientes) && Objects.equals(cuentasAhorro, cliente.cuentasAhorro) && Objects.equals(cuentasAhorroProgramado, cliente.cuentasAhorroProgramado);
    }

    /**
     *
     * @return retorna el objeto en formato String
     */
    @Override
    public String toString() {
        return "\nNombre: " + nombre + "\t" +
                "Identificación: " + identificacion + "\t" +
                "Direccion: " + direccion+"\t \n";
    }

}
