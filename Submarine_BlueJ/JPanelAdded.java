
/**
 * Write a description of class JPanelAdded here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
public class JPanelAdded extends JPanel
{
    private static ImageIcon submarine;
    /**
     * Constructor for objects of class JPanelAdded
     */
    public JPanelAdded()
    {
        //components needed for the JPanel
        this.setPreferredSize(new Dimension(650,650));
        try{
             submarine = new ImageIcon("Sub1.png");
        }
        catch(Exception e){
            System.out.println("The image did not load");
        }
        
    }
    public void paintComponent(Graphics page){
        submarine.paintIcon(this,page,100,100);
        
    }
}
