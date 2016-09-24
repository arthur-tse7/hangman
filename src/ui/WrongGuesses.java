package ui;

import model.HMGame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Arthur Desktop on 2016-05-01.
 */
public class WrongGuesses extends JLabel {
    private HMGame game;

    public WrongGuesses(HMGame game) {
        super();
        this.game = game;
        setFont(new Font("Tahoma", Font.PLAIN, 14));
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(10, 237, 304, 63);
    }

    public void update() {
        String wrongGuesses = "";
        for (int i = 0; i < game.getWrongGuesses().size(); i++) {
            if (i == 0) {
                wrongGuesses = game.getWrongGuesses().get(i);
            } else {
                wrongGuesses = wrongGuesses + ", " + game.getWrongGuesses().get(i);
            }
        }
        setText(wrongGuesses);
    }
}
