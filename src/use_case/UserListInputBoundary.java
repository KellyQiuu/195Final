package use_case;

import entity.User;

import java.util.List;

public interface UserListInputBoundary {
    List<User> execute();
}
