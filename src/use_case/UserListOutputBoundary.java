package use_case;
import use_case.UserListOutputData;

public interface UserListOutputBoundary {
    void prepareSuccessView(UserListOutputData clear);
}
//TODO:(Kelly) what is going on? why is this outside the case?