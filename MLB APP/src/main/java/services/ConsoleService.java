package services;

import java.util.Scanner;

public class ConsoleService {

        private Scanner scanner;

        public ConsoleService() {
            this.scanner = new Scanner(System.in);
        }

        public void displayMenu() {
            System.out.println("Welcome to the MLB stats application!");
            System.out.println("Please choose an option:");
            System.out.println("1. Get player stats");
            System.out.println("2. Get team stats");
            System.out.println("3. Exit");
        }

        public int getOption() {
            System.out.print("Enter option number: ");
            return scanner.nextInt();
        }

        public String getPlayerName() {
            scanner.nextLine(); // Consume the newline character left by nextInt()
            System.out.print("Enter player name: ");
            return scanner.nextLine();
        }

        public String getTeamName() {
            scanner.nextLine(); // Consume the newline character left by nextInt()
            System.out.print("Enter team name: ");
            return scanner.nextLine();
        }

        public void displayStats(String stats) {
            System.out.println(stats);
        }

        public void displayError(String errorMessage) {
            System.err.println(errorMessage);
        }

        public void closeScanner() {
            scanner.close();
        }
    }

