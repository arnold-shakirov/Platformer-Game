package inputs;
import main.gamepanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
                gamepanel.changeydelta(-5);
                break;
            case KeyEvent.VK_A:
                gamepanel.changexdelta(-5);
                break;
            case KeyEvent.VK_S:
                gamepanel.changeydelta( 5);
                break;
            case KeyEvent.VK_D:
                gamepanel.changexdelta( 5);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
