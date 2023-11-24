package view;

import interface_adapter.other_profile.OtherProfileController;
import interface_adapter.user_list.UserListController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class UserListView extends JPanel implements PropertyChangeListener {
    private final UserListViewModel userListViewModel;

    private final JPanel userCardsPanel;
    public final String viewName = "User List";
    private final UserListController userListController;
    private ArrayList<ActionListener> listeners = new ArrayList<>();

    private OtherProfileController otherProfileController;

    public UserListView(UserListViewModel viewModel, UserListController controller, OtherProfileController otherProfileController) throws IOException {
        this.userListViewModel = viewModel;
        this.userListController = controller;
        this.userCardsPanel = new JPanel();
        userCardsPanel.setLayout(new BoxLayout(userCardsPanel, BoxLayout.Y_AXIS));
        this.otherProfileController = otherProfileController;

        setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(userCardsPanel);
        add(scrollPane, BorderLayout.CENTER);

        viewModel.addPropertyChangeListener(this);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                try {
                    userListController.execute();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        this.setVisible(true);
    }

    public void addUserCardClickedListener(ActionListener listener) {
        listeners.add(listener);
    }

    private void updateUserCards() {
        userCardsPanel.removeAll();
        ArrayList<String> userDisplayData = userListViewModel.getUserDisplayData();
        for (String userInfo : userDisplayData) {
            String[] parts = userInfo.split("\n");
            String userName = parts[0].trim();
            ArrayList<String> courses = new ArrayList<>(Arrays.asList(parts[2].split(", ")));

            UserCardPanel cardPanel = new UserCardPanel(userName, courses, e -> {
                try {
                    notifyUserCardClicked(userName);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
            addUserCardClickedListener(cardPanel.getListener());
            System.out.println("Added listener");
            userCardsPanel.add(cardPanel);
        }
        userCardsPanel.revalidate();
        userCardsPanel.repaint();
    }

    private void notifyUserCardClicked(String userName) throws IOException {
        otherProfileController.execute(userName);

    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            updateUserCards();
        }
    }

    public String getViewName() {
        return viewName;
    }
}
