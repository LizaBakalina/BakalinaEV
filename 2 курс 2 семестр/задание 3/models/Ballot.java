package models;

import java.time.LocalDateTime;

public class Ballot {
    private int id;
    private String voterLogin;
    private String candidateLogin;
    private LocalDateTime voteTime;

    public Ballot(int id, String voterLogin, String candidateLogin) {
        this.id = id;
        this.voterLogin = voterLogin;
        this.candidateLogin = candidateLogin;
        this.voteTime = LocalDateTime.now();
    }

    // Геттеры
    public String getVoterLogin() { return voterLogin; }
    public String getCandidateLogin() { return candidateLogin; }
    public LocalDateTime getVoteTime() { return voteTime; }
}