package utilz;

import main.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class loadsave {
    //we dont need an object
    public static final String PLAYER_ATLAS = "player_sprites.png";
    public static final String LEVEL_ATLAS = "outside_sprites.png";
    public static final String LEVEL_ONE_DATA = "level_one_data.png";
    public static BufferedImage getspriteatlas(String filename) {
        BufferedImage img = null;
        InputStream is = loadsave.class.getResourceAsStream("/" + filename ); // / is used to show that the img is not next to this class
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
        return img;
    }
    public static int[][] getleveldata() {
         int [][] lvldata = new int[game.TILES_IN_HEIGHT][game.TILES_IN_WIDTH];
         BufferedImage img = getspriteatlas(LEVEL_ONE_DATA);

         for (int j = 0; j < img.getHeight(); j++) {
             for(int i = 0; i < img.getWidth(); i ++) {
                 Color color = new Color(img.getRGB(i,j)); //using the color to define which block we are placing
                 int value = color.getRed();
                 if (value >= 48) {
                     value = 0;
                 }
                 lvldata[j][i] = value;
             }
         }
         return lvldata;
    }
}
