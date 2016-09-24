package ui;

import model.HMGame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Arthur Desktop on 2016-05-03.
 */
public class HealthLabel extends JLabel {
    private HMGame game;

    public HealthLabel(HMGame game) {
        super("Health: " + Integer.toString(game.getHealth()));
        this.game = game;
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(new Font("Tahoma", Font.PLAIN, 18));
        setBounds(324, 237, 100, 63);
    }

    public void update() {
        setText("Health: " + Integer.toString(game.getHealth()));
    }
}
