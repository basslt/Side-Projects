package services;

import Response.PlayerSearchResponse;
import mlb.Player;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import wrapper.PlayerWrapper;

public class PlayerService {
    private RestTemplate restTemplate = new RestTemplate();
    private String API_KEY = "api key";
    private final String API_BASE_URL = "https://statsapi.mlb.com/api/v1/";

    public int getPlayerIdByName(String playerName) {
            String url = "https://statsapi.mlb.com/api/v1/people?search=" + playerName + "&limit=1&hydrate=person";

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer" + API_KEY);

            HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

            ResponseEntity<PlayerSearchResponse> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    PlayerSearchResponse.class
            );

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                PlayerSearchResponse response = responseEntity.getBody();
                if (response != null && response.getPlayerList().size() > 0) {
                    return response.getPlayerList().get(0).getId();
                }
            }

            throw new RuntimeException("Player not found");
        }
    public Player getPlayerByName(String name) {
        int playerId = getPlayerIdByName(name);
        if (playerId == -1) {
            System.out.println("Could not find player with name " + name);
            return null;
        }

        String url = "https://statsapi.mlb.com/api/v1/people/" + playerId + "?hydrate=currentTeam,stats(group=[hitting,pitching],type=[yearByYear])";
        ResponseEntity<PlayerWrapper> response = restTemplate.getForEntity(url, PlayerWrapper.class);
        PlayerWrapper playerWrapper = response.getBody();
        Player player = (Player) playerWrapper.getPlayer().get(0);

        return player;
    }

    }




