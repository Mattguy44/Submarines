
/**
 * Write a description of interface Submarine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*;
public abstract class Submarine extends JFrameAdded
{
    private int dimmensionsX = 100;
    private int dimmensionsY = 50;
    private boolean isUnderwater = false;
    private int locationX;
    private int locationY;
    private int TOR_SPEED;
    public Submarine(boolean isUnder){
        isUnderwater=isUnder;
    }
    public static void main(String [] args){
        new JFrameAdded();
    }
    public void fire(String direction){
        //new Torpedo(dimmensionsX, isUnderwater);
        //new Torpedo(direction, isUnderwater);
    }
    public abstract boolean submerge(); //returns true if successful sumberge, false if failed
    public abstract void move(); // differs by keys used (depending on player)
}
