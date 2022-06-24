package com.gamenight.client;

import com.gamenight.BoardGame;
import com.gamenight.GameType;

public class BoardGameClient {


    public static void main(String[] args) {

        BoardGame newGame1 = new BoardGame("Dune", GameType.RESOURCE_CONTROL);
        newGame1.setMinPlayerCount(2);
        newGame1.setMaxPlayerCount(6);
        newGame1.setMinPlayerAge(14);
        newGame1.setMinGameTime(120);
        newGame1.setAverageGameTime(240);
        newGame1.setAlternateEditionOfAnotherGame(false);

        BoardGame newGame2 = new BoardGame("Ticket to Ride: Rails and Sails");
        newGame2.setType(GameType.AREA_CONTROL);
        newGame2.setMinPlayerCount(2);
        newGame2.setMaxPlayerCount(5);
        newGame2.setMinPlayerAge(10);
        newGame2.setMinGameTime(60);
        newGame2.setAverageGameTime(90);
        newGame2.setAlternateEditionOfAnotherGame(true);

        BoardGame newGame3 = new BoardGame();

        System.out.println(newGame1);
        newGame1.canWePlay();
        System.out.println(newGame2);
        newGame2.canWePlay();
        System.out.println(newGame3);
        newGame3.canWePlay();

        BoardGame newGame4 = new BoardGame("Test_Business_Method", GameType.WORKER_PLACEMENT, 1, 8, 12);
        newGame4.setMinGameTime(45);
        System.out.println(newGame4);
        newGame4.canWePlay();

        System.out.println(BoardGame.getInstanceCount() + " Games");
    }
}
