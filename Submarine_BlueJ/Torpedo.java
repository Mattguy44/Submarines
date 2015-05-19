import java.awt.*;
/**
 * Write a description of class Torpedo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Torpedo
{
    private int speed;
    private boolean isUnderwater;
    private int centerX,centerY;
    private boolean isFiring;
    private String direction;
    /**
     * Constructor for objects of class Torpedo
     */
    public Torpedo(String dir,int x,int y,int s, boolean uw,boolean fire)
    {
        direction=dir;
        centerX=x;
        centerY=y;
        speed = s;
        isUnderwater = uw;
        isFiring=fire;
    }
    public void update(){
        
    }
    public void draw(Graphics g){
    }
}
