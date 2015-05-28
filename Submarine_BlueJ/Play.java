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
    private int BOARD_WIDTH;
    private int BOARD_HEIGHT;
    private boolean [][] obstacles;
    private Submarine p1;
    private Submarine p2;
    private Submarine curSub;
    private Graphics G;
    public Play (int width, int height) {
        BOARD_WIDTH = width;
        BOARD_HEIGHT = height;
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
        Pan pan = new Pan();
        public Board(){

            this.setSize(BOARD_WIDTH,BOARD_HEIGHT);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("Submarines");
            this.add(pan);
            pan.setBackground(Color.CYAN); // not sure if this is doing anything...
            //pan.addKeyListener(new Listener()); // now handled in Pan class
            pan.setFocusable(true); // allows keys to be listened for in panel
            this.setVisible(true);
            //islands();
        }
        private class Pan extends JPanel{ 
            //In here because making a JPanel object does not 
            //allow one to choose witch method is repaint
            public void paint(Graphics m){
                addKeyListener(new Listener());
                Graphics2D g2=(Graphics2D)m;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
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
                drawSub(m,p1);
                drawSub(m,p2);
                G = m;
            }

            public void paintComponent(Graphics g){
                super.paintComponent(g);
                drawSub(g,curSub);
            }

            public void drawSub (Graphics g, Submarine sub){
                g.setColor(Color.RED);
                if(sub.isUnder()){
                    g.setColor(Color.BLACK);
                }
                if(sub.getDir().equals("UP")){
                    g.fillOval(sub.getX()-8,sub.getY()-20,15,40);
                    g.setColor(Color.GRAY);
                    g.fillRect(sub.getX()-3,sub.getY()-5,5,10);
                }
                if(sub.getDir().equals("RIGHT")){
                    g.fillOval(sub.getX()-20,sub.getY()-8,40,15);
                    g.setColor(Color.GRAY);
                    g.fillRect(sub.getX()-5,sub.getY()-3,10,5);
                }
                if(sub.getDir().equals("LEFT")){
                    g.fillOval(sub.getX()-20,sub.getY()-8,40,15);
                    g.setColor(Color.GRAY);
                    g.fillRect(sub.getX()-5,sub.getY()-3,10,5);
                }
                if(sub.getDir().equals("DOWN")){
                    g.fillOval(sub.getX()-8,sub.getY()-20,15,40);
                    g.setColor(Color.GRAY);
                    g.fillRect(sub.getX()-3,sub.getY()-5,5,10);
                }

            }

            public void init(){}

            public void start(){}

            public void stop(){}
            private class Listener implements KeyListener { //In here for access to repaint()
                public Listener(){}

                public void keyTyped(KeyEvent e) {keyPressed(e);}

                public void keyPressed(KeyEvent e){
                    int key = e.getKeyCode();
                    if (key == KeyEvent.VK_LEFT) {
                        p1.setX(p1.getX()-5);
                        p1.setDirection("LEFT");
                        curSub = p1;
                    }
                    if (key == KeyEvent.VK_RIGHT) {
                        p1.setX(p1.getX()+5);
                        p1.setDirection("RIGHT");
                        curSub = p1;
                    }
                    if (key == KeyEvent.VK_UP) {
                        p1.setY(p1.getY()-5);
                        p1.setDirection("UP");
                        curSub = p1;
                    }
                    if (key == KeyEvent.VK_DOWN) {
                        p1.setY(p1.getY()+5);
                        p1.setDirection("DOWN");
                        curSub = p1;
                    }
                    //p1.draw(G);
                    if (key == KeyEvent.VK_A) {
                        p2.setX(p2.getX()-5);
                        p2.setDirection("LEFT");
                        curSub = p2;
                    }
                    if (key == KeyEvent.VK_D) {
                        p2.setX(p2.getX()+5);
                        p2.setDirection("RIGHT");
                        curSub = p2;
                    }
                    if (key == KeyEvent.VK_W) {
                        p2.setY(p2.getY()-5);
                        p2.setDirection("UP");
                        curSub = p2;
                    }
                    if (key == KeyEvent.VK_S) {
                        p2.setY(p2.getY()+5);
                        p2.setDirection("DOWN");
                        curSub = p2;
                    }
                    repaint();
                }

                public void keyReleased(KeyEvent e){
                    int key = e.getKeyCode();
                    if (key == KeyEvent.VK_SHIFT) {
                        p1.fire();
                    }
                    if (key == KeyEvent.VK_SLASH){
                        p1.submerge();
                    }

                    if (key == KeyEvent.VK_SPACE) {
                        p2.fire();
                    }
                    if (key == KeyEvent.VK_X){
                        p2.submerge();
                    }
                    repaint();
                }
            }
        }

    }

}
