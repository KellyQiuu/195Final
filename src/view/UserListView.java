package view;
import interface_adapter.user_list.UserListState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserListView extends JPanel {

    private final UserListViewModel userListViewModel;
    private final JList<String> userListDisplay;
    private final DefaultListModel<String> listModel;

    public UserListView(UserListViewModel viewModel) {
        this.userListViewModel = viewModel;
        this.userListDisplay = new JList<>();
        this.listModel = new DefaultListModel<>();

        // Set up the JList with the list model
        userListDisplay.setModel(listModel);
        userListDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Layout
        setLayout(new BorderLayout());

        // Scroll pane for user list
        JScrollPane scrollPane = new JScrollPane(userListDisplay);
        add(scrollPane, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel();
        JButton viewDetailsButton = new JButton("View Details");
        JButton deleteUserButton = new JButton("Delete User");
        buttonPanel.add(viewDetailsButton);
        buttonPanel.add(deleteUserButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Register listeners for buttons
        viewDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle view details action
            }
        });

        deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle delete user action
            }
        });

        // Observe changes in the view model
        viewModel.addPropertyChangeListener(evt -> {
            if ("userList".equals(evt.getPropertyName())) {
                updateListDisplay((UserListState) evt.getNewValue());
            }
        });
    }

    // Method to update the list display based on the state
    private void updateListDisplay(UserListState state) {
        listModel.clear();
        for (String userName : state.getUserNames()) {
            listModel.addElement(userName);
        }
    }
}
