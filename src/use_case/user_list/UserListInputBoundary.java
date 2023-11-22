package use_case.user_list;

import entity.User;

import java.io.IOException;
import java.util.List;

public interface UserListInputBoundary {
    void execute() throws IOException;
}
