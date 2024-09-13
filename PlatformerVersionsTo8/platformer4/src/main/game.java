package main;

public class game implements Runnable{
     private gamewindow gamewindow;
     private gamepanel gamepanel;
     private Thread gamethread;
     private final int FPS_SET = 120;
     public game() {
         gamepanel = new gamepanel();
         gamewindow = new gamewindow(gamepanel);
         gamepanel.requestFocus();
         startgameloop();
     }
    private void startgameloop() {
         gamethread = new Thread(this);
         gamethread.start();
    }
    @Override
    public void run() {
         double timeperframe = 1000000000.0 / FPS_SET; //WE NEED TO CHECK IT IN NANOSECONDS
         long lastframe = System.nanoTime();
         long now = System.nanoTime();
         int frames = 0;
         long lastcheck =System.currentTimeMillis();
        while(true) {
            now = System.nanoTime();
            if (now - lastframe >= timeperframe) {
                gamepanel.repaint();
                lastframe = now;
                frames++;
            }
            if (System.currentTimeMillis() - lastcheck >= 1000) { //print out fps in console
                lastcheck = System.currentTimeMillis();
                System.out.println("FPS:" + frames);
                frames = 0;
            }
        }


    }
}
