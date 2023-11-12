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

    private final JButton connectButton;

    private final JTextArea freeTextMessageArea;

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

        connectButton = new JButton("Connect");
        connectButton.addActionListener(this);

        freeTextMessageArea = new JTextArea(5, 20);
        freeTextMessageArea.setLineWrap(true);
        freeTextMessageArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(freeTextMessageArea);

        // Arrange components on the panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(connectButton);
        add(scrollPane);

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
            User recipient = getRecipientUser(); // Implement this method to retrieve the displayed profile
            String freeTextMessage = freeTextMessageArea.getText();
            profileController.onConnectButtonClick(recipient, freeTextMessage);
        } else if (e.getSource() == update) {
            // Handle the update action
        }
    }

    private User getRecipientUser() {
        // TODO: Implement the logic to retrieve the User object that is currently being viewed on the profile
        return null;
    }

    public void showSuccessMessage() {
        JOptionPane.showMessageDialog(this, "Email sent successfully.");
    }

    public void showErrorMessage(String s) {
        JOptionPane.showMessageDialog(this, "Email send failed.");
    }


    @Override
    //public void actionPerformed(ActionEvent e) {

    //}

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
