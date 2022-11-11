module com.example.tarea2_keylorgomezrodriguez {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens vista to javafx.fxml;
    exports vista;
    exports modelo;
}