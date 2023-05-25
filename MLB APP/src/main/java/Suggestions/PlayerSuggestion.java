package Suggestions;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PlayerSuggestion {
    private int id;
    private String fullName;
    private String position;
    private String team;
    private List<PlayerSuggestion> players;


    // getters and setters
    public PlayerSuggestion(@JsonProperty("id") int id, @JsonProperty("fullName") String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public List<PlayerSuggestion> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerSuggestion> players) {
        this.players = players;
    }
}


