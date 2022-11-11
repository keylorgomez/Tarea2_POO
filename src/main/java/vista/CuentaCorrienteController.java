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
import modelo.CuentaCorriente;

import java.io.IOException;
import java.util.Objects;

public class CuentaCorrienteController {
    CuentaCorriente cuentaCorriente =new CuentaCorriente();
    @FXML
    private Button btnCrearCuenta;

    @FXML
    private Button btnRegresar;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtMonto;

    @FXML
    void CrearCuenta(ActionEvent event) {
        cuentaCorriente.setIdentificacion(txtCedula.getText());
        cuentaCorriente.setSaldo(Double.valueOf(txtMonto.getText()));

        String IdentificacionCliente=cuentaCorriente.getIdentificacion();
        Double SaldoCliente=cuentaCorriente.getSaldo();
        if(ValidarDatos(IdentificacionCliente,SaldoCliente)==true){
            if(BancoControlador.CedulaExistente(IdentificacionCliente)==true){
                String  NumeroCuenta=BancoControlador.CrearCuentaCorriente(IdentificacionCliente,SaldoCliente);
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setHeaderText(null);
                alert.setContentText("La cuenta se creó correctamente\nSu número de cuenta corriente es: "+NumeroCuenta);
                alert.initStyle(StageStyle.UTILITY);
                alert.showAndWait();
                LimpiarCampos();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El número de cédula ingresada no se encuentra registrado en el sistema.");
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

    public boolean ValidarDatos(String pidentificacion,double pMonto){
        if((pidentificacion==null || pidentificacion=="")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Todos los datos son requeridos");
            alert.showAndWait();
            return false;
        } else if (pMonto<50000) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("El monto a depositar debe ser mayor a ₡50000");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    public void LimpiarCampos(){
        txtCedula.setText("");
        txtMonto.setText("");
    }


}
