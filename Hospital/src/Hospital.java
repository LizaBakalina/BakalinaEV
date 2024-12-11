import java.util.List;
import java.util.ArrayList;
import java.sql.*;
class Hospital {
    private Connection connection;

    public Hospital() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_db", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDepartment(Department department) {
        try {
            String sql = "INSERT INTO departments (name) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, department.getName());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                department.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeDepartment(Department department) {
        try {
            String sql = "DELETE FROM departments WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, department.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPatient(Patient patient, Department department) {
        try {
            String sql = "INSERT INTO patients (full_name, age, gender, department_id) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, patient.getFullName());
            statement.setInt(2, patient.getAge());
            statement.setString(3, patient.getGender());
            statement.setInt(4, department.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void removePatient(Patient patient) {
        try {
            String sql = "DELETE FROM patients WHERE full_name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, patient.getFullName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Department> getDepartments() {
        List<Department> departments = new ArrayList<>();
        try {
            String sql = "SELECT * FROM departments";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Department department = new Department(resultSet.getString("name"));
                department.setId(resultSet.getInt("id"));
                departments.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    public List<Patient> getPatients(Department department) {
        List<Patient> patients = new ArrayList<>();
        try {
            String sql = "SELECT * FROM patients WHERE department_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, department.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Patient patient = new Patient(
                        resultSet.getString("full_name"),
                        resultSet.getInt("age"),
                        resultSet.getString("gender")
                );
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }
}



