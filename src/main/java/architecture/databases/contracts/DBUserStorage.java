package architecture.databases.contracts;

import architecture.model.User;

public interface DBUserStorage {

    void createUser(String username, String password);
    User getUserByName(String username);

}
