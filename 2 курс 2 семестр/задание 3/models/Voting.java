package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Voting {
    private int id;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<Candidate> candidates;
    private List<Ballot> ballots;

    public Voting(int id, String title, String description,
                  LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.candidates = new ArrayList<>();
        this.ballots = new ArrayList<>();
    }

    // Геттеры и методы управления
    public boolean isActive() {
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(startDate) && now.isBefore(endDate);
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    public void addBallot(Ballot ballot) {
        ballots.add(ballot);
    }

    public List<Candidate> getCandidates() { return candidates; }
    public List<Ballot> getBallots() { return ballots; }
    public String getTitle() { return title; }
    public LocalDateTime getEndDate() { return endDate; }
}