package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VirusChecker extends JFrame {
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem FileCheckMenuItem;
    private JMenuItem RunMenuItem;
    public VirusChecker(){
        initialize();
    }
    private void initialize(){
        frame = new JFrame();
        frame.setTitle("Virus Checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,300);
        frame.setLayout(new BorderLayout(10,10));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        Font f = new Font("Serif", Font.PLAIN, 18);
        UIManager.put("Menu.font", f);
        UIManager.put("MenuItem.font", f);
        UIManager.put("Button.font", f);
        UIManager.put("RadioButtonMenuItem.font",f);

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        RunMenuItem = new JMenuItem("Run PC Scan");
        FileCheckMenuItem = new JMenuItem("Select File");
        fileMenu.add(RunMenuItem);
        fileMenu.add(FileCheckMenuItem);
        RunMenuItem.addActionListener(new RunVirusScan ());
        FileCheckMenuItem.addActionListener(new FileCheck ());
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.add(new JLabel(new ImageIcon("images/VIRUS DETECTOR.png")));
        frame.setVisible(true);
    }
    private class RunVirusScan implements ActionListener{
        public void actionPerformed(ActionEvent e){

        }
    }
    private class FileCheck implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter fileNameExtensionFilter =
                    new FileNameExtensionFilter("Image file", "jpg", "jpeg", "PNG");
            jFileChooser.addChoosableFileFilter(fileNameExtensionFilter);

            int checkInput = jFileChooser.showOpenDialog(null);

            if (checkInput == JFileChooser.APPROVE_OPTION) {
                File openedFile = jFileChooser.getSelectedFile();
            }
        }
    }
    public static void main(String[] args){ new VirusChecker(); }
}