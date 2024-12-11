import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class statisticHospitalGUI {
    private Hospital hospital;
    private JFrame frame;

    private JList<Department> departmentList;
    private JList<Patient> patientList;
    private DefaultListModel<Department> departmentListModel;
    private DefaultListModel<Patient> patientListModel;

    public statisticHospitalGUI(Hospital hospital) {
        this.hospital = hospital;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Hospital Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // список для отделений
        departmentListModel = new DefaultListModel<>();
        departmentList = new JList<>(departmentListModel);
        departmentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // список для пациентов
        patientListModel = new DefaultListModel<>();
        patientList = new JList<>(patientListModel);

        // отображения списков
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(new JScrollPane(departmentList));
        panel.add(new JScrollPane(patientList));

        // Кнопка для обновления списка отделений
        JButton refreshButton = new JButton("Обновить отделения");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDepartmentList();
            }
        });

        // Добавление элементов
        frame.add(panel, BorderLayout.CENTER);
        frame.add(refreshButton, BorderLayout.SOUTH);

        // бновляем список отделений
        updateDepartmentList();

        frame.setVisible(true);
    }

    // обновленине списка отделений
    private void updateDepartmentList() {
        departmentListModel.clear();
        List<Department> departments = hospital.getDepartments();
        for (Department department : departments) {
            departmentListModel.addElement(department);
        }
    }
    public void show() {
        
        Hospital hospital = new Hospital();
        SwingUtilities.invokeLater(() -> new statisticHospitalGUI(hospital));
    }
}
