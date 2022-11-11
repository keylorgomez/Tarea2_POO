package modelo;

import java.time.LocalDate;

public class CuentaCorriente extends Cuenta{
    public CuentaCorriente(String identificacion,String numeroCuenta, double saldo,LocalDate fechaCreacion) {
        super(identificacion,numeroCuenta, saldo,fechaCreacion);
    }
    public CuentaCorriente(){

    }

}
