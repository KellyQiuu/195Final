
package use_case.user_list;


import java.io.IOException;

public interface UserListOutputBoundary {
    void prepareSuccessView(UserListOutputData sortedUsers) throws IOException;

}
