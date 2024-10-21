package Modul2;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEventSwing extends JFrame {
    public ButtonEventSwing() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Hello World");
        label.setBounds(130, 40, 400, 10);

        JButton button = new JButton("Click Me");
        button.setBounds(100, 100, 100, 40);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Hello Programming II");
            }
        });

        this.add(button);
        this.add(label);

        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ButtonEventSwing frame = new ButtonEventSwing();
                frame.setVisible(true);
            }
        });
    }
}