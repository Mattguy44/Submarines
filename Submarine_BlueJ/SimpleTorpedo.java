import java.awt.*;
/**
 * Write a description of class Torpedo here.
 * 
 * @author (your name) Neo
 * @version (a version number or a date)5/25/15
 */
public class SimpleTorpedo
{
    //instance variables
    private int speedTor;
    private boolean isUnderWater;
    private int centerX,centerY;
    private String direction;
    private boolean [][] obstacle; //hidden place
    private static int tWidth=24,tHeight=24; //Example
    private boolean cont;
    private int explosionFrameNumber;  
    private static boolean firstPrint=true;
    /**
     * Constructor to create a Torpedo with right location, direction, known map, and other states.
     */

    public SimpleTorpedo(boolean [][] o,String dir,int x,int y,int st,int ss, boolean uw)
    {
        obstacle=o;
        direction=dir;
        centerX=x;
        centerY=y;
        speedTor = st;
        isUnderWater = uw;
        cont=true;
    }

    /**
     *  Accesser method getTWidth(): to get the width of any Torpedo
     */
    public static int getTWidth(){return tWidth;}

    /**
     *  Accesser method getTHeight(): to get the height of any Torpedo
     */
    public static int getTHeight(){return tHeight;}

    /**
     *  Accesser method isUnderWater(): to get if Torpedo is under the water
     */
    public boolean isUnderWater() {return isUnderWater;}

    /**
     *  Accesser method isCont(): to get if Torpedo should continue going
     */
    public boolean isCont() {return cont;}

    /**
     *  Mutator method speedReset(): to set the speedTor 0
     */
    public void speedReset() {speedTor=0;}
    
    /**
     *   Update the torpedo motion: first check if Torpedo is exploding second check how does it move
     */
    public void update(SimpleSubmarine opp){ //if the torpedo is firing, react correspondingly
        if(opp.isExploding())
        {
            explosionFrameNumber++;
            if (explosionFrameNumber == 20) {
                if(firstPrint){
                opp.setExploding(false);
                cont=false;
                
                System.out.println(opp.getEName()+" wins!~~~ Congrats!");
                firstPrint=false;
                }//checks if it's the first time to annouce the winner
            } //print the message: winner when the explosion animation frame equals to twenty
            else if (explosionFrameNumber == 550){
                System.exit(0);
            }  //GUI screen automatically close when the explosion animation frame equals to 550
        }

       /* if(obstacle[centerX][centerY]){ 
            cont=false;
            if(centerX%2==1&&isUnderWater||centerX%2==0&&!isUnderWater) 
                obstacle[centerX][centerY]=false;
        } */ //works only when very very lucky hahaha... who will be the award winner?
        else if( this.isUnderWater==opp.isUnderWater()
        &&      Math.abs(opp.getCenterX()-centerX)<= opp.getWidth()/2.
        &&      Math.abs(opp.getCenterY()-centerY)<= opp.getHeight()/2.){
            opp.setExploding (true);
            //opp.setFrameNumber (1);
            //Don't worry about it: original plan to make submarine explode but failed
            cont=false;
        }
        else{
            if(direction.equals ("l")){
                int ix=-0;
                int speedAtGivenTime=0;
                //Note: obstacles changed from orignal plan of blocking to hiding...
                while((centerX-tWidth/2-ix-1>=-36) &&
                (ix<speedTor/*&&!obstacle[centerX-tWidth/2][centerY]*/)){
                    ix++;
                }
                speedAtGivenTime=ix;
                centerX-=speedAtGivenTime;
            }
            else if(direction.equals("r")){
                int ix=0;
                int speedAtGivenTime=0;
                while(centerX+tWidth/2+ix+1<obstacle.length+36&&
                (ix<speedTor/*&&!obstacle[centerX+tWidth/2][centerY]*/)){
                    ix++;
                }
                speedAtGivenTime=ix;
                centerX+=speedAtGivenTime;
            }
            else if(direction.equals("u")){
                int ix=-0;
                int speedAtGivenTime=0;
                while(centerY-tHeight/2-ix-1>=-36&&
                (ix<speedTor/*&&!obstacle[centerX][centerY-tHeight/2]*/)){
                    ix++;
                }
                speedAtGivenTime=ix;
                centerY-=speedAtGivenTime;
            }
            else if(direction.equals("d")){
                int ix=0;
                int speedAtGivenTime=0;
                while(centerY+tHeight/2+ix+1<obstacle[0].length+36&&
                (ix<speedTor/*&&!obstacle[centerX][centerY+tHeight/2]*/)){
                    ix++;
                }
                speedAtGivenTime=ix;
                centerY+=speedAtGivenTime;
            }
            else
                System.out.print("Error: check if right direction is assigned!");
            //move at the right direction until torpedo touches the screen
        }
    }

    /**
     *  Draw the current torpedo 
     */
    public void draw(Graphics g){ //draw the Torpedo
        if(isUnderWater) 
            g.setColor(Color.green);
        else
            g.setColor(Color.black);
        g.fillOval(centerX-tWidth/2,centerY-tHeight/2,tWidth,tHeight);
        //Make the Torpedo a circle for convenience. (After the torpedo is fired before hitting the opponent.)
        if(!cont){
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
        //If torpedo hits the opponent submarine , the explosion starts
    }
}
