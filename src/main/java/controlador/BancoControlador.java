package controlador;

import modelo.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class BancoControlador {
    public static ArrayList<Cliente> listaClientes=new ArrayList<>();
    static ArrayList<String> listaCedulas=new ArrayList<>();
    static ArrayList<String> listaCuentasGeneral=new ArrayList<>();
    static ArrayList<CuentaCorriente> listaCuentaCorriente=new ArrayList<>();
    static ArrayList<CuentaAhorro> listaCuentaAhorro=new ArrayList<>();
    static ArrayList<CuentaAhorroProgramado> listaCuentaAhorroProgramado=new ArrayList<>();
    static ArrayList<Transaccion> listaTransacciones=new ArrayList<>();


    public static boolean  RegistarCliente(String Nombre, String Identificacion, String Direccion){
        boolean validarCed=false;
        for (int i=0;i<listaCedulas.size();i++){
            if (Identificacion.equals(listaCedulas.get(i))){
                validarCed=true;
                break;
            }
        }
        if(validarCed==false){
            Cliente cliente1 = new Cliente(Nombre,Identificacion,Direccion);
            listaClientes.add(cliente1);
            listaCedulas.add(cliente1.getIdentificacion());
            return true;
        }else{
            return false;
        }
    }

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
        for (int i=0;i<listaCedulas.size();i++){
            if (Identificacion.equals(listaCedulas.get(i))){
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
            return "La cuenta de ahorro no posee fondos";
        }
    }
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
            return "La cuenta de ahorro no posee fondos";
        }
    }

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
        return "El retiro se realizó con éxito.";
    }
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
        return "El retiro se realizó con éxito.";
    }

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
                    return "Se pueden realizar retiros de dinero a partir del: "+fechaPermitidaRetiro;
                }
            }else{
                return "No se pudo realizar el retiro del dinero.";
            }
        }
        return "El retiro se realizó con éxito";
    }

}
