package CODE.Modul2.Latihan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LatihanFinal extends JFrame {
    public LatihanFinal() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel for the input form
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0, 2, 10, 10)); // Using GridLayout for form layout

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");

        menuBar.add(menu);

        JMenuItem reset = new JMenuItem("Reset");
        JMenuItem exit = new JMenuItem("Exit");

        menu.add(reset);
        menu.add(exit);

        // Labels and fields for inputs
        JLabel nameLabel = new JLabel("Name: ");
        JTextField nameField = new JTextField();

        JLabel addressLabel = new JLabel("Address: ");
        JTextField addressField = new JTextField();

        JLabel phoneLabel = new JLabel("Phone: ");
        JTextField phoneField = new JTextField();

        JLabel genderLabel = new JLabel("Gender:");
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JRadioButton maleRadio = new JRadioButton("Laki-Laki");
        JRadioButton femaleRadio = new JRadioButton("Perempuan");
        ButtonGroup group = new ButtonGroup();
        group.add(maleRadio);
        group.add(femaleRadio);
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);

        JLabel savingTypeLabel = new JLabel("Saving Type:");
        JList<String> savingTypeList = new JList<>(new String[]{"Regular", "Gold", "Platinum", "Diamond"});
        savingTypeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane savingTypeScroll = new JScrollPane(savingTypeList);

        JLabel transactionFrequencyLabel = new JLabel("Transaction Frequency:");
        JSlider transactionFrequencySlider = new JSlider(1, 100, 1);
        transactionFrequencySlider.setMajorTickSpacing(10);
        transactionFrequencySlider.setMinorTickSpacing(1);
        transactionFrequencySlider.setPaintLabels(true);
        transactionFrequencySlider.setPaintTicks(true);

        JLabel passwordLabel = new JLabel("Password: ");
        JPasswordField passwordField = new JPasswordField();

        JLabel confirmPasswordLabel = new JLabel("Confirm Password: ");
        JPasswordField confirmPasswordField = new JPasswordField();

        JLabel dateOfBirthLabel = new JLabel("Tanggal Lahir: ");
        JSpinner dateOfBirthSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateOfBirthSpinner, "dd/MM/yyyy");
        dateOfBirthSpinner.setEditor(dateEditor);

        // Button to submit form
        JButton button = new JButton("Submit");

        // Text area for output result (will be on the right)
        JTextArea textOutput = new JTextArea();
        textOutput.setEditable(false); // prevent editing
        JScrollPane outputScroll = new JScrollPane(textOutput);

        // Add components to the input panel in a grid layout
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(addressLabel);
        inputPanel.add(addressField);
        inputPanel.add(phoneLabel);
        inputPanel.add(phoneField);
        inputPanel.add(genderLabel);
        inputPanel.add(genderPanel);
        inputPanel.add(savingTypeLabel);
        inputPanel.add(savingTypeScroll);
        inputPanel.add(transactionFrequencyLabel);
        inputPanel.add(transactionFrequencySlider);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);
        inputPanel.add(confirmPasswordLabel);
        inputPanel.add(confirmPasswordField);
        inputPanel.add(dateOfBirthLabel);
        inputPanel.add(dateOfBirthSpinner);
        inputPanel.add(new JLabel()); // empty cell for alignment
        inputPanel.add(button);

        // Submit button action listener
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String address = addressField.getText();
                String phone = phoneField.getText();
                String gender = maleRadio.isSelected() ? maleRadio.getText() : femaleRadio.getText();
                String savingType = savingTypeList.getSelectedValue();
                int transactionFrequency = transactionFrequencySlider.getValue();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());
                String dateOfBirth = dateEditor.getFormat().format(dateOfBirthSpinner.getValue());

                if (!password.equals(confirmPassword)) {
                    textOutput.append("Password does not match\n");
                    return;
                }

                textOutput.append("Name: " + name +
                        "\nAddress: " + address +
                        "\nPhone: " + phone +
                        "\nGender: " + gender +
                        "\nSaving Type: " + savingType +
                        "\nTransaction Frequency: " + transactionFrequency +
                        "\nDate of Birth: " + dateOfBirth +
                        "\n______________________\n");

                // Clear form fields after submission
                nameField.setText("");
                addressField.setText("");
                phoneField.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
                group.clearSelection();
                savingTypeList.clearSelection();
                transactionFrequencySlider.setValue(1);
            }
        });

        // Reset button action listener
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                addressField.setText("");
                phoneField.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
                group.clearSelection();
                savingTypeList.clearSelection();
                transactionFrequencySlider.setValue(1);
            }
        });

        // Exit button action listener
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Use JSplitPane to split the input panel (left) and output text area (right)
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, inputPanel, outputScroll);
        splitPane.setDividerLocation(400); // Set initial divider location (400 pixels)
        splitPane.setOneTouchExpandable(true); // Enable quick collapsing/expanding

        this.setJMenuBar(menuBar);
        this.add(splitPane); // Add the split pane to the frame

        this.setSize(800, 600); // adjust size as necessary
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LatihanFinal frame = new LatihanFinal();
                frame.setVisible(true);
            }
        });
    }
}
