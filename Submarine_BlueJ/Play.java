import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play
{
    //private Submarine p1 = new ARROWS();
    //private Submarine p2 = new WASD();
    private int BOARD_WIDTH = 500;
    private int BOARD_HEIGHT = 500;
    private boolean [][] obstacles;
    private Submarine p1;
    private Submarine p2;
    private Graphics G;
    public Play () {
        //BOARD_WIDTH = width;
        //BOARD_HEIGHT = height;
        p1 = new ARROWS(false, 5, BOARD_WIDTH - 50, 50);
        p2 = new WASD(false, 5, 50, BOARD_HEIGHT - 50);
        createBoard();
    }
    
    public void createBoard(){
        //fills obstacles[][]
        obstacles = new boolean [BOARD_HEIGHT/5][BOARD_WIDTH/5];
        for (int x = 0; x < BOARD_WIDTH/10; x++)
        {
            obstacles[(int)(Math.random()*obstacles.length)]
                        [(int)(Math.random()*obstacles[0].length)] = true;
        }
        for (int r = 0; r < obstacles.length; r++)
        {
            for (int c = 0; c < obstacles[0].length; c++)
            {
                if (isAdjacent(r,c) && (int)(Math.random()*2) == 0)
                {
                    obstacles[r][c] = true;
                }
            }
        }
        for (int r = 0; r < obstacles.length; r++)
        {
            for (int c = 0; c < obstacles[0].length; c++)
            {
                if (isAdjacent(r,c) && (int)(Math.random()*3) == 0)
                {
                    obstacles[r][c] = true;
                }
            }
        }
        
        //builds board
        new Board();
    }
    
    public boolean isAdjacent(int row, int col){
        if (col > 0 && obstacles[row][col-1])
            return true;
        if (col < obstacles[0].length-1 && obstacles[row][col+1])
            return true;
        if (row > 0 && obstacles[row-1][col])
            return true;
        //use the below and change first Math.random() in createBoard() 
        //to *3 for a different map layout
        /*if (col < obstacles[0].length-1 && row > 0 && obstacles[row-1][col+1])
            return true;
        if (col > 0 && row > 0 && obstacles[row-1][col-1])
            return true;*/
        return false;
    }
    
    private class Board extends JFrame
    {
        private JPanel pan = new JPanel();
        public Board(){
            
            this.setSize(BOARD_WIDTH,BOARD_HEIGHT);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("Submarines");
            this.add(pan);
            pan.setBackground(Color.CYAN);
            pan.addKeyListener(new Listener());
            this.setVisible(true);
            //islands();
        }
        
        public void paint(Graphics m){
            m.setColor(Color.CYAN);
            m.fillRect(0,0,BOARD_WIDTH,BOARD_HEIGHT);
            m.setColor(Color.GREEN);
            for (int r = 0; r < obstacles.length; r++)
            {
                for (int c = 0; c < obstacles[0].length; c++)
                {
                    if (obstacles[r][c])
                        m.fillRect(r*5, c*5, 5, 5);
                }
            }
            G = m;
            p1.draw(m);
            p2.draw(m);
        }
        
        public void init(){}
        public void start(){}
        public void stop(){}
    }
    
    private class Listener implements KeyListener {
        public void keyTyped(KeyEvent e) {}
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT) {
                p1.setX(p1.getX()-5);
            }
            if (key == KeyEvent.VK_RIGHT) {
                p1.setX(p1.getX()+5);
            }
            if (key == KeyEvent.VK_UP) {
                p1.setY(p1.getY()-5);
            }
            if (key == KeyEvent.VK_DOWN) {
                p1.setY(p1.getY()+5);
            }
            p1.draw(G);
        }

        public void keyReleased(KeyEvent e){
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_SHIFT) {
                p1.fire();
            }
            if (key == KeyEvent.VK_SLASH){
                p1.submerge();
            }
        }
    }
}
