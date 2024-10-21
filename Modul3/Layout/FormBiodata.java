import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormBiodata extends JFrame {
    // Components
    private JTextField txtNama;
    private JTextField txtNomorHP;
    private JRadioButton rbLakilaki;
    private JRadioButton rbPerempuan;
    private ButtonGroup bgJenisKelamin;
    private JButton btnSimpan;

    public FormBiodata() {
        // Set up the frame
        setTitle("Form Biodata");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel lblNama = new JLabel("Nama:");
        txtNama = new JTextField(5);

        JLabel lblNomorHP = new JLabel("Nomor HP:");
        txtNomorHP = new JTextField(5);

        JLabel lblJenisKelamin = new JLabel("Jenis Kelamin:");
        rbLakilaki = new JRadioButton("Laki-laki");
        rbPerempuan = new JRadioButton("Perempuan");
        bgJenisKelamin = new ButtonGroup();
        bgJenisKelamin.add(rbLakilaki);
        bgJenisKelamin.add(rbPerempuan);

        btnSimpan = new JButton("Simpan");

        // Add components to the frame
        add(lblNama);
        add(txtNama);
        add(lblNomorHP);
        add(txtNomorHP);
        add(lblJenisKelamin);
        add(rbLakilaki);
        add(rbPerempuan);
        add(btnSimpan);

        // Add action listener to the button
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the input values
                String nama = txtNama.getText();
                String nomorHP = txtNomorHP.getText();
                String jenisKelamin = rbLakilaki.isSelected() ? "Laki-laki" : "Perempuan";

                // Display the input values
                JOptionPane.showMessageDialog(null, "Nama: " + nama + "\nNomor HP: " + nomorHP + "\nJenis Kelamin: " + jenisKelamin);
            }
        });

        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new FormBiodata();
    }
}