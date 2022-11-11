package modelo;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Se encarga de gestionar toda la clase cuenta y sus hijas
 */
public class Cuenta {
    private String identificacion;
    private String numeroCuenta;
    private double saldo;
    private LocalDate fechaCreacion;

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     *
     * @param identificacion es de tipo String y permite asociar a quien pertenece la cuenta
     * @param numeroCuenta es de tipo String y representa el número de cuenta de los clientes
     * @param saldo es de tipo double y posee el saldo de la cuenta
     * @param fechaCreacion es de tipo LocalDate y permite conocer la fecha en que se crea una cuenta
     */
    public Cuenta(String identificacion, String numeroCuenta, double saldo, LocalDate fechaCreacion) {
        this.identificacion= identificacion;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Constructor por defecto de la clase Cuenta
     */
    public  Cuenta(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuenta cuenta = (Cuenta) o;
        return Double.compare(cuenta.saldo, saldo) == 0 && Objects.equals(identificacion, cuenta.identificacion) && Objects.equals(numeroCuenta, cuenta.numeroCuenta) && Objects.equals(fechaCreacion, cuenta.fechaCreacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificacion, numeroCuenta, saldo, fechaCreacion);
    }

    /**
     * Metodo que devuelve los atributos en formato String
     * @return String con el estado del objeto
     */
    @Override
    public String toString() {
        return  "Identificacion: " + identificacion +"\t" +
                "Número de cuenta: " + numeroCuenta + "\t"  +
                "Saldo: " + saldo +"\t"  +
                "Fecha de creacion: " + fechaCreacion;
    }
}
