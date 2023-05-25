package Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import wrapper.PlayerWrapper;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerSearchResponse {
    private List<PlayerWrapper> player;

    public List<PlayerWrapper> getPlayerList() {
        return player;
    }

    public void setPlayerList(List<PlayerWrapper> playern) {
        this.player = player;
    }
}
