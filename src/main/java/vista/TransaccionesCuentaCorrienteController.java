package vista;

import controlador.BancoControlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelo.Transaccion;

import java.io.IOException;
import java.util.Objects;

public class TransaccionesCuentaCorrienteController {
    Transaccion transaccion=new Transaccion();

    @FXML
    private Button btnDeposito;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnRetiro;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextArea txtDetalle;

    @FXML
    private TextField txtMonto;

    @FXML
    private TextField txtNumeroCuenta;

    @FXML
    void RealizarDeposito(ActionEvent event) {
        transaccion.setDescripcion(txtDetalle.getText());
        transaccion.setMonto(Double.valueOf(txtMonto.getText()));
        String Detalle=transaccion.getDescripcion();
        double Monto=transaccion.getMonto();
        String identificacion=txtCedula.getText();
        String numeroCuenta=txtNumeroCuenta.getText();
        if(ValidarCampos(identificacion,numeroCuenta,Detalle,Monto)==true){
            if(BancoControlador.VerificarCuentaCorriente(identificacion,numeroCuenta)==true){
                String resultDeposito=BancoControlador.RealizarDepositoCuentaCorriente(identificacion,numeroCuenta,Detalle,Monto);
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setHeaderText(null);
                alert.setContentText(resultDeposito);
                alert.initStyle(StageStyle.UTILITY);
                alert.showAndWait();
                LimpiarCampos();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El número de cédula o el número de cuenta corriente fueron ingresados de manera incorrecta.");
                alert.showAndWait();
            }
        }

    }

    @FXML
    void RealizarRetiro(ActionEvent event) {
        transaccion.setDescripcion(txtDetalle.getText());
        transaccion.setMonto(Double.valueOf(txtMonto.getText()));
        String Detalle=transaccion.getDescripcion();
        double Monto=transaccion.getMonto();
        String identificacion=txtCedula.getText();
        String numeroCuenta=txtNumeroCuenta.getText();
        if(ValidarCampos(identificacion,numeroCuenta,Detalle,Monto)==true){
            if(BancoControlador.VerificarCuentaCorriente(identificacion,numeroCuenta)==true){
                String resultRetriro=BancoControlador.RealizarRetiroCuentaCorriente(identificacion,numeroCuenta,Detalle,Monto);
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Retiro de dinero");
                alert.setHeaderText(null);
                alert.setContentText(resultRetriro);
                alert.initStyle(StageStyle.UTILITY);
                alert.showAndWait();
                LimpiarCampos();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El número de cédula o el número de cuenta corriente fueron ingresados de manera incorrecta.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void Regresar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Inicio.class.getResource("MenuTransacciones.fxml")));
        Stage window = (Stage) btnRegresar.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    public boolean ValidarCampos(String identificacion, String numeroCuenta, String Descripcion, double Monto){
        if((identificacion==null || identificacion=="")||(numeroCuenta==null || numeroCuenta=="")||(Descripcion==null || Descripcion=="")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Todos los datos son requeridos.");
            alert.showAndWait();
            return false;
        } else if (Monto<0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No se permiten transacciones negativas.");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    public void LimpiarCampos(){
        txtCedula.setText("");
        txtNumeroCuenta.setText("");
        txtDetalle.setText("");
        txtMonto.setText("");
    }

}
