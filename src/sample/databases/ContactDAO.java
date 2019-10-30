package sample.databases;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sample.model.Contact;
import java.util.List;

public class ContactDAO {

    public void createContact(Contact contact) {
        Transaction transaction = null;
        try {
            Session session = HibConfig.getSessionFactory().getCurrentSession();
            // start a transaction
            transaction = session.beginTransaction();

            // save the person object
            session.save(contact);
            // commit transaction
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public List<Contact> getContacts() {
        Transaction transaction = null;
        try {
            Session session = HibConfig.getSessionFactory().getCurrentSession();
            // start a transaction
            transaction = session.beginTransaction();

            List<Contact> result =  session.createCriteria(Contact.class)
                    .list();

            transaction.commit();
            return result;

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            return null;
        }
    }

}
