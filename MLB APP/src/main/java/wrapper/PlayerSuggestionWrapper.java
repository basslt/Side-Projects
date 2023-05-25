package wrapper;

import Suggestions.PlayerSuggestion;

import java.util.List;

public class PlayerSuggestionWrapper {
    private List<PlayerSuggestion> suggestions;
    private List<PlayerSuggestion> players;

    public List<PlayerSuggestion> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<PlayerSuggestion> suggestions) {
        this.suggestions = suggestions;
    }

    public List<PlayerSuggestion> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerSuggestion> players) {
        this.players = players;
    }
}


