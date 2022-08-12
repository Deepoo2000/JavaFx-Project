module com.example.frama_login {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.frama_login to javafx.fxml;
    exports com.example.frama_login;
}