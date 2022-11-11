package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Transaccion {
    private LocalDate fecha;
    private String Descripcion;
    private double Monto;

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double monto) {
        Monto = monto;
    }

    public Transaccion(LocalDate fecha, String descripcion, double monto) {
        this.fecha = fecha;
        Descripcion = descripcion;
        Monto = monto;
    }

    public Transaccion(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaccion that = (Transaccion) o;
        return Double.compare(that.Monto, Monto) == 0 && Objects.equals(fecha, that.fecha) && Objects.equals(Descripcion, that.Descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha, Descripcion, Monto);
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "fecha=" + fecha +
                ", Descripcion='" + Descripcion + '\'' +
                ", Monto=" + Monto +
                '}';
    }
}
