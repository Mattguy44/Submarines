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
    
}
