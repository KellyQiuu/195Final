package view;

import interface_adapter.self_profile.SelfProfileController;
import interface_adapter.self_profile.SelfProfileViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SelfProfileView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "profile";

    private final SelfProfileViewModel profileViewModel;

    final JButton update;
    private final SelfProfileController profileController;

    public SelfProfileView(SelfProfileViewModel profileViewModel, SelfProfileController profileController) {
        this.profileController = profileController;
        this.profileViewModel = profileViewModel;
        this.profileViewModel.addPropertyChangeListener(this);

        JLabel header = new JLabel("Profile Information");
        header.setAlignmentX(Component.CENTER_ALIGNMENT);


        JPanel buttons = new JPanel();
        update = new JButton(SelfProfileViewModel.UPDATE_BUTTON_LABEL);
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
