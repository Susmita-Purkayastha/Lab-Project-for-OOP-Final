import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class AddressBookApp extends JFrame {
    private static final long serialVersionUID = 1L;

    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel addressLabel;
    private JTextField addressField;
    private JButton addButton;
    private JComboBox<String> comboBox;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JCheckBox checkBox;
    private JLabel imageLabel;

    public AddressBookApp() {
        setTitle("Address Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setContentPane(createMainPanel());

        String imageUrl = "https://media.istockphoto.com/id/1468287182/photo/handmade-address-book.jpg?s=1024x1024&w=is&k=20&c=hw1xDsfe8Kn_He2tn0ie-pD6dfy4NiTQVHtXIS7OoPo=";
        try {
            URL url = new URL(imageUrl);
            ImageIcon originalImageIcon = new ImageIcon(url);
            Image originalImage = originalImageIcon.getImage();
            Image resizedImage = originalImage.getScaledInstance(350, -1, Image.SCALE_SMOOTH);
            ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
            imageLabel = new JLabel(resizedImageIcon);
            add(imageLabel, BorderLayout.NORTH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(Color.decode("#FFFFFA"));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 2, 10, 10));
        formPanel.setBackground(Color.decode("#FFFFF6"));
        mainPanel.add(formPanel, BorderLayout.CENTER);

        nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.decode("#0A6EBD"));
        formPanel.add(nameLabel);

        nameField = new JTextField(20);
        formPanel.add(nameField);

        addressLabel = new JLabel("Address:");
        addressLabel.setForeground(Color.decode("#0A6EBD"));
        formPanel.add(addressLabel);

        addressField = new JTextField(20);
        formPanel.add(addressField);

        addButton = new JButton("Add");
        addButton.setBackground(Color.decode("#0A6EBD"));
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String address = addressField.getText();
                String option = (String) comboBox.getSelectedItem();
                String gender = maleRadioButton.isSelected() ? "Male" : "Female";
                boolean important = checkBox.isSelected();

                
                String message = "Name: " + name + "\n"
                        + "Address: " + address + "\n"
                        + "Option: " + option + "\n"
                        + "Gender: " + gender + "\n"
                        + "Important: " + (important ? "Yes" : "No");
                JOptionPane.showMessageDialog(AddressBookApp.this, message, "Contact Added", JOptionPane.INFORMATION_MESSAGE);

                
                nameField.setText("");
                addressField.setText("");
                comboBox.setSelectedIndex(0);
                maleRadioButton.setSelected(true);
                checkBox.setSelected(false);
            }
        });
        mainPanel.add(addButton, BorderLayout.SOUTH);

        comboBox = new JComboBox<>(new String[]{"Friend", "Family", "Work"});
        comboBox.setForeground(Color.decode("#0A6EBD"));
        comboBox.setBackground(Color.decode("#FFFFF6"));
        formPanel.add(new JLabel("Options:"));
        formPanel.add(comboBox);

        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(maleRadioButton);
        radioGroup.add(femaleRadioButton);
        formPanel.add(new JLabel("Gender:"));
        formPanel.add(maleRadioButton);
        formPanel.add(new JLabel(""));
        formPanel.add(femaleRadioButton);

        checkBox = new JCheckBox("Important");
        checkBox.setForeground(Color.decode("#0A6EBD"));
        formPanel.add(new JLabel("Check Box:"));
        formPanel.add(checkBox);

        return mainPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AddressBookApp();
            }
        });
    }
}
