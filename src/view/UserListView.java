package view;
import entity.User;
import interface_adapter.user_list.UserListController;
import interface_adapter.user_list.UserListState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;

public class UserListView extends JPanel implements ActionListener, PropertyChangeListener {
    private final UserListViewModel userListViewModel;
    private final JPanel userCardsPanel;
    public final String viewName ="User List";
    public final UserListController userListController;

    public UserListView(UserListViewModel viewModel, UserListController controller) {
        this.userListViewModel = viewModel;
        this.userListController = controller;
        this.userCardsPanel = new JPanel();
        userCardsPanel.setLayout(new BoxLayout(userCardsPanel, BoxLayout.Y_AXIS));

        setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(userCardsPanel);
        add(scrollPane, BorderLayout.CENTER);

        viewModel.addPropertyChangeListener(evt -> {
            if ("state".equals(evt.getPropertyName())) {
                updateUserCards();
            }
        });

        // Add a component listener to trigger controller's execute method when this view is shown
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                userListController.execute(); // Call the execute method on the controller
            }
        });

        this.setVisible(true);
    }

    private void updateUserCards() {
        userCardsPanel.removeAll();
        ArrayList<String> userDisplayData = userListViewModel.getUserDisplayData();
        for (String userInfo : userDisplayData) {
            String[] parts = userInfo.split("\n");
            String userName = parts[0].trim();
            // Split the courses string by comma and convert it into an ArrayList
            ArrayList<String> courses = new ArrayList<>(Arrays.asList(parts[2].split(", ")));

            UserCardPanel cardPanel = new UserCardPanel(userName, courses);
            userCardsPanel.add(cardPanel);
        }
        userCardsPanel.revalidate();
        userCardsPanel.repaint();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // Action handling code
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Property change handling code
    }

    public String getViewName() {
        return viewName;
    }
}
