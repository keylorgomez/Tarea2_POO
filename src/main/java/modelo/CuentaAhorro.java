package modelo;

import java.time.LocalDate;

public class CuentaAhorro extends Cuenta{

    public CuentaAhorro(String identificacion, String numeroCuenta, double saldo, LocalDate fechaCreacion, double tasaInteres) {
        super(identificacion, numeroCuenta, saldo, fechaCreacion);
        this.tasaInteres = tasaInteres;
    }

    private static double tasaInteres;

    public static double getTasaInteres() {
        return tasaInteres;
    }

    public static void setTasaInteres(double tasaInteres) {
        CuentaAhorro.tasaInteres = tasaInteres;
    }

    public CuentaAhorro(){

    }




}
