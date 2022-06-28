package com.gamenight;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GameFilter {
    // TODO call getPlayerInfo > figure out how selected players are being pushed
    private static ArrayList<PlayerInfo> playerInfoArray = CSVParserGameNightSelector.getPlayerInfo();
    // TODO call getGameInfo > figure out how selected games are being filtered
    private static Set<BoardGame> games = CSVParserGameNightSelector.getGameInfo();
    private static ArrayList<PlayerInfo> playersInAttendance;
    public static int getPlayerCount() {
        return playersInAttendance.size();
    }

    public static ArrayList<PlayerInfo> getPlayersInAttendance() {
        if (playersInAttendance == null) {
            System.out.println("List the players that will be in attendance, separate each player by comma's : ");
            System.out.println("Example: Bill,Bob,Larry");
            Scanner scanner = new Scanner(System.in);
            String[] playersInAttendanceInput = scanner.nextLine().split(",");
            playersInAttendance = new ArrayList<>();

            for(String currentPlayer : playersInAttendanceInput) {
                for(PlayerInfo player : playerInfoArray) {
                    if(player.getPlayerName().equals(currentPlayer)) {
                        playersInAttendance.add(player);
                    }
                }
            }
        }
        return playersInAttendance;
    }



    public static int getAgeRestriction() {
        int minAge = Integer.MAX_VALUE;
        for(PlayerInfo player : playersInAttendance) {
            minAge = Math.min(player.getPlayerAge(), minAge);
        }
        return minAge;
    }

    public static Set<GameType> gameTypePreference() {
        Set<GameType> gameTypes = new HashSet<>();
        for(PlayerInfo player : playersInAttendance) {
            gameTypes.add(player.getGameType());
        }
        return gameTypes;
    }



    public void filterGames() {


        for(BoardGame game : games) {
        }
        //  filter based on players selected > use that list to determine
        //  1) Player count
        //  2) minAge restriction
        //  3) game type preference list

        //TODO Call getGameInfo > remove games that dont meet 1, 2, or 3

        //TODO Shuffle games
        // rng > pick game


    }

    public static void main(String[] args) {
        getPlayersInAttendance();

        int playerCount = getPlayerCount();
        System.out.printf("Player Count is: %d", playerCount);
        System.out.println();

        int age = getAgeRestriction();
        System.out.printf("Age restriction is: %d", age);
        System.out.println();

        Set<GameType> gameType = gameTypePreference();
        System.out.println("These are the following Game Types to choose from base on Players in attendance");
        gameType.forEach((g) -> System.out.println(g));
        System.out.println();
    }
}
