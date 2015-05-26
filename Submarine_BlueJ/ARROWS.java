import java.awt.event.*;
import java.awt.*;
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
    public void draw(Graphics g){
        if(underwater=true){
            g.setColor(Color.BLACK);
        }
        else{
            g.setColor(Color.RED);
        }
        g.drawOval(50,10,x,y);
    }
    private class Listener implements KeyListener {
        public void keyTyped(KeyEvent e) {}
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT) {
                x = -5;
                repaint();
            }
            if (key == KeyEvent.VK_RIGHT) {
                x = 5;
                repaint();
            }
            if (key == KeyEvent.VK_UP) {
                y = -5;
                repaint();
            }
            if (key == KeyEvent.VK_DOWN) {
                y = 5;
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
}
