package vista;

import controlador.BancoControlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ListarClientesController {

    @FXML
    private Button btnListar;

    @FXML
    private Button btnRegresar;

    @FXML
    private Label labelClientes;

    @FXML
    private TextArea txtListaClientes;

    @FXML
    void ListarClientes(ActionEvent event) {
        txtListaClientes.setText(BancoControlador.clientesRegistrados());

    }

    @FXML
    void RegresarMenuPrincipal(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Inicio.class.getResource("MenuPrincipal.fxml")));
        Stage window = (Stage) btnRegresar.getScene().getWindow();
        window.setScene(new Scene(root));

    }

}