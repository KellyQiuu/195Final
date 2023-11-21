package view;

import interface_adapter.connect.ConnectController;
import interface_adapter.self_profile.SelfProfileController;
import interface_adapter.self_profile.SelfProfileViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SelfProfileView extends JDialog implements ActionListener, PropertyChangeListener {
    public final String viewName = "self_profile";

    private final ConnectController connectController;
    private SelfProfileViewModel profileViewModel;
    private final SelfProfileController profileController;

    private JLabel nameLabel, emailLabel, coursesLabel;
    private JLabel nameField, emailField, coursesField;
    private JButton connect;


    public SelfProfileView(SelfProfileViewModel profileViewModel, SelfProfileController profileController, ConnectController connectController) {

        this.profileController = profileController;
        this.profileViewModel = profileViewModel;
        this.profileViewModel.addPropertyChangeListener(this);
        this.connectController = connectController;

        JLabel title = new JLabel(SelfProfileViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        createUserInfo();

        LabelTextPanel usernameInfo = new LabelTextPanel(nameLabel, nameField);
        LabelTextPanel emailInfo = new LabelTextPanel(emailLabel, emailField);
        LabelTextPanel coursesInfo = new LabelTextPanel(coursesLabel, coursesField);

        JPanel buttons = new JPanel();


        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(title);
        add(usernameInfo);
        add(emailInfo);
        add(coursesInfo);
        add(buttons);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ensure the window closes properly
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true); // Make the window visible
    }

    private void createUserInfo() {
        nameLabel = new JLabel("Name:");
        emailLabel = new JLabel("Email:");
        coursesLabel = new JLabel("Courses:");


        nameField = new JLabel("");
        emailField = new JLabel("");
        coursesField = new JLabel(""); // Assuming getCourses() returns a List or similar

//		nameField.setEditable(false);
//		emailField.setEditable(false);
//		coursesField.setEditable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "actionPerformed");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
//        if ("state".equals(evt.getPropertyName())) {
//            nameField.setText(profileViewModel.getState().getUserName());
//            emailField.setText(profileViewModel.getState().getUserEmail());
//            coursesField.setText(profileViewModel.getState().getUserCourses().toString());
//        }
    }
}
