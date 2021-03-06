package architecture.controller;

import architecture.databases.UserDAO;
import architecture.model.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegisterController {
    private List<User> users = new ArrayList<>();

    @FXML
    private AnchorPane rootpane;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password_id;

    @FXML
    private TextField first_password;

    @FXML
    private PasswordField confirm_passwd;

    @FXML
    private Button register_btn;

    @FXML
    private Button back_btn;

    @FXML
    private Label err_msg;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu file;

    @FXML
    private MenuItem close;

    @FXML
    private Menu help;

    @FXML
    void onBtnRegister(ActionEvent event) {
        System.out.println("Request for adding user: " + username.getText() + password_id.getText() + confirm_passwd.getText());
        err_msg.setText("");

        if ((username.getText().trim().equals("")) || (password_id.getText().trim().equals("")) || (confirm_passwd.getText().trim().equals(""))){
            err_msg.setText("username & password & confirm password shall be filled in!");
            return;
        }
        else if (!password_id.getText().trim().equals(confirm_passwd.getText().trim())){
            err_msg.setText("password & confirm password differ!");
            return;
        }
        else {
            if (UserDAO.ifUserExists(username.getText())) {
                System.out.println("Username exists already");
                err_msg.setText("username already exists");

            } else {
                System.out.println("Username is new, adding it");
                User user = new User(username.getText(), password_id.getText());
                UserDAO userDAO = new UserDAO();
                userDAO.createUser(user);
                err_msg.setText("User added");
                users.add(user);
            }
            //UseCases.addContact()
        }
    }

    @FXML
    void onBtnBack(ActionEvent event) throws IOException {
        System.out.println("onBtnBack clicked");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/login.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    public void onClose(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    public void onAbout(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/about.fxml"));
        rootpane.getChildren().setAll(pane);
    }
}
