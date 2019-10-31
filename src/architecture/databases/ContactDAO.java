package architecture.databases;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import architecture.model.Contact;

import java.util.List;
import java.util.function.Function;

public class ContactDAO {

    public static void createContact(Contact contact) {
        withDBSession(session -> {
            session.save(contact);
            return contact;
        });


    }

    public static void deleteContact(Contact contact) {
        Transaction transaction = null;
        try {
            Session session = HibConfig.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(contact);
            transaction.commit();
//            session.close();
        } catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    //query -> withDBSession
    private static <T> T withDBSession(Function<Session, T> function) {
        Session session = HibConfig.getSessionFactory().getCurrentSession();
        Transaction transaction = null;

        T out = null;
        try {
            transaction = session.beginTransaction();
            out = function.apply(session);
            System.out.println("From function " + out);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        session.close();
        System.out.println("before return " + out);
        return out;
    }

    public static Contact getContactByName(String name) {
        try {
            Session session = HibConfig.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            Query query = session.createQuery("from Contact where name=:name", Contact.class);
            query.setParameter("name", name);
            Contact contact = (Contact) query.uniqueResult();

//            session.close();
            return contact;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }


//        try {
//            Session session = HibConfig.getSessionFactory().getCurrentSession();
//                    session.beginTransaction();
//
//            Contact contact = session.find(Contact.class, name);
//            return contact;
//        } catch (Exception ex){
//            ex.printStackTrace();
//            return null;
//        }
    }

    public static boolean ifContactExist(String name) {
        Session session = HibConfig.getSessionFactory().getCurrentSession();
        boolean result = false;
        Contact contact = getContactByName(name);

        if (contact != null) {
            result = true;
        }
//        session.close();
        return result;
    }

    public static List<Contact> getContacts() {
        Session session = HibConfig.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Contact");
        List<Contact> list = query.list();

//        session.close();
        return list;
    }
}
