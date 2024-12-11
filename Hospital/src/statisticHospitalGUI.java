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

        // Модель и список для отделений
        departmentListModel = new DefaultListModel<>();
        departmentList = new JList<>(departmentListModel);
        departmentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Модель и список для пациентов
        patientListModel = new DefaultListModel<>();
        patientList = new JList<>(patientListModel);

        // Панель для отображения списков
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

        // Добавление элементов на фрейм
        frame.add(panel, BorderLayout.CENTER);
        frame.add(refreshButton, BorderLayout.SOUTH);

        // Изначально обновляем список отделений
        updateDepartmentList();

        frame.setVisible(true);
    }

    // Метод для обновления списка отделений
    private void updateDepartmentList() {
        departmentListModel.clear();
        List<Department> departments = hospital.getDepartments();
        for (Department department : departments) {
            departmentListModel.addElement(department);
        }
    }
    public void show() {
        // Создаем экземпляр Hospital и запускаем GUI
        Hospital hospital = new Hospital();
        SwingUtilities.invokeLater(() -> new statisticHospitalGUI(hospital));
    }
}