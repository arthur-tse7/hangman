package ui;

import model.HMGame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Arthur Desktop on 2016-05-01.
 */
public class CurrentGuess extends JLabel{
    private HMGame game;

    public CurrentGuess(HMGame game) {
        super();
        this.game = game;
        setBlankGuess();
        setFont(new Font("Tahoma",Font.PLAIN, 30));
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(10, 57, 414, 169);
    }

    private void setBlankGuess() {
        String blank = "";
        for (int i = 0; i < game.getWord().length(); i++) {
            if (i == 0) {
                blank = "_";
            } else {
                blank = blank + " _";
            }
        }
        setText(blank);
    }

    public void update() {
        String guess = "";
        for (int i = 0; i < game.getWord().length(); i++) {
            String l = game.getWord().substring(i, i + 1);
            if (i == 0) {
                if (game.getCorrectGuesses().contains(l))
                    guess = l;
                if (game.getLettersToGuess().contains(l))
                    guess = "_";
            } else {
                if (game.getCorrectGuesses().contains(l))
                    guess = guess + " " + l;
                if (game.getLettersToGuess().contains(l))
                    guess = guess + " _";
            }
        }
        setText(guess);
    }

}
