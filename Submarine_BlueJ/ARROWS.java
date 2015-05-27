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
    /*private int x;
    private int y;
    private boolean underWater;
    private int numTorpedoes;*/
    private Graphics G;
    // Rshift for shoot
    // "/"  for under
    public ARROWS(boolean isUnder, int torpedoes, int locX, int locY)
    {
        super(isUnder, torpedoes, locX, locY);
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
            g.fillOval(getX()-20,getY()-8,40,15);
            g.fillRect(getX()-5,getY(),10,5);
        }
        if(this.getDir().equals("RIGHT")){
            g.fillOval(getX()-20,getY()-8,40,15);
            g.fillRect(getX()-5,getY(),10,5);
        }
        if(this.getDir().equals("LEFT")){
            g.fillOval(getX()-20,getY()-8,40,15);
            g.fillRect(getX()-5,getY(),10,5);
        }
        if(this.getDir().equals("DOWN")){
            g.fillOval(getX()-20,getY()-8,40,15);
            g.fillRect(getX()-5,getY(),10,5);
        }
        g.fillOval(getX()-20,getY()-8,40,15);
        G = g;
    }
    
}
