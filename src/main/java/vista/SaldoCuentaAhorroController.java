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

import java.io.IOException;
import java.util.Objects;

public class SaldoCuentaAhorroController {

    @FXML
    private Button btnMostrarSaldo;

    @FXML
    private Button btnRegresar;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtNumeroCuenta;

    @FXML
    void MostrarSaldo(ActionEvent event) {
        String identificacion=txtCedula.getText();
        String numeroCuenta=txtNumeroCuenta.getText();
        if(ValidarCampos(identificacion,numeroCuenta)==true){
            if(BancoControlador.VerificarCuentaAhorro(identificacion,numeroCuenta)==true){
                String infoSaldo=BancoControlador.MostrarSaldoCuentaAhorro(identificacion,numeroCuenta);
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setHeaderText(null);
                alert.setContentText(infoSaldo);
                alert.initStyle(StageStyle.UTILITY);
                alert.showAndWait();
                LimpiarCampos();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El número de cédula o el número de cuenta de ahorro se ingresó de manera incorrecta.");
                alert.showAndWait();
            }
        }

    }

    @FXML
    void Regresar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Inicio.class.getResource("MenuMostrarSaldos.fxml")));
        Stage window = (Stage) btnRegresar.getScene().getWindow();
        window.setScene(new Scene(root));

    }

    public boolean ValidarCampos(String identificacion, String numeroCuenta){
        if((identificacion==null || identificacion=="")||(numeroCuenta==null || numeroCuenta=="")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Todos los datos son requeridos");
            alert.showAndWait();
            return false;
        }
        return true;
    }
    public void LimpiarCampos(){
        txtCedula.setText("");
        txtNumeroCuenta.setText("");
    }

}