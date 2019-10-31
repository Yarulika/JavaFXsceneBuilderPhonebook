package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.databases.ContactDAO;
import sample.model.Contact;

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
    private TextField error_msg;

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
        if (!ContactDAO.ifContactExist(name.getText())){
                System.out.println("Adding contact: " + name.getText() + city.getText() + phone.getText());
                Contact contact = new Contact(name.getText(), city.getText(), Integer.parseInt(phone.getText()));
                ContactDAO contactDAO = new ContactDAO();
                contactDAO.createContact(contact);
                contacts.add(contact);
            } else {
            error_msg.setText("Contact already exist");
        }
    }


//    private void handleLogin(ActionEvent event) {
//        if(QueryDAO.isValidUser(usernameText.getText(), passwordText.getText())){
//            try {
//                Parent root = FXMLLoader.load((getClass().getClassLoader().getResource("fxml/phonebook_registry.fxml")));
//                Stage stage = (Stage) loginButton.getScene().getWindow();
//                stage.setScene(new Scene(root));
//
//                QueryDAO.getAllRegistry();
//            } catch (IOException io) {
//                io.printStackTrace();
//            }
//        } else {
//            errorText.setText("Invalid Username or Password!");
//        }
//    }



    @FXML
    void onBtnShowContactsClick(ActionEvent event) {
//        System.out.println("Show Contacts onBtnShowContactsClick");
//        ContactDAO contactDAO = new ContactDAO();
//        contacts = contactDAO.getContacts();
//        for (Contact con : contacts) {
//            contactsList.getItems().add(con.toString());
//        }


//        Contact contact = ContactDAO.ifContactExist("Gio");
//        Contact contact = ContactDAO.getContactByName("Gio");
//        System.out.println("if exist " + contact.toString() );
        System.out.println("if exist " + ContactDAO.ifContactExist("Gio") );



    }

}
