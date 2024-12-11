import java.util.Scanner;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие: 1 - Добавить отделение, 2 - Удалить отделение, 3 - Добавить пациента, 4 - Удалить пациента, " +
                    "5 - Показать отделения, 6 - Показать пациентов, 0 - Выход");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1: // Добавить отделение
                    System.out.print("Введите название отделения: ");
                    String departmentName = scanner.nextLine();
                    hospital.addDepartment(new Department(departmentName));
                    break;

                case 2: // Удалить отделение
                    System.out.print("Введите название отделения для удаления: ");
                    String depNameToRemove = scanner.nextLine();
                    // Найдите отделение по имени и удалите его
                    for (Department dep : hospital.getDepartments()) {
                        if (dep.getName().equals(depNameToRemove)) {
                            hospital.removeDepartment(dep);
                        }
                    }
                    break;

                case 3: // Добавить пациента
                    System.out.print("Введите название отделения: ");
                    String depNameForPatient = scanner.nextLine();
                    for (Department dep : hospital.getDepartments()) {
                        if (dep.getName().equals(depNameForPatient)) {
                            System.out.print("Введите ФИО пациента: ");
                            String fullName = scanner.nextLine();
                            System.out.print("Введите возраст пациента: ");
                            int age = scanner.nextInt();
                            scanner.nextLine(); // очистка буфера
                            System.out.print("Введите пол пациента: ");
                            String gender = scanner.nextLine();
                            hospital.addPatient(new Patient(fullName, age, gender), dep);
                        }
                    }
                    break;

                case 4: // Удалить пациента
                    System.out.print("Введите ФИО пациента для удаления: ");
                    String fullNameToRemove = scanner.nextLine();
                    // Удалите пациента по ФИО
                    for (Department dep : hospital.getDepartments()) {
                        for (Patient patient : hospital.getPatients(dep)) {
                            if (patient.getFullName().equals(fullNameToRemove)) {
                                hospital.removePatient(patient);
                            }
                        }
                    }
                    break;

                case 5: // Показать отделения
                    for (Department dep : hospital.getDepartments()) {
                        System.out.println(dep);
                    }
                    break;

                case 6: // Показать пациентов
                    System.out.print("Введите название отделения: ");
                    String depNameForShowPatients = scanner.nextLine();
                    for (Department dep : hospital.getDepartments()) {
                        if (dep.getName().equals(depNameForShowPatients)) {
                            List<Patient> patients = hospital.getPatients(dep);
                            System.out.println(dep.getName() + ":");
                            for (Patient patient : patients) {
                                System.out.println("  " + patient);
                            }
                        }
                    }
                    break;

                case 0: // Выход
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }
}