package architecture.databases;

import architecture.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.function.Function;

public class UserDAO {

    public static void createUser(User user) {
        withDBSession(session -> {
            session.save(user);
            return user;
        });
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

    public static User getUserByUsername(String username) {
        User user = null;
        try {
            //without transaction for select: openSession
            Session session = HibConfig.getSessionFactory().openSession();
            Query query = session.createQuery("from User where username=:username", User.class);
            query.setParameter("username", username);
            user = (User) query.uniqueResult();
            session.close();
            return user;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public static boolean ifUserExists(String username) {
        // Session session = HibConfig.getSessionFactory().getCurrentSession();
        boolean result = false;
        User user = getUserByUsername(username);
        if (user != null) {
            result = true;
        }
        return result;
    }
}
