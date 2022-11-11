package modelo;

import java.time.LocalDate;

/**
 * Clase que gestiona a las clases corrientes
 */
public class CuentaCorriente extends Cuenta{
    public CuentaCorriente(String identificacion,String numeroCuenta, double saldo,LocalDate fechaCreacion) {
        super(identificacion,numeroCuenta, saldo,fechaCreacion);
    }

    /**
     * Constructor por defecto
     */
    public CuentaCorriente(){

    }

}
