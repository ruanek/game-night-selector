package com.gamenight;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CSVParserGameNightSelector {
    public static ArrayList<PlayerInfo> getPlayerInfo() {
        String path = "src/main/resources/PlayerInfo.csv";
        ArrayList<PlayerInfo> playersArray = null;

        try (Reader in = new FileReader(path)) {
            for (CSVRecord row : CSVFormat.EXCEL.parse(in)) {
                if (row.get(0).equals("Name")) {
                    continue;
                }
                String name = row.get(0);
                int age = Integer.parseInt(row.get(1));
                GameType gameType = GameType.valueOf(row.get(2));
                System.out.println("Name: " + name + ", Age: " + age + ", GameType: " + gameType);

                playersArray = new ArrayList<>();
                PlayerInfo player = new PlayerInfo(name, age, gameType);
                playersArray.add(player);
            }
            return playersArray;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return playersArray;
    }
    public static Set<BoardGame> getGameInfo() {
        String path = "src/main/resources/Games.csv";
        Set<BoardGame> games = null;

        try (Reader in = new FileReader(path)) {
            for (CSVRecord row : CSVFormat.EXCEL.parse(in)) {
                if (row.get(0).equals("playerName")) {
                    continue;
                }
                String playerName = row.get(0);
                String gameName = row.get(1);
                GameType gameType = GameType.valueOf(row.get(2));
                int minPlayerCount = Integer.parseInt(row.get(3));
                int maxPlayerCount = Integer.parseInt(row.get(4));
                int minPlayerAge = Integer.parseInt(row.get(5));
                int minGameTime = Integer.parseInt(row.get(6));

                System.out.println("Name: " + playerName + ", Game: " + gameName +
                        ", GameType: " + gameType + ", Min # Players: " + minPlayerCount
                        + ", Max # Players: " + maxPlayerCount + ", Min Player Age: " + minPlayerAge
                        + ", Min Game Time: " + minGameTime);

                // create a set of board games, using set to eliminate possible duplicate board games
                games = new HashSet<>();
                games.add(new BoardGame(playerName, gameName, gameType, minPlayerCount, maxPlayerCount, minPlayerAge, minGameTime));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return games;
    }

    public static void main(String[] args) {
        getPlayerInfo();
        getGameInfo();
    }
}
