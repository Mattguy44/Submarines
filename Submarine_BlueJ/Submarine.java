
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

    public void setDirection(String dir){
        curDir = dir;
    }

    public abstract void draw(Graphics g);
    

    //public void paint(Graphics G){
    //}

    //public abstract boolean submerge(); //returns true if successful sumberge, false if failed
    //public abstract void move(); // differs by keys used (depending on player)
}
