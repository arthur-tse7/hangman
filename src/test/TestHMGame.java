package test;

import model.*;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Arthur Desktop on 2016-05-02.
 */
public class TestHMGame {
    private HMGame game;

    @Before
    public void setUp() {
        game = new HMGame();
    }

    @Test
    public void testRemoveFromWordBank() {
        assertEquals(20, game.getWordBank().size());
        game.removeFromWordBank("peanut");
        assertEquals(19, game.getWordBank().size());
    }

    @Test
    public void testSetGameOver() {
        assertFalse(game.isGameOver());
        game.setGameOver(true);
        assertTrue(game.isGameOver());
    }

    @Test
    public void testConvertWordToLettersToGuess() {
        ArrayList<String> shortTest = new ArrayList<String>();
        shortTest.add("s");
        shortTest.add("e");
        shortTest.add("t");
        assertEquals(shortTest, game.convertWordToLettersToGuess("set"));
        ArrayList<String> longTest = new ArrayList<String>();
        longTest.add("c");
        longTest.add("h");
        longTest.add("e");
        longTest.add("r");
        longTest.add("i");
        longTest.add("s");
        assertEquals(longTest, game.convertWordToLettersToGuess("cherries"));
    }

    @Test
    public void testCheckGameOver() {
        game.checkGameOver();
        assertFalse(game.isGameOver());
        game.setHealth(0);
        game.checkGameOver();
        assertTrue(game.isGameOver());
        game.setHealth(8);
        game.checkGameOver();
        assertFalse(game.isGameOver());
        game.setLettersToGuess(new ArrayList<String>());
        game.checkGameOver();
        assertTrue(game.isGameOver());
    }
}
