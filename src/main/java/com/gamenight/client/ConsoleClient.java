package com.gamenight.client;

import com.gamenight.BoardGame;
import com.gamenight.GetAGame;

public class ConsoleClient {


    public static void main(String[] args) {
        BoardGame game = GetAGame.pickAGame();
        System.out.printf("The Game Selected is = %s", game.getGameName());
    }
}

