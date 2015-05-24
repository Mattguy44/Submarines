import java.awt.*;
/**
 * Write a description of class Torpedo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SimpleTorpedo
{
    private int speedTor;
    private int speedSub;
    private boolean isUnderWater;
    private int centerX,centerY;
    private boolean isFiring;
    private String direction;
    private boolean [][] obstacle; //SimpleSubmarine doesn't count
    private static int tWidth=24,tHeight=24; //Example
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
        speedSub = ss;
        isUnderWater = uw;
        isFiring=false;
    }

    public static int getTWidth(){return tWidth;}
    public static int getTHeight(){return tHeight;}
    public boolean isFiring(){return isFiring;}
    public boolean isUnderWater() {return isUnderWater;}
    
    public void setFire(boolean isFire) {isFiring=isFire;}
    public void setDirection(String direct){direction=direct;}
    public void setIsUnderWater(boolean water) {isUnderWater=water;}
    
    public void update(SimpleSubmarine opp){ //if the torpedo is firing, react correspondingly

        if(isFiring){
            if(obstacle[centerX][centerY]){ 
                isFiring=false;
                if(centerX%2==1&&isUnderWater||centerX%2==0&&!isUnderWater) 
                obstacle[centerX][centerY]=false;
            }
            else if( this.isUnderWater==opp.isUnderWater()
            &&      Math.abs(opp.getCenterX()-centerX)<= opp.getWidth()/2.
            &&      Math.abs(opp.getCenterY()-centerY)<= opp.getHeight()/2.){
                opp.setExploding (true);
                opp.setFrameNumber (1);        
                isFiring=false;
            }
            else{
                if(direction.equals ("l")){
                    int ix=0;
                    int speedAtGivenTime=0;
                    while(centerX-tWidth/2>=0&&
                    (ix<speedTor&&!obstacle[centerX-tWidth/2][centerY])){
                        ix++;
                    }
                    speedAtGivenTime=ix;
                    centerX-=speedAtGivenTime;
                }
                else if(direction.equals("r")){
                    int ix=0;
                    int speedAtGivenTime=0;
                    while(centerX+tWidth/2<obstacle.length&&
                    (ix<speedTor&&!obstacle[centerX+tWidth/2][centerY])){
                        ix++;
                    }
                    speedAtGivenTime=ix;
                    centerX+=speedAtGivenTime;
                }
                else if(direction.equals("u")){
                    int ix=0;
                    int speedAtGivenTime=0;
                    while(centerY-tHeight/2>=0&&
                    (ix<speedTor&&!obstacle[centerX][centerY-tHeight/2])){
                        ix++;
                    }
                    speedAtGivenTime=ix;
                    centerY-=speedAtGivenTime;
                }
                else if(direction.equals("d")){
                    int ix=0;
                    int speedAtGivenTime=0;
                    while(centerY+tHeight/2<obstacle[0].length&&
                    (ix<speedTor&&!obstacle[centerX][centerY+tHeight/2])){
                        ix++;
                    }
                    speedAtGivenTime=ix;
                    centerY+=speedAtGivenTime;
                }
                else
                    System.out.print("Error: check if right direction is assigned!");
            }
        }
    }

    public int draw(Graphics g){ //draw the Torpedo
        int finalSpeed=0;
        if( !isFiring) {
            if(direction.equals("l")){
                int ix=0;
                int speedAtGivenTime=0;
                while(centerX-tWidth/2>=0&&
                (ix<speedSub&&!obstacle[centerX-tWidth/2][centerY])){
                    ix++;
                }
                speedAtGivenTime=ix;
                finalSpeed=speedAtGivenTime;
                centerX-=speedAtGivenTime;
            }
            else if(direction.equals("r")){
                int ix=0;
                int speedAtGivenTime=0;
                while(centerX+tWidth/2<obstacle.length&&
                (ix<speedSub&&!obstacle[centerX+tWidth/2][centerY])){
                    ix++;
                }
                speedAtGivenTime=ix;
                finalSpeed=speedAtGivenTime;
                centerX+=speedAtGivenTime;
            }
            else if(direction.equals("u")){
                int ix=0;
                int speedAtGivenTime=0;
                while(centerY-tHeight/2>=0&&
                (ix<speedSub&&!obstacle[centerX][centerY-tHeight/2])){
                    ix++;
                }
                speedAtGivenTime=ix;
                finalSpeed=speedAtGivenTime;
                centerY-=speedAtGivenTime;
            }    
            else if(direction.equals("d")){
                int ix=0;
                int speedAtGivenTime=0;
                while(centerY+tHeight/2<obstacle[0].length&&
                (ix<speedSub&&!obstacle[centerX][centerY+tHeight/2])){
                    ix++;
                }
                speedAtGivenTime=ix;
                finalSpeed=speedAtGivenTime;
                centerY+=speedAtGivenTime;
            }    
            else
                System.out.print("Error: check if right direction is assigned!");
        }
        
        if(isUnderWater) 
        g.setColor(Color.green);
        else
        g.setColor(Color.black);

        g.fillOval(centerX-tWidth/2,centerY-tHeight/2,tWidth,tHeight);
        //Make the Torpedo a circle for convenience.

        return finalSpeed;
    }
}
