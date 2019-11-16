package architecture.databases;

import architecture.databases.contracts.DBUserStorage;
import architecture.model.Contact;
import architecture.model.User;

import java.util.HashMap;
import java.util.List;

public class TestUserStorage implements DBUserStorage {
    HashMap<String, User> users = new HashMap<>();

    public TestUserStorage(HashMap<String, User> initUsers) {
        users = initUsers;
        // console read
    }

    @Override
    public void createUser(String username, String password) {
        // happy flow: last step
        return;

    }

    @Override
    public User getUserByName(String username) {
        return users.get(username);
    }
}

//
//    public class TestConsole implements Console {
//        private List<String> testOutput;
//
//        public TestConsole(List<String> testOutput) {
//            this.testOutput = testOutput;
//        }
//
//        public String readLine(){}
