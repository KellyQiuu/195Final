package view.signup_login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageView extends JPanel {

    private SignupView signupView;

    private LoginView loginView;

    private JButton Signup;

    private JButton Login;

    private JLabel Title;

    public MainPageView(CardLayout cardLayout, JPanel views, SignupView signupView, LoginView loginView) {
        this.signupView = signupView;
        this.loginView = loginView;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title label
        Title = new JLabel("CourseMate Connect", SwingConstants.CENTER);
        Title.setFont(new Font("Arial", Font.BOLD, 30));
        Title.setForeground(Color.black);
        // Title position
        gbc.insets = new Insets(50, 0, 100, 0);
        add(Title, gbc);

        // Sign Up Button
        Signup = new JButton("Sign Up");
        Signup.setFont(new Font("Arial", Font.BOLD, 14));
        Signup.setPreferredSize(new Dimension(150, 40));

        // Log In Button
        Login = new JButton("Log In");
        Login.setFont(new Font("Arial", Font.BOLD, 14));
        Login.setPreferredSize(new Dimension(150, 40));

        // Add some space between the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(Signup);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(Login);
        buttonPanel.setOpaque(false);

        Signup.setBackground(Color.LIGHT_GRAY); // Example color
        Login.setBackground(Color.LIGHT_GRAY); // Example color

        // Add components to the panel
//        add(Title, gbc);
//        gbc.insets = new Insets(20, 0, 5, 0);
//        add(Signup, gbc);
//        gbc.insets = new Insets(5, 0, 20, 0);
//        add(Login, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 0, 20, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        add(buttonPanel, gbc);


        // Set background color of the panel
        setBackground(Color.white); // Example color to match the screenshot


        Signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(views, signupView.viewName);
            }
        });
        add(Signup);


        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(views, loginView.viewName);
            }
        });
        add(Login);
    }
}
