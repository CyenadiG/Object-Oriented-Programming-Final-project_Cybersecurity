package org.example;
import javafx.scene.control.PasswordField;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginMenu extends JFrame {
    private JPanel panel;
    private JLabel messageLabelUsername;
    private JLabel messageLabelPassword;
    private JTextField TextField1;
    private JPasswordField TextField2;
    private JButton Button;
    private final int WINDOW_WIDTH = 300;
    private final int WINDOW_HEIGHT = 140;

    public LoginMenu(){
        setTitle("Virus Checker Login");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        buildPanel();
        add(panel);
        setVisible(true);
    }
    private void buildPanel(){
        messageLabelUsername = new JLabel("Enter your Username: ");
        messageLabelPassword = new JLabel("Enter your Password: ");
        TextField1 = new JTextField(10);
        TextField2 = new JPasswordField(10);
        Button = new JButton("Login");
        Button.addActionListener(new LoginListen());
        panel = new JPanel();
        panel.add(messageLabelUsername);
        panel.add(TextField1);
        panel.add(messageLabelPassword);
        panel.add(TextField2);
        panel.add(Button);
    }
    private class LoginListen implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = TextField1.getText();
            String password = TextField2.getText();
            if(username.equals("admin") && password.equals("admin")){
                JOptionPane.showMessageDialog(LoginMenu.this, "Login Successful");
                VirusChecker checker = new VirusChecker();
                checker.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(LoginMenu.this, "Wrong Username or Password");
            }

        }
    }
    public static void main(String[] args){ new LoginMenu(); }
}
