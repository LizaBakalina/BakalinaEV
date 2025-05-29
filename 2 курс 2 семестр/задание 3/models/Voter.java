package models;

import java.time.LocalDate;

public class Voter extends User {
    private String fullName;
    private LocalDate birthDate;
    private String snils;

    public Voter(String login, String password, String fullName,
                 LocalDate birthDate, String snils) {
        super(login, password, "voter");
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.snils = snils;
    }

    // Геттеры и сеттеры
    public String getFullName() { return fullName; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getSnils() { return snils; }
}