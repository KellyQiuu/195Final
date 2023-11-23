package use_case.connect;

import entity.User;
import java.io.IOException;

public interface ConnectDataAccessInterface {
    User get(String username) throws IOException;
}
