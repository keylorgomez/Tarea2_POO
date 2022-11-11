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
import modelo.CuentaAhorro;

import java.io.IOException;
import java.util.Objects;

public class CrearCuentaAhorroController {
    CuentaAhorro cuentaAhorro=new CuentaAhorro();

    @FXML
    private Button btnCrearCuenta;

    @FXML
    private Button btnRegresar;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtMonto;
    @FXML
    private TextField txtTasaInteres;



    @FXML
    void CrearCuenta(ActionEvent event) {
        cuentaAhorro.setIdentificacion(txtCedula.getText());
        cuentaAhorro.setSaldo(Double.valueOf(txtMonto.getText()));
        CuentaAhorro.setTasaInteres(Double.valueOf(txtTasaInteres.getText()));
        String identificacion=cuentaAhorro.getIdentificacion();
        double deposito=cuentaAhorro.getSaldo();
        double tasaInteres=CuentaAhorro.getTasaInteres();
        if(ValidarDatos(identificacion,deposito,tasaInteres)==true){
            if(BancoControlador.CedulaExistente(identificacion)==true){
                String NumeroCuenta=BancoControlador.CrearCuentaAhorro(identificacion,deposito,tasaInteres);
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setHeaderText(null);
                alert.setContentText("La cuenta de ahorra se creo correctamente.\nSu número de cuenta corriente es: "+NumeroCuenta);
                alert.initStyle(StageStyle.UTILITY);
                alert.showAndWait();
                LimpiarCampos();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El número de cédula ingresado aún no se encuentra registrado en el sistema.");
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

    public boolean ValidarDatos(String pidentificacion,double pMonto, double pTasaInteres){
        if((pidentificacion==null || pidentificacion=="")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Todos los datos son requeridos.");
            alert.showAndWait();
            return false;
        } else if (pMonto<0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No se permiten depósitos negativos.");
            alert.showAndWait();
            return false;
        } else if (pTasaInteres<=0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("La tasa de interés debe ser superior a 0%.");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    public void LimpiarCampos(){
        txtCedula.setText("");
        txtMonto.setText("");
        txtTasaInteres.setText("");
    }
}
