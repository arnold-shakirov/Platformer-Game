package main;

import inputs.keyboardinputs;
import inputs.mouseinputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import static utilz.constants.playerconstants.*; // * means all
import static utilz.constants.directions.*;


public class gamepanel extends JPanel {
    private mouseinputs mouseinputs;
    private game game;
    public gamepanel(game game) {
         mouseinputs = new mouseinputs(this);
         this.game = game;
         setpanelsize();
         addKeyListener(new keyboardinputs(this));
         addMouseListener(mouseinputs);
         addMouseMotionListener(mouseinputs);
    }

    private void setpanelsize() {
        Dimension size = new Dimension(1280,800);
        setPreferredSize(size);
    }

    public void updategame() { // all of the game logic goes here, events and stuff to be updated

    }

    public void paintComponent(Graphics g) { // graphical updates go here
        super.paintComponent(g);
        game.render(g);

    }
    public game getgame() {
        return game;
    }




}
