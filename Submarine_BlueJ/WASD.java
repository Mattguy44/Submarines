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
        if(isUnder()){
            g.setColor(Color.BLACK);
        }
        else{
            g.setColor(Color.RED);
        }
        g.fillOval(getX()-20,getY()-8,40,15);
        G = g;
    }
    private class Listener implements KeyListener {
        public void keyTyped(KeyEvent e) {}
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT) {
                setX(getX()-5);
            }
            if (key == KeyEvent.VK_RIGHT) {
                setX(getX()+5);
            }
            if (key == KeyEvent.VK_UP) {
                setY(getY()-5);
            }
            if (key == KeyEvent.VK_DOWN) {
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
