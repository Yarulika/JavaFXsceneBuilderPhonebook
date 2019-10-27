package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class Controller {
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
    private Button showContacts;


    public Controller(){
    }

    @FXML
    private void initialize(){
        System.out.println("Controller initialized!");
    }

    @FXML
    void onBtnAddContactClick(ActionEvent event) {
        System.out.println("Adding contact: " + name.getText() + city.getText() + phone.getText());

        Contact contact = new Contact(name.getText(), city.getText(), Integer.parseInt(phone.getText()) );
        ContactDAO contactDAO = new ContactDAO();
        contactDAO.createContact(contact);

        contacts.add(contact);
    }

    @FXML
    void onBtnShowContactsClick(ActionEvent event) {
        System.out.println("Show Contacts Click");
        ContactDAO contactDAO = new ContactDAO();
        contacts = contactDAO.getContacts();
        for (Contact con: contacts){
            contactsList.getItems().add(con.toString());
        }
    }
}
