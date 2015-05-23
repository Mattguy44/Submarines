import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * Write a description of class Arrows here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ARROWS extends Submarine
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private boolean underWater = false;
    private int numTorpedoes;
    // Rshift for shoot
    // "/"  for under
    public ARROWS(boolean isUnder, int torpedoes)
    {
       super(isUnder, torpedoes);
    }
        public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            x = -25;
            repaint();
        }
        if (key == KeyEvent.VK_RIGHT) {
            x = 25;
            repaint();
        }
        if (key == KeyEvent.VK_UP) {
            y = -25;
            repaint();
        }
        if (key == KeyEvent.VK_DOWN) {
            y = 25;
            repaint();
        }
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SHIFT) {
            numTorpedoes--;
        }
        if (key == KeyEvent.VK_SLASH){
            if(underWater == false){
                underWater = true;
            }
            else{
                underWater = false;
            }
        }
    }
}
