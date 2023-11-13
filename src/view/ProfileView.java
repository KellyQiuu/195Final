package view;

import interface_adapter.profile.ProfileController;
import interface_adapter.profile.ProfileViewModel;
import interface_adapter.profile.ProfileState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ProfileView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "profile";

    private final ProfileViewModel profileViewModel;

    final JButton update;
    private final ProfileController profileController;

    public ProfileView(ProfileViewModel profileViewModel, ProfileController profileController) {
        this.profileController = profileController;
        this.profileViewModel = profileViewModel;
        this.profileViewModel.addPropertyChangeListener(this);

        JLabel header = new JLabel("Profile Information");
        header.setAlignmentX(Component.CENTER_ALIGNMENT);


        JPanel buttons = new JPanel();
        update = new JButton(ProfileViewModel.UPDATE_BUTTON_LABEL);
        buttons.add(update);

        update.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    }
                }
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
