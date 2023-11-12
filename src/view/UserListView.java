package view;
import interface_adapter.user_list.UserListState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class UserListView extends JPanel implements ActionListener, PropertyChangeListener {

    private final UserListViewModel userListViewModel;
    private final JPanel userCardsPanel;
    /// private final JList<String> userListDisplay;
    // private final DefaultListModel<String> listModel;

    public UserListView(UserListViewModel viewModel) {
        this.userListViewModel = viewModel;
        this.userCardsPanel = new JPanel();
        userCardsPanel.setLayout(new BoxLayout(userCardsPanel, BoxLayout.Y_AXIS));

        // Layout
        setLayout(new BorderLayout());

        // Scroll pane for user cards
        JScrollPane scrollPane = new JScrollPane(userCardsPanel);
        add(scrollPane, BorderLayout.CENTER);

        // Observe changes in the view model
        viewModel.addPropertyChangeListener(evt -> {
            if ("state".equals(evt.getPropertyName())) {
                updateUserCards((UserListState) evt.getNewValue());
            }
        });
    }

    // Method to update the card display based on the state
    private void updateUserCards(UserListState state) {
        userCardsPanel.removeAll();
        for (String userName : state.getUserNames()) {
            UserCardPanel cardPanel = new UserCardPanel(userName);
            userCardsPanel.add(cardPanel);
        }
        userCardsPanel.revalidate();
        userCardsPanel.repaint();
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //TODO: see what this will do


    }

}
