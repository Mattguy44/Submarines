
/**
 * Write a description of interface Submarine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*;
public abstract class Submarine extends JFrameAdded
{
<<<<<<< HEAD
    private boolean isUnderwater = true;
    public Submarine(boolean isUnder, int torpedoes){
=======
    private int dimmensionsX = 100;
    private int dimmensionsY = 50;
    private boolean isUnderwater = false;
    public Submarine(boolean isUnder){
>>>>>>> 9334342d00babbc434e0db51b79e044344b0aa17
        isUnderwater=isUnder;
    }
    public static void main(String [] args){
        new JFrameAdded();
    }
    public void fire(String direction){
        new Torpedo(dimmensionsX, isUnderwater);
        //new Torpedo(direction, isUnderwater);
    }
    public abstract boolean submerge(); //returns true if successful sumberge, false if failed
    public abstract void move(); // differs by keys used (depending on player)
}
