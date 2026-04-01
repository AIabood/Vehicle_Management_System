import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VehicleManagementGUI extends JFrame {
    private final Garage garage;

    private final JTextField ownerField;
    private final JTextField brandField;
    private final JTextField modelField;
    private final JTextField yearField;
    private final JComboBox<String> typeCombo;
    private final JLabel dynamicLabel;
    private final JTextField dynamicField;

    private final JTextArea outputArea;

    public VehicleManagementGUI() {
        super("Vehicle Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 540);
        setLocationRelativeTo(null);

        garage = new Garage();

        // Form section
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Add New Vehicle"));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 6, 4, 6);
        c.anchor = GridBagConstraints.WEST;

        c.gridx = 0; c.gridy = 0;
        formPanel.add(new JLabel("Owner Name:"), c);
        c.gridx = 1;
        ownerField = new JTextField(16);
        formPanel.add(ownerField, c);

        c.gridx = 0; c.gridy = 1;
        formPanel.add(new JLabel("Brand:"), c);
        c.gridx = 1;
        brandField = new JTextField(16);
        formPanel.add(brandField, c);

        c.gridx = 0; c.gridy = 2;
        formPanel.add(new JLabel("Model:"), c);
        c.gridx = 1;
        modelField = new JTextField(16);
        formPanel.add(modelField, c);

        c.gridx = 0; c.gridy = 3;
        formPanel.add(new JLabel("Year:"), c);
        c.gridx = 1;
        yearField = new JTextField(16);
        formPanel.add(yearField, c);

        c.gridx = 0; c.gridy = 4;
        formPanel.add(new JLabel("Vehicle Type:"), c);
        c.gridx = 1;
        typeCombo = new JComboBox<>(new String[] {"Car", "Truck", "Motorcycle"});
        formPanel.add(typeCombo, c);

        c.gridx = 0; c.gridy = 5;
        dynamicLabel = new JLabel("Seating Capacity:");
        formPanel.add(dynamicLabel, c);
        c.gridx = 1;
        dynamicField = new JTextField(16);
        formPanel.add(dynamicField, c);

        typeCombo.addActionListener(e -> updateDynamicField());

        // Output section
        outputArea = new JTextArea(15, 52);
        outputArea.setEditable(false);
        outputArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(outputArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Garage Output"));

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 16, 8));
        JButton addButton = new JButton("Add Vehicle");
        JButton displayButton = new JButton("Display Vehicles");

        addButton.addActionListener(new AddVehicleListener());
        displayButton.addActionListener(e -> outputArea.setText(garage.getAllVehicleInfo()));

        buttonPanel.add(addButton);
        buttonPanel.add(displayButton);

        // Top layout container
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(formPanel, BorderLayout.NORTH);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().setLayout(new BorderLayout(10, 10));
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private void updateDynamicField() {
        String selected = (String) typeCombo.getSelectedItem();
        if ("Car".equals(selected)) {
            dynamicLabel.setText("Seating Capacity:");
            dynamicField.setToolTipText("Enter number of seats (int)");
        } else if ("Truck".equals(selected)) {
            dynamicLabel.setText("Cargo Capacity:");
            dynamicField.setToolTipText("Enter cargo capacity in tons (double)");
        } else {
            dynamicLabel.setText("Engine Size:");
            dynamicField.setToolTipText("Enter engine size in cc (int)");
        }
    }

    private class AddVehicleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String owner = ownerField.getText().trim();
            String brand = brandField.getText().trim();
            String model = modelField.getText().trim();
            String yearText = yearField.getText().trim();
            String type = (String) typeCombo.getSelectedItem();
            String extraText = dynamicField.getText().trim();

            if (owner.isEmpty() || brand.isEmpty() || model.isEmpty() || yearText.isEmpty() || extraText.isEmpty()) {
                JOptionPane.showMessageDialog(VehicleManagementGUI.this,
                        "Please fill in all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int year;
            try {
                year = Integer.parseInt(yearText);
                if (year < 1886 || year > 9999) {
                    throw new NumberFormatException("year range invalid");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(VehicleManagementGUI.this,
                        "Year must be a valid integer between 1886 and 9999.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                Vehicle vehicle;
                switch (type) {
                    case "Car" -> {
                        int seating = Integer.parseInt(extraText);
                        if (seating <= 0) throw new NumberFormatException("invalid seating");
                        vehicle = new Car(owner, brand, model, year, seating);
                    }
                    case "Truck" -> {
                        double cargo = Double.parseDouble(extraText);
                        if (cargo <= 0) throw new NumberFormatException("invalid cargo");
                        vehicle = new Truck(owner, brand, model, year, cargo);
                    }
                    case "Motorcycle" -> {
                        int engine = Integer.parseInt(extraText);
                        if (engine <= 0) throw new NumberFormatException("invalid engine");
                        vehicle = new Motorcycle(owner, brand, model, year, engine);
                    }
                    default -> throw new IllegalArgumentException("Unknown type");
                }

                boolean added = garage.addVehicle(vehicle);
                if (added) {
                    JOptionPane.showMessageDialog(VehicleManagementGUI.this,
                            "Vehicle added to garage.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    clearInputs();
                    outputArea.setText(garage.getAllVehicleInfo());
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(VehicleManagementGUI.this,
                        "Extra field must be numeric with a valid value.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(VehicleManagementGUI.this,
                        "Error adding vehicle: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void clearInputs() {
            ownerField.setText("");
            brandField.setText("");
            modelField.setText("");
            yearField.setText("");
            dynamicField.setText("");
            typeCombo.setSelectedIndex(0);
            updateDynamicField();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VehicleManagementGUI::new);
    }
}
