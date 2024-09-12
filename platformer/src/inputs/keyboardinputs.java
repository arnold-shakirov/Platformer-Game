package inputs;
import main.gamepanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static utilz.constants.directions.*;

public class keyboardinputs implements KeyListener {
    private gamepanel gamepanel; //we use main.gamepanel because it is from a different package (group)
    public keyboardinputs(main.gamepanel gamepanel) {
        this.gamepanel = gamepanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                gamepanel.getgame().getplayer().setUp(true);
                break;
            case KeyEvent.VK_A:
                gamepanel.getgame().getplayer().setLeft(true);
                break;
            case KeyEvent.VK_S:
                gamepanel.getgame().getplayer().setDown(true);
                break;
            case KeyEvent.VK_D:
                gamepanel.getgame().getplayer().setRight(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                gamepanel.getgame().getplayer().setUp(false);
                break;
            case KeyEvent.VK_A:
                gamepanel.getgame().getplayer().setLeft(false);
                break;
            case KeyEvent.VK_S:
                gamepanel.getgame().getplayer().setDown(false);
                break;
            case KeyEvent.VK_D:
                gamepanel.getgame().getplayer().setRight(false);
                break;
        }
    }
}
