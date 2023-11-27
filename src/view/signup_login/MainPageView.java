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
        Title.setFont(new Font("Arial", Font.BOLD, 24));
        Title.setForeground(Color.black);

        // Sign Up Button
        Signup = new JButton("Sign Up");
        Signup.setFont(new Font("Arial", Font.BOLD, 14));
        Signup.setPreferredSize(new Dimension(200, 50));

        // Log In Button
        Login = new JButton("Log In");
        Login.setFont(new Font("Arial", Font.BOLD, 14));
        Login.setPreferredSize(new Dimension(200, 50));

        Signup.setBackground(Color.LIGHT_GRAY); // Example color
        Login.setBackground(Color.LIGHT_GRAY); // Example color

        // Add components to the panel
        add(Title, gbc);
        gbc.insets = new Insets(20, 0, 5, 0);
        add(Signup, gbc);
        gbc.insets = new Insets(5, 0, 20, 0);
        add(Login, gbc);


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
