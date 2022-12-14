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
import modelo.Transaccion;

import java.io.IOException;
import java.util.Objects;

public class TransaccionesCuentaAhorroProgramadoController {
    Transaccion transaccion = new Transaccion();

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnRetirar;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextArea txtDetalle;

    @FXML
    private TextField txtMonto;

    @FXML
    private TextField txtNumeroCuenta;

    @FXML
    void Regresar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Inicio.class.getResource("MenuTransacciones.fxml")));
        Stage window = (Stage) btnRegresar.getScene().getWindow();
        window.setScene(new Scene(root));

    }

    @FXML
    void Retirar(ActionEvent event) {
        transaccion.setDescripcion(txtDetalle.getText());
        transaccion.setMonto(Double.valueOf(txtMonto.getText()));
        String Detalle=transaccion.getDescripcion();
        double Monto=transaccion.getMonto();
        String identificacion=txtCedula.getText();
        String numeroCuenta=txtNumeroCuenta.getText();
        if(ValidarCampos(identificacion,numeroCuenta,Detalle,Monto)==true) {
            if (BancoControlador.VerificarCuentaAhorroProgramado(identificacion, numeroCuenta) == true) {
                String resultadoRetiro=BancoControlador.RealizarRetiroCuentaAhorroProgramado(identificacion,numeroCuenta,Detalle,Monto);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(resultadoRetiro);
                alert.showAndWait();
                LimpiarCampos();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El n??mero de c??dula o el n??mero de cuenta de ahorro programado fueron ingresados de manera incorrecta.");
                alert.showAndWait();
            }
        }

    }
    public boolean ValidarCampos(String identificacion, String numeroCuenta, String Descripcion, double Monto){
        if((identificacion==null || identificacion.equals(""))||(numeroCuenta==null || numeroCuenta.equals(""))||(Descripcion==null || Descripcion.equals(""))){
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