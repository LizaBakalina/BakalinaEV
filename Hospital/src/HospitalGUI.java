import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

class HospitalGUI extends JFrame {
    private JList<Department> departmentList;
    private JList<Patient> patientList;
    private DefaultListModel<Department> departmentListModel;
    private DefaultListModel<Patient> patientListModel;
    private Hospital hospital;
    private JTextField departmentField;
    private JTextField patientNameField;
    private JTextField patientAgeField;
    private JTextField patientGenderField;
    private JComboBox<Department> departmentComboBox;
    private JTextArea outputArea;

    public HospitalGUI() {
        hospital = new Hospital();
        setTitle("Hospital Management System");
        setSize(1200, 1080);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Панель для ввода данных
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        inputPanel.add(new JLabel("Отделение: "));
        departmentField = new JTextField();
        inputPanel.add(departmentField);

        inputPanel.add(new JLabel("ФИО пациента: "));
        patientNameField = new JTextField();
        inputPanel.add(patientNameField);

        inputPanel.add(new JLabel("Возраст: "));
        patientAgeField = new JTextField();
        inputPanel.add(patientAgeField);

        inputPanel.add(new JLabel("Пол: "));
        patientGenderField = new JTextField();
        inputPanel.add(patientGenderField);

        JButton addDepartmentButton = new JButton("Добавить отделение");
        addDepartmentButton.addActionListener(new AddDepartmentListener());
        inputPanel.add(addDepartmentButton);

        //JButton showDepartmentButton = new JButton("Показать отделения");
        //showDepartmentButton.show();
        //inputPanel.add(showDepartmentButton)


        JButton addPatientButton = new JButton("Добавить пациента");
        addPatientButton.addActionListener(new AddPatientListener());
        inputPanel.add(addPatientButton);

        // Панель для вывода информации
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Обновляем список отделений
        updateDepartmentComboBox();

        setVisible(true);
    }


    private void updateDepartmentComboBox() {
        List<Department> departments = hospital.getDepartments();
        departmentComboBox = new JComboBox<>(departments.toArray(new Department[0]));
    }

    private class AddDepartmentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String departmentName = departmentField.getText();
            if (!departmentName.isEmpty()) {
                hospital.addDepartment(new Department(departmentName));
                outputArea.append("Добавлено отделение: " + departmentName + "\n");
                departmentField.setText("");
                updateDepartmentComboBox();
            } else {
                JOptionPane.showMessageDialog(null, "Введите название отделения.");
            }
        }
    }

    private class AddPatientListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String fullName = patientNameField.getText();
            int age = Integer.parseInt(patientAgeField.getText());
            String gender = patientGenderField.getText();
            Department selectedDepartment = (Department) departmentComboBox.getSelectedItem();

            if (selectedDepartment != null) {
                hospital.addPatient(new Patient(fullName, age, gender), selectedDepartment);
                outputArea.append("Добавлен пациент: " + fullName + " в отделение: " + selectedDepartment.getName() + "\n");
                patientNameField.setText("");
                patientAgeField.setText("");
                patientGenderField.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Выберите отделение.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HospitalGUI::new);
    }

}