
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
    private boolean isUnderwater;
    private int locationX;
    private int locationY;
    private int TOR_SPEED;
    private String curDir = "UP"; //current direction
    private int numTorpedoes;
    public Submarine(boolean isUnder, int tors, int locX, int locY){
        isUnderwater=isUnder;
        numTorpedoes = tors;
        locationX = locX;
        locationY = locY;
    }

    public static void main(String [] args){
        //new JFrameAdded();
    }

    public void fire(){
<<<<<<< HEAD

        //new Torpedo(dimmensionsX, isUnderwater);
        //new Torpedo(direction, isUnderwater);
    }

    public void setLocation (int x, int y){
=======
        numTorpedoes--;
        //new Torpedo(dimmensionsX, isUnderwater);
        //new Torpedo(direction, isUnderwater);
    }
    public void setX (int x){
>>>>>>> 67cb52596ae41c86dd1d85fa88cc1225d7b1bd2d
        locationX = x;
    }
    public void setY (int y){
        locationY = y;
    }
<<<<<<< HEAD
    <<<<<<< HEAD
    <<<<<<< HEAD

    =======
    public void setDirection(String dir){
        curDir = dir;
    }
    >>>>>>> 888de62d12f82c6acf9a612659ce6759736e1507
    =======
    <<<<<<< HEAD
    public abstract void draw(Graphics g);

    =======
    <<<<<<< HEAD
    //public void paint(Graphics G){
    //}
    =======
    >>>>>>> 25fef22afc41f3be8674eb52cdf2b47d81bff8ef
    >>>>>>> 10bc9b714509dc5cf966d667a287c4a8a9fcbb39
    >>>>>>> 2429398452c9aba761df312d9f5c50d52564bf36
=======

    public abstract void draw(Graphics g);
    public int getX(){
        return locationX;
    }
    public int getY(){
        return locationY;
    }
    public boolean isUnder(){
        return isUnderwater;
    }
    public void submerge(){
        if (isUnderwater)
            isUnderwater = false;
        else
            isUnderwater = true;
    }
    public String getDir(String curDir){
    }

    public void setDirection(String dir);
    public abstract void draw(Graphics g);
    

    //public void paint(Graphics G){
    //}


>>>>>>> 67cb52596ae41c86dd1d85fa88cc1225d7b1bd2d
    //public abstract boolean submerge(); //returns true if successful sumberge, false if failed
    //public abstract void move(); // differs by keys used (depending on player)
}
