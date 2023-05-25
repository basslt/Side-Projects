import mlb.Player;
import mlb.Teams;
import services.ConsoleService;
import services.PlayerService;
import services.TeamsService;

import java.util.Scanner;


public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlayerService playerService = new PlayerService();
        TeamsService teamService = new TeamsService();

        System.out.println("Welcome to MLB Stats App!");

        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1. Search for player stats");
            System.out.println("2. Search for team stats");
            System.out.println("3. Exit");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                System.out.println("Enter player name:");
                String playerName = scanner.nextLine();
                Player player = playerService.getPlayerByName(playerName);

                if (player == null) {
                    System.out.println("Player not found.");
                } else {
                    System.out.println(player);
                }
            } else if (input.equals("2")) {
                System.out.println("Enter team name:");
                String teamName = scanner.nextLine();
                Teams team = teamService.getTeamInfo(teamName);

                if (team == null) {
                    System.out.println("Team not found.");
                } else {
                    System.out.println(team);
                }
            } else if (input.equals("3")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid input.");
            }
        }

        scanner.close();
    }
}
