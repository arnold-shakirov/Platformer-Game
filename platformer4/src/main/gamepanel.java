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
    private float xdelta=100, ydelta=100;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private int anitick, aniindex, anispeed = 15;
    private int playeraction = IDLE;   //contains current player actions
    private int playerdir = -1;
    private boolean moving = false;
    public gamepanel() {
         mouseinputs = new mouseinputs(this);
         importimg();
         loadanimations();
         setpanelsize();
         addKeyListener(new keyboardinputs(this));
         addMouseListener(mouseinputs);
         addMouseMotionListener(mouseinputs);
    }

    private void loadanimations() {
        animations = new BufferedImage[9][6];
        for (int j = 0; j < animations.length; j ++) { // j is a row and i is columns, a number in a row
            for (int i = 0; i < animations[j].length; i++) {
                animations[j][i] = img.getSubimage(i * 64, j*40, 64, 40);
            }
        }
    }

    private void importimg() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png"); // / is used to show that the img is not next to this class
       try { //stronger if, for loading a file path may not exist
           img = ImageIO.read(is);
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           try {
               is.close();
           } catch (IOException e) {
               e.printStackTrace();
           }

       }
    }

    private void setpanelsize() {
        Dimension size = new Dimension(1280,800);
        setPreferredSize(size);
    }
    public void setDirection (int direction) {
        this.playerdir = direction;
        moving = true;

    }
    public void setmoving(boolean moving) {
         this.moving = moving;
    }

    private void updateanimationtick() {
       anitick++;
       if (anitick >= anispeed) {
           anitick = 0;
           aniindex++;
           if (aniindex >= GetSpriteAmount(playeraction)) { //depending on the player action we choose how many sprites, different amount of index
                aniindex = 0;
           }
       }
    }
    private void setanimation() { // what kind of animation we will have
        if (moving) {
            playeraction = RUNNING;
        }
        else {
            playeraction = IDLE;
        }
    }
    private void updatepos() {
        if (moving) {
            switch (playerdir) {
                case LEFT:
                    xdelta -= 5;
                    break;
                case UP:
                    ydelta -= 5;
                    break;
                case RIGHT:
                    xdelta += 5;
                    break;
                case DOWN:
                    ydelta += 5;
                    break;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateanimationtick(); // go through animation frames
        setanimation(); // what kind of animation
         updatepos();
        g.drawImage(animations[playeraction][aniindex], (int)xdelta, (int)ydelta ,256,160, null);


    }




}
