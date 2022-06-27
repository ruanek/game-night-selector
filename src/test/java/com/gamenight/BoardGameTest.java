package com.gamenight;

public class BoardGameTest {

    public static void main(String[] args) {
        BoardGame newGame1 = new BoardGame("Test Game 1");
        newGame1.setMinPlayerAge(7);
        System.out.println(newGame1.getMinPlayerAge());

        newGame1.setMinPlayerAge(-2);
        System.out.println(newGame1.getMinPlayerAge());
        assert newGame1.getMinPlayerAge() == 7;

        newGame1.setMinPlayerAge(101);
        System.out.println(newGame1.getMinPlayerAge());
        assert newGame1.getMinPlayerAge() == 7;

        newGame1.setMinGameTime(30);
        newGame1.setMinGameTime(-20);
        System.out.println(newGame1.getMinGameTime());
        assert newGame1.getMinGameTime() == 30;

        BoardGame newGame2 = new BoardGame("Test Game 2", GameType.MYSTERY);
        System.out.println(newGame2.getGameName());


    }
}
