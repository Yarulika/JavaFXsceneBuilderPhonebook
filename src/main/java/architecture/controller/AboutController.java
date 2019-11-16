package architecture.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class AboutController {

    @FXML
    private AnchorPane rootpane;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu file;

    @FXML
    private MenuItem close;

    @FXML
    void onClose(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
}
