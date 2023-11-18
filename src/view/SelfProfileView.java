package view;

import interface_adapter.other_profile.OtherProfileViewModel;
import interface_adapter.self_profile.SelfProfileController;
import interface_adapter.self_profile.SelfProfileViewModel;
import interface_adapter.signup.SignupState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SelfProfileView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "profile";

    private final SelfProfileViewModel profileViewModel;
    private final SelfProfileController profileController;

    private JLabel nameLabel, emailLabel, coursesLabel, passwordLabel;
    private JTextField nameField, emailField, coursesField, passwordField;


    public SelfProfileView(SelfProfileViewModel profileViewModel, SelfProfileController profileController) {
        this.profileController = profileController;
        this.profileViewModel = profileViewModel;
        this.profileViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(SelfProfileViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        createUserInfo();

        LabelTextPanel usernameInfo = new LabelTextPanel(nameLabel, nameField);
        LabelTextPanel emailInfo = new LabelTextPanel(emailLabel, emailField);
        LabelTextPanel passwordInfo = new LabelTextPanel(passwordLabel, passwordField);
        LabelTextPanel coursesInfo = new LabelTextPanel(coursesLabel, coursesField);
    }

//    private JPanel createHeader() {
//        JPanel headerPanel = new JPanel();
//        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
//        JLabel header = new JLabel("User Information");
//        header.setFont(new Font("Arial", Font.BOLD, 16));
//        headerPanel.add(header);
//        return headerPanel;
//    }
    private void createUserInfo() {
        nameLabel = new JLabel("Name:");
        emailLabel = new JLabel("Email:");
        coursesLabel = new JLabel("Courses:");
        passwordLabel = new JLabel("Password");

        nameField = new JTextField(profileViewModel.getUser().getName());
        emailField = new JTextField(profileViewModel.getUser().getEmail());
        coursesField = new JTextField(profileViewModel.getUser().getCourses().toString()); // Assuming getCourses() returns a List or similar
        passwordField = new JTextField(profileViewModel.getUser().getPassword());


        nameField.setEditable(false);
        emailField.setEditable(false);
        coursesField.setEditable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "NOTHING");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }
    }
}
