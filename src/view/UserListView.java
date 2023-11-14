package view;
import entity.User;
import interface_adapter.user_list.UserListState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;

public class UserListView extends JPanel implements ActionListener, PropertyChangeListener {
    private final UserListViewModel userListViewModel;
    private final JPanel userCardsPanel;

    public UserListView(UserListViewModel viewModel) {
        this.userListViewModel = viewModel;
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
}
