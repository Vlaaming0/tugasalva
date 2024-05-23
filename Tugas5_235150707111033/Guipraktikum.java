import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Guipraktikum {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Page1().setVisible(true));
    }
}

class Page1 extends JFrame {
    private JTextField NamaLengkapField, TTLField, NoDaftarField, NoTelpField, emailField;
    private JTextArea AlamatField;

    public Page1() {
        setTitle("Pengisian Data Mahasiswa");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(60, 179, 113));
        JLabel titleLabel = new JLabel("Pengisian Data Mahasiswa");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);

        JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        formPanel.setBackground(new Color(255, 250, 240));

        JLabel fullNameLabel = new JLabel("Nama Lengkap                 :");
        fullNameLabel.setForeground(new Color(0, 128, 128));
        NamaLengkapField = new JTextField();
        NamaLengkapField.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 128)));

        JLabel dobLabel = new JLabel("Tanggal Lahir (yyyy-mm-dd)               :");
        dobLabel.setForeground(new Color(0, 128, 128));
        TTLField = new JTextField();
        TTLField.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 128)));

        JLabel registrationNumberLabel = new JLabel("Nomor Pendaftaran                    :");
        registrationNumberLabel.setForeground(new Color(0, 128, 128));
        NoDaftarField = new JTextField();
        NoDaftarField.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 128)));

        JLabel phoneLabel = new JLabel("No. Telp                    :");
        phoneLabel.setForeground(new Color(0, 128, 128));
        NoTelpField = new JTextField();
        NoTelpField.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 128)));

        JLabel addressLabel = new JLabel("Alamat                   :");
        addressLabel.setForeground(new Color(0, 128, 128));
        AlamatField = new JTextArea(3, 20);
        AlamatField.setLineWrap(true);
        AlamatField.setWrapStyleWord(true);
        AlamatField.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 128)));
        JScrollPane addressScrollPane = new JScrollPane(AlamatField);

        JLabel emailLabel = new JLabel("E-mail                   :");
        emailLabel.setForeground(new Color(0, 128, 128));
        emailField = new JTextField();
        emailField.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 128)));

        JButton nextButton = new JButton("Next");
        nextButton.setBackground(new Color(30, 144, 255));
        nextButton.setForeground(Color.WHITE);
        nextButton.setFocusPainted(false);
        nextButton.setFont(new Font("Arial", Font.BOLD, 14));
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isAllFieldsFilled()) {
                    String NamaLengkap = NamaLengkapField.getText();
                    String TTL = TTLField.getText();
                    String NoDaftar = NoDaftarField.getText();
                    String NoTelp = NoTelpField.getText();
                    String Alamat = AlamatField.getText();
                    String email = emailField.getText();

                    konfirmasi Konfirmasi = new konfirmasi(NamaLengkap, TTL, NoDaftar, NoTelp, Alamat, email);
                    Konfirmasi.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(Page1.this, "Please fill in all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }

            private boolean isAllFieldsFilled() {
                return !NamaLengkapField.getText().isEmpty() && !TTLField.getText().isEmpty() && !NoDaftarField.getText().isEmpty()
                        && !NoTelpField.getText().isEmpty() && !AlamatField.getText().isEmpty() && !emailField.getText().isEmpty();
            }
        });

        formPanel.add(fullNameLabel);
        formPanel.add(NamaLengkapField);
        formPanel.add(dobLabel);
        formPanel.add(TTLField);
        formPanel.add(registrationNumberLabel);
        formPanel.add(NoDaftarField);
        formPanel.add(phoneLabel);
        formPanel.add(NoTelpField);
        formPanel.add(addressLabel);
        formPanel.add(addressScrollPane);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(new JLabel());
        formPanel.add(nextButton);

        add(titlePanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
    }
}

