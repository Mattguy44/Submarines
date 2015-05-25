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
    private boolean isUnderWater;
    private int centerX,centerY;
    private String direction;
    private boolean [][] obstacle; //SimpleSubmarine doesn't count
    private static int tWidth=24,tHeight=24; //Example
    private boolean cont;
    private int explosionFrameNumber;  
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

    public static int getTWidth(){return tWidth;}
    public static int getTHeight(){return tHeight;}
    public boolean isUnderWater() {return isUnderWater;}
    public boolean isCont() {return cont;}
    
    public void update(SimpleSubmarine opp){ //if the torpedo is firing, react correspondingly
            if(opp.isExploding())
            {
               explosionFrameNumber++;
                if (explosionFrameNumber == 150) {
               opp.setExploding(false);
               cont=false;
               System.out.println(opp.getEName()+" wins!~~~ Congrats1");
            }
        }
        
            if(obstacle[centerX][centerY]){ 
                cont=false;
                if(centerX%2==1&&isUnderWater||centerX%2==0&&!isUnderWater) 
                obstacle[centerX][centerY]=false;
            }
            else if( this.isUnderWater==opp.isUnderWater()
            &&      Math.abs(opp.getCenterX()-centerX)<= opp.getWidth()/2.
            &&      Math.abs(opp.getCenterY()-centerY)<= opp.getHeight()/2.){
                opp.setExploding (true);
                opp.setFrameNumber (1);        
                cont=false;
            }
            else{
                if(direction.equals ("l")){
                    int ix=-0;
                    int speedAtGivenTime=0;
                    while(centerX-tWidth/2-ix-1>=0&&
                    (ix<speedTor&&!obstacle[centerX-tWidth/2][centerY])){
                        ix++;
                    }
                    speedAtGivenTime=ix;
                    centerX-=speedAtGivenTime;
                }
                else if(direction.equals("r")){
                    int ix=0;
                    int speedAtGivenTime=0;
                    while(centerX+tWidth/2+ix+1<obstacle.length&&
                    (ix<speedTor&&!obstacle[centerX+tWidth/2][centerY])){
                        ix++;
                    }
                    speedAtGivenTime=ix;
                    centerX+=speedAtGivenTime;
                }
                else if(direction.equals("u")){
                    int ix=-0;
                    int speedAtGivenTime=0;
                    while(centerY-tHeight/2-ix-1>=0&&
                    (ix<speedTor&&!obstacle[centerX][centerY-tHeight/2])){
                        ix++;
                    }
                    speedAtGivenTime=ix;
                    centerY-=speedAtGivenTime;
                }
                else if(direction.equals("d")){
                    int ix=0;
                    int speedAtGivenTime=0;
                    while(centerY+tHeight/2+ix+1<obstacle[0].length&&
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
    
    public void draw(Graphics g){ //draw the Torpedo
        if(isUnderWater) 
        g.setColor(Color.green);
        else
        g.setColor(Color.black);
        g.fillOval(centerX-tWidth/2,centerY-tHeight/2,tWidth,tHeight);
        //Make the Torpedo a circle for convenience.
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
    }
}
