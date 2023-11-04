package view;

import view.UserListViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class UserListView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "User List";
    private final ViewModel userListViewModel;

    public UserListView(UserListViewModel userListViewModel) {
        this.userListViewModel = userListViewModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
