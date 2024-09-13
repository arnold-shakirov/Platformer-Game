package main;
import entities.player;

import java.awt.*;

public class game implements Runnable{
     private gamewindow gamewindow;
     private gamepanel gamepanel;
     private Thread gamethread;
     private final int FPS_SET = 120;
     private final int UPS_SET = 200;
     private player player;
     public game() {
         initclasses();
         gamepanel = new gamepanel(this);
         gamewindow = new gamewindow(gamepanel);
         gamepanel.requestFocus();

         startgameloop();

     }

    private void initclasses() {
         player =  new player(200,200);
    }

    private void startgameloop() {
         gamethread = new Thread(this);
         gamethread.start();
    }
    public void update() {
          //if you want to update player then player.update() if level level.update();
        player.update();
    }
    public void render(Graphics g) {
         player.render(g);



    }
    @Override
    public void run() {
         double timeperframe = 1000000000.0 / FPS_SET; //WE NEED TO CHECK IT IN NANOSECONDS
        double timeperupdate = 1000000000.0 / UPS_SET;
         long previoustime = System.nanoTime();
         int frames = 0;
         int updates = 0;
         long lastcheck =System.currentTimeMillis();

         double deltau = 0;
         double deltaf = 0;

        while(true) {
            long currenttime= System.nanoTime();

            deltau += (currenttime - previoustime) / timeperupdate; //its more than one when time passed more than update per frame
            deltaf += (currenttime - previoustime) / timeperframe;
            previoustime = currenttime;
            if (deltau >= 1) {
                update();
                updates++;
                deltau--; //if there is left next time it will update a little sooner
            }
            if (deltaf >= 1) {
                gamepanel.repaint();
                frames++;
                deltaf--;
            }

            //if (now - lastframe >= timeperframe) {
            //    gamepanel.repaint();
            //    lastframe = now;
            //    frames++;
            //}
            if (System.currentTimeMillis() - lastcheck >= 1000) { //print out fps in console
                lastcheck = System.currentTimeMillis();
                System.out.println("FPS:" + frames + " UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }


    }
    public void windowfocuslost() {
         player.resetdirbooleans();
    }
    public player getplayer() {
         return player;
    }


}
