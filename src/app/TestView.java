package app;
import javax.swing.SwingUtilities;
// or
import java.awt.EventQueue; // Either of these imports will work for invokeLater

import interface_adapter.user_list.UserListState;
import static javax.swing.SwingUtilities.*;
import view.UserListView;
import view.UserListViewModel;

import java.awt.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Arrays;

public class TestView {

    public static void main(String[] args) {
    // Ensure the GUI is created on the Event Dispatch Thread for thread safety
        EventQueue.invokeLater(() -> {
        // Create the view model and state
        UserListState listViewState = new UserListState();
        UserListViewModel viewModel = new UserListViewModel(listViewState);
        ArrayList<String> users = new ArrayList<>(Arrays.asList("User 1", "User 2", "User 3"));
        // Populate the list with dummy data for testing
        listViewState.setUserNames(users);

        viewModel.setState(listViewState);

        // Create the view, passing in the view model
        UserListView userListView = new UserListView(viewModel);

        // Set up the frame that will hold our UserListView
        JFrame frame = new JFrame("User List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(userListView); // Add the UserListView to the frame
        frame.pack(); // Size the frame based on the preferred sizes of its components
        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setVisible(true); // Make the frame visible
    });

}}


