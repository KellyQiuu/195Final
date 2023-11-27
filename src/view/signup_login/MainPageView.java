package view.signup_login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageView extends JPanel {

    private SignupView signupView;

    private LoginView loginView;
    private JButton btnSignup;
    private JButton btnLogin;

    public MainPageView(CardLayout cardLayout, JPanel views, SignupView signupView, LoginView loginView) {
        this.signupView = signupView;
        this.loginView = loginView;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Sign Up Button
        btnSignup = new JButton("Sign Up");
        btnSignup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(views, signupView.viewName); // Replace "SignupView" with the correct identifier used in your CardLayout
            }
        });
        add(btnSignup);

        // Log In Button
        btnLogin = new JButton("Log In");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(views, loginView.viewName); // Replace "LoginView" with the correct identifier used in your CardLayout
            }
        });
        add(btnLogin);
    }
}
