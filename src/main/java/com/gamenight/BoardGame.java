package com.gamenight;

public class BoardGame {
    //Final Fields
    public static final int MIN_PLAYER_AGE = 0;
    private String playerName;
    //Fields
    private String gameName;
    private GameType type = GameType.NO_TYPE_DEFINED;
    private int minPlayerCount;
    private int maxPlayerCount;
    private int minPlayerAge;

    //Constructors
    public BoardGame(String playerName, String gameName, GameType type, int minPlayerCount, int maxPlayerCount, int minPlayerAge) {
        setPlayerName(playerName);
        setGameName(gameName);
        setType(type);
        setMinPlayerCount(minPlayerCount);
        setMaxPlayerCount(maxPlayerCount);
        setMinPlayerAge(minPlayerAge);
    }

    //Getters & Setters
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public GameType getType() {
        return type;
    }

    public void setType(GameType type) {
        this.type = type;
    }

    public int getMinPlayerCount() {
        return minPlayerCount;
    }

    public void setMinPlayerCount(int minPlayerCount) {
        this.minPlayerCount = minPlayerCount;
    }

    public int getMaxPlayerCount() {
        return maxPlayerCount;
    }

    public void setMaxPlayerCount(int maxPlayerCount) {
        this.maxPlayerCount = maxPlayerCount;
    }

    public int getMinPlayerAge() {
        return minPlayerAge;
    }

    public void setMinPlayerAge(int minPlayerAge) {

        if (minPlayerAge > MIN_PLAYER_AGE) {
            this.minPlayerAge = minPlayerAge;
        } else {
            System.out.println(minPlayerAge + " is not a valid age");
        }
    }
}
