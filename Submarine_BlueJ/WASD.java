
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

}
