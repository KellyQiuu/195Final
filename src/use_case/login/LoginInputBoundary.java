package use_case.login;

import java.io.IOException;

public interface LoginInputBoundary {

    void login(LoginInputData loginInputData) throws IOException;

}
