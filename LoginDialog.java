import javax.swing.*;
import java.awt.*;

public class LoginDialog extends JDialog {
    private JTextField userField = new JTextField(15);
    private JPasswordField passField = new JPasswordField(15);
    private boolean authenticated = false;

    public LoginDialog() {
        setTitle("Logowanie");
        setModal(true);
        setLayout(new GridLayout(3, 2, 5, 5));

        add(new JLabel(" Login:")); add(userField);
        add(new JLabel(" Hasło:")); add(passField);

        JButton loginBtn = new JButton("Zaloguj");
        loginBtn.addActionListener(e -> verify());
        add(loginBtn);

        pack();
        setLocationRelativeTo(null);
    }

    private void verify() {
        String user = userField.getText();
        String pass = new String(passField.getPassword());

        if (user.equals("admin") && pass.equals("admin123")) {
            Session.login(user, "ADMIN");
            authenticated = true;
            dispose();
        } else if (user.equals("user") && pass.equals("user123")) {
            Session.login(user, "USER");
            authenticated = true;
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Błędne dane!", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean isAuthenticated() { return authenticated; }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception e) {}

        LoginDialog login = new LoginDialog();
        login.setVisible(true);

        if (login.isAuthenticated()) {
            new MainFrame().setVisible(true);
        }
    }
}
