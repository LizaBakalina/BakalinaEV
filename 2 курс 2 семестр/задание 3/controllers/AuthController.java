package controllers;

import models.*;
import views.AuthView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AuthController {
    private Database db;
    private AuthView view;

    public AuthController(Database db, AuthView view) {
        this.db = db;
        this.view = view;
    }

    public User login() {
        String[] credentials = view.getCredentials();
        User user = db.authenticate(credentials[0], credentials[1]);

        if (user == null) {
            view.showError("Неверный логин или пароль");
        }
        return user;
    }

    public boolean register() {
        String[] data = view.getRegistrationData();
        try {
            LocalDate birthDate = LocalDate.parse(data[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            return db.registerVoter(data[0], data[1], data[2], birthDate, data[4]);
        } catch (Exception e) {
            view.showError("Некорректный формат даты. Используйте ДД.ММ.ГГГГ");
            return false;
        }
    }
}