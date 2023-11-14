package use_case.user_list;
import java.util.*;

import entity.User;
import entity.UserFactory;
import use_case.SessionManagerInteractor;



public class UserListInteractor implements UserListInputBoundary {

    private User currentUser;
    final UserListDataAccessInterface userDataAccessObject;
    final UserListOutputBoundary userListPresenter;

    public UserListInteractor(
                              UserListDataAccessInterface userDataAccessObject,
                              UserListOutputBoundary userListPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.userListPresenter = userListPresenter;

        // this.currentUser = SessionManagerInteractor.getCurrentUser();
        ArrayList<String> c = new ArrayList<>(Arrays.asList("CSC207","MAT237","CSC343","MAT246","MAT337"));
        this.currentUser = UserFactory.creatUser("myself", "123","12829929","randomemail@email.com",c);
        //TODO: change this to a real secession Manager
        System.out.println("UFake user is created, "+this.currentUser.toString());
    }
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public List<User> execute() {
        // I will add to the map everytime the usecase is executed, and I would not store this anywhere
        // this means the map gets updated per login.

        Map<User, Integer> userSimilarityScore = new HashMap<>();
        for(User u:userDataAccessObject.getAllUsers()){
            if (!u.getId().equals(currentUser.getId())) {
                int similarity = calculateSimilarity(currentUser, u);
                userSimilarityScore.put(u, similarity);
        }    }
        // sort the Map based on the scores and output an arrayList of users
        List<User> sorted = new ArrayList<>(userSimilarityScore.keySet()); // unsorted list
        // for any two users, define them to be comparable based on simiarlity score, and sort based on way to compare them
        sorted.sort((user1, user2) -> userSimilarityScore.get(user2) - userSimilarityScore.get(user1));

        System.out.println("UFake user is Sorted, "+sorted);
        return sorted;
        //TODO: change the fakeUser, to use it as input data. UserListInputData
    }

    private int calculateSimilarity(User currentUser, User u) {
        // for now define the score as the number of common courses that two users both take.
        Set<String> commonCourses = new HashSet<>(currentUser.getCourses());
        List<String> courses = u.getCourses();
        commonCourses.retainAll(courses); // keep only the courses that the other user also take
        return commonCourses.size();

    }
    }
