package ui;

import model.HMGame;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * Created by Arthur Desktop on 2016-04-30.
 */
public class HangmanGame extends JFrame {

    private static final int INTERVAL = 20;
    private HMGame game;
    private MessageLabel mLabel;
    private CurrentGuess cGuess;
    private WrongGuesses wGuess;
    private HealthLabel hLabel;
    private Timer t;

    public HangmanGame() {
        super ("Hangman");
        game = new HMGame();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 450, 350);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        mLabel = new MessageLabel(game);
        contentPane.add(mLabel);

        cGuess = new CurrentGuess(game);
        contentPane.add(cGuess);

        wGuess = new WrongGuesses(game);
        contentPane.add(wGuess);

        hLabel = new HealthLabel(game);
        contentPane.add(hLabel);

        addKeyListener(new KeyHandler());
        centreOnScreen();
        setVisible(true);
        addTimer();
        t.start();
    }

    // Centres frame on desktop
    // modifies: this
    // effects:  location of frame is set so frame is centred on desktop
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

    // Set up timer
    // modifies: none
    // effects:  initializes a timer that updates game each
    //           INTERVAL milliseconds
    private void addTimer() {
        t = new Timer(INTERVAL, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                mLabel.update();
                cGuess.update();
                wGuess.update();
                hLabel.update();
                
                if (game.isGameOver())
                    gameOver();
            }
        });
    }

    private void gameOver() {
        int input = JOptionPane.showOptionDialog(null, "Game Over!", "Replay?", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

        if (input == JOptionPane.YES_OPTION) {
            if (game.isWordBankEmpty()) {
                emptyWordBank();
            } else {
                game.setUp();
            }
        }
        if (input == JOptionPane.NO_OPTION || input == JOptionPane.CANCEL_OPTION) {
            game.setGameOver(false);
            setVisible(false);
            dispose();
            System.exit(0);
        }
    }

    private void emptyWordBank() {
        JOptionPane.showMessageDialog(null, "No more words in word bank!", "Close Hangman", JOptionPane.INFORMATION_MESSAGE);
        game.setGameOver(false);
        setVisible(false);
        dispose();
        System.exit(0);
    }

    /*
	 * A key handler to respond to key events
	 */
    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            game.keyPressed(e);
        }
    }

    public static void main (String ... args) {
        new HangmanGame();
    }
}
