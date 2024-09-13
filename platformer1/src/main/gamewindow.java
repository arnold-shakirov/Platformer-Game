package main;

import javax.swing.*;

public class gamewindow {
    private JFrame jframe;
    public gamewindow(gamepanel gamepanel) {
        jframe = new JFrame();
        jframe.setSize(400,400);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(gamepanel);
        jframe.setVisible(true);

    }
}
