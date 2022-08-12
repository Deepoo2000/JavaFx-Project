package com.example.frama_login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class SignIn extends CRUD_Operations{
    @FXML
    private TextField Sign_in_Email;

    @FXML
    private PasswordField Sign_In_Password;

    @FXML
    private Button BtnSignIn;

    @FXML
    private Label PrintMassage;

    @FXML
    void FunSignIn(ActionEvent event) throws SQLException {
        if(Search(Sign_in_Email.getText(), Sign_In_Password.getText())> 0)
        PrintMassage.setText("success >> Bro");
        else PrintMassage.setText("Enter A valid Email and Password");
    }
}
