package levels;

import main.game;
import utilz.loadsave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class levelmanager {
    private game game;
    private BufferedImage[] levelsprite;
    private level levelone;
    public levelmanager(game game) {
        this.game = game;
//        levelsprite = loadsave.getspriteatlas(loadsave.LEVEL_ATLAS);
        importoutsidesprites();
        levelone =  new level(loadsave.getleveldata());
    }

    private void importoutsidesprites() {
         BufferedImage img =  loadsave.getspriteatlas(loadsave.LEVEL_ATLAS);
        levelsprite = new BufferedImage[48];
        for (int j = 0; j < 4; j ++) {
            for (int i = 0; i < 12; i ++) {
                 int index = j * 12 +  i;
                 levelsprite[index] = img.getSubimage(i*32,j*32, 32,32);
            }
        }
    }

    public void draw (Graphics g) {
        for (int j = 0; j < game.TILES_IN_HEIGHT; j ++) {
            for (int i = 0; i < game.TILES_IN_WIDTH; i ++) {
                int index = levelone.getspriteindex(i,j);
                g.drawImage(levelsprite[index], game.TILES_SIZE*i, game.TILES_SIZE*j, game.TILES_SIZE, game.TILES_SIZE, null);
            }
        }



    }
    public void update() {

    }
    public level getcurrentlvl() {
        return levelone;
    }
}
