package com.gamenight;

import com.gamenight.BoardGame;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class GameFilter {
    // TODO call getPlayerInfo > figure out how selected players are being pushed
    static ArrayList<PlayerInfo> playerInfoArray = CSVParserGameNightSelector.getPlayerInfo();
    // TODO call getGameInfo > figure out how selected games are being filtered
    Set<BoardGame> games = CSVParserGameNightSelector.getGameInfo();
    public static int getPlayerCount() {
        return playersInAttendance().size();
    }

    public static ArrayList<PlayerInfo> playersInAttendance() {
        System.out.println("List the players that will be in attendance, separate each player by comma's : ");
        System.out.println("Example: Bill,Bob,Larry");
        Scanner scanner = new Scanner(System.in);
        String[] playersInAttendance = scanner.nextLine().split(",");
        ArrayList<PlayerInfo> playersInAttendanceArrayList = new ArrayList<>();

        for(String currentPlayer : playersInAttendance) {
            for(PlayerInfo player : playerInfoArray) {
                if(player.getPlayerName().equals(currentPlayer)) {
                    playersInAttendanceArrayList.add(player);
                }
            }
        }
        return playersInAttendanceArrayList;
    }



    public static int getAgeRestriction() {
        return 0;
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
        int length = getPlayerCount();
    }
}
