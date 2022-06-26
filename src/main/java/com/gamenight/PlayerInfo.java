package com.gamenight;

public class PlayerInfo {
//Fields
    private String playerName;
    private int playerAge;
    private GameType type;
    private int playerMinGameTime;
// Constructor (remove if only the default is needed)
    public PlayerInfo() {
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

    public GameType getType() {
        return type;
    }

    public void setType(GameType type) {
        this.type = type;
    }

    public int getPlayerMinGameTime() {
        return playerMinGameTime;
    }

    public void setPlayerMinGameTime(int playerMinGameTime) {
        this.playerMinGameTime = playerMinGameTime;
    }
// TODO write business method(s) that we can call to add new players to hashmaps

}
