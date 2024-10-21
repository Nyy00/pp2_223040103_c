package Modul2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloInput extends JFrame {
    public HelloInput() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel inputLabel = new JLabel("Input your name: ");
        inputLabel.setBounds(130, 40, 200, 30);

        JTextField textField = new JTextField();
        textField.setBounds(130, 60, 100, 40);

        JButton button = new JButton("Submit");
        button.setBounds(130, 100, 100, 40);

        JLabel labelOutput = new JLabel("");
        labelOutput.setBounds(130, 140, 200, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                labelOutput.setText("Hello, " + name);
            }
        });

        this.add(inputLabel);
        this.add(textField);
        this.add(button);
        this.add(labelOutput);

        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HelloInput frame = new HelloInput();
                frame.setVisible(true);
            }
        });
    }

}