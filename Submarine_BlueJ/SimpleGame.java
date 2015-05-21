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
    
    private 
    
    /**
     * Constructor for objects of class SimpleGame
     */
    public SimpleGame()
    {
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
            }
        });
        
    }

    public void paintComponent(Graphics g){
     super.paintComponent(g);
    }
}
