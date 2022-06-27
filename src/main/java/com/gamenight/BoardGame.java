package com.gamenight;

public class BoardGame {
    //Final Fields
    public static final int MIN_PLAYER_AGE = 0;
    public static final int MIN_GAME_TIME = 0;
    //Fields
    private String gameName;
    private GameType type = GameType.NO_TYPE_DEFINED;
    private int minPlayerCount;
    private int maxPlayerCount;
    private int minPlayerAge;
    private int minGameTime;

    public BoardGame() {

    }

    //Constructors
    public BoardGame(String gameName) {
        this();
        setGameName(gameName);
    }

    public BoardGame(String gameName, GameType type) {
        this(gameName);
        setType(type);
    }

    public BoardGame(String gameName, GameType type, int minPlayerCount) {
        this(gameName, type);
        setMinPlayerCount(minPlayerCount);
    }

    public BoardGame(String gameName, GameType type, int minPlayerCount, int maxPlayerCount) {
        this(gameName, type, minPlayerCount);
        setMaxPlayerCount(maxPlayerCount);
    }

    public BoardGame(String gameName, GameType type, int minPlayerCount, int maxPlayerCount, int minPlayerAge) {
        this(gameName, type, minPlayerCount, maxPlayerCount);
        setMinPlayerAge(minPlayerAge);
    }

    //Getters & Setters
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

    public int getMinGameTime() {
        return minGameTime;
    }

    public void setMinGameTime(int minGameTime) {
        if (minGameTime > MIN_GAME_TIME) {
            this.minGameTime = minGameTime;
        } else {
            System.out.println(minGameTime + " is not valid, please set a value greater than 0");
        }
    }

    @Override
    public String toString() {
        return "BoardGame= " + gameName + '\n' +
                "type= " + type + '\n' +
                "minPlayerCount= " + minPlayerCount + '\n' +
                "maxPlayerCount= " + maxPlayerCount + '\n' +
                "minPlayerAge= " + minPlayerAge + " years old" + '\n' +
                "minGameTime= " + minGameTime + " minutes" + '\n';
    }


}
