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
        contacts.add(new Contact(name.getText(), city.getText(), Integer.parseInt(phone.getText()) ));
        contactsList.getItems().add(String.format("Name: %s, city: %s, phone: %s", name.getText(), city.getText(), phone.getText()));
    }

    @FXML
    void onBtnShowContactsClick(ActionEvent event) {
        System.out.println("Contacts: ");
    }

}
