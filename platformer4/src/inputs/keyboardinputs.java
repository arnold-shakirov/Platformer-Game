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
                gamepanel.setDirection(UP);
                break;
            case KeyEvent.VK_A:
                gamepanel.setDirection(LEFT);
                break;
            case KeyEvent.VK_S:
                gamepanel.setDirection(DOWN);
                break;
            case KeyEvent.VK_D:
                gamepanel.setDirection(RIGHT);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_A:
            case KeyEvent.VK_S:
            case KeyEvent.VK_D:
                gamepanel.setmoving(false);
                break;
        }
    }
}
