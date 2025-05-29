package controllers;

import models.*;
import views.AdminView;

import java.util.List;

public class AdminController {
    private Database db;
    private AdminView view;

    public AdminController(Database db, AdminView view) {
        this.db = db;
        this.view = view;
    }

    public void showMenu() {
        boolean running = true;
        while (running) {
            int choice = view.showMenu();

            switch (choice) {
                case 1:
                    view.showUsers(db.getAllUsers());
                    break;
                case 2:
                    String login = view.getUserToDelete();
                    db.removeUser(login);
                    break;
                case 3:
                    String[] cecData = view.getCECData();
                    db.addUser(new CEC(cecData[0], cecData[1]));
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    view.showError("Неверный выбор");
            }
        }
    }
}