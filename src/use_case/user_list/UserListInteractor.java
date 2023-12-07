package use_case.user_list;
import java.io.IOException;
import java.util.*;

import entity.GeneralUser;
import entity.User;
import entity.UserFactory;
import use_case.UserSecession;


public class UserListInteractor implements UserListInputBoundary {

    private GeneralUser currentUser;
    final UserListDataAccessInterface userDataAccessObject;
    final UserListOutputBoundary userListPresenter;

    public UserListInteractor(
                              UserListDataAccessInterface userDataAccessObject,
                              UserListOutputBoundary userListPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.userListPresenter = userListPresenter;

    }
    public void setCurrentUser() throws IOException {


        String currentUserName = UserSecession.getInstance().getCurrentUserName();
        System.out.println("(UserList Interactor): current user is retrived, it is "+currentUserName);
        this.currentUser = userDataAccessObject.get(currentUserName);
        System.out.println("(UserList Interactor): current user object is got from DAO: "+ this.currentUser);

        System.out.println("Real user is created, "+this.currentUser);
    }

    @Override
    public void execute() throws IOException {
        // I will add to the map everytime the usecase is executed, and I would not store this anywhere
        // this means the map gets updated per login.
        setCurrentUser();

        ArrayList<GeneralUser> all = userDataAccessObject.getAllUsers();
        Map<GeneralUser, Integer> userSimilarityScore = new HashMap<>();
        for(GeneralUser u:all){
            if (!u.getId().equals(currentUser.getId()) ||
            !u.getName().equals(currentUser.getName()) ||
            !u.getEmail().equals(currentUser.getEmail())) {

                int similarity = calculateSimilarity(currentUser, u);
                userSimilarityScore.put(u, similarity);

        }

        }

        // sort the Map based on the scores and output an arrayList of users
        List<GeneralUser> sorted = new ArrayList<>(userSimilarityScore.keySet()); // unsorted list
        // for any two users, define them to be comparable based on simiarlity score, and sort based on way to compare them
        sorted.sort((user1, user2) -> userSimilarityScore.get(user2) - userSimilarityScore.get(user1));

        System.out.println("UFake user is Sorted, "+sorted);

        UserListOutputData output = new UserListOutputData((ArrayList<GeneralUser>) sorted);

        userListPresenter.prepareSuccessView(output);
    }

    private int calculateSimilarity(GeneralUser currentUser, GeneralUser u) {
        // for now define the score as the number of common courses that two users both take.
        Set<String> commonCourses = new HashSet<>(currentUser.getCourses());
        List<String> courses = u.getCourses();
        commonCourses.retainAll(courses); // keep only the courses that the other user also take
        return commonCourses.size();

    }
    }
