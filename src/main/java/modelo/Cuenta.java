package modelo;

import java.time.LocalDate;
import java.util.Objects;

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

    public Cuenta(String identificacion, String numeroCuenta, double saldo, LocalDate fechaCreacion) {
        this.identificacion= identificacion;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.fechaCreacion = fechaCreacion;
    }

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

    @Override
    public String toString() {
        return  "Identificacion: " + identificacion +"\t" +
                "Número de cuenta: " + numeroCuenta + "\t"  +
                "Saldo: " + saldo +"\t"  +
                "Fecha de creacion: " + fechaCreacion;
    }
}
