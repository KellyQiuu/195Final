package use_case.connect;

import entity.GeneralUser;

import java.io.IOException;

public interface ConnectDataAccessInterface {
    GeneralUser get(String username) throws IOException;
}
