package entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.constants.directions.*;
import static utilz.constants.directions.DOWN;
import static utilz.constants.playerconstants.*;

public class player extends entity{
    private BufferedImage[][] animations;
    private int anitick, aniindex, anispeed = 15;
    private int playeraction = IDLE;   //contains current player actions
    private boolean moving = false, attacking = false;
    private boolean left,up,right,down;
    private float playerspeed = 2.0f;
    public player(float x, float y) {
        super(x, y);
        loadanimations();
    }
    public void update() {
        updatepos();
        updateanimationtick(); // go through animation frames
        setanimation(); // what kind of animation

    }
    public void render(Graphics g) {
        g.drawImage(animations[playeraction][aniindex], (int)x, (int)y ,256,160, null);

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
        }
        else {
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
        if (left && !right) {
            x-= playerspeed;
            moving = true;
        }
        else if (right && !left) {
            x += playerspeed;
            moving = true;
        }
        if (up && !down) {
            y -= playerspeed;
            moving = true;
        }
        else if (down && !up) {
            y += playerspeed;
            moving = true;
        }

    }
    public void resetdirbooleans() {
        left = false;
    }
    public void setattacking(boolean attacking) {
        this.attacking = attacking;
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
        InputStream is = getClass().getResourceAsStream("/player_sprites.png"); // / is used to show that the img is not next to this class
        try { //stronger if, for loading a file path may not exist
            BufferedImage img = ImageIO.read(is);
            animations = new BufferedImage[9][6];
            for (int j = 0; j < animations.length; j ++) { // j is a row and i is columns, a number in a row
                for (int i = 0; i < animations[j].length; i++) {
                    animations[j][i] = img.getSubimage(i * 64, j*40, 64, 40);
                }
            }
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
}
