package vista;

import controlador.BancoControlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelo.CuentaAhorroProgramado;

import java.io.IOException;
import java.util.Objects;

public class CrearCuentaAhorroProgramadoController {
    CuentaAhorroProgramado cuentaAhorroProgramado=new CuentaAhorroProgramado();
    @FXML
    private Button btnCrearCuenta;

    @FXML
    private Button btnRegresar;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtCuentaRelacionada;

    @FXML
    private TextField txtMonto;

    @FXML
    void CrearCuenta(ActionEvent event) {
        cuentaAhorroProgramado.setIdentificacion(txtCedula.getText());
        cuentaAhorroProgramado.setNumeroCuenta(txtCuentaRelacionada.getText());
        cuentaAhorroProgramado.setMontoDepositar(Double.valueOf(txtMonto.getText()));

        String identificacion= cuentaAhorroProgramado.getIdentificacion();
        String cuentaRelacionada=cuentaAhorroProgramado.getNumeroCuenta();
        double montoDeposito=cuentaAhorroProgramado.getMontoDepositar();
        if(ValidarDatos(identificacion,cuentaRelacionada,montoDeposito)==true){
            boolean CuentaRelacionadaVerificada=BancoControlador.VerificarCuentaCorriente(identificacion,cuentaRelacionada);
            if(CuentaRelacionadaVerificada==true){
                String CuentaAhorroProgramado=BancoControlador.CrearCuetaAhorroProgramado(identificacion,cuentaRelacionada,montoDeposito);
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setHeaderText(null);
                alert.setContentText("La cuenta se creó correctamente\nSu número de cuenta de ahorro programado es: "+CuentaAhorroProgramado);
                alert.initStyle(StageStyle.UTILITY);
                alert.showAndWait();
                LimpiarCampos();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El número de cuenta no se encuentra asociado al cliente ingresado");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void Regresar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Inicio.class.getResource("CrearCuentaMenu.fxml")));
        Stage window = (Stage) btnRegresar.getScene().getWindow();
        window.setScene(new Scene(root));

    }
    
    public boolean ValidarDatos(String identificacion,String CuentaCorriente, double MontoMensual){
        if((identificacion==null || identificacion=="") || (CuentaCorriente==null || CuentaCorriente=="")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Todos los datos son requeridos");
            alert.showAndWait();
            return false;
        } else if (MontoMensual<0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("El monto a depositar mensualmente debe ser mayor a ₡0");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    public void LimpiarCampos(){
        txtCedula.setText("");
        txtCuentaRelacionada.setText("");
        txtMonto.setText("");
    }
}
