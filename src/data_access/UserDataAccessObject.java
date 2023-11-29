package data_access;

import entity.GeneralUser;
import entity.User;
import entity.UserFactory;
import use_case.connect.ConnectDataAccessInterface;
import use_case.other_profile.OtherProfileDataAccessInterface;
import use_case.self_profile.SelfProfileDataAccessInterface;
import use_case.signup.SignupUserAccessInterface;
import use_case.login.LoginUserAccessInterface;
import use_case.user_list.UserListDataAccessInterface;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class UserDataAccessObject implements SignupUserAccessInterface, UserListDataAccessInterface,
        SelfProfileDataAccessInterface, LoginUserAccessInterface, OtherProfileDataAccessInterface, ConnectDataAccessInterface {

    private final String filePath;

    private final Map<String, String> usersDataMap;//should we refactor the name to "authentication"? since this is username+password

    //TODO:(Kelly)This needs to have String:User map.( For latter extensions and for Usecase Data Access).I would need to
    // Add one for now. Please see if changes needed for this added accounts attribute.

    private final Map<String, GeneralUser> usernameUserMap;

    private final ArrayList<GeneralUser> allUsers = new ArrayList<>();

    public UserDataAccessObject(UserFactory userFactory) throws IOException {

        System.out.println("UserDataAccess constructor reached");
        this.filePath = "src/data_access/users.csv";

        this.usersDataMap = new HashMap<>();
        this.usernameUserMap = new HashMap<>();

        loadUsersFromFile();
    }

    private void loadUsersFromFile() {
        List<String> lines;
        System.out.println("UserLoadFromFile is called");

        // Clear the list before loading users from file
        allUsers.clear();

        try {
            lines = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Error reading users file", e);
        }

        for (String line: lines) {
            String[] p = line.split(",");
            if (p.length >= 5) {
                usersDataMap.put(p[0], p[1]);
                //(Kelly): populating also the Account attribute here
                ArrayList<String> courses = turnCoursesIntoList(p[4]);
                //TODO: Please edit the creation of this courses ArrayList after changing the File format, including
                // email, courses info in the file.
                //create user object from the information stored in the file, put them in the allUsers list.
                GeneralUser user = UserFactory.createUser(p[0],p[1],p[2],p[3],courses);
                allUsers.add(user);

                // Update the usernameUserMap with the new user
                usernameUserMap.put(p[0], user);
                System.out.println("Loaded user: " + p[0]);
            }
        }
        System.out.println(allUsers);
    }

    private ArrayList<String> turnCoursesIntoList(String s) {
        //TODO:(ye) please implement this. This should be able to turn the String we get from the file into an ArrayList
        // of Strings. each String is a course name.
        return new ArrayList<>(Arrays.asList(s.split("\\+")));
    }

    private User turnUserIntoUserObject(String line) {
        String[] data = line.split(",");
        return new User(data[0], data[1], data[2], data[3], turnCoursesIntoList(data[4]));
    }


    @Override
    // TODO: 11/8/2023 use api?
    public boolean checkValidEmail(String email) {
//        return true;
        return EmailVerificationService.verifyEmail3(email);
    }

    @Override
    public boolean checkValidUsername(String username) {
        return !usersDataMap.containsKey(username);
    }

    @Override
    public boolean existsByName(String username) {
        return usersDataMap.containsKey(username);
    }

    @Override
    public GeneralUser get(String username) throws IOException {
        loadUsersFromFile();
        return usernameUserMap.get(username);
    }

    @Override
    public String getPass(String username) {
        return usersDataMap.get(username);
    }

    @Override
    public GeneralUser get2(String username) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length >= 5 && parts[0].equals(username)) {
                // Assuming the format is: username,password,email,id,courses
                ArrayList<String> courses = new ArrayList<>(Arrays.asList(parts[4].split("\\+")));
                return UserFactory.createUser(parts[0], parts[1], parts[2], parts[3], courses);
            }
        }
        return null;
    }


    @Override
    public void save(GeneralUser user) {
        usersDataMap.put(user.getName(), user.getPassword());

        String userData = user + "\n";
//        String userData = user.getName() + "," + user.getPassword()+ "," + user.getId()+ "," + user.getEmail()+ ","+
//                storeCourses(user)+"\n"; // Format the user data for CSV
        try {
            Files.write(Paths.get(filePath), userData.getBytes(), StandardOpenOption.APPEND); // Append to the CSV file
        } catch (IOException e) {
            throw new RuntimeException("Error writing to users file", e);
        }
    }

    // by Kelly: for UserList Interactor.
    @Override
    public ArrayList<GeneralUser> getAllUsers() {// by Kelly: for UserList Interactor.

        return allUsers;
    }

    // Get the current user object.
    @Override
    public GeneralUser getUser(String username) {
        if (usersDataMap.containsKey(username)) {
            for (GeneralUser i : getAllUsers()) {
                if (Objects.equals(i.getName(), username)) {
                    return i;
                }
            }
        }
        return null;
    }
}

