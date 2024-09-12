package utilz;

import main.game;

public class helpmethods {
    public static boolean canmovehere(float x, float y, float width, float height, int [][] lvldata) { //pass width and height from the hitbox
        if (!issolid(x,y,lvldata)) { //if it is not solid, top left
            if (!issolid(x+width,y+height,lvldata)) { //bottom right
                if(!issolid(x+width,y,lvldata)) { //top right
                    if (!issolid(x,y+height,lvldata)) { // bottom left
                         return true;
                    }
                    else {
                        return false;
                    }
                }

            }

        }
        return false;
    }
    private static boolean issolid(float x, float y, int[][] lvldata) {
        if (x < 0 || x >=  game.GAME_WIDTH) { //inside the game window
            return true;
        }
        if (y < 0 || y >= game.GAME_HEIGHT) {
            return true;
        }
        float xindex = x / game.TILES_SIZE; //number of the tile that you are on right now
        float yindex = y / game.TILES_SIZE;

        int value = lvldata[(int)yindex][(int)xindex];  //number of the sprite of the tile that you are on, there are 48 sprites

        if (value >= 48 || value < 0 || value != 11) {
             return true;
        }
        else{
            return false;
        }

    }
}
