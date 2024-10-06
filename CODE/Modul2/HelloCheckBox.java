package CODE.Modul2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class HelloCheckBox extends JFrame {
    private boolean checked;

    public HelloCheckBox() {
        this.checked = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel inputLabel = new JLabel("Name: ");
        inputLabel.setBounds(15, 40, 350, 10);

        JTextField textField = new JTextField();
        textField.setBounds(15, 60, 350, 30);

        JCheckBox checkBox = new JCheckBox("I accept the terms and conditions");
        checkBox.setBounds(15, 100, 350, 30);

        JButton button = new JButton("Submit");
        button.setBounds(15, 150, 100, 40);

        JTextArea textOutput = new JTextArea("");
        textOutput.setBounds(15, 200, 350, 100);

        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                checked = e.getStateChange() == ItemEvent.SELECTED;
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checked) {
                    String name = textField.getText();
                    textOutput.append("Hallo, " + name + "\n");
                    textField.setText("");
                } else {
                    textOutput.append("Please accept the terms and conditions\n");
                }
            }
        });

        this.add(inputLabel);
        this.add(textField);
        this.add(checkBox);
        this.add(button);
        this.add(textOutput);

        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HelloCheckBox frame = new HelloCheckBox();
                frame.setVisible(true);
            }
        });
    }
}