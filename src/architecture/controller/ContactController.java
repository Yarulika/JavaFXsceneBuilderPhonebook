package architecture.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import architecture.databases.ContactDAO;
import architecture.model.Contact;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class ContactController {
    private List<Contact> contacts = new ArrayList<>();

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
    private ListView<String> contactsList;

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
        for (Contact con : contacts) {
            contactsList.getItems().add(con.toString());
        }

//        Contact contact = ContactDAO.getContactByName("Gio");
////        System.out.println("if exist " + contact.toString() );
//        System.out.println("if exist " + ContactDAO.ifContactExist("Gio") );
//        ContactDAO.deleteContact(contact);
    }
}
