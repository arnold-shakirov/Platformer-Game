package entities;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class entity {
    protected float x, y; //only classes who extends can use it
    protected int width, height;
    protected Rectangle2D.Float hitbox;
    public entity(float x, float y, int width, int height) {
         this.x = x; // we are given a variable and put it into ours variable
         this.y = y;
         this.width = width;
         this.height = height;

    }
    protected void drawhitbox(Graphics g) {
        //for debugging the hitbox
        g.setColor(Color.RED);
        g.drawRect((int)hitbox.x,(int)hitbox.y, (int)hitbox.width, (int)hitbox.height);
    }
    protected void inithitbox(float x, float y, float width, float height) {
         hitbox = new Rectangle2D.Float(x,y,width,height);
    }
    //protected void updatehitbox() {
    //    hitbox.x = (int)x;
    //    hitbox.y = (int)y;
    //}
    public Rectangle2D.Float getHitBox() {
        return hitbox;
    }

}
