package entities;

public abstract class entity {
    protected float x, y; //only classes who extends can use it
    public entity(float x, float y) {
         this.x = x; // we are given a variable and put it into ours variable
         this.y = y;

    }

}