class konfirmasi extends JFrame {
    public konfirmasi(String fullName, String dob, String registrationNumber, String phone, String address, String email) {
        setTitle("Konfirmasi Data");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(60, 179, 113));
        JLabel titleLabel = new JLabel("Konfirmasi Data");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);

        JPanel confirmationPanel = new JPanel(new GridLayout(9, 2, 10, 10));
        confirmationPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        confirmationPanel.setBackground(new Color(255, 250, 240));

        JLabel fullNameLabel = new JLabel("Nama Lengkap:");
        JLabel fullNameValue = new JLabel(fullName);
        fullNameLabel.setForeground(new Color(0, 128, 128));

        JLabel dobLabel = new JLabel("Tanggal Lahir:");
        JLabel dobValue = new JLabel(dob);
        dobLabel.setForeground(new Color(0, 128, 128));

        JLabel registrationNumberLabel = new JLabel("Nomor Pendaftaran:");
        JLabel registrationNumberValue = new JLabel(registrationNumber);
        registrationNumberLabel.setForeground(new Color(0, 128, 128));

        JLabel phoneLabel = new JLabel("No. Telp:");
        JLabel phoneValue = new JLabel(phone);
        phoneLabel.setForeground(new Color(0, 128, 128));

        JLabel addressLabel = new JLabel("Alamat:");
        JLabel addressValue = new JLabel("<html>" + address.replaceAll("\n", "<br>") + "</html>");
        addressLabel.setForeground(new Color(0, 128, 128));

        JLabel emailLabel = new JLabel("E-mail:");
        JLabel emailValue = new JLabel(email);
        emailLabel.setForeground(new Color(0, 128, 128));

        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(255, 69, 0));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Page1 page1 = new Page1();
                page1.setVisible(true);
                dispose();
            }
        });

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBackground(new Color(30, 144, 255));
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFocusPainted(false);
        confirmButton.setFont(new Font("Arial", Font.BOLD, 14));
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Page2 page2 = new Page2(fullName, dob, registrationNumber, phone, address, email);
                page2.setVisible(true);
                dispose();
            }
        });

        confirmationPanel.add(fullNameLabel);
        confirmationPanel.add(fullNameValue);
        confirmationPanel.add(dobLabel);
        confirmationPanel.add(dobValue);
        confirmationPanel.add(registrationNumberLabel);
        confirmationPanel.add(registrationNumberValue);
        confirmationPanel.add(phoneLabel);
        confirmationPanel.add(phoneValue);
        confirmationPanel.add(addressLabel);
        confirmationPanel.add(addressValue);
        confirmationPanel.add(emailLabel);
        confirmationPanel.add(emailValue);
        confirmationPanel.add(backButton);
        confirmationPanel.add(confirmButton);

        add(titlePanel, BorderLayout.NORTH);
        add(confirmationPanel, BorderLayout.CENTER);
    }
}

class Page2 extends JFrame {
    public Page2(String fullName, String dob, String registrationNumber, String phone, String address, String email) {
        setTitle("Data Mahasiswa");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(60, 179, 113));
        JLabel titleLabel = new JLabel("Data Mahasiswa");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);

        JPanel infoPanel = new JPanel(new GridLayout(8, 2, 10, 10));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        infoPanel.setBackground(new Color(255, 250, 240));

        JLabel fullNameLabel = new JLabel("Nama Lengkap:");
        JLabel fullNameValue = new JLabel(fullName);
        fullNameLabel.setForeground(new Color(0, 128, 128));

        JLabel dobLabel = new JLabel("Tanggal Lahir:");
        JLabel dobValue = new JLabel(dob);
        dobLabel.setForeground(new Color(0, 128, 128));

        JLabel registrationNumberLabel = new JLabel("Nomor Pendaftaran:");
        JLabel registrationNumberValue = new JLabel(registrationNumber);
        registrationNumberLabel.setForeground(new Color(0, 128, 128));

        JLabel phoneLabel = new JLabel("No. Telp:");
        JLabel phoneValue = new JLabel(phone);
        phoneLabel.setForeground(new Color(0, 128, 128));

        JLabel addressLabel = new JLabel("Alamat:");
        JLabel addressValue = new JLabel("<html>" + address.replaceAll("\n", "<br>") + "</html>");
        addressLabel.setForeground(new Color(0, 128, 128));

        JLabel emailLabel = new JLabel("E-mail:");
        JLabel emailValue = new JLabel(email);
        emailLabel.setForeground(new Color(0, 128, 128));

        infoPanel.add(fullNameLabel);
        infoPanel.add(fullNameValue);
        infoPanel.add(dobLabel);
        infoPanel.add(dobValue);
        infoPanel.add(registrationNumberLabel);
        infoPanel.add(registrationNumberValue);
        infoPanel.add(phoneLabel);
        infoPanel.add(phoneValue);
        infoPanel.add(addressLabel);
        infoPanel.add(addressValue);
        infoPanel.add(emailLabel);
        infoPanel.add(emailValue);

        add(titlePanel, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.CENTER);
    }
}
