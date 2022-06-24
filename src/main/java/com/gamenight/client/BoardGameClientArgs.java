package com.gamenight.client;

import com.gamenight.BoardGame;
import com.gamenight.GameType;

class BoardGameClientArgs {

    public static void main(String[] args) {
        if (args.length < 5) {
            String usage = "Usage: java com.gamenight.client.BoardGameClientArgs <name> <type> <minPlayerCount> <maxPlayerCount>, <minPlayerAge>";
            String example = "Example: java com.gamenight.client.TelevisionClientArgs Terraforimng_Mars AREA_CONTROL 1 5 12";
            String note = "Note: available game types are WORKER_PLACEMENT, RESOURCE_CONTROL, DECK_BUILDER, AREA_CONTROL, LEGACY, MYSTERY, COMBAT, NO_TYPE_DEFINED;";
            System.out.println(usage);
            System.out.println(example);
            System.out.println(note);
            return;
        }

        System.out.println(args.length + " arguments have been provided");

        BoardGame newGame1 = new BoardGame(args[0], GameType.valueOf(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]));
        System.out.println(newGame1);
    }
}
