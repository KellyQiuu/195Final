package app;
import java.awt.EventQueue;

import entity.User;
import entity.UserFactory;
import interface_adapter.user_list.UserListState;

import view.UserListView;
import view.UserListViewModel;


import javax.swing.*;

import java.util.ArrayList;
import java.util.Arrays;

public class TestView {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            // Create the view model with an empty state
            UserListState listViewState = new UserListState();
            UserListViewModel viewModel = new UserListViewModel(listViewState);

            // Create the view and pass in the view model
            UserListView userListView = new UserListView(viewModel);

            // Normally, you'd have a controller or interactor to handle the data fetching and updating
            // Here we'll simulate it directly for simplicity
            ArrayList<String> kellycourse = new ArrayList<>(Arrays.asList("CSC207","MAT237","CSC343","MAT246","MAT337"));

            User u1 = UserFactory.creatUser("Kelly", "Qiuwenyu",
                    "1008197602","qiuwenyu2021@outlook.com",kellycourse);

            ArrayList<String> yecourse = new ArrayList<>(Arrays.asList("CSC207","MAT240","CSC331","STA246","PSY137"));

            User u2 = UserFactory.creatUser("Ziyi Ye", "Yeziyi",
                    "100238392","ziyi.ye@outlook.com",yecourse);
            ArrayList<User> users = new ArrayList<>(Arrays.asList(u1,u2));

            listViewState.setUsers(users); // Set the user names in the state
            viewModel.setState(listViewState); // Update the view model's state
            viewModel.firePropertyChanged(); // Fire the property change event to update the view

            // Create and show the GUI
            JFrame frame = new JFrame("User List");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(userListView); // Add the UserListView to the frame
            frame.pack(); // Size the frame
            frame.setLocationRelativeTo(null); // Center the window
            frame.setVisible(true); // Show the window
        });
    }}


