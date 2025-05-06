package org.example;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccount extends JFrame {
    private JPanel panel;
    private JLabel messageLabelUsername;
    private JLabel messageLabelPassword;
    private JTextField TextField1;
    private JPasswordField TextField2;
    private JButton Button;
    private final int WINDOW_WIDTH = 300;
    private final int WINDOW_HEIGHT = 140;

    public CreateAccount(){
        setTitle("New Account");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        buildPanel();
        add(panel);
        setVisible(true);
    }
    private void buildPanel(){
        messageLabelUsername = new JLabel("Enter a new Username: ");
        messageLabelPassword = new JLabel("Enter a new Password: ");
        TextField1 = new JTextField(10);
        TextField2 = new JPasswordField(10);
        Button = new JButton("Create Account");
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
            int UserLength = username.length();
            int PasswordLength = password.length();
            if(UserLength >= 4 && PasswordLength >= 7){
                JOptionPane.showMessageDialog(CreateAccount.this, "New Account Created");
                VirusChecker checker = new VirusChecker();
                checker.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(CreateAccount.this, "Invalid Username or Password");
            }

        }
    }
    public static void main(String[] args){ new LoginMenu(); }
}