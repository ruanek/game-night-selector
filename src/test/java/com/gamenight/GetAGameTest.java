package com.gamenight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.gamenight.GetAGame.*;
import static org.junit.jupiter.api.Assertions.*;

class GetAGameTest {
    ArrayList<PlayerInfo> playersInAttendanceArray;
    static ArrayList<PlayerInfo> playersArray = CSVParserGameNightSelector.getPlayerInfo();

    static Map<String, PlayerInfo> playersMap;
    static {
        playersMap = new HashMap<>();
        for (PlayerInfo player : playersArray) {
            playersMap.put(player.getPlayerName(), player);
        }
    }

    @BeforeEach
    void setUp() {
        playersInAttendanceArray = new ArrayList<>();
        playersInAttendanceArray.add(playersMap.get("Bill"));
        playersInAttendanceArray.add(playersMap.get("Bob"));
        playersInAttendanceArray.add(playersMap.get("Tim"));
    }


    @Test
    void filterGamesTest() {
        ArrayList<BoardGame> filteredGames = filterGames(playersInAttendanceArray);
        assertEquals("Terraforming-Mars",filteredGames.get(0).getGameName());
        assertEquals("Dune",filteredGames.get(1).getGameName());

        playersInAttendanceArray.add(playersMap.get("Joe"));
        filteredGames = filterGames(playersInAttendanceArray);
        assertTrue(filteredGames.isEmpty());
    }

    @Test
    void getPlayerCountInAttendanceTest() {
        // should be equal to size 3
        assertEquals(getPlayerCountInAttendance(playersInAttendanceArray), playersInAttendanceArray.size());
        playersInAttendanceArray.add(playersMap.get("Jane"));
        // should now be equal to size 4, I added Jane
        assertEquals(getPlayerCountInAttendance(playersInAttendanceArray), playersInAttendanceArray.size());
        // should now be equal to size 3 again, I removed Tim
        playersInAttendanceArray.remove(playersMap.get("Tim"));
        assertEquals(getPlayerCountInAttendance(playersInAttendanceArray), playersInAttendanceArray.size());
    }

    @Test
    void getAgeRestrictionInAttendanceTest() {
        int ageRestriction = getAgeRestrictionInAttendance(playersInAttendanceArray);
        assertEquals(23, ageRestriction);

        // try adding a player that is younger than the current players in attendance
        // then reinitialize the age restriction by calling our helper method getAgeRestrictionInAttendance
        // expected value should have changed to the youngest player which is Joe
        playersInAttendanceArray.add(playersMap.get("Joe"));
        ageRestriction = getAgeRestrictionInAttendance(playersInAttendanceArray);
        assertEquals(5, ageRestriction);
    }

    @Test
    void getGameTypePreferenceInAttendanceTest() {
        assertEquals(playersInAttendanceArray.get(0).getGameType(),GameType.RESOURCE_CONTROL); // Bob's game type
        assertEquals(playersInAttendanceArray.get(1).getGameType(),GameType.DECK_BUILDER); // Bill's game type
        assertEquals(playersInAttendanceArray.get(2).getGameType(),GameType.PATTERN_BUILDING); // Tim's game type
    }

    @Test
    void getPlayerNamesInAttendanceTest() {
        assertEquals(playersInAttendanceArray.get(0).getPlayerName(), "Bill");
        assertEquals(playersInAttendanceArray.get(1).getPlayerName(), "Bob");
        assertEquals(playersInAttendanceArray.get(2).getPlayerName(), "Tim");
        playersInAttendanceArray.add(playersMap.get("Joseph"));
        assertEquals(playersInAttendanceArray.get(3).getPlayerName(), "Joseph");
    }
}