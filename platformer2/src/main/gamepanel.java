package main;

import inputs.keyboardinputs;
import inputs.mouseinputs;

import javax.swing.*;
import java.awt.*;

public class gamepanel extends JPanel {
    private mouseinputs mouseinputs;
    private int xdelta=100;
    private int ydelta=100;
    public gamepanel() {
         mouseinputs = new mouseinputs(this);
         addKeyListener(new keyboardinputs(this));
         addMouseListener(mouseinputs);
         addMouseMotionListener(mouseinputs);
    }
    public void changexdelta(int value) {
        this.xdelta += value;
        repaint(); //we call paintcomponent actually  each time we use repaint, we say to go there and paint everything again
    }
    public void changeydelta(int value) {
        this.ydelta += value;
        repaint();
    }
    public void setrectpos(int x, int y) {
         this.xdelta = x;
         this.ydelta = y;
         repaint();
    }
    public void paintComponent(Graphics g) {
         super.paintComponent(g);
        g.fillRect(xdelta, ydelta, 200, 50);
    }
}
