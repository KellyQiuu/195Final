package data_access;

import entity.User;
import use_case.signup.SignupUserAccessInterface;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class UserDataAccessObject implements SignupUserAccessInterface {

    private final String filePath;
    private final Map<String, String> usersDataMap;

    public UserDataAccessObject() throws IOException {
        this.filePath = "./src/main/data_access/users.csv";
        this.usersDataMap = new HashMap<>();
        loadUsersFromFile();
    }

    private void loadUsersFromFile() throws IOException {
        List<String> lines;

        try {
            lines = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Error reading users file", e);
        }

        for (String line: lines) {
            String[] p = line.split(",");
            if (p.length >= 2) {
                usersDataMap.put(p[0], p[1]);
            }

        }

    }

    @Override
    // TODO: 11/8/2023 use api?
    public boolean checkValidEmail(String username) {
        return false;
    }

    @Override
    public boolean checkValidUsername(String username) {
        return !usersDataMap.containsKey(username);
    }

    @Override
    public void save(User user) {
        usersDataMap.put(user.getName(), user.getPassword());
        // Step 2: Append the new user's data to the CSV file
        String userData = user.getName() + "," + user.getPassword() + "\n"; // Format the user data for CSV

        try {
            Files.write(Paths.get(filePath), userData.getBytes(), StandardOpenOption.APPEND); // Append to the CSV file
        } catch (IOException e) {
            throw new RuntimeException("Error writing to users file", e);
        }
    }

}

