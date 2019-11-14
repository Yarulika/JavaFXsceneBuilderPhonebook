package architecture.controller;

import architecture.databases.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import architecture.Main;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField userName;

    @FXML
    private PasswordField userPass;

    @FXML
    private Button loginBtn;

    @FXML
    private Button registerBtn;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu file;

    @FXML
    private MenuItem close;

    @FXML
    private Menu help;

    @FXML
    private Label err_msg;

    @FXML
    private AnchorPane rootpane;

    @FXML
    private void initialize() {
        System.out.println("LoginController initialized!");
    }

    @FXML
    void onBtnLogin(ActionEvent event) throws IOException {
        System.out.println("onBtnLogin clicked");

        if (userName.getText().trim().equals("") || userPass.getText().trim().equals("")) {
            err_msg.setText("username and password shall not be empty!");
            return;
        }
        else if (!UserDAO.ifUserExists(userName.getText())){
            err_msg.setText("username was not found");
            return;
        }
        else if (!UserDAO.getUserByUsername(userName.getText()).getPassword().equals(userPass.getText().trim())){
            err_msg.setText("password is wrong");
            return;
        }
        else {
            AnchorPane pane = FXMLLoader.load(Main.class.getResource("view/form.fxml"));
            rootpane.getChildren().setAll(pane);
        }
    }

    @FXML
    void onBtnRegisterNew(ActionEvent event) throws IOException {
        System.out.println("onBtnRegisterNew clicked");

        AnchorPane pane = FXMLLoader.load(Main.class.getResource("view/register.fxml"));
        rootpane.getChildren().setAll(pane);
    }
}
