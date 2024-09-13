package utilz;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class loadsave {
    //we dont need an object
    public static BufferedImage getplayeratlas() {
        BufferedImage img = null;
        InputStream is = loadsave.class.getResourceAsStream("/player_sprites.png"); // / is used to show that the img is not next to this class
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
}
