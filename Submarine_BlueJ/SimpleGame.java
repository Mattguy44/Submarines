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
        obstacles=new boolean [500][500];
        
        
        for(int r=SimpleSubmarine.getWidth()+SimpleTorpedo.getTWidth()+20;
        r<obstacles.length-SimpleSubmarine.getWidth()-SimpleTorpedo.getTWidth()-20;r+=41)
        for(int c=0;c<obstacles[0].length;c+=41){
        obstacles[r][c]=(Math.random()<0.08);
        }
        
        
        
        
        setBackground (new Color (50,250,50));
        
        ActionListener action=new ActionListener() {
          public void actionPerformed(ActionEvent evt){
            if(arrows.getSimpleTorpedo()!=null)
            arrows.getSimpleTorpedo().update(wasd);
            if(wasd.getSimpleTorpedo()!=null)
            wasd.getSimpleTorpedo().update(arrows);
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
               
               //Note:for arrows, left right up down arrows are directions, enter is fire
               //and shift is change the state of above or below water.
               if(code==KeyEvent.VK_LEFT){
                  arrows.setDirection("l");
                  arrows.update();
               }
               else if (code==KeyEvent.VK_RIGHT){
                  arrows.setDirection("r");
                  arrows.update();
               }
               else if (code==KeyEvent.VK_UP){
                  arrows.setDirection("u");
                  arrows.update();
                }
               else if (code==KeyEvent.VK_DOWN){
                  arrows.setDirection("d");
                  arrows.update();
                }
               else if (code==KeyEvent.VK_ENTER){
                  arrows.getNewSimpleTorpedo();
                }
               else if (code==KeyEvent.VK_SHIFT){
                  arrows.setIsUnderWater(!arrows.isUnderWater());
                }
               //Note: space is for wasd submarine 
               else if (code==KeyEvent.VK_SPACE){
                  wasd.getNewSimpleTorpedo();
                }
            }
            
           public void keyTyped (KeyEvent evt){
                char character=evt.getKeyChar();
                SimpleTorpedo wasdTorpedo=wasd.getSimpleTorpedo();
                if(character=='W'||character=='w'){
                  wasd.setDirection("u");
                  wasd.update();
                }
                else if(character=='A'||character=='a'){
                  wasd.setDirection("l");
                  wasd.update();
                }
                else if(character=='S'||character=='s'){
                  wasd.setDirection("d");
                  wasd.update();
                }
                else if(character=='D'||character=='d'){
                  wasd.setDirection("r");
                  wasd.update();
                }
                else if(character=='C'||character=='c'){
                  wasd.setIsUnderWater(!wasd.isUnderWater());
                }
            }
            
        });
        
    }

    public void paintComponent(Graphics g){

         
        
        
     super.paintComponent(g);
     
     Graphics2D g2=(Graphics2D)g;
     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
     
     setBackground(Color.CYAN);
     
     for(int r=SimpleSubmarine.getWidth()+SimpleTorpedo.getTWidth()+20;
        r<obstacles.length-SimpleSubmarine.getWidth()-SimpleTorpedo.getTWidth()-20;r+=41)
        for(int c=0;c<obstacles[0].length;c+=41){
        if(obstacles[r][c]&&r%2==1) {
            g.setColor(Color.green);
            g.fillRect(r,c,41,41);
        }
        else if(obstacles[r][c]) {
            g.setColor(Color.black);
            g.fillRect(r,c,41,41);
        }
        }
        
     if(arrows==null || wasd==null){
      widthPanel=getWidth();
      heightPanel=getHeight();
      int speedOfSubmarine=(int)(Math.random()*50)+20;
      int speedOfTorpedo=(int)(Math.random()*20)+15;
      arrows=new SimpleSubmarine(obstacles,"r",SimpleSubmarine.getHeight()/2+1,heightPanel-1-SimpleSubmarine.getWidth()/2,
      speedOfSubmarine,speedOfTorpedo,true);
      wasd=new SimpleSubmarine(obstacles,"l",widthPanel-1-SimpleSubmarine.getHeight()/2,SimpleSubmarine.getWidth()/2+1,
      speedOfSubmarine,speedOfTorpedo,false);
    }
    
   if(hasFocus())
       g.setColor(Color.BLACK);
    else{
     g.setColor(Color.CYAN);
     g.drawString("Click to activate",100,20);
     //g.setColor(Color.gray);
    }   
    
    arrows.draw(g);
    wasd.draw(g);
    }
}
