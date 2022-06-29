package com.gamenight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GetAGame {
    private static final ArrayList<PlayerInfo> playerInfoArray = CSVParserGameNightSelector.getPlayerInfo();
    private static final Set<BoardGame> games = CSVParserGameNightSelector.getGameInfo();
    private static ArrayList<PlayerInfo> playersInAttendance;

    public static BoardGame pickAGame() {
        // create random number generator between 0 - Array.size()
        int randomNumber = (int) (Math.random() * filterGames().size());

        // use random number to pick a game in the filtered array
        try {
            return filterGames().get(randomNumber);
        } catch (Exception e) {
            throw new IndexOutOfBoundsException(String.valueOf(e));
        }
    }

    // helper methods

    private static void getPlayersInAttendance() {
        if (playersInAttendance == null) {
            playersInAttendance = new ArrayList<>();
            for (PlayerInfo player : playerInfoArray) {
                System.out.printf("Is: %s playing? (enter 'y' for yes or 'n' for no) ", player.getPlayerName());
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                if (input.equals("y")) {
                    playersInAttendance.add(player);
                }
            }
        }
    }
    private static ArrayList<BoardGame> filterGames() {
        getPlayersInAttendance();
        ArrayList<BoardGame> filteredGames = new ArrayList<>();
        //  filter based on players selected and each players restrictions
        //  Player count min ,Age restriction, game type preference list
        for (BoardGame game : games) {
            if (getPlayerNamesInAttendance().contains(game.getPlayerName())
                    && getPlayerCountInAttendance() < game.getMaxPlayerCount() && getPlayerCountInAttendance() > game.getMinPlayerCount()
                    && getAgeRestrictionInAttendance() > game.getMinPlayerAge()
                    && getGameTypePreferenceInAttendance().contains(game.getType())) {
                filteredGames.add(game);
            }
        }
        return filteredGames;
    }

    private static int getPlayerCountInAttendance() {
        return playersInAttendance.size();
    }

    private static int getAgeRestrictionInAttendance() {
        int minAge = Integer.MAX_VALUE;
        for (PlayerInfo player : playersInAttendance) {
            minAge = Math.min(player.getPlayerAge(), minAge);
        }
        return minAge;
    }

    private static Set<GameType> getGameTypePreferenceInAttendance() {
        Set<GameType> gameTypes = new HashSet<>();
        for (PlayerInfo player : playersInAttendance) {
            gameTypes.add(player.getGameType());
        }
        return gameTypes;
    }

    private static Set<String> getPlayerNamesInAttendance() {
        Set<String> playerNamesInAttendance = new HashSet<>();
        for (PlayerInfo player : playersInAttendance) {
            playerNamesInAttendance.add(player.getPlayerName());
        }
        return playerNamesInAttendance;
    }
}