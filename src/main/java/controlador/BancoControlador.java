package controlador;

import modelo.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

/**
 * Gestiona toda la clase Banco y cada uno de sus métodos
 */

public class BancoControlador {
    public static ArrayList<Cliente> listaClientes=new ArrayList<>();
    static ArrayList<CuentaCorriente> listaCuentaCorriente=new ArrayList<>();
    static ArrayList<CuentaAhorro> listaCuentaAhorro=new ArrayList<>();
    static ArrayList<CuentaAhorroProgramado> listaCuentaAhorroProgramado=new ArrayList<>();
    static ArrayList<Transaccion> listaTransacciones=new ArrayList<>();

    /**
     * Funcion que permite registrar clientes
     * @param Nombre
     * @param Identificacion
     * @param Direccion
     * @return
     */
    public static boolean  RegistarCliente(String Nombre, String Identificacion, String Direccion){
        boolean validarCed=false;
        for (int i=0;i<listaClientes.size();i++){
            if (Identificacion.equals(listaClientes.get(i).getIdentificacion())){
                validarCed=true;
                break;
            }
        }
        if(validarCed==false){
            Cliente cliente1 = new Cliente(Nombre,Identificacion,Direccion);
            listaClientes.add(cliente1);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Permite listar todos los clientes
     * @return retorna la lista de clientes del sistema
     */
    public static String clientesRegistrados(){
        String ListaTemp="";
        String listaClientesTemporal []= new String[listaClientes.size()];
        for(int contador=0;contador<listaClientesTemporal.length;contador++){
            listaClientesTemporal[contador]=listaClientes.get(contador).toString();
        }
        for(int j=0;j<listaClientesTemporal.length;j++){
            ListaTemp+=listaClientesTemporal[j];
        }
        return  ListaTemp;
    }

    public static boolean CedulaExistente(String Identificacion){
        boolean validacion=false;
        for (int i=0;i<listaClientes.size();i++){
            if (Identificacion.equals(listaClientes.get(i).getIdentificacion())){
                validacion=true;
                break;
            }
        }
        if(validacion==true){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Permite crear una nueva cuenta corriente
     * @param Identificacion
     * @param Monto
     * @return
     */
    public static String CrearCuentaCorriente(String Identificacion, double Monto){
        Random numeroAleatorio= new Random();
        int n=numeroAleatorio.nextInt(234567-126849)+126849;
        int numeroCuentaCorriente=Integer.parseInt("2"+n);
        String numeroCuenta= String.valueOf(numeroCuentaCorriente);
        LocalDate fechaCreacion= LocalDate.now();
        CuentaCorriente cuentaCorriente=new CuentaCorriente(Identificacion,numeroCuenta,Monto,fechaCreacion);
        listaCuentaCorriente.add(cuentaCorriente);
        return numeroCuenta;
    }

    /**
     * Permite crear una nueva cuenta de ahorro
     * @param Identificacion
     * @param Monto
     * @param tasaInteres
     * @return
     */
    public static String CrearCuentaAhorro(String Identificacion, double Monto, double tasaInteres){
        Random numeroAleatorio= new Random();
        int n=numeroAleatorio.nextInt(234567-126849)+126849;
        int numeroCuentaCorriente=Integer.parseInt("3"+n);
        String numeroCuenta= String.valueOf(numeroCuentaCorriente);
        LocalDate fechaCreacion= LocalDate.now();
        CuentaAhorro cuentaAhorro=new CuentaAhorro(Identificacion,numeroCuenta,Monto,fechaCreacion,tasaInteres);
        listaCuentaAhorro.add(cuentaAhorro);
        System.out.println(listaCuentaAhorro);
        return numeroCuenta;
    }

    /**
     * Permite crear una nueva cuenta de ahorro programado
     * @param identificacion
     * @param cuentaCorriente
     * @param MontoDeposito
     * @return
     */
    public static String CrearCuetaAhorroProgramado(String identificacion, String cuentaCorriente, double MontoDeposito){
        double SaldoCuenta=0;
        SaldoCuenta+=MontoDeposito;
        double ActualizarSaldoCuentaCorriente;
        for (int i=0;i<listaCuentaCorriente.size();i++){
            if(cuentaCorriente.equals(listaCuentaCorriente.get(i).getNumeroCuenta())){
                ActualizarSaldoCuentaCorriente=listaCuentaCorriente.get(i).getSaldo()-MontoDeposito;
                listaCuentaCorriente.get(i).setSaldo(ActualizarSaldoCuentaCorriente);
                break;
            }
        }
        Random numeroAleatorio= new Random();
        int n=numeroAleatorio.nextInt(334567-226849)+226849;
        int numeroCuentaCorriente=Integer.parseInt("4"+n);
        String numeroCuenta= String.valueOf(numeroCuentaCorriente);
        LocalDate fechaCreacion= LocalDate.now();
        CuentaAhorroProgramado cuentaAhorroProgramado = new CuentaAhorroProgramado(identificacion,numeroCuenta,SaldoCuenta,fechaCreacion,cuentaCorriente,MontoDeposito);
        listaCuentaAhorroProgramado.add(cuentaAhorroProgramado);
        return numeroCuenta;
    }


    public static boolean VerificarCuentaCorriente(String identificacion, String cuentaCorriente){
        boolean validar=false;
        for(int contador=0;contador<listaCuentaCorriente.size();contador++){
            if(identificacion.equals(listaCuentaCorriente.get(contador).getIdentificacion()) && cuentaCorriente.equals(listaCuentaCorriente.get(contador).getNumeroCuenta())){
                validar=true;
                break;
            }
        }
        return validar;
    }

    public static boolean VerificarCuentaAhorro(String identificacion, String cuentaCorriente){
        boolean validar=false;
        for(int contador=0;contador<listaCuentaAhorro.size();contador++){
            if(identificacion.equals(listaCuentaAhorro.get(contador).getIdentificacion()) && cuentaCorriente.equals(listaCuentaAhorro.get(contador).getNumeroCuenta())){
                validar=true;
                break;
            }
        }
        return validar;
    }

    public static boolean VerificarCuentaAhorroProgramado(String identificacion, String cuentaCorriente){
        boolean validar=false;
        for(int contador=0;contador<listaCuentaAhorroProgramado.size();contador++){
            if(identificacion.equals(listaCuentaAhorroProgramado.get(contador).getIdentificacion()) && cuentaCorriente.equals(listaCuentaAhorroProgramado.get(contador).getNumeroCuenta())){
                validar=true;
                break;
            }
        }
        return validar;
    }

    /**
     * Permite mostrar el saldo de una cuenta corriente
     * @param identificacion
     * @param numeroCuenta
     * @return
     */
    public static String MostrarSaldoCuentaCorriente(String identificacion, String numeroCuenta){
        double saldoCuenta=0;
        for(int i=0;i<listaCuentaCorriente.size();i++){
            if(numeroCuenta.equals(listaCuentaCorriente.get(i).getNumeroCuenta())){
                saldoCuenta=listaCuentaCorriente.get(i).getSaldo();
                break;
            }
        }
        if (saldoCuenta>0){
            return "Su saldo es: ₡"+saldoCuenta+" colones";
        }else{
            return "La cuenta corriente no posee fondos.";
        }
    }

    /**
     * Permite mostrar el saldo de una cuenta de ahorro
     * @param identificacion
     * @param numeroCuenta
     * @return
     */
    public static String MostrarSaldoCuentaAhorro(String identificacion, String numeroCuenta){
        double saldoCuenta=0;
        for(int i=0;i<listaCuentaAhorro.size();i++){
            if(numeroCuenta.equals(listaCuentaAhorro.get(i).getNumeroCuenta())){
                saldoCuenta=listaCuentaAhorro.get(i).getSaldo();
                break;
            }
        }
        if (saldoCuenta>0){
            return "Su saldo es: ₡"+saldoCuenta+" colones";
        }else{
            return "La cuenta de ahorro no posee fondos.";
        }
    }

    /**
     * Permite mostrar el saldo de una cuenta de ahorro programado
     * @param identificacion
     * @param numeroCuenta
     * @return
     */
    public static String MostrarSaldoCuentaAhorroProgramado(String identificacion, String numeroCuenta){
        double saldoCuenta=0;
        for(int i=0;i<listaCuentaAhorroProgramado.size();i++){
            if(numeroCuenta.equals(listaCuentaAhorroProgramado.get(i).getNumeroCuenta())){
                saldoCuenta=listaCuentaAhorroProgramado.get(i).getSaldo();
                break;
            }
        }
        if (saldoCuenta>0){
            return "Su saldo es: ₡"+saldoCuenta+" colones";
        }else{
            return "La cuenta de ahorro programado no posee fondos.";
        }
    }

    /**
     * Permite generar depositos en una cuenta corriente
     * @param identificacion
     * @param numeroCuenta
     * @param Detalle
     * @param Monto
     * @return
     */
    public static String RealizarDepositoCuentaCorriente(String identificacion, String numeroCuenta, String Detalle, double Monto){
        LocalDate fechaTransaccion= LocalDate.now();
        double nuevoSaldo=0;
        for(int i=0;i<listaCuentaCorriente.size();i++){
            if(numeroCuenta.equals(listaCuentaCorriente.get(i).getNumeroCuenta())){
                nuevoSaldo=listaCuentaCorriente.get(i).getSaldo()+Monto;
                listaCuentaCorriente.get(i).setSaldo(nuevoSaldo);
                Transaccion transaccion=new Transaccion(fechaTransaccion,Detalle,Monto);
                listaTransacciones.add(transaccion);
                break;
            }
        }
        return "El depósito se realizó con éxito.";
    }

    /**
     * Permite generar retiros en una cuenta corriente
     * @param identificacion
     * @param numeroCuenta
     * @param Detalle
     * @param Monto
     * @return
     */
    public static String RealizarRetiroCuentaCorriente(String identificacion, String numeroCuenta, String Detalle, double Monto){
        LocalDate fechaTransaccion= LocalDate.now();
        double nuevoSaldo=0;
        for (int i=0;i<listaCuentaCorriente.size();i++){
            if (numeroCuenta.equals(listaCuentaCorriente.get(i).getNumeroCuenta()) && listaCuentaCorriente.get(i).getSaldo()>Monto){
                nuevoSaldo=listaCuentaCorriente.get(i).getSaldo()-Monto;
                listaCuentaCorriente.get(i).setSaldo(nuevoSaldo);
                Transaccion transaccion=new Transaccion(fechaTransaccion,Detalle,Monto);
                listaTransacciones.add(transaccion);
                break;
            }else {
                return "ERROR!\nNO se puede retirar más dinero del que se posee en la cuenta.";
            }
        }
        return "El retiro de dinero se realizó con éxito.";
    }

    /**
     * Permite generar depositos en una cuenta de ahorro
     * @param identificacion
     * @param numeroCuenta
     * @param Detalle
     * @param Monto
     * @return
     */
    public static String RealizarDepositoCuentaAhorro(String identificacion, String numeroCuenta, String Detalle, double Monto){
        LocalDate fechaTransaccion= LocalDate.now();
        double nuevoSaldo=0;
        for(int i=0;i<listaCuentaAhorro.size();i++){
            if(numeroCuenta.equals(listaCuentaAhorro.get(i).getNumeroCuenta())){
                nuevoSaldo=listaCuentaAhorro.get(i).getSaldo()+Monto;
                listaCuentaAhorro.get(i).setSaldo(nuevoSaldo);
                Transaccion transaccion=new Transaccion(fechaTransaccion,Detalle,Monto);
                listaTransacciones.add(transaccion);
                break;
            }
        }
        return "El depósito se realizó con éxito.";
    }

    /**
     * Permite generar retiros en una cuenta de ahorro
     * @param identificacion
     * @param numeroCuenta
     * @param Detalle
     * @param Monto
     * @return
     */
    public static String RealizarRetiroCuentaAhorro(String identificacion, String numeroCuenta, String Detalle, double Monto){
        LocalDate fechaTransaccion= LocalDate.now();
        double nuevoSaldo=0;
        for (int i=0;i<listaCuentaAhorro.size();i++){
            if (numeroCuenta.equals(listaCuentaAhorro.get(i).getNumeroCuenta()) && listaCuentaAhorro.get(i).getSaldo()>=100000 && Monto<=(listaCuentaAhorro.get(i).getSaldo())*0.50){
                nuevoSaldo=listaCuentaAhorro.get(i).getSaldo()-Monto;
                listaCuentaAhorro.get(i).setSaldo(nuevoSaldo);
                Transaccion transaccion=new Transaccion(fechaTransaccion,Detalle,Monto);
                listaTransacciones.add(transaccion);
                break;
            }else {
                return "ERROR!\nNO se puede realizar el retiro del dinero.";
            }
        }
        return "El retiro de dinero se realizó con éxito.";
    }

    /**
     * Permite generar retiros en una cuenta de ahorro programado
     * @param identificacion
     * @param numeroCuenta
     * @param Detalle
     * @param Monto
     * @return
     */
    public static String RealizarRetiroCuentaAhorroProgramado(String identificacion, String numeroCuenta, String Detalle, double Monto){
        LocalDate fechaTransaccion=LocalDate.now();
        LocalDate fechaPermitidaRetiro;
        double nuevoSaldo=0;
        for (int i=0;i<listaCuentaAhorroProgramado.size();i++){
            if(numeroCuenta.equals(listaCuentaAhorroProgramado.get(i).getNumeroCuenta()) && listaCuentaAhorroProgramado.get(i).getSaldo()>Monto){
                fechaPermitidaRetiro=listaCuentaAhorroProgramado.get(i).getFechaCreacion().plusYears(1);
                if((fechaPermitidaRetiro.isBefore(fechaTransaccion))==true){
                    nuevoSaldo=listaCuentaAhorroProgramado.get(i).getSaldo()-Monto;
                    listaCuentaAhorroProgramado.get(i).setSaldo(nuevoSaldo);
                    Transaccion transaccion=new Transaccion(fechaTransaccion,Detalle,Monto);
                    listaTransacciones.add(transaccion);
                    break;
                }else{
                    return "Los retiros de dinero en esta cuenta son permitidos a partir del: "+fechaPermitidaRetiro;
                }
            }else{
                return "No se pudo realizar el retiro del dinero.";
            }
        }
        return "El retiro de dinero se realizó con éxito.";
    }

}
