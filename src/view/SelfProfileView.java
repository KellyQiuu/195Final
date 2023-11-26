package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.self_profile.SelfProfileController;
import interface_adapter.self_profile.SelfProfileViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


/**
 * This class represents the self profile view in the GUI.
 * It extends JPanel and is used to display and interact with the user's own profile.
 */
public class SelfProfileView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "self_profile";
    private SelfProfileViewModel profileViewModel;
    private ViewManagerModel viewManagerModel;
    private final SelfProfileController profileController;
    private JLabel nameLabel, emailLabel, coursesLabel;
    private JLabel nameField, emailField, coursesField;
    private JButton backButton;

    /**
     * Constructor for SelfProfileView.
     * Initializes the view with necessary components and configurations.
     *
     * @param profileController The controller that handles the logic for this view.
     * @param profileViewModel The self profile view model created for handling the data.
     */
    public SelfProfileView(ViewManagerModel viewManagerModel, SelfProfileViewModel profileViewModel, SelfProfileController profileController) {

        this.profileController = profileController;
        this.profileViewModel = profileViewModel;
        this.profileViewModel.addPropertyChangeListener(this);
        this.viewManagerModel = viewManagerModel;

        JLabel title = new JLabel(SelfProfileViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        createUserInfo();

        LabelTextPanel usernameInfo = new LabelTextPanel(nameLabel, nameField);
        LabelTextPanel emailInfo = new LabelTextPanel(emailLabel, emailField);
        LabelTextPanel coursesInfo = new LabelTextPanel(coursesLabel, coursesField);

        backButton = new JButton("Go Back");
        backButton.addActionListener(e -> goBack());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(backButton);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(title);
        centerPanel.add(usernameInfo);
        centerPanel.add(emailInfo);
        centerPanel.add(coursesInfo);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(topPanel);
        add(centerPanel);
        setSize(400, 300);
    }

    private void createUserInfo() {
        nameLabel = new JLabel("Name:");
        emailLabel = new JLabel("Email:");
        coursesLabel = new JLabel("Courses:");


        nameField = new JLabel("");
        emailField = new JLabel("");
        coursesField = new JLabel(""); // Assuming getCourses() returns a List or similar

    }
    /**
     * Action handler for events in the self profile view.
     * This method is triggered when an action is performed on a component in the view.
     *
     * @param e The ActionEvent that occurred.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "actionPerformed");
    }

    /**
     * Updates the profile information displayed on the view.
     * This method is typically called when the profile data has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            nameField.setText(profileViewModel.getState().getUserName());
            emailField.setText(profileViewModel.getState().getUserEmail());
            String courses = profileViewModel.getState().getUserCourses().toString();
            coursesField.setText(courses.substring(1, courses.length()-1));
        }
    }

    public void goBack() {
        String previousView = viewManagerModel.getPreviousView();
        if (previousView != null) {
            viewManagerModel.setActiveView(previousView);
            viewManagerModel.firePropertyChanged();
        }
    }
    public String getViewName() {
        return viewName;
    }
}
