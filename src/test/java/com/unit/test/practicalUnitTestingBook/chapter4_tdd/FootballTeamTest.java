package com.unit.test.practicalUnitTestingBook.chapter4_tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class FootballTeamTest {

    private static final int THREE_GAMES_WON = 3;
    private static final int ANY_NUMBER = 122;

    private static int[] nbOfGamesWon() {
        return new int[]{0, 1, 2};
    }

    private static int[] illegalNBOfGamesWon() { return new int[]{-10, -1}; }

    @Test
    public void constructorShouldSetGamesWon() {
        FootballTeam team = new FootballTeam(THREE_GAMES_WON);
        assertEquals(THREE_GAMES_WON, team.getGamesWon());
    }

    @ParameterizedTest
    @MethodSource("nbOfGamesWon")
    public void constructorShouldSetGamesWon(int nbOfGamesWon) {
        FootballTeam footballTeam = new FootballTeam(nbOfGamesWon);
        assertEquals(nbOfGamesWon, footballTeam.getGamesWon());
    }

    @ParameterizedTest
    @MethodSource("illegalNBOfGamesWon")
    public void constructorShouldThrowIAEForInvalidGameNo(int nbOfGamesWon) {
        assertThrows(IllegalArgumentException.class, () -> new FootballTeam(nbOfGamesWon));
    }

    @Test
    public void shouldBePossibleToCompareTeams() {
        FootballTeam footballTeam = new FootballTeam(ANY_NUMBER);

        assertTrue(footballTeam instanceof Comparable,
                "Football team should implement Comparable");
    }

    @Test
    public void teamsWithMoreMatchesShouldBeGreater() {
        FootballTeam team_2 = new FootballTeam(2);
        FootballTeam team_3 = new FootballTeam(3);

        assertTrue(team_3.compareTo(team_2) > 0);
    }

    @Test
    public void teamsWithLessMatchesShouldBeLesser() {
        FootballTeam team_2 = new FootballTeam(2);
        FootballTeam team_3 = new FootballTeam(3);

        assertTrue(team_2.compareTo(team_3) < 0,
                "team with " + team_2.getGamesWon()
                    + " games won should be ranked after the team with "
                    + team_3.getGamesWon() + " games won");
    }

    @Test
    public void teamsWithSameNumberOfMatchesWonShouldBeEqual() {
        FootballTeam teamA = new FootballTeam(3);
        FootballTeam teamB = new FootballTeam(3);

        assertEquals(0, teamA.compareTo(teamB),
                "both teams have won the same number of games: "
                + teamA.getGamesWon() + " vs. " + teamB.getGamesWon()
                + " and should be ranked equal ");
    }
}
