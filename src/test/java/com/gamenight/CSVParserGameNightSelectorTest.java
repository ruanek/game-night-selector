package com.gamenight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CSVParserGameNightSelectorTest {

    @Test
    void getPlayerInfo() {
        PlayerInfo player = new PlayerInfo("Bill", 23, GameType.RESOURCE_CONTROL);

        // test the Obj setters and ctor to make sure the object came out correct
        assertEquals("Bill", player.getPlayerName());
        assertEquals(23, player.getPlayerAge());
        assertEquals(GameType.RESOURCE_CONTROL, player.getGameType());
    }

    @Test
    void getGameInfo() {
        BoardGame game = new BoardGame("Bill", "Dune",
                GameType.RESOURCE_CONTROL, 2, 6, 14);

        // test the Obj setters and ctor to make sure the object came out correct
        assertEquals("Dune", game.getGameName());
        assertEquals("Bill", game.getPlayerName());
        assertEquals(GameType.RESOURCE_CONTROL, game.getType());
        assertEquals(2, game.getMinPlayerCount());
        assertEquals(6, game.getMaxPlayerCount());
        assertEquals(14, game.getMinPlayerAge());
    }
}