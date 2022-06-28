package com.gamenight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GameFilter {
    private static ArrayList<PlayerInfo> playerInfoArray = CSVParserGameNightSelector.getPlayerInfo();
    private static Set<BoardGame> games = CSVParserGameNightSelector.getGameInfo();
    private static ArrayList<PlayerInfo> playersInAttendance;

    public static ArrayList<BoardGame> filterGames() {
        getPlayersInAttendance();
        ArrayList<BoardGame> filteredGames = new ArrayList<>();
        //  filter based on players selected and each players restrictions
        //  Player count min ,Age restriction, game type preference list
        for(BoardGame game : games) {
            if(getPlayerNamesInAttendance().contains(game.getPlayerName())
                    && getPlayerCount() < game.getMaxPlayerCount() && getPlayerCount() > game.getMinPlayerCount()
                    && getAgeRestriction() > game.getMinPlayerAge()
                    && getGameTypePreference().contains(game.getType())) {
                filteredGames.add(game);
            }
        }
        filteredGames.forEach((game) -> System.out.println(game.getPlayerName()));
        return filteredGames;
    }

    public BoardGame pickAGame() {
        BoardGame game = null;
        // create random number generator

        // use random number to pick a game in the filtered array
        return game;
    }

    // helper methods
    private static ArrayList<PlayerInfo> getPlayersInAttendance() {
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

    private static int getPlayerCount() {
        return playersInAttendance.size();
    }

    private static int getAgeRestriction() {
        int minAge = Integer.MAX_VALUE;
        for(PlayerInfo player : playersInAttendance) {
            minAge = Math.min(player.getPlayerAge(), minAge);
        }
        return minAge;
    }

    private static Set<GameType> getGameTypePreference() {
        Set<GameType> gameTypes = new HashSet<>();
        for(PlayerInfo player : playersInAttendance) {
            gameTypes.add(player.getGameType());
        }
        return gameTypes;
    }

    private static Set<String> getPlayerNamesInAttendance() {
        Set<String> playerNamesInAttendance = new HashSet<>();
        for(PlayerInfo player : playersInAttendance) {
            playerNamesInAttendance.add(player.getPlayerName());
        }
        return playerNamesInAttendance;
    }

    public static void main(String[] args) {
//
//        int playerCount = getPlayerCount();
//        System.out.printf("\n\nPlayer Count is: %d", playerCount);
//
//        int age = getAgeRestriction();
//        System.out.printf("\n\nAge restriction is: %d", age);
//
//        Set<GameType> gameType = getGameTypePreference();
//        System.out.println("\n\nThese are the following Game Types to choose from base on Players in attendance");
//        gameType.forEach((g) -> System.out.println(g));

        System.out.println("\n\n");
        filterGames();
    }
}
