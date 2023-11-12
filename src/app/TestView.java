package app;
import java.awt.EventQueue;

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
            ArrayList<String> users = new ArrayList<>(Arrays.asList("User 1", "User 2", "User 3"));
            listViewState.setUserNames(users); // Set the user names in the state
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


