package com.gamenight;

public class BoardGame {
    //Final Fields
    public static final int MIN_PLAYER_AGE = 0;
    public static final int MAX_PLAYER_AGE = 100;
    public static final int MIN_GAME_TIME = 0;
    //Fields
    private String name;
    private GameType type = GameType.NO_TYPE_DEFINED;
    private int minPlayerCount;
    private int maxPlayerCount;
    private int minPlayerAge;
    private int minGameTime;
    private int averageGameTime;
    private boolean alternateEditionOfAnotherGame;
    private static int instanceCount = 0;

    public BoardGame() {
        instanceCount++;
    }

    //Constructors
    public BoardGame(String name) {
        this();
        setName(name);
    }

    public BoardGame(String name, GameType type) {
        this(name);
        setType(type);
    }

    public BoardGame(String name, GameType type, int minPlayerCount) {
        this(name, type);
        setMinPlayerCount(minPlayerCount);
    }

    public BoardGame(String name, GameType type, int minPlayerCount, int maxPlayerCount) {
        this(name, type, minPlayerCount);
        setMaxPlayerCount(maxPlayerCount);
    }

    public BoardGame(String name, GameType type, int minPlayerCount, int maxPlayerCount, int minPlayerAge) {
        this(name, type, minPlayerCount, maxPlayerCount);
        setMinPlayerAge(minPlayerAge);
    }

    //Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        if (minPlayerAge >= MIN_PLAYER_AGE && minPlayerAge <= MAX_PLAYER_AGE) {
            this.minPlayerAge = minPlayerAge;
        } else {
            System.out.println(minPlayerAge + " is not a valid volume");
        }
    }

    public int getMinGameTime() {
        return minGameTime;
    }

    public void setMinGameTime(int minGameTime) {
        if (minGameTime >= MIN_GAME_TIME) {
            this.minGameTime = minGameTime;
        } else {
            System.out.println(minGameTime + " is not valid, please set a value greater than 0");
        }
    }

    public int getAverageGameTime() {
        return averageGameTime;
    }

    public void setAverageGameTime(int averageGameTime) {
        this.averageGameTime = averageGameTime;
    }

    public boolean isAlternateEditionOfAnotherGame() {
        return alternateEditionOfAnotherGame;
    }

    public void setAlternateEditionOfAnotherGame(boolean alternateEditionOfAnotherGame) {
        this.alternateEditionOfAnotherGame = alternateEditionOfAnotherGame;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }
//Business Method
    public void canWePlay() {
        if (getMinGameTime() <= 60 && getMaxPlayerCount() >= 6) {
            System.out.printf("%nWe can Play: %s, it's a %s game!!!%n%n", getName(), getType());
        } else
            System.out.printf("We can't play %s tonight :( %n%n", getName());
    }
    //toString Override
    @Override
    public String toString() {
        return "BoardGame= " + name + '\n' +
                "type= " + type + '\n' +
                "minPlayerCount= " + minPlayerCount + '\n' +
                "maxPlayerCount= " + maxPlayerCount + '\n' +
                "minPlayerAge= " + minPlayerAge + " years old" + '\n' +
                "minGameTime= " + minGameTime + " minutes" + '\n' +
                "averageGameTime= " + averageGameTime + " minutes" + '\n' +
                "alternateEditionOfAnotherGame= " + alternateEditionOfAnotherGame + '\n';
    }


}
