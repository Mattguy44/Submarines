
/**
 * Write a description of interface Submarine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*;
public abstract class Submarine extends JFrameAdded
{
    private boolean isUnderwater = true;
    public Submarine(boolean isUnder){
        isUnderwater=isUnder;
    }
    public static void main(String [] args){
        new JFrameAdded();
    }
}
