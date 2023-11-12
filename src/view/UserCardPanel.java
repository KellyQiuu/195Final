package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class UserCardPanel extends JPanel{
    private String userName;

    public UserCardPanel(String userName) {
        this.userName = userName;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK)); // for card-like appearance
        add(new JLabel(userName), BorderLayout.CENTER);

        // Set the preferred size of the card, for example:
        setPreferredSize(new Dimension(200, 100));

        // Add mouse click event handling
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Call your method or functionality to handle user card click
                userCardClicked(userName);
            }
        });
    }

    private void userCardClicked(String userName) {
        JOptionPane.showMessageDialog(this, "User " + userName + " clicked!");
        // Implement further navigation or action here
    }

}
