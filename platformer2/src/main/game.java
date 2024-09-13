package main;

public class game {
     private gamewindow gamewindow;
     private gamepanel gamepanel;
     public game() {
         gamepanel = new gamepanel();
         gamewindow = new gamewindow(gamepanel);
         gamepanel.requestFocus();



     }
}
