
/**
 * Write a description of interface Submarine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public abstract class Submarine
{
    private int dimmensionsX = 100;
    private int dimmensionsY = 50;
    private boolean isUnderwater = false;
    private int locationX;
    private int locationY;
    private int TOR_SPEED;
    private String curDir = "UP"; //current direction
    private int numTorpedoes;
    public Submarine(boolean isUnder, int tors){
        isUnderwater=isUnder;
        numTorpedoes = tors;
    }
    public static void main(String [] args){
        //new JFrameAdded();
    }
    public void fire(){
        
        //new Torpedo(dimmensionsX, isUnderwater);
        //new Torpedo(direction, isUnderwater);
    }
    public void setLocation (int x, int y){
        locationX = x;
        locationY = y;
    }
<<<<<<< HEAD
    public abstract void draw(Graphics g);
    
=======
<<<<<<< HEAD
    //public void paint(Graphics G){
    //}
=======
>>>>>>> 25fef22afc41f3be8674eb52cdf2b47d81bff8ef
>>>>>>> 10bc9b714509dc5cf966d667a287c4a8a9fcbb39
    //public abstract boolean submerge(); //returns true if successful sumberge, false if failed
    //public abstract void move(); // differs by keys used (depending on player)
}
