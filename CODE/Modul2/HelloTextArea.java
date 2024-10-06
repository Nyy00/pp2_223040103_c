package CODE.Modul2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloTextArea extends JFrame {
    public HelloTextArea() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel inputLabel = new JLabel("Input your name: ");
        inputLabel.setBounds(130, 40, 200, 30);

        JTextField textField = new JTextField();
        textField.setBounds(130, 60, 100, 40);

        JButton button = new JButton("Submit");
        button.setBounds(130, 100, 100, 40);

        JTextArea textOutput = new JTextArea("");
        textOutput.setBounds(130, 140, 200, 100);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                textOutput.append("Hello, " + name + "\n");
                textField.setText("");
            }
        });

        this.add(inputLabel);
        this.add(textField);
        this.add(button);
        this.add(textOutput);

        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HelloTextArea frame = new HelloTextArea();
                frame.setVisible(true);
            }
        });
    }
}