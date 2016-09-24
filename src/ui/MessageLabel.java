package ui;

import model.HMGame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Arthur Desktop on 2016-05-01.
 */
public class MessageLabel extends JLabel{
    private HMGame game;

    public MessageLabel(HMGame game) {
        super();
        this.game = game;
        setFont(new Font("Tahoma", Font.PLAIN, 16));
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(10, 11, 414, 35);
    }

    public void update() {
        switch (game.getMessageToDisplay()) {
            case 0: setText("");
                    break;
            case 1: setText("You already guessed this letter.");
                    break;
            case 2: setText("Correct! This letter is in the word!");
                    break;
            case 3: setText("Wrong! This letter is not in this word!");
                    break;
        }
    }
}
