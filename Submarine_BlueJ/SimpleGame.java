import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class SimpleGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SimpleGame extends JPanel
{
    
    public static void main(String[] args){
        JFrame window=new JFrame("Submarine Game!");
        SimpleGame game=new SimpleGame();
        window.setContentPane(game);
        window.setSize(500,500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
    }

    private Timer timer;
    
    private int widthPanel, heightPanel;
    
    private boolean [][] obstacles;
    
    private SimpleSubmarine arrows;
    
    private SimpleSubmarine wasd;
    
   
    
    /**
     * Constructor for objects of class SimpleGame
     */
    public SimpleGame()
    {
        obstacles=new boolean [widthPanel][heightPanel];
        
        for(int r=SimpleSubmarine.getWidth()+SimpleTorpedo.getTWidth();
        r<obstacles.length-SimpleSubmarine.getWidth()-SimpleTorpedo.getTWidth();r++)
        for(int c=0;c<obstacles[0].length;c++){
        obstacles[r][c]=(Math.random()<0.3);
        }
        
        
        
        setBackground (new Color (50,250,50));
        
        ActionListener action=new ActionListener() {
          public void actionPerformed(ActionEvent evt){
          if(!(arrows==null || wasd==null)){
            arrows.update(arrows.getSimpleTorpedo().draw(getGraphics()));
            wasd.update(arrows.getSimpleTorpedo().draw(getGraphics()));
            }
            repaint();
          }
        };
        timer=new Timer(25,action);
        
        addMouseListener(new MouseAdapter(){
          public void mousePressed(MouseEvent evt){
             requestFocus();
          }
        });
        
        addFocusListener(new FocusListener() {
          public void focusGained(FocusEvent evt){
             timer.start();
             repaint();
            }
          public void focusLost(FocusEvent evt){
             timer.stop();
             repaint();
            }
        } );
        
        addKeyListener(new KeyAdapter(){
        
           public void keyPressed(KeyEvent evt){
               int code=evt.getKeyCode();
               SimpleTorpedo arrowTorpedo=arrows.getSimpleTorpedo();
               
               //Note:for arrows, left right up down arrows are directions, enter is fire
               //and shift is change the state of above or below water.
               if(code==KeyEvent.VK_LEFT){
                  arrows.setDirection("l");
                  if(!arrowTorpedo.isFiring())
                  arrowTorpedo.setDirection(arrows.getDirection());
               }
               else if (code==KeyEvent.VK_RIGHT){
                  arrows.setDirection("r");
                  if(!arrowTorpedo.isFiring())
                  arrowTorpedo.setDirection(arrows.getDirection());
               }
               else if (code==KeyEvent.VK_UP){
                  arrows.setDirection("u");
                  if(!arrowTorpedo.isFiring())
                  arrowTorpedo.setDirection(arrows.getDirection());
                }
               else if (code==KeyEvent.VK_DOWN){
                  arrows.setDirection("d");
                  if(!arrowTorpedo.isFiring())
                  arrowTorpedo.setDirection(arrows.getDirection());
                }
               else if (code==KeyEvent.VK_ENTER){
                  arrowTorpedo.setFire(true);
                }
               else if (code==KeyEvent.VK_SHIFT){
                  arrows.setIsUnderWater(!arrows.isUnderWater());
                  arrowTorpedo.setIsUnderWater(!arrowTorpedo.isUnderWater());
                }
               //Note: space is for wasd submarine 
               else if (code==KeyEvent.VK_SPACE){
                  wasd.getSimpleTorpedo().setFire(true);
                }
            }
            
           public void keyTyped (KeyEvent evt){
                char character=evt.getKeyChar();
                SimpleTorpedo wasdTorpedo=wasd.getSimpleTorpedo();
                if(character=='W'||character=='w'){
                  wasd.setDirection("u");
                  if(!wasdTorpedo.isFiring())
                  wasdTorpedo.setDirection(wasd.getDirection());
                }
                else if(character=='A'||character=='a'){
                  wasd.setDirection("l");
                  if(!wasdTorpedo.isFiring())
                  wasdTorpedo.setDirection(wasd.getDirection());
                }
                else if(character=='S'||character=='s'){
                  wasd.setDirection("d");
                  if(!wasdTorpedo.isFiring())
                  wasdTorpedo.setDirection(wasd.getDirection());
                }
                else if(character=='D'||character=='d'){
                  wasd.setDirection("r");
                  if(!wasdTorpedo.isFiring())
                  wasdTorpedo.setDirection(wasd.getDirection());
                }
                else if(character=='C'||character=='c'){
                  wasd.setIsUnderWater(!wasd.isUnderWater());
                  wasdTorpedo.setIsUnderWater(!wasdTorpedo.isUnderWater());
                }
            }
            
        });
        
    }

    public void paintComponent(Graphics g){

     super.paintComponent(g);
     
     Graphics2D g2=(Graphics2D)g;
     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
     
     if(arrows==null || wasd==null){
      widthPanel=getWidth();
      heightPanel=getHeight();
      arrows=new SimpleSubmarine(obstacles,"r",0,heightPanel-1-SimpleSubmarine.getWidth(),
      (int)(Math.random()*50)+50,(int)(Math.random()*200)+150,true);
      wasd=new SimpleSubmarine(obstacles,"l",widthPanel-1-SimpleSubmarine.getHeight(),0,
      (int)(Math.random()*50)+50,(int)(Math.random()*200)+150,true);
     }
    }
}
