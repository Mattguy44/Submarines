import java.awt.event.*;
import java.awt.*;
/**
 * Write a description of class WASD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WASD extends Submarine
{
    /*private int x;
    private int y;
    private boolean underWater;
    private int numTorpedoes;*/
    // above out because handled in superclass
    private Graphics G;
    //X for under
    //space for shoot
    public WASD(boolean isUnder, int torpedoes, int locX, int locY)
    {
        super(isUnder,torpedoes, locX, locY);
    }

    public void draw(Graphics g){
        g.setColor(Color.RED);
        if(isUnder()){
            g.setColor(Color.BLACK);
        }
        else{
            g.setColor(Color.RED);
        }
        if(getDir().equals("UP")){
            g.fillOval(getX(),getY(),15,40);
            g.fillRect(getX()-5,getY(),10,5);
        }
        if(getDir().equals("RIGHT")){
            g.fillOval(getX(),getY(),40,15);
            g.fillRect(getX()-5,getY(),10,5);
        }
        if(getDir().equals("LEFT")){
            g.fillOval(getX(),getY(),40,15);
            g.fillRect(getX()-5,getY(),10,5);
        }
        if(getDir().equals("DOWN")){
            g.fillOval(getX(),getY(),15,40);
            g.fillRect(getX()-5,getY(),10,5);
        }
        g.fillOval(getX()-20,getY()-8,40,15);
        G = g;
    }

    private class Listener implements KeyListener {
        public void keyTyped(KeyEvent e) {}

        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_A) {
                setX(getX()-5);
            }
            if (key == KeyEvent.VK_D) {
                setX(getX()+5);
            }
            if (key == KeyEvent.VK_W) {
                setY(getY()-5);
            }
            if (key == KeyEvent.VK_S) {
                setY(getY()+5);
            }
            draw(G);
        }

        public void keyReleased(KeyEvent e){
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_SPACE) {
                fire();
            }
            if (key == KeyEvent.VK_X){
                submerge();
            }
        }
    }
}
