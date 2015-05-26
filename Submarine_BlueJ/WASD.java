import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * Write a description of class WASD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WASD extends Submarine
{
    private int x;
    private int y;
    private boolean underWater = false;
    private int numTorpedoes;
    //X for under
    //space for shoot
    public WASD(boolean isUnder, int torpedoes)
    {
        super(isUnder,torpedoes);
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
            if (key == KeyEvent.VK_A) {
                x = -5;
                repaint();
            }
            if (key == KeyEvent.VK_D) {
                x = 5;
                repaint();
            }
            if (key == KeyEvent.VK_W) {
                y = -5;
                repaint();
            }
            if (key == KeyEvent.VK_S) {
                y = 5;
                repaint();
            }
        }

        public void keyReleased(KeyEvent e){
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_SPACE) {
                numTorpedoes--;
            }
            if (key == KeyEvent.VK_X){
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
