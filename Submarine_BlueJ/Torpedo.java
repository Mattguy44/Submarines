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
    private boolean [][] obstacle; //Submarine doesn't count
    private final int tWidth=5,tHeight=5; //Example
    /**
     * Constructor to create a Torpedo with right location, direction, known map, and other states.
     */
    public Torpedo(boolean [][] o,String dir,int x,int y,int s, boolean uw,boolean fire)
    {
        obstacle=o;
        direction=dir;
        centerX=x;
        centerY=y;
        speed = s;
        isUnderwater = uw;
        isFiring=fire;
    }
    
    
    
    public void update(Submarine opp){ //if the torpedo is firing, react correspondingly
        if(isFiring){
            if(obstacle[centerX][centerY]){ 
                isFiring=false;
            }
            /*else if(Math.abs(opp.getCenterX-centerX)<= opp.getWidth()/2.
            &&      Math.abs(opp.getCenterX-centerY)<= opp.getHeight()/2.){
                opp.setExploding (true);
                opp.setFrameNumber (1);        
                isFiring=false;
            }*/
            else{
                if(direction.equals ("l") || direction.equals("L")
                || direction.equals ("left") || direction.equals("LEFT"))
                centerX-=speed;
                else if(direction.equals("r") || direction.equals("R")
                || direction.equals("right") || direction.equals("RIGHT"))
                centerX+=speed; 
                else if(direction.equals("u") || direction.equals("U")
                || direction.equals("up") || direction.equals("UP"))
                centerY-=speed;
                else if(direction.equals("d") || direction.equals("D")
                || direction.equals("down") || direction.equals("DOWN"))
                centerY+=speed;
                else
                System.out.print("Error: check if right direction is assigned!");
            }
            //Note: the 4 choices in every if statements should be restricted to one, I add them because I would 
            //like to know what's your guys' prefered parameter as direction
        }
    }
    public void draw(Graphics g,Submarine control){ //draw the Torpedo
        /*if( !isFiring) {
           if(direction.equals("l") || direction.equals("L")
                || direction.equals("left") || direction.equals("LEFT")){
                centerX=control.getCenterX()-tWidth;
                centerY=control.getCenterY();
            }
                else if(direction.equals("r") || direction.equals("R")
                || direction.equals("right") || direction.equals("RIGHT")){
                centerX=control.getCenterX()+tWidth;
                centerY=control.getCenterY();
            }
                else if(direction.equals("u") || direction.equals("U")
                || direction.equals("up") || direction.equals("UP")){
                centerX=control.getCenterX();
                centerY=control.getCenterY()-tHeight;
            }    
                else if(direction.equals("d") || direction.equals("D")
                || direction.equals("down") || direction.equals("DOWN")){
                centerX=control.getCenterX();
                centerY=control.getCenterY()+tHeight;
            }    
                else
                System.out.print("Error: check if right direction is assigned!");
        }*/
        
        //Note: the 4 choices in every if statements should be restricted to one, I add them because I would 
        //like to know what's your guys' prefered parameter as direction
        
        g.setColor(new Color(155,0,0));
        g.fillOval(centerX-tWidth/2,centerY-tHeight/2,tWidth,tHeight);
        //Make the Torpedo a circle for convenience.
    }
    
    /*Advices for Submarine class:
     *0. Don't make it abstract and create subclassese like WASD and ARROWS as subclass
     *   They can all be done in KeyListener
     *1. Include accessor methods getCenterX(),getCenterY(),getWidth(),getHeight()
     *   (Of course you first need instance variables centerX,centerY,width,height...)
     *2. Include mutator  methods  setExploding(boolean ex), setFrameNumber (int frame)
     *I will design a simple class of how things can be done in the same project, Bye-bye!
     */
}
