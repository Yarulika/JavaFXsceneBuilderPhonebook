package architecture.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import architecture.Main;

import java.io.IOException;

public class LoginController  {

    @FXML
    private TextField loginName;

    @FXML
    private TextField loginPassword;

    @FXML
    private Button loginBtn;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu file;

    @FXML
    private MenuItem close;

    @FXML
    private Menu help;

    @FXML
    private AnchorPane rootpane;

    @FXML
    private void initialize() {
        System.out.println("LoginController initialized!");
    }

    @FXML
    void onBtnLogin(ActionEvent event) throws IOException {
        System.out.println("onBtnLogin clicked");
        AnchorPane pane = FXMLLoader.load(Main.class.getResource("view/form.fxml"));
        rootpane.getChildren().setAll(pane);
    }
}
