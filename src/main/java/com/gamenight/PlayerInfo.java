package com.gamenight;

public class PlayerInfo {
//Fields
    private String playerName;
    private int playerAge;
    private GameType gameType;

    public PlayerInfo(String playerName, int playerAge, GameType gameType) {
        setPlayerName(playerName);
        setPlayerAge(playerAge);
        setGameType(gameType);
    }

    // Setters and Getters
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerAge() {
        return playerAge;
    }

    public void setPlayerAge(int playerAge) {
        this.playerAge = playerAge;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

}
