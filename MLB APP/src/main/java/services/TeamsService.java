package services;

import mlb.Teams;


import org.springframework.web.client.RestTemplate;






public class TeamsService {

        private final RestTemplate restTemplate = new RestTemplate();

        public Teams getTeamInfo(String teamName) {
            String url = "https://lookup-service-prod.mlb.com/json/named.team_all_season.bam?sport_code='mlb'&all_star_sw='N'&season='2022'";
            Teams[] teams = restTemplate.getForObject(url, Teams[].class);

            for (Teams team : teams) {
                if (team.getTeamName().equals(teamName)) {

                    team.setTeamName(team.getTeamName());
                    team.setLocationName(team.getLocationName());
                    team.setShortName(team.getShortName());
                    team.setAbbreviation(team.getAbbreviation());
                    team.setLeagueName(team.getLeagueName());
                    team.setDivisionName(team.getDivisionName());
                    team.setLastChampionshipYear(team.getLastChampionshipYear());
                    team.setLastDivisionTitleYear(team.getLastDivisionTitleYear());
                    team.setLastPennantYear(team.getLastPennantYear());
                    return team;
                }
            }

            return null;
        }
    }