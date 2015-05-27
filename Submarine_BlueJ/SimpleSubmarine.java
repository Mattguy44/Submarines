import java.awt.*;
/**
 * Write a description of class SimpleSubmarine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SimpleSubmarine
{
    //instance variables
    private int speed;
    private int torSpeed;
    private boolean isUnderWater;
    private int centerX,centerY;
    private boolean isExploding;
    private String direction;  
    private boolean [][] obstacle;
    private static int width=48,height=48;
    private int explosionFrameNumber;  
    private SimpleTorpedo st;
    private String Ename;
    /**
     * Constructor to create a Submarine with right location, direction, known map, and other states.
     */
    public SimpleSubmarine(boolean [][] o,String Ename,String dir,int x,int y,int magVelocity,int torSpeed, boolean uw){
        obstacle=o;
        direction=dir;
        centerX=x;
        centerY=y;
        this.torSpeed=torSpeed;
        this.Ename=Ename;
        speed = magVelocity;
        isUnderWater = uw;
        isExploding=false;
        int centerTorpedoX=centerX, centerTorpedoY=centerY;
        /*if(direction.equals ("l")){
        centerTorpedoX=centerTorpedoX-width/2-SimpleTorpedo.getTWidth()/2;
        }
        else if (direction.equals("r")){
        centerTorpedoX=centerTorpedoX+width/2+SimpleTorpedo.getTWidth()/2;
        }
        else if(direction.equals ("u")){
        centerTorpedoY=centerTorpedoY-height/2-SimpleTorpedo.getTHeight()/2;
        }
        else if(direction.equals ("d")){
        centerTorpedoY=centerTorpedoY+height/2+SimpleTorpedo.getTHeight()/2;
        }*/
        st=null;
    }

    //accessors
    /**
     * Accessor method: get the speed of submarine
     */
    public int getSpeed() {return speed;}

    /**
     * Accessor method: get the x-coordinate of the center of submarine
     */
    public int getCenterX() {return centerX;}

    /**
     * Accessor method: get the y-coordinate of the center of submarine
     */
    public int getCenterY() {return centerY;}

    /**
     * Accessor method: get the direction of submarine
     */
    public String getDirection() {return direction;}

    /**
     * Accessor method: get the obstacle/map of submarine
     */
    public boolean [][] getObstacle() {return obstacle;}

    /**
     * Accessor method: get if submarine is under water
     */
    public boolean isUnderWater() {return isUnderWater;}

    /**
     * Accessor method: get the width of any submarine
     */
    public static int getWidth() {return width;}

    /**
     * Accessor method: get the height of any submarine
     */
    public static int getHeight() {return height;}

    /**
     * Accessor method: get the torpedo of the submarine
     */
    public SimpleTorpedo getSimpleTorpedo(){return st;}

    /**
     * Accessor method: get if submarine is exploding
     */
    public boolean isExploding() {return isExploding;}

    /**
     * Accessor method: get the name of enermy of the submarine
     */
    public String getEName(){return Ename;}
    //mutators
    /**
     * Mutator method: decide whether the submarine is exploding
     */
    public void setExploding(boolean ex) {isExploding=ex;}

    /**
     * Mutator method: set the frame number of the explosion animation
     */
    public void setFrameNumber(int frame) {explosionFrameNumber=frame;}

    /**
     * Mutator method: set the direction of submarine
     */
    public void setDirection(String direct){direction=direct;}

    /**
     * Mutator method: set if submarine is under water
     */
    public void setIsUnderWater(boolean water) {isUnderWater=water;}
    
    
    /**
     * Mutator method: reset all speed to 0
     */
    public void speedReset() 
    {speed=0;
     torSpeed=0;
    }
    
    /**
     * Make a new torpedo start at the center
     */
    public void getNewSimpleTorpedo()
    {
        int centerTorpedoX=centerX, centerTorpedoY=centerY;
        /*if(direction.equals ("l")){
        centerTorpedoX=centerTorpedoX-width/2-SimpleTorpedo.getTWidth()/2;
        }
        else if (direction.equals("r")){
        centerTorpedoX=centerTorpedoX+width/2+SimpleTorpedo.getTWidth()/2;
        }
        else if(direction.equals ("u")){
        centerTorpedoY=centerTorpedoY-height/2-SimpleTorpedo.getTHeight()/2;
        }
        else if(direction.equals ("d")){
        centerTorpedoY=centerTorpedoY+height/2+SimpleTorpedo.getTHeight()/2;
        }*/
        st=new SimpleTorpedo(obstacle,direction,centerTorpedoX,centerTorpedoY,torSpeed,speed,isUnderWater);
    }

    /**
     * To update the current frame: moving based on the direction
     */
    public void update(){
        if(isExploding) {
            /*explosionFrameNumber++;
            if (explosionFrameNumber == 10) {
            isExploding=false;
            System.out.println(Ename+" wins, congrats!");
            }*/
        }
        else {
            if(direction.equals ("l")){
                int ix=0;
                while(centerX-width/2-ix-1>=0&&
                (ix<speed/*&&!obstacle[centerX-width/2][centerY]*/)){
                    ix++;
                }
                centerX-=ix;}

            else if(direction.equals("r")) {
                int ix=0;
                while(centerX+width/2+ix+1<obstacle.length&&
                (ix<speed/*&&!obstacle[centerX+width/2][centerY]*/)){
                    ix++;
                }
                centerX+=ix;
            }
            else if(direction.equals("u")) {
                int ix=0;
                while(centerY-height/2-ix-1>=0&&
                (ix<speed/*&&!obstacle[centerX][centerY-height/2]*/)){
                    ix++;
                }
                centerY-=ix;
            }
            else if(direction.equals("d")) {
                int ix=0;
                while(centerY+height/2+ix+1<obstacle.length&&
                (ix<speed/*&&!obstacle[centerX][centerY+height/2]*/)){
                    ix++;
                }
                centerY+=ix;
            }
            else
                System.out.print("Error: check if right direction is assigned!");
        }
    }

    /**
     * Draw the current submarine
     */
    public void draw(Graphics g){
        if(isUnderWater) 
            g.setColor(Color.green);
        else
            g.setColor(Color.black);
        g.fillRect(centerX-width/2,centerY-height/2,width,height);
        /*if(isExploding){
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
        }*/

        if(st!=null)
            st.draw(g);
    }
}
