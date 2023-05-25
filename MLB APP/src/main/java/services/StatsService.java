package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import mlb.Player;
import mlb.PlayerStats;
import mlb.TeamStats;
import mlb.Teams;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


public class StatsService {
    private final String baseUrl = "https://lookup-service-prod.mlb.com";
    private final RestTemplate restTemplate = new RestTemplate();


    public PlayerStats getPlayerStatsByName(String playerName) {
        String url = baseUrl + "/json/named.sport_hitting_tm.bam?league_list_id='mlb'&game_type='R'&season=2022&player_id=" + getPlayerId(playerName);
        PlayerStats playerStats = restTemplate.getForObject(url, PlayerStats.class);
        return playerStats;
    }

    public TeamStats getTeamStatsByName(String teamName) {
        String url = baseUrl + "/json/named.sport_team_stats.bam?league_id=103&season=2022&team_id=" + getTeamId(teamName);
        TeamStats teamStats = restTemplate.getForObject(url, TeamStats.class);
        return teamStats;
    }

    public String getPlayerId(String playerName) {
        String url = baseUrl + "/json/named.search_player_all.bam?sport_code='mlb'&active_sw='Y'&name_part='" + playerName + "%25'";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = mapper.readTree(response.getBody());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        JsonNode playerNode = rootNode.path("search_player_all").path("queryResults").path("row").get(0);
        String playerId = playerNode.path("player_id").asText();

        return playerId;
    }

    public String getTeamId(String teamName) {
        String url = baseUrl + "/json/named.search_teams.bam?sport_code='mlb'&active_sw='Y'&search_term='" + teamName + "'";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = mapper.readTree(response.getBody());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        JsonNode teamNode = rootNode.path("search_teams").path("queryResults").path("row").get(0);
        String teamId = teamNode.path("team_id").asText();

        return teamId;
    }
}


