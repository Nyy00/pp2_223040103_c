package Tugas3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PatientManagementApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JTable tableHasilPasien; // Tabel untuk hasil inputan pasien
    private JTable tableHasilPemeriksaan; // Tabel untuk hasil inputan pemeriksaan

    public PatientManagementApp() {
        setTitle("Aplikasi Manajemen Pasien");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem itemPasien = new JMenuItem("Input Data Pasien");
        JMenuItem itemPemeriksaan = new JMenuItem("Input Data Pemeriksaan");
        JMenuItem itemDataPasien = new JMenuItem("Data Pasien");

        itemPasien.addActionListener(e -> cardLayout.show(mainPanel, "Pasien"));
        itemPemeriksaan.addActionListener(e -> cardLayout.show(mainPanel, "Pemeriksaan"));
        itemDataPasien.addActionListener(e -> showDataPasien());

        menu.add(itemPasien);
        menu.add(itemPemeriksaan);
        menu.add(itemDataPasien);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Main Panel with CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.add(createPatientForm(), "Pasien");
        mainPanel.add(createExaminationForm(), "Pemeriksaan");

        // Tabel untuk hasil inputan pasien
        tableHasilPasien = new JTable(new DefaultTableModel(new Object[]{"Nama", "Umur", "Alamat", "Jenis Kelamin", "Asuransi"}, 0));
        // Tabel untuk hasil inputan pemeriksaan
        tableHasilPemeriksaan = new JTable(new DefaultTableModel(new Object[]{"Nama Pasien", "Jenis Pemeriksaan", "Tingkat Kesehatan", "Tanggal Pemeriksaan", "Dokter"}, 0));

        add(mainPanel);
    }

    private JPanel createPatientForm() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(0, 2));

        JTextField txtNama = new JTextField();
        JTextField txtUmur = new JTextField();
        JTextArea txtAlamat = new JTextArea(3, 20);
        JRadioButton rbLaki = new JRadioButton("Laki-laki");
        JRadioButton rbPerempuan = new JRadioButton("Perempuan");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbLaki);
        genderGroup.add(rbPerempuan);
        JCheckBox cbAsuransi = new JCheckBox("Memiliki Asuransi");

        inputPanel.add(new JLabel("Nama:"));
        inputPanel.add(txtNama);
        inputPanel.add(new JLabel("Umur:"));
        inputPanel.add(txtUmur);
        inputPanel.add(new JLabel("Alamat:"));
        inputPanel.add(new JScrollPane(txtAlamat));
        inputPanel.add(new JLabel("Jenis Kelamin:"));
        inputPanel.add(rbLaki);
        inputPanel.add(new JLabel(""));
        inputPanel.add(rbPerempuan);
        inputPanel.add(cbAsuransi);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(e -> {
            DefaultTableModel model = (DefaultTableModel) tableHasilPasien.getModel();
            model.addRow(new Object[]{
                    txtNama.getText(),
                    txtUmur.getText(),
                    txtAlamat.getText(),
                    rbLaki.isSelected() ? "Laki-laki" : "Perempuan",
                    cbAsuransi.isSelected() ? "Ya" : "Tidak"
            });
            txtNama.setText("");
            txtUmur.setText("");
            txtAlamat.setText("");
            genderGroup.clearSelection();
            cbAsuransi.setSelected(false);
        });

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(btnSubmit, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createExaminationForm() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(0, 2));
    
        JTextField txtPasien = new JTextField();
        JComboBox<String> cbJenisPemeriksaan = new JComboBox<>(new String[]{"Umum", "Spesialis", "Darurat"});
        JSlider sliderTingkatKesehatan = new JSlider(0, 10); // Menggunakan slider untuk tingkat nyeri
        sliderTingkatKesehatan.setPaintTicks(true);
        sliderTingkatKesehatan.setPaintLabels(true);
        sliderTingkatKesehatan.setMajorTickSpacing(1);
        
        JSpinner spinnerTanggalPemeriksaan = new JSpinner(new SpinnerDateModel());
        JList<String> listDokter = new JList<>(new String[]{"Dokter W", "Dokter X", "Dokter Y", "Dokter Z"});
    
        inputPanel.add(new JLabel("Nama Pasien:"));
        inputPanel.add(txtPasien);
        inputPanel.add(new JLabel("Jenis Pemeriksaan:"));
        inputPanel.add(cbJenisPemeriksaan);
        inputPanel.add(new JLabel("Tingkat Kesehatan (0-10):"));
        inputPanel.add(sliderTingkatKesehatan);
        inputPanel.add(new JLabel("Tanggal Pemeriksaan:"));
        inputPanel.add(spinnerTanggalPemeriksaan);
        inputPanel.add(new JLabel("Dokter:"));
        inputPanel.add(new JScrollPane(listDokter));
    
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(e -> {
            DefaultTableModel model = (DefaultTableModel) tableHasilPemeriksaan.getModel();
            model.addRow(new Object[]{
                    txtPasien.getText(),
                    cbJenisPemeriksaan.getSelectedItem(),
                    sliderTingkatKesehatan.getValue(), // Menggunakan nilai dari slider
                    spinnerTanggalPemeriksaan.getValue(),
                    listDokter.getSelectedValue()
            });
            txtPasien.setText("");
            cbJenisPemeriksaan.setSelectedIndex(0);
            sliderTingkatKesehatan.setValue(0); // Reset slider ke 0
            spinnerTanggalPemeriksaan.setValue(new java.util.Date());
            listDokter.clearSelection();
        });
    
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(btnSubmit, BorderLayout.SOUTH);
        return panel;
    }

    private void showDataPasien() {
        JFrame frame = new JFrame("Data Pasien");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(tableHasilPasien), BorderLayout.NORTH);
        panel.add(new JScrollPane(tableHasilPemeriksaan), BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PatientManagementApp app = new PatientManagementApp();
            app.setVisible(true);
        });
    }
}