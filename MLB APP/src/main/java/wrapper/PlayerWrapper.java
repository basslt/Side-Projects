package wrapper;

import mlb.Player;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerWrapper {
    private int id;
    private List player;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List getPlayer() {
        return player;
    }

    public void setPlayer(List player) {
        this.player = player;
    }
}
