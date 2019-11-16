package architecture.controller;

import architecture.databases.ContactDAO;
import architecture.model.Contact;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactsOperationsController {
    private List<Contact> contacts = new ArrayList<>();

    @FXML
    private AnchorPane rootpane;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu file;

    @FXML
    private MenuItem close;

    @FXML
    private Menu help;

    @FXML
    private Button showContacts;

    @FXML
    private TableView<Contact> contactsTableView;

    @FXML
    private TableColumn<Contact, String> contacts_name;

    @FXML
    private TableColumn<Contact, String> contacts_city;

    @FXML
    private TableColumn<Contact, String> contacts_phone;

    @FXML
    private Button btn_add_contact;

    @FXML
    private void initialize() {
        System.out.println("Show Contacts onBtnShowContactsClick");
        ContactDAO contactDAO = new ContactDAO();
        contacts = contactDAO.getContacts();

        contacts_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        contacts_city.setCellValueFactory(new PropertyValueFactory<>("city"));
        contacts_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        for (Contact contact: contacts){
            contactsTableView.getItems().add(contact);
        }
    }

    @FXML
    void onBtnAddContact(ActionEvent event) throws IOException {
        System.out.println("onBtnAddContact clicked");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/form.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    public void onClose(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
}
