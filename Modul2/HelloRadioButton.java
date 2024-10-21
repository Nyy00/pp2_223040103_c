package Modul2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloRadioButton extends JFrame {
    public HelloRadioButton() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel inputLabel = new JLabel("Input your name: ");
        inputLabel.setBounds(15, 40, 350, 10);

        JTextField textField = new JTextField();
        textField.setBounds(15, 60, 350, 30);

        JLabel radioLabel = new JLabel("Membership: ");
        radioLabel.setBounds(15, 100, 350, 10);

        JRadioButton radio1 = new JRadioButton("Silver");
        radio1.setBounds(15, 115, 350, 30);

        JRadioButton radio2 = new JRadioButton("Gold");
        radio2.setBounds(15, 145, 350, 30);

        JRadioButton radio3 = new JRadioButton("Platinum");
        radio3.setBounds(15, 175, 350, 30);

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        group.add(radio3);

        JButton button = new JButton("Submit");
        button.setBounds(15, 205, 100, 40);

        JTextArea textOutput = new JTextArea("");
        textOutput.setBounds(15, 250, 350, 100);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String membershipType = "";

                if (radio1.isSelected()) {
                    membershipType = radio1.getText();
                }

                if (radio2.isSelected()) {
                    membershipType = radio2.getText();
                }

                if (radio3.isSelected()) {
                    membershipType = radio3.getText();
                }

                String name = textField.getText();
                textOutput.append("Hello, " + name + "\n");
                textOutput.append("Your membership type is " + membershipType + "\n");
                textField.setText("");
            }
        });

        this.add(inputLabel);
        this.add(textField);
        this.add(radioLabel);
        this.add(radio1);
        this.add(radio2);
        this.add(radio3);
        this.add(button);
        this.add(textOutput);

        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HelloRadioButton frame = new HelloRadioButton();
                frame.setVisible(true);
            }
        });
    }
}