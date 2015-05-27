<<<<<<< HEAD
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

=======
import java.awt.event.*;
import java.awt.*;
>>>>>>> 67cb52596ae41c86dd1d85fa88cc1225d7b1bd2d
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
    public String getDir(){
        return curDir;
    }
    public void draw(Graphics g){
        g.setColor(Color.RED);
        if(isUnder()){
            g.setColor(Color.BLACK);
        }
        else{
            g.setColor(Color.RED);
        }
        if(this.getDir().equals("UP")){
            g.fillOval(getX(),getY(),15,40);
            g.fillRect(getX()-5,getY(),10,5);
        }
        if(this.getDir().equals("RIGHT")){
            g.fillOval(getX(),getY(),40,15);
            g.fillRect(getX()-5,getY(),10,5);
        }
        if(this.getDir().equals("LEFT")){
            g.fillOval(getX(),getY(),40,15);
            g.fillRect(getX()-5,getY(),10,5);
        }
        if(this.getDir().equals("DOWN")){
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
<<<<<<< HEAD
            if (key == KeyEvent.VK_A) {
                x = -5;
                //repaint();
            }
            if (key == KeyEvent.VK_D) {
                x = 5;
                //repaint();
            }
            if (key == KeyEvent.VK_W) {
                y = -5;
                //repaint();
            }
            if (key == KeyEvent.VK_S) {
                y = 5;
                // repaint();
=======
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
>>>>>>> 67cb52596ae41c86dd1d85fa88cc1225d7b1bd2d
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
