
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

        numTorpedoes--;
        //new Torpedo(dimmensionsX, isUnderwater);
        //new Torpedo(direction, isUnderwater);
    }

    public void setLocation (int x, int y){

        
        //new Torpedo(dimmensionsX, isUnderwater);
        //new Torpedo(direction, isUnderwater);
    }
    public void setX (int x){

        locationX = x;
    }
    public void setY (int y){
        locationY = y;
    }

    public void setDirection(String dir){
        curDir = dir;
    }


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
    public String getDir(){
        return curDir;
    }

    //public void setDirection(String dir);

    

    //public void paint(Graphics G){
    //}



    //public abstract boolean submerge(); //returns true if successful sumberge, false if failed
    //public abstract void move(); // differs by keys used (depending on player)
}
