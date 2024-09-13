package main;

import inputs.keyboardinputs;
import inputs.mouseinputs;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class gamepanel extends JPanel {
    private mouseinputs mouseinputs;
    private float xdelta=100, ydelta=100;
    private float xdir = 1f, ydir = 1f;
    private int frames = 0;
    private long lastcheck = 0;
    private Color color = new Color(150,20,90);
    private Random random;
    public gamepanel() {
         random = new Random();
         mouseinputs = new mouseinputs(this);
         addKeyListener(new keyboardinputs(this));
         addMouseListener(mouseinputs);
         addMouseMotionListener(mouseinputs);
    }
    public void changexdelta(int value) {
        this.xdelta += value;
        //repaint(); //we call paintcomponent actually  each time we use repaint, we say to go there and paint everything again
    }
    public void changeydelta(int value) {
        this.ydelta += value;
        //repaint();
    }
    public void setrectpos(int x, int y) {
         this.xdelta = x;
         this.ydelta = y;
         //repaint();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        updaterectangle();
        g.setColor(color);
        g.fillRect((int)xdelta, (int)ydelta, 200, 50);


    }

    private void updaterectangle() {
        xdelta += xdir;
        if (xdelta > 400 || xdelta < 0 ) {
            xdir*=-1;
            color = getrndcolor();
        }
        ydelta += ydir;
        if (ydelta > 400 || ydelta < 0) {
            ydir*=-1;
            color = getrndcolor();
        }
    }

    private Color getrndcolor() {
         int r = random.nextInt(255), g = random.nextInt(255),  b = random.nextInt(255);
        return new Color(r,g,b);
    }
}
