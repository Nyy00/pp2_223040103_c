package Modul2.Latihan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Latihan1 extends JFrame {
    public Latihan1() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(130, 40, 200, 30);

        JTextField nameField = new JTextField();
        nameField.setBounds(130, 60, 100, 40);

        JLabel phoneLabel = new JLabel("Phone: ");
        phoneLabel.setBounds(130, 100, 200, 30);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(130, 120, 100, 40);

        JButton button = new JButton("Submit");
        button.setBounds(130, 160, 100, 40);

        JTextArea textOutput = new JTextArea("");
        textOutput.setBounds(130, 200, 200, 100);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String phone = phoneField.getText();
                textOutput.append("Name: " + name + "\nPhone: " + phone + "\n" + "______________________\n");
                nameField.setText("");
                phoneField.setText("");
            }
        });

        this.add(nameLabel);
        this.add(nameField);
        this.add(phoneLabel);
        this.add(phoneField);
        this.add(button);
        this.add(textOutput);

        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Latihan1 frame = new Latihan1();
                frame.setVisible(true);
            }
        });
    }
}