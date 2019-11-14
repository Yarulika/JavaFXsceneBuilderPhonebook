package architecture.databases;

import architecture.model.User;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;

public class UserListener {

    @PostPersist
    public void userCreated(User user) {
        System.out.println("User created:" + user.getUsername());
    }

    @PostLoad
    public void printUser(User user) {
        System.out.println("User loaded:" + user.getUsername());
    }

}
