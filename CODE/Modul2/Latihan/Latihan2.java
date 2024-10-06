package CODE.Modul2.Latihan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Latihan2 extends JFrame {
    public Latihan2() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(16, 16, 350, 10);

        JTextField nameField = new JTextField();
        nameField.setBounds(16, 32, 350, 30);

        JLabel phoneLabel = new JLabel("Phone: ");
        phoneLabel.setBounds(16, 72, 350, 10);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(16, 88, 350, 30);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(16, 128, 350, 10);

        JRadioButton maleRadio = new JRadioButton("Laki-Laki");
        maleRadio.setBounds(16, 144, 350, 30);

        JRadioButton femaleRadio = new JRadioButton("Perempuan");
        femaleRadio.setBounds(16, 176, 350, 30);

        ButtonGroup group = new ButtonGroup();
        group.add(maleRadio);
        group.add(femaleRadio);

        JButton button = new JButton("Submit");
        button.setBounds(16, 256, 100, 40);

        JTextArea textOutput = new JTextArea("");
        textOutput.setBounds(16, 312, 350, 100);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String phone = phoneField.getText();
                String gender = maleRadio.isSelected() ? maleRadio.getText() : femaleRadio.getText();

                textOutput.append("Name: " + name +
                        "\nPhone: " + phone +
                        "\nGender: " + gender +
                        "\n" +
                        "______________________\n");
                nameField.setText("");
            }
        });

        this.add(nameLabel);
        this.add(nameField);
        this.add(phoneLabel);
        this.add(phoneField);
        this.add(genderLabel);
        this.add(maleRadio);
        this.add(femaleRadio);
        this.add(button);
        this.add(textOutput);

        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Latihan2 frame = new Latihan2();
                frame.setVisible(true);
            }
        });
    }
}