package models;

public class Candidate extends User {
    private String fullName;
    private String bio;

    public Candidate(String login, String password, String fullName) {
        super(login, password, "candidate");
        this.fullName = fullName;
        this.bio = "";
    }

    public String getFullName() { return fullName; }
    public String getBio() { return bio; }

    public void setBio(String bio) { this.bio = bio; }
}