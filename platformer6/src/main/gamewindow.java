package main;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class gamewindow {
    private JFrame jframe;
    public gamewindow(gamepanel gamepanel) {
        jframe = new JFrame();
        //jframe.setSize(400,400);

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(gamepanel);
        jframe.setLocationRelativeTo(null); // window  spawn in the center
        jframe.setResizable(false);
        jframe.pack();
        jframe.setVisible(true);
        jframe.addWindowFocusListener(new WindowFocusListener() { //to not ontinue running while in another window
            @Override
            public void windowGainedFocus(WindowEvent e) {
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                 gamepanel.getgame().windowfocuslost();
                System.out.println("bye") ;
            }
        });

    }
}
