package org.example;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewUserReturnUser extends JFrame {
    private JPanel panel;
    private JButton Button1;
    private JButton Button2;
    private final int WINDOW_WIDTH = 300;
    private final int WINDOW_HEIGHT = 80;

    public NewUserReturnUser(){
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
        Button1 = new JButton("   New User   ");
        Button1.addActionListener(new NewUserReturnUser.NewListen());
        Button2 = new JButton("Returning User");
        Button2.addActionListener(new NewUserReturnUser.ReturnListen());
        panel = new JPanel();
        panel.add(Button1);
        panel.add(Button2);
    }
    private class NewListen implements ActionListener{
        public void actionPerformed(ActionEvent e){
            CreateAccount account = new CreateAccount();
            account.setVisible(true);
        }
    }
    private class ReturnListen implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            LoginMenu login = new LoginMenu();
            login.setVisible(true);
        }
    }
    public static void main(String[] args){ new NewUserReturnUser(); }
}
