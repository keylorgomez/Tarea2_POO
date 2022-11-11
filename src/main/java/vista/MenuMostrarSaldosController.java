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

public class MenuMostrarSaldosController {

    @FXML
    private Button btnAhorro;

    @FXML
    private Button btnCorriente;

    @FXML
    private Button btnProgramado;

    @FXML
    private Button btnRegresar;

    @FXML
    void IrCuentaAhorro(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Inicio.class.getResource("SaldoCuentaAhorro.fxml")));
        Stage window = (Stage) btnAhorro.getScene().getWindow();
        window.setScene(new Scene(root));

    }

    @FXML
    void IrCuentaAhorroProgramado(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Inicio.class.getResource("SaldoAhorroProgramado.fxml")));
        Stage window = (Stage) btnProgramado.getScene().getWindow();
        window.setScene(new Scene(root));


    }

    @FXML
    void IrCuentaCorriente(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Inicio.class.getResource("SaldoCuentaCorriente.fxml")));
        Stage window = (Stage) btnCorriente.getScene().getWindow();
        window.setScene(new Scene(root));

    }
    @FXML
    void Regresar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Inicio.class.getResource("MenuPrincipal.fxml")));
        Stage window = (Stage) btnRegresar.getScene().getWindow();
        window.setScene(new Scene(root));
    }


}