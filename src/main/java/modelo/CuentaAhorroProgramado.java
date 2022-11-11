package modelo;

import java.time.LocalDate;

/**
 * Clase que gestiona a las cuentas de ahorro programado
 */
public class CuentaAhorroProgramado extends Cuenta {

    public CuentaAhorroProgramado(String identificacion, String numeroCuenta, double saldo, LocalDate fechaCreacion, String cuentaCorrienteAsociada, double montoDepositar) {
        super(identificacion, numeroCuenta, saldo, fechaCreacion);
        this.cuentaCorrienteAsociada = cuentaCorrienteAsociada;
        this.montoDepositar = montoDepositar;
    }

    private String cuentaCorrienteAsociada;
    private double montoDepositar;

    public String getCuentaCorrienteAsociada() {
        return cuentaCorrienteAsociada;
    }

    public void setCuentaCorrienteAsociada(String cuentaCorrienteAsociada) {
        this.cuentaCorrienteAsociada = cuentaCorrienteAsociada;
    }

    public double getMontoDepositar() {
        return montoDepositar;
    }

    public void setMontoDepositar(double montoDepositar) {
        this.montoDepositar = montoDepositar;
    }


    /**
     * Constructor por defecto
     */
    public CuentaAhorroProgramado(){

    }
}
