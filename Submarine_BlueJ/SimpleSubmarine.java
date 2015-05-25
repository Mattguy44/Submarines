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
   private static int width=49,height=49;
   private int explosionFrameNumber;  
   private SimpleTorpedo st;
   private String Ename;
   //Constructor
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
   public int getSpeed() {return speed;}
   public int getCenterX() {return centerX;}
   public int getCenterY() {return centerY;}
   public String getDirection() {return direction;}
   public boolean [][] getObstacle() {return obstacle;}
   public boolean isUnderWater() {return isUnderWater;}
   public static int getWidth() {return width;}
   public static int getHeight() {return height;}
   public SimpleTorpedo getSimpleTorpedo(){return st;}
   public boolean isExploding() {return isExploding;}
   public String getEName(){return Ename;}
   //mutators
   public void setExploding(boolean ex) {isExploding=ex;}
   public void setFrameNumber(int frame) {explosionFrameNumber=frame;}
   public void setDirection(String direct){direction=direct;}
   public void setIsUnderWater(boolean water) {isUnderWater=water;}
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

   
   //to update the current frame
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
                (ix<speed&&!obstacle[centerX-width/2][centerY])){
                    ix++;
                }
                centerX-=ix;}
        
         else if(direction.equals("r")) {
             int ix=0;
                while(centerX+width/2+ix+1<obstacle.length&&
                (ix<speed&&!obstacle[centerX+width/2][centerY])){
                    ix++;
                }
               centerX+=ix;
            }
         else if(direction.equals("u")) {
              int ix=0;
                while(centerY-height/2-ix-1>=0&&
                (ix<speed&&!obstacle[centerX][centerY-height/2])){
                    ix++;
                }
                centerY-=ix;
            }
         else if(direction.equals("d")) {
             int ix=0;
                while(centerY+height/2+ix+1<obstacle.length&&
                (ix<speed&&!obstacle[centerX][centerY+height/2])){
                    ix++;
                }
                centerY+=ix;
            }
         else
         System.out.print("Error: check if right direction is assigned!");
    }
}
   
   
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
