package entities;

import main.game;
import utilz.loadsave;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.constants.directions.*;
import static utilz.constants.directions.DOWN;
import static utilz.constants.playerconstants.*;
import static utilz.helpmethods.canmovehere;

public class player extends entity {
    private BufferedImage[][] animations;
    private int anitick, aniindex, anispeed = 15;
    private int playeraction = IDLE;   //contains current player actions
    private boolean moving = false, attacking = false;
    private boolean left, up, right, down;
    private float playerspeed = 2.0f;
    private int[][] lvldata;
    private float xdrawoffset = 21 * game.SCALE;
    private float ydrawoffset = 4 * game.SCALE;

    public player(float x, float y, int width, int height) {
        super(x, y, width, height);
        loadanimations();
        inithitbox(x,y,20*game.SCALE,28*game.SCALE); //the width and the lenght is 20 and 28 retrospectively
    }

    public void update() {
        updatepos();
        updateanimationtick(); // go through animation frames
        setanimation(); // what kind of animation

    }

    public void render(Graphics g) {
        g.drawImage(animations[playeraction][aniindex],(int)(hitbox.x - xdrawoffset), (int)(hitbox.y - ydrawoffset), width, height , null);
        drawhitbox(g);

    }

    private void updateanimationtick() {
        anitick++;
        if (anitick >= anispeed) {
            anitick = 0;
            aniindex++;
            if (aniindex >= GetSpriteAmount(playeraction)) { //depending on the player action we choose how many sprites, different amount of index
                aniindex = 0;
                attacking = false;
            }
        }
    }

    private void setanimation() { // what kind of animation we will have
        //we have to set index and tick of animation to zero to play new animation from the start
        int startani = playeraction;
        if (moving) {
            playeraction = RUNNING;
        } else {
            playeraction = IDLE;
        }
        if (attacking) {
            playeraction = ATTACK_1;
        }
        if (startani != playeraction) { //we changed action
            resetanitick();
        }
    }

    private void resetanitick() {
        anitick = 0;
        aniindex = 0;
    }

    private void updatepos() {
        moving = false;
        if (!left && !right && !up && ! down) //if we are holding eny button
            return;
        float xspeed = 0, yspeed = 0;
        if (left && !right)
            xspeed = -playerspeed;
        else if (right && !left)
            xspeed = playerspeed;
        if (up && !down)
            yspeed = -playerspeed;
        else if (down && !up)
            yspeed += playerspeed;
        //if (canmovehere(x+xspeed,y+yspeed,width,height,lvldata)) {
        //    this.x += xspeed;
        //    this.y += yspeed;
        //    moving = true;
        //}
        if (canmovehere(hitbox.x +xspeed,hitbox.y+yspeed,hitbox.width,hitbox.height,lvldata)) {
            hitbox.x += xspeed;
            hitbox.y += yspeed;
            moving = true;
        }
    }
    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    private void loadanimations() {
        BufferedImage img = loadsave.getspriteatlas(loadsave.PLAYER_ATLAS);
        animations = new BufferedImage[9][6];
        for (int j = 0; j < animations.length; j++) { // j is a row and i is columns, a number in a row
            for (int i = 0; i < animations[j].length; i++) {
                animations[j][i] = img.getSubimage(i * 64, j * 40, 64, 40);
            }
        }
    }
    public void loadlvldata(int[][] lvldata) {
        this.lvldata = lvldata;

    }

    public void resetdirbooleans() {
        left = false;
    }

    public void setattacking(boolean attacking) {
        this.attacking = attacking;
    }
}