package view;

import interface_adapter.profile.ProfileController;
import interface_adapter.profile.ProfileViewModel;
import entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ProfileView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "profile";

    private final ProfileViewModel profileViewModel;

    final JButton connectButton;

    private JTextArea freeTextMessageArea;

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

        connectButton = new JButton(ProfileViewModel.CONNECT_BUTTON_LABEL);
        connectButton.addActionListener(this);
        this.add(connectButton);

        freeTextMessageArea = new JTextArea(5,20);
        JScrollPane scrollPane = new JScrollPane(freeTextMessageArea);
        this.add(scrollPane);

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
        if (e.getSource() == connectButton) {
            User recipient = getRecipientUser();
            String freeTextMessage = freeTextMessageArea.getText();
            profileController.onConnectButtonClick(recipient, freeTextMessage);
        }
    }

    private User getRecipientUser() {
        // TODO: Replace with actual logic to get the recipient User object
        // This could be from the selection in a list or any other component in your UI
        return null; // Placeholder
    }

    public void showSuccessMessage() {
        JOptionPane.showMessageDialog(this, "Email sent successfully.");
    }

    public void showErrorMessage(String s) {
        JOptionPane.showMessageDialog(this, "Email send failed.");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
