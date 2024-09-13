package inputs;
import main.gamepanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class mouseinputs implements MouseListener, MouseMotionListener {
    private gamepanel gamepanel;
    public mouseinputs(gamepanel gamepanel) {
        this.gamepanel = gamepanel;

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // gamepanel.setrectpos(e.getX(),e.getY());
    }
}
