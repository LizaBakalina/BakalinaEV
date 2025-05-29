package views;

import models.User;
import java.util.List;
import java.util.Scanner;

public class AdminView {
    private Scanner scanner;

    public AdminView() {
        scanner = new Scanner(System.in);
    }

    public int showMenu() {
        System.out.println("\n=== Меню администратора ===");
        System.out.println("1. Просмотр пользователей");
        System.out.println("2. Удаление пользователя");
        System.out.println("3. Создание ЦИК");
        System.out.println("0. Выход");
        System.out.print("Выберите действие: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void showUsers(List<User> users) {
        System.out.println("\n=== Список пользователей ===");
        for (User user : users) {
            System.out.println(user.getLogin() + " (" + user.getRole() + ")");
        }
    }

    public String getUserToDelete() {
        System.out.print("\nВведите логин пользователя для удаления: ");
        return scanner.nextLine();
    }

    public String[] getCECData() {
        System.out.println("\n=== Создание ЦИК ===");
        System.out.print("Логин: ");
        String login = scanner.nextLine();
        System.out.print("Пароль: ");
        String password = scanner.nextLine();
        return new String[]{login, password};
    }
}