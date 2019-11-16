package architecture.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import architecture.databases.ContactDAO;
import architecture.model.Contact;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactController {
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
    private Button addContact;

    @FXML
    private TextField name;

    @FXML
    private TextField city;

    @FXML
    private TextField phone;

    @FXML
    private TableView<Contact> contactsTableView;

    @FXML
    private TableColumn<Contact, String> contacts_name;

    @FXML
    private TableColumn<Contact, String> contacts_city;

    @FXML
    private TableColumn<Contact, Integer> contacts_phone;

    @FXML
    private ContextMenu contextManu;

    @FXML
    private MenuItem menuItem;

    @FXML
    private Text error_msg;

    @FXML
    private Button showContacts;

    @FXML
    private void initialize() {
        System.out.println("ContactController initialized!");

        //phone accepts only digits
        phone.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0,9}")) {
                phone.setText(oldValue);
            }
        });
    }

    @FXML
    void onBtnAddContactClick(ActionEvent event) {
        System.out.println("Request for adding contact: " + name.getText() + city.getText() + phone.getText());
        error_msg.setText("");
        // TODO check not empty!
        if (ContactDAO.ifContactExist(name.getText())) {
            System.out.println("Contact exists already");
            error_msg.setText("Contact already exist");

        } else {
            System.out.println("Contact is new, adding it");
            Contact contact = new Contact(name.getText(), city.getText(), Integer.parseInt(phone.getText()));
            ContactDAO contactDAO = new ContactDAO();
            contactDAO.createContact(contact);
            contacts.add(contact);
        }
    }

    @FXML
    void onBtnShowContactsClick(ActionEvent event) {
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
    private void onClose() {
        Platform.exit();
        System.exit(0);
    }

    public void onAbout(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/about.fxml"));
        rootpane.getChildren().setAll(pane);
    }
}
