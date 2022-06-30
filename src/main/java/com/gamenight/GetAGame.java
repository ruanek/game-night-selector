package com.gamenight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GetAGame {
    private static final Set<BoardGame> games = CSVParser.getGameInfo();

    public static BoardGame pickAGame(ArrayList<PlayerInfo> playersInAttendanceArray) {
        // create random number generator between 0 - Array.size()
        ArrayList<BoardGame> filteredGames = filterGames(playersInAttendanceArray);
        int randomNumber = (int) (Math.random() * filteredGames.size());

        // use random number to pick a game in the filtered array, if there is no compatible game, throw an exception
        try {
            return filteredGames.get(randomNumber);
        } catch (IndexOutOfBoundsException e) {
            // return null because I want to actually display something different on the GUI
            // I can't do that if it throws an Error
            return null;
        }
    }

    // helper methods
    static ArrayList<BoardGame> filterGames(ArrayList<PlayerInfo> playersInAttendanceArray) {
        ArrayList<BoardGame> filteredGames = new ArrayList<>();
        //  filter based on players in attendance and each player's restrictions
        //  Restrictions are Player Count Min, Player Count Max, Age restriction, Game Type Preference
        for (BoardGame game : games) {
            if (getPlayerNamesInAttendance(playersInAttendanceArray).contains(game.getPlayerName())
                    && getPlayerCountInAttendance(playersInAttendanceArray) <= game.getMaxPlayerCount()
                    && getPlayerCountInAttendance(playersInAttendanceArray) >= game.getMinPlayerCount()
                    && getAgeRestrictionInAttendance(playersInAttendanceArray) >= game.getMinPlayerAge()
                    && getGameTypePreferenceInAttendance(playersInAttendanceArray).contains(game.getType())
            ) {
                filteredGames.add(game);
            }
        }
        return filteredGames;
    }

    static int getPlayerCountInAttendance(ArrayList<PlayerInfo> playersInAttendanceArray) {
        return playersInAttendanceArray.size();
    }

    static int getAgeRestrictionInAttendance(ArrayList<PlayerInfo> playersInAttendanceArray) {
        int minAge = Integer.MAX_VALUE;
        for (PlayerInfo player : playersInAttendanceArray) {
            minAge = Math.min(player.getPlayerAge(), minAge);
        }
        return minAge;
    }

    static Set<GameType> getGameTypePreferenceInAttendance(ArrayList<PlayerInfo> playersInAttendanceArray) {
        Set<GameType> gameTypes = new HashSet<>();
        for (PlayerInfo player : playersInAttendanceArray) {
            gameTypes.add(player.getGameType());
        }
        return gameTypes;
    }

    static Set<String> getPlayerNamesInAttendance(ArrayList<PlayerInfo> playersInAttendanceArray) {
        Set<String> playerNamesInAttendance = new HashSet<>();
        for (PlayerInfo player : playersInAttendanceArray) {
            playerNamesInAttendance.add(player.getPlayerName());
        }
        return playerNamesInAttendance;
    }
}