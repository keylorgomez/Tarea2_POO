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
import modelo.Cliente;

import java.io.IOException;
import java.util.Objects;

public class RegistrarClienteController {

    Cliente cliente= new Cliente();
    @FXML
    private Button btnRegistrarCliente;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnRegresar;

    @FXML
    void RegistrarCliente(ActionEvent event) {
        cliente.setNombre(txtNombre.getText());
        cliente.setIdentificacion(txtCedula.getText());
        cliente.setDireccion(txtDireccion.getText());

        String NombreCliente= cliente.getNombre();
        String IdentificacionCliente=cliente.getIdentificacion();
        String DireccionCliente=cliente.getDireccion();

        if((ValidarDatos(NombreCliente,IdentificacionCliente,DireccionCliente))==true){
            if(BancoControlador.RegistarCliente(NombreCliente,IdentificacionCliente,DireccionCliente)==true){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setHeaderText(null);
                alert.setContentText(NombreCliente+" se registró correctamente");
                alert.initStyle(StageStyle.UTILITY);
                alert.showAndWait();
                LimpiarCampos();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Ya se encuentra un cliente registrado bajo mismo número de cédula.");
                alert.showAndWait();
            }

        }

    }
    @FXML
    void RegresarMenuPrincipal(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Inicio.class.getResource("MenuPrincipal.fxml")));
        Stage window = (Stage) btnRegresar.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    public  boolean ValidarDatos( String pNombre, String pIdentificacion, String pDireccion){
        if ((pNombre==null || pNombre =="")||(pIdentificacion==null || pIdentificacion=="") ||(pDireccion==null || pDireccion=="")){
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
        txtNombre.setText("");
        txtCedula.setText("");
        txtDireccion.setText("");
    }



}
