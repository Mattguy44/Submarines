
/**
 * Write a description of class Torpedo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.event.*;

public class Torpedo
{
    private int speed;
    private boolean isUnderwater;
    private int locationX,locationY;
    private String facing;
    private int a;
    /**
     * Constructor for objects of class Torpedo
     */
    public Torpedo(int s, boolean uw,int x,int y)
    {
        speed = s;
        isUnderwater = uw;
        locationX=x;
        locationY=y;
    }
    
    
    
    public class Launch implements ActionListener{
    public void actionPerformed(ActionEvent evt){
       
    }
    }
<<<<<<< HEAD
    public void fire(){
    }
=======
>>>>>>> 055f9e2fa58e15d3276cba7ec1db97b3ac5cf43e
}
