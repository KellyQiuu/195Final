package data_access;

import entity.User;

import java.util.List;

public class FileUserDataAccessObject {
    private final List<User> allUsers;

    public FileUserDataAccessObject(List<User> allUsers) {
        this.allUsers = allUsers;
    }
}
