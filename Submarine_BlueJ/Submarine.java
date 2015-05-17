
/**
 * Write a description of interface Submarine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public abstract class Submarine extends JFrame
{
    private boolean isUnderwater = true;
    public Submarine(boolean isUnder){
        isUnderwater=isUnder;
        this.setSize(200,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Submarine Game");
        this.setVisible(true);
    }
    public static void main(String [] args){
        new Submarine(boolean isUnder);
    }
}
