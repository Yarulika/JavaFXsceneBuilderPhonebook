package architecture.databases;

import architecture.model.Contact;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;

public class ContactListener {

    @PostPersist
    public void contactCreated(Contact contact){
        System.out.println("Contact created:" + contact.getName());
    }

    @PostLoad
    public void printContact(Contact contact){
        System.out.println("Contact loaded:" + contact.getName());
    }
}
