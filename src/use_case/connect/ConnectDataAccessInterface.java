package use_case.connect;

import entity.User;

public interface ConnectDataAccessInterface {
    User getUserByUsername(String username);
}
