package com.gamenight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GetAGame {
    // TODO delete playerInfoArray, write tests for filterGames and IndexOutOfBounds
    private static final ArrayList<PlayerInfo> playerInfoArray = CSVParserGameNightSelector.getPlayerInfo();
    private static final Set<BoardGame> games = CSVParserGameNightSelector.getGameInfo();
    public static BoardGame pickAGame(ArrayList<PlayerInfo> playersInAttendanceArray) {
        // create random number generator between 0 - Array.size()
        int randomNumber = (int) (Math.random() * filterGames(playersInAttendanceArray).size());

        // use random number to pick a game in the filtered array
        try {
            return filterGames(playersInAttendanceArray).get(randomNumber);
        } catch (Exception e) {
            System.out.println("There is no compatible game for this specific combination of players");
            throw new IndexOutOfBoundsException("Out of bounds because the array of filtered games is empty");
        }
    }

    // helper methods
    private static ArrayList<BoardGame> filterGames(ArrayList<PlayerInfo> playersInAttendanceArray) {
        ArrayList<BoardGame> filteredGames = new ArrayList<>();
        //  filter based on players selected and each players restrictions
        //  Player count min ,Age restriction, game type preference list
        for (BoardGame game : games) {
            if (getPlayerNamesInAttendance(playersInAttendanceArray).contains(game.getPlayerName())
                    && getPlayerCountInAttendance(playersInAttendanceArray) <= game.getMaxPlayerCount()
                    && getPlayerCountInAttendance(playersInAttendanceArray) >= game.getMinPlayerCount()
                    && getAgeRestrictionInAttendance(playersInAttendanceArray) > game.getMinPlayerAge()
                    && getGameTypePreferenceInAttendance(playersInAttendanceArray).contains(game.getType())) {
                filteredGames.add(game);
            }
        }
       filteredGames.forEach((game) -> System.out.println(game.getGameName()));
        return filteredGames;
    }

    private static int getPlayerCountInAttendance(ArrayList<PlayerInfo> playersInAttendanceArray) {
        return playersInAttendanceArray.size();
    }

    private static int getAgeRestrictionInAttendance(ArrayList<PlayerInfo> playersInAttendanceArray) {
        int minAge = Integer.MAX_VALUE;
        for (PlayerInfo player : playersInAttendanceArray) {
            minAge = Math.min(player.getPlayerAge(), minAge);
        }
        return minAge;
    }

    private static Set<GameType> getGameTypePreferenceInAttendance(ArrayList<PlayerInfo> playersInAttendanceArray) {
        Set<GameType> gameTypes = new HashSet<>();
        for (PlayerInfo player : playersInAttendanceArray) {
            gameTypes.add(player.getGameType());
        }
        return gameTypes;
    }

    private static Set<String> getPlayerNamesInAttendance(ArrayList<PlayerInfo> playersInAttendanceArray) {
        Set<String> playerNamesInAttendance = new HashSet<>();
        for (PlayerInfo player : playersInAttendanceArray) {
            playerNamesInAttendance.add(player.getPlayerName());
        }
        return playerNamesInAttendance;
    }
}