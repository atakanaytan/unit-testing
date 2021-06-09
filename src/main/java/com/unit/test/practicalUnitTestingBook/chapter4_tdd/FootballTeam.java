package com.unit.test.practicalUnitTestingBook.chapter4_tdd;

public class FootballTeam implements Comparable<FootballTeam> {

    private int gamesWon;

    public FootballTeam(int gamesWon) {
        if (gamesWon < 0) {
            throw new IllegalArgumentException("illegal match number: [ " + gamesWon + " ]");
        }
        this.gamesWon = gamesWon;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    @Override
    public int compareTo(FootballTeam otherTeam) {
        return gamesWon - otherTeam.getGamesWon();
    }
}
