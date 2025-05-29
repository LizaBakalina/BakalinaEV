package views;

import java.util.Scanner;

public class AuthView {
    private Scanner scanner;

    public AuthView() {
        scanner = new Scanner(System.in);
    }

    public String[] getCredentials() {
        System.out.println("\n=== Вход в систему ===");
        System.out.print("Логин: ");
        String login = scanner.nextLine();
        System.out.print("Пароль: ");
        String password = scanner.nextLine();
        return new String[]{login, password};
    }

    public String[] getRegistrationData() {
        System.out.println("\n=== Регистрация избирателя ===");
        System.out.print("Логин: ");
        String login = scanner.nextLine();
        System.out.print("Пароль: ");
        String password = scanner.nextLine();
        System.out.print("ФИО: ");
        String fullName = scanner.nextLine();
        System.out.print("Дата рождения (ДД.ММ.ГГГГ): ");
        String birthDate = scanner.nextLine();
        System.out.print("СНИЛС: ");
        String snils = scanner.nextLine();
        return new String[]{login, password, fullName, birthDate, snils};
    }

    public void showError(String message) {
        System.out.println("Ошибка: " + message);
    }

    public void showSuccess(String message) {
        System.out.println(message);
    }
}