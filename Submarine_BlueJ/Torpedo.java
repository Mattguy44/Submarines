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
    public Torpedo(boolean [][] o,String dir,int x,int y,int s, boolean uw)
    {
        obstacle=o;
        direction=dir;
        centerX=x;
        centerY=y;
        speed = s;
        isUnderwater = uw;
    }

    public void hit(Graphics g){
        g.setColor(Color.yellow);

        g.fillOval(centerX-4*explosionFrameNumber,
            centerY-4*explosionFrameNumber,
            8*explosionFrameNumber,
            8*explosionFrameNumber);

        g.setColor(Color.red);

        g.fillOval(centerX-2*explosionFrameNumber,
            centerY-explosionFrameNumber,
            4*explosionFrameNumber,
            2*explosionFrameNumber
        );
    }

    public void update(Submarine opp){ //if the torpedo is firing, react correspondingly
<<<<<<< HEAD
            if(obstacle[centerX][centerY]){ 
                //Torpedo this=null;
            }
            /*else if(Math.abs(opp.getCenterX-centerX)<= opp.getWidth()/2.
            &&      Math.abs(opp.getCenterX-centerY)<= opp.getHeight()/2.){
                opp.setExploding (true);
                opp.setFrameNumber (1);        
                Torpedo=null;
            }*/
            else{
                if(direction.equals ("l") || direction.equals("L")
                || direction.equals ("left") || direction.equals("LEFT"))
=======
        if(obstacle[centerX][centerY]){ 

        }
        /*else if(Math.abs(opp.getCenterX-centerX)<= opp.getWidth()/2.
        &&      Math.abs(opp.getCenterX-centerY)<= opp.getHeight()/2.){
        opp.setExploding (true);
        opp.setFrameNumber (1);        
        Torpedo=null;
        }*/
        else{
            if(direction.equals ("l") || direction.equals("L")
            || direction.equals ("left") || direction.equals("LEFT"))
>>>>>>> af76d9d06c9e093c86503b2de88602c3c632f8e5
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

    public void draw(Graphics g){ //draw the Torpedo

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
