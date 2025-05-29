package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private Map<String, User> users;
    private List<Voting> votings;
    private int nextVotingId;
    private int nextBallotId;

    public Database() {
        users = new HashMap<>();
        votings = new ArrayList<>();
        nextVotingId = 1;
        nextBallotId = 1;
        initializeTestData();
    }

    private void initializeTestData() {
        // Тестовый администратор
        users.put("admin", new Admin("admin", "admin123"));

        // Тестовая ЦИК
        users.put("cec1", new CEC("cec1", "cec123"));

        // Тестовые кандидаты
        users.put("cand1", new Candidate("cand1", "cand123", "Иванов Иван Иванович"));
        users.put("cand2", new Candidate("cand2", "cand123", "Петров Петр Петрович"));

        // Тестовые избиратели
        users.put("voter1", new Voter("voter1", "voter123", "Сидоров Сидор Сидорович",
                LocalDate.of(1980, 5, 15), "123-456-789 00"));

        // Тестовое голосование
        Voting voting = new Voting(nextVotingId++, "Выборы мэра", "Выборы мэра города",
                LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(7));
        voting.addCandidate((Candidate)users.get("cand1"));
        voting.addCandidate((Candidate)users.get("cand2"));
        votings.add(voting);
    }

    public User authenticate(String login, String password) {
        User user = users.get(login);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public boolean registerVoter(String login, String password, String fullName,
                                 LocalDate birthDate, String snils) {
        if (users.containsKey(login)) {
            return false;
        }
        users.put(login, new Voter(login, password, fullName, birthDate, snils));
        return true;
    }

    // Другие методы для работы с данными...
}