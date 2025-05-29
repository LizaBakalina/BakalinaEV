import controllers.*;
import models.*;
import views.*;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        AuthView authView = new AuthView();
        AuthController authController = new AuthController(db, authView);

        while (true) {
            System.out.println("\n=== Система электронного голосования ===");
            System.out.println("1. Вход");
            System.out.println("2. Регистрация");
            System.out.println("3. Выход");
            System.out.print("Выберите действие: ");

            int choice = Integer.parseInt(authView.getCredentials()[0]);

            switch (choice) {
                case 1:
                    User user = authController.login();
                    if (user != null) {
                        startUserSession(user, db);
                    }
                    break;
                case 2:
                    if (authController.register()) {
                        authView.showSuccess("Регистрация успешно завершена");
                    } else {
                        authView.showError("Ошибка регистрации. Возможно, логин уже занят.");
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    authView.showError("Неверный выбор");
            }
        }
    }

    private static void startUserSession(User user, Database db) {
        switch (user.getRole()) {
            case "admin":
                AdminView adminView = new AdminView();
                new AdminController(db, adminView).showMenu();
                break;
            case "cec":
                CECView cecView = new CECView();
                new CECController(db, cecView).showMenu();
                break;
            case "candidate":
                CandidateView candidateView = new CandidateView();
                new CandidateController(db, candidateView).showMenu();
                break;
            case "voter":
                UserView userView = new UserView();
                new UserController(db, userView).showMenu();
                break;
        }
    }
}