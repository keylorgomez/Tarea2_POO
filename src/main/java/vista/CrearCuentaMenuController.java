package vista;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CrearCuentaMenuController {
    CrearCuentaAhorroController cuentaAhorro = new CrearCuentaAhorroController();
    @FXML
    private Button btnAhorroProgramado;

    @FXML
    private Button btnCuentaAhorro;

    @FXML
    private Button btnCuentaCorriente;

    @FXML
    private Button btnRegresar;

    @FXML
    void IrCuentaAhorroProgramado(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Inicio.class.getResource("CrearCuentaAhorroProgramado.fxml")));
        Stage window = (Stage) btnCuentaAhorro.getScene().getWindow();
        window.setScene(new Scene(root));

    }

    @FXML
    void IrCuentaCorriente(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Inicio.class.getResource("CuentaCorriente.fxml")));
        Stage window = (Stage) btnCuentaCorriente.getScene().getWindow();
        window.setScene(new Scene(root));

    }

    @FXML
    void IrCuentaAhorro(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Inicio.class.getResource("CrearCuentaAhorro.fxml")));
        Stage window = (Stage) btnCuentaAhorro.getScene().getWindow();
        window.setScene(new Scene(root));

    }

    @FXML
    void RegresarMenuPrincipal(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Inicio.class.getResource("MenuPrincipal.fxml")));
        Stage window = (Stage) btnRegresar.getScene().getWindow();
        window.setScene(new Scene(root));

    }
}
