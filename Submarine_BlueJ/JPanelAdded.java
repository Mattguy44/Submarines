
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
    private static BufferedImage submarine;
    /**
     * Constructor for objects of class JPanelAdded
     */
    public JPanelAdded()
    {
        //components needed for the JPanel
        this.setPreferredSize(new Dimension(650,650));
        try{
             submarine = new JPanelAdded().scaleImage(50,50,"Sub1.png");//ImageIO.read(new File("Sub1.png"));
        }
        catch(Exception e){
            System.out.println("The image did not load");
        }
        
    }
    public BufferedImage scaleImage(int w,int h,String filename){
        BufferedImage bi = null;
        try{
            ImageIcon ii = new ImageIcon(filename);
            bi = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = (Graphics2D) bi.createGraphics();
            g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
            g2d.drawImage(ii.getImage(),0,0,w,h,null);
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return bi;
    }
    @Override 
    protected void paintComponent(Graphics page){
        //BufferedImage submarine = new JPanelAdded().scaleImage(50,50,"Sub1.png");
        //submarine.paintIcon(this,page,100,100);
        super.paintComponent(page);
        page.drawImage(submarine,0,0,null);
        
    }
}
