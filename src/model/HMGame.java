package model;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * Created by Arthur Desktop on 2016-05-01.
 */
public class HMGame {

    private LinkedList<String> wordBank;
    private int health;
    private String word;
    private List<String> lettersToGuess;
    private List<String> correctGuesses;
    private List<String> wrongGuesses;
    private int messageToDisplay;
    private boolean isGameOver;

    public HMGame() {
        correctGuesses = new ArrayList<String>();
        wrongGuesses = new ArrayList<String>();
        wordBank = new LinkedList<String>();
        wordBank.add("peanut");
        wordBank.add("seven");
        wordBank.add("spaghetti");
        wordBank.add("bread");
        wordBank.add("cold");
        wordBank.add("cherries");
        wordBank.add("ten");
        wordBank.add("elephant");
        wordBank.add("hibernation");
        wordBank.add("forger");
        wordBank.add("puzzle");
        wordBank.add("feather");
        wordBank.add("lust");
        wordBank.add("hideous");
        wordBank.add("focus");
        wordBank.add("neon");
        wordBank.add("barber");
        wordBank.add("mutilation");
        wordBank.add("ray");
        wordBank.add("crumply");
        setUp();
    }

    public void setUp() {
        health = 8;
        word = wordBank.getFirst();
        lettersToGuess = convertWordToLettersToGuess(word);
        correctGuesses.clear();
        wrongGuesses.clear();
        messageToDisplay = 0;
        isGameOver = false;
    }

    public LinkedList<String> getWordBank() {
        return wordBank;
    }

    public int getHealth() {
        return health;
    }

    public String getWord() {
        return word;
    }

    public List<String> getLettersToGuess() {
        return lettersToGuess;
    }

    public List<String> getCorrectGuesses() {
        return correctGuesses;
    }

    public List<String> getWrongGuesses() {
        return wrongGuesses;
    }

    public int getMessageToDisplay() {
        return messageToDisplay;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public boolean isWordBankEmpty() {
        return wordBank.isEmpty();
    }

    public void removeFromWordBank(String s) {
        wordBank.remove(s);
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setLettersToGuess(List<String> lettersToGuess) {
        this.lettersToGuess = lettersToGuess;
    }

    public List<String> convertWordToLettersToGuess(String word) {
        List<String> ret = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            String s = word.substring(i, i + 1);
            if (!ret.contains(s)) {
                ret.add(s);
            }
        }
        return ret;
    }

    private void guess(String s) {
        if (correctGuesses.contains(s) || wrongGuesses.contains(s)) {
            messageToDisplay = 1;
        } else if (lettersToGuess.contains(s)) {
            correctGuesses.add(s);
            lettersToGuess.remove(s);
            messageToDisplay = 2;
        } else {
            wrongGuesses.add(s);
            messageToDisplay = 3;
            health--;
        }
        checkGameOver();
    }

    public void checkGameOver() {
        if (health == 0 || lettersToGuess.size() == 0) {
            isGameOver = true;
            wordBank.remove(word);
        } else {
            isGameOver = false;
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A)
            guess("a");
        if (e.getKeyCode() == KeyEvent.VK_B)
            guess("b");
        if (e.getKeyCode() == KeyEvent.VK_C)
            guess("c");
        if (e.getKeyCode() == KeyEvent.VK_D)
            guess("d");
        if (e.getKeyCode() == KeyEvent.VK_E)
            guess("e");
        if (e.getKeyCode() == KeyEvent.VK_F)
            guess("f");
        if (e.getKeyCode() == KeyEvent.VK_G)
            guess("g");
        if (e.getKeyCode() == KeyEvent.VK_H)
            guess("h");
        if (e.getKeyCode() == KeyEvent.VK_I)
            guess("i");
        if (e.getKeyCode() == KeyEvent.VK_J)
            guess("j");
        if (e.getKeyCode() == KeyEvent.VK_K)
            guess("k");
        if (e.getKeyCode() == KeyEvent.VK_L)
            guess("l");
        if (e.getKeyCode() == KeyEvent.VK_M)
            guess("m");
        if (e.getKeyCode() == KeyEvent.VK_N)
            guess("n");
        if (e.getKeyCode() == KeyEvent.VK_O)
            guess("o");
        if (e.getKeyCode() == KeyEvent.VK_P)
            guess("p");
        if (e.getKeyCode() == KeyEvent.VK_Q)
            guess("q");
        if (e.getKeyCode() == KeyEvent.VK_R)
            guess("r");
        if (e.getKeyCode() == KeyEvent.VK_S)
            guess("s");
        if (e.getKeyCode() == KeyEvent.VK_T)
            guess("t");
        if (e.getKeyCode() == KeyEvent.VK_U)
            guess("u");
        if (e.getKeyCode() == KeyEvent.VK_V)
            guess("v");
        if (e.getKeyCode() == KeyEvent.VK_W)
            guess("w");
        if (e.getKeyCode() == KeyEvent.VK_X)
            guess("x");
        if (e.getKeyCode() == KeyEvent.VK_Y)
            guess("y");
        if (e.getKeyCode() == KeyEvent.VK_Z)
            guess("z");
    }
}
