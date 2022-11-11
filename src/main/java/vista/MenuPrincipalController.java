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

public class MenuPrincipalController {
    @FXML
    private Button btnTransacciones;

    @FXML
    private Button btnCrearCuenta;

    @FXML
    private Button btnListarCliente;

    @FXML
    private Button btnMostrarSaldo;

    @FXML
    private Button btnRegistrarCliente;

    @FXML
    void IrCrearCuenta(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Inicio.class.getResource("CrearCuentaMenu.fxml")));
        Stage window = (Stage) btnCrearCuenta.getScene().getWindow();
        window.setScene(new Scene(root));

    }

    @FXML
    void IrTransacciones(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Inicio.class.getResource("MenuTransacciones.fxml")));
        Stage window = (Stage) btnTransacciones.getScene().getWindow();
        window.setScene(new Scene(root));

    }

    @FXML
    void IrListarClientes(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Inicio.class.getResource("ListarClientes.fxml")));
        Stage window = (Stage) btnListarCliente.getScene().getWindow();
        window.setScene(new Scene(root));

    }

    @FXML
    void IrMostrarSaldo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Inicio.class.getResource("MenuMostrarSaldos.fxml")));
        Stage window = (Stage) btnMostrarSaldo.getScene().getWindow();
        window.setScene(new Scene(root));

    }

    @FXML
    void IrRegistrarCliente(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Inicio.class.getResource("RegistrarCliente.fxml")));
        Stage window = (Stage) btnRegistrarCliente.getScene().getWindow();
        window.setScene(new Scene(root));

    }
}
