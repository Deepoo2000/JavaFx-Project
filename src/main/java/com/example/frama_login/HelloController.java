package com.example.frama_login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloController extends CRUD_Operations{
    @FXML
    private DatePicker BirthDay;

    @FXML
    private TextField Email;

    @FXML
    private PasswordField Password;

    @FXML
    private TextField Username;

    @FXML
    private TextField Name;

    @FXML
    private Button BtnSignUp;

    @FXML
    private Button BtnSignIn;

    @FXML
    private Button BtnClear;

    @FXML
    private Label BtnMessage;

    @FXML
    void FunSignIn(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        stage.close();
        stage.setScene(getScene("SignIn.fxml"));
        stage.show();
    }

    Scene getScene(String scenePath){
        Parent parent;
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(scenePath));
            parent = loader.load();
        } catch (Exception e)
        {
            return null;
        }

        Scene scene = new Scene(parent , 500 , 300);
        return scene;

    }

    @FXML
    void FunSignUp(ActionEvent event) throws SQLException, ClassNotFoundException {

        try{
            Insert(this.Name.getText(), this.Username.getText(), this.Password.getText(),
                    this.Email.getText(), this.BirthDay.getEditor().getText());
            BtnMessage.setText("Success >> Bro");
        }
        catch (SQLException e){
            BtnMessage.setText("Your Email is already exist....");
        }
    }

    @FXML
    void FunDelete(ActionEvent event) throws SQLException, ClassNotFoundException {
         Delete(this.Name.getText());
    }

    @FXML
    void FunUpdate(ActionEvent event) throws SQLException {
        Update(this.Name.getText(), this.Username.getText(), this.Password.getText(),
                this.Email.getText(), this.BirthDay.getEditor().getText());
    }

    @FXML
    void FunClear(ActionEvent event) {
        this.Name.clear();
        this.Username.clear();
        this.Password.clear();
        this.Email.clear();
        this.BirthDay.getEditor().clear();
    }
}