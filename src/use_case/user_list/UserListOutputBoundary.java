
package use_case.user_list;
import use_case.UserListOutputData;

public interface UserListOutputBoundary {
    void prepareSuccessView(UserListOutputData clear);
}
