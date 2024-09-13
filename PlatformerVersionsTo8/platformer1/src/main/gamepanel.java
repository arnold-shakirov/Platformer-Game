package main;

import javax.swing.*;
import java.awt.*;

public class gamepanel extends JPanel {
     public gamepanel() {


     }
     public void paintComponent(Graphics g) {
         super.paintComponent(g);
        g.fillRect(100, 100, 200, 50);
     }
}
