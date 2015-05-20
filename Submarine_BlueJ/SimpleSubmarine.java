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
   private boolean isUnderWater;
   private int centerX,centerY;
   private boolean isExploding;
   private String direction;  
   private boolean [][] obstacle;
   private final int width=10,height=10;
   private int explosionFrameNumber;  
   
   //Constructor
   public SimpleSubmarine(boolean [][] o,String dir,int x,int y,int s,boolean uw){
     obstacle=o;
     direction=dir;
     centerX=x;
     centerY=y;
     speed = s;
     isUnderWater = uw;
     isExploding=false;
   }
   
   //accessors
   public int getSpeed() {return speed;}
   public int getCenterX() {return centerX;}
   public int getCenterY() {return centerY;}
   public String getDirection() {return direction;}
   public boolean [][] getObstacle() {return obstacle;}
   public boolean isUnderWater() {return isUnderWater;}
   public int getWidth() {return width;}
   public int getHeight() {return height;}
   
   //mutators
   public void setExploding(boolean ex) {isExploding=ex;}
   public void setFrameNumber(int frame) {explosionFrameNumber=frame;}
   
   //to update the current frame
   public void update(int speedSubmarine){
    if(isExploding) {
        explosionFrameNumber++;
        if (explosionFrameNumber == 20) {
        isExploding=false;
        }
    }
    else {
         if(direction.equals ("l")){centerX-=speedSubmarine;}
         else if(direction.equals("r")) {centerX+=speedSubmarine;}
         else if(direction.equals("u")) {centerY-=speedSubmarine;}
         else if(direction.equals("d")) {centerY+=speedSubmarine;}
         else
         System.out.print("Error: check if right direction is assigned!");
    }
   }
   
   public void draw(Graphics g){
    g.setColor(Color.cyan);
    g.fillRect(centerX-width/2,centerY-height/2,width,height);
    if(isExploding){
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
