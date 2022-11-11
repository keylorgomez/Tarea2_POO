package modelo;

import java.time.LocalDate;

/**
 * Clase que gestiona a las cuentas de ahorro
 */
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

    /**
     * Constructor por defecto de la clase cuenta ahorro
     */
    public CuentaAhorro(){

    }




}
