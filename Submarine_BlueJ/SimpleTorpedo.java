import java.awt.*;
/**
 * Write a description of class Torpedo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SimpleTorpedo
{
    private int speed;
    private boolean isUnderWater;
    private int centerX,centerY;
    private boolean isFiring;
    private String direction;
    private boolean [][] obstacle; //SimpleSubmarine doesn't count
    private final int tWidth=5,tHeight=5; //Example
    /**
     * Constructor to create a Torpedo with right location, direction, known map, and other states.
     */
    public SimpleTorpedo(boolean [][] o,String dir,int x,int y,int s, boolean uw)
    {
        obstacle=o;
        direction=dir;
        centerX=x;
        centerY=y;
        speed = s;
        isUnderWater = uw;
        isFiring=false;
    }

    public int update(SimpleSubmarine opp){ //if the torpedo is firing, react correspondingly
        int speedSub=0;
        if(isFiring){
            if(obstacle[centerX][centerY]){ 
                isFiring=false;
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
                    int ix=1;
                    int speedAtGivenTime=0;
                    while(ix<=speed&&!obstacle[centerX][centerY]){
                        ix++;
                    }
                    speedAtGivenTime=ix;
                    centerX-=speedAtGivenTime;
                    speedSub=speedAtGivenTime;
                }
                else if(direction.equals("r")){
                    int ix=1;
                    int speedAtGivenTime=0;
                    while(ix<=speed&&!obstacle[centerX][centerY]){
                        ix++;
                    }
                    speedAtGivenTime=ix;
                    centerX+=speedAtGivenTime;
                    speedSub=speedAtGivenTime;
                }
                else if(direction.equals("u")){
                    int ix=1;
                    int speedAtGivenTime=0;
                    while(ix<=speed&&!obstacle[centerX][centerY]){
                        ix++;
                    }
                    speedAtGivenTime=ix;
                    centerY-=speedAtGivenTime;
                    speedSub=speedAtGivenTime;
                }
                else if(direction.equals("d")){
                    int ix=1;
                    int speedAtGivenTime=0;
                    while(ix<=speed&&!obstacle[centerX][centerY]){
                        ix++;
                    }
                    speedAtGivenTime=ix;
                    centerY+=speedAtGivenTime;
                    speedSub=speedAtGivenTime;
                }
                else
                    System.out.print("Error: check if right direction is assigned!");
            }
        }
        return speedSub;//mistake here
    }

    public void draw(Graphics g,SimpleSubmarine control){ //draw the Torpedo
        if( !isFiring) {
            if(direction.equals("l")){
                centerX=control.getCenterX()-tWidth;
                centerY=control.getCenterY();
            }
            else if(direction.equals("r")){
                centerX=control.getCenterX()+tWidth;
                centerY=control.getCenterY();
            }
            else if(direction.equals("u")){
                centerX=control.getCenterX();
                centerY=control.getCenterY()-tHeight;
            }    
            else if(direction.equals("d")){
                centerX=control.getCenterX();
                centerY=control.getCenterY()+tHeight;
            }    
            else
                System.out.print("Error: check if right direction is assigned!");
        }

        g.setColor(new Color(155,0,0));
        g.fillOval(centerX-tWidth/2,centerY-tHeight/2,tWidth,tHeight);
        //Make the Torpedo a circle for convenience.
    }
}
