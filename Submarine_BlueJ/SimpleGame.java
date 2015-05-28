import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class SimpleGame here.
 * 
 * @author (your name) Neo
 * @version (a version number or a date) 5/25/15
 */
public class SimpleGame extends JPanel //inheritance: subclass of JPanel
{
    /**
     * Draw the current window with clear instruction on the other side
     */
    public static void main(String[] args){
        JFrame window=new JFrame("Submarine Game!");
        SimpleGame game=new SimpleGame();
        window.setContentPane(game);
        window.setSize(506,528);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
        System.out.println("Welcome to Submarine World!");
        System.out.println("To play the game, 2 people is best"+"\n"+"unless you can fight your right hand with left");
        System.out.println("First submarine: WASD");
        System.out.println("W:up S:down A:left D:right");
        System.out.println("Space:firing Torpedo; C:change color");
        System.out.println("Second submarine: Arrow");
        System.out.println("Directions follows arrows");
        System.out.println("Enter:firing Torpedo; Shift:change color");
        System.out.println("Green stands for under water;black stands for above water");
        System.out.println("Only when both submarines are under water or both above water, one can attack successfully");
        System.out.println("The obstacles are good hidden place,but don't abuse it");
        System.out.println("Knowing your location is the key");
        System.out.println("To end the game, close the window");
        System.out.println("Prepare for the explosion! hahaha");
        System.out.println("Have a wonderful game play!");
        System.out.println("Don't close the window: waiting for the winner!");
        //Introduction to all the game rules by unconventional print statements
    }

    //Instance variables
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

        /*for(int r=SimpleSubmarine.getWidth()+SimpleTorpedo.getTWidth()+20;
        r<obstacles.length-SimpleSubmarine.getWidth()-SimpleTorpedo.getTWidth()-20;r+=63)*/  //original row 
        
          for(int r=1;r<obstacles.length-64;r+=63)
            for(int c=1;c<obstacles[0].length-64;c+=63){
                obstacles[r][c]=(Math.random()<0.5);
            }

        
        setBackground (new Color (50,250,50));
        /**
         * Abstract inner class: defines action Performed after given time interval of Timer
         */
        ActionListener action=new ActionListener() {
                public void actionPerformed(ActionEvent evt){
                    //executed every time an interrupt occurs every 25 ms due to the timer
                    if((arrows.getSimpleTorpedo()!=null&&!arrows.getSimpleTorpedo().isCont()
                    || wasd.getSimpleTorpedo()!=null && !wasd.getSimpleTorpedo().isCont()))
                    {arrows.speedReset();
                     wasd.speedReset();
                    }
                    //SpeedReset sets the speed of both submarines as 0 to ensure they don't "do funny things" during the huge explosion
                    //However, if the time difference in the firing is less than 25 ms, both submarine will explode. So need to check output (see firstPrint in SimpleTorpedo)
                    
                    if(arrows.getSimpleTorpedo()!=null)
                        arrows.getSimpleTorpedo().update(wasd);
                    if(wasd.getSimpleTorpedo()!=null)
                        wasd.getSimpleTorpedo().update(arrows);
                    //if submarine has a working torpedo, update the torpedo

                   repaint();
                }
            };
        timer=new Timer(25,action);

        /**
         *  Abstract inner class: request focus when mouse is pressed
         */
        addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent evt){
                    requestFocus();
                    //press the screen to request the forcus
                }
            });

        /**
         *  Abstract inner class: start and stop timer based on if focus is lost or gained
         */
        addFocusListener(new FocusListener() {
                public void focusGained(FocusEvent evt){
                    timer.start();
                    repaint();
                    //when focus is gained start the timer 
                }

                public void focusLost(FocusEvent evt){
                    timer.stop();
                    repaint();
                    //when focus is lost stop the timer
                }
            } );

        /**
         *  Abstract inner class: defines the action based on what key or letter is pressed 
         */
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
                        if(!(arrows.getSimpleTorpedo()!=null&&!arrows.getSimpleTorpedo().isCont()
                    || wasd.getSimpleTorpedo()!=null && !wasd.getSimpleTorpedo().isCont()))  
                       // if statement ensures players don't "do funny things" during explosion, so do all the following identical ones
                        arrows.getNewSimpleTorpedo();
                    }
                    else if (code==KeyEvent.VK_SHIFT){
                        if(!(arrows.getSimpleTorpedo()!=null&&!arrows.getSimpleTorpedo().isCont()
                    || wasd.getSimpleTorpedo()!=null && !wasd.getSimpleTorpedo().isCont()))
                        arrows.setIsUnderWater(!arrows.isUnderWater());
                    }
                    //Note: space is for wasd submarine 
                    else if (code==KeyEvent.VK_SPACE){
                        if(!(arrows.getSimpleTorpedo()!=null&&!arrows.getSimpleTorpedo().isCont()
                    || wasd.getSimpleTorpedo()!=null && !wasd.getSimpleTorpedo().isCont()))
                        wasd.getNewSimpleTorpedo();
                    }
                    
                    //"do the right thing" when the right key is pressed
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
                        if(!(arrows.getSimpleTorpedo()!=null&&!arrows.getSimpleTorpedo().isCont()
                    || wasd.getSimpleTorpedo()!=null && !wasd.getSimpleTorpedo().isCont()))
                        wasd.setIsUnderWater(!wasd.isUnderWater());
                    }
                    
                    //"do the right thing" when the right character is typed
                }

            });

    }

    /**
     *  Paint what's on the window based on the states and behaviors of objects
     */
    public void paintComponent(Graphics g){
       
        //overriding the method void paintComponent(Graphics g) from JPanel
        
        super.paintComponent(g); // calls super for background
        Graphics2D g2=(Graphics2D)g; //For more advanced feature
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //to reduce the jaggedness & make the shape more beautiful (not necessary)

        setBackground(Color.CYAN);


        for(int r=1;r<obstacles.length-64;r+=63)
            for(int c=1;c<obstacles[0].length-64;c+=63){
                if(obstacles[r][c]&&r%2==1) {
                    g.setColor(Color.green);
                    g.fillRect(r,c,63,63);
                }
                else if(obstacles[r][c]) {
                    g.setColor(Color.black);
                    g.fillRect(r,c,63,63);
                }
                //fill 63 by 63 rectangles as one obstacle and based on the location decide whether black or green
            }

        if(arrows==null || wasd==null){
            widthPanel=getWidth();    
            heightPanel=getHeight();
            
            int speedOfSubmarine=(int)(Math.random()*7)+8;
            int speedOfTorpedo=(int)(Math.random()*15)+10;
            //make the speed of both submarine and torpedo random to some extent
            
            arrows=new SimpleSubmarine(obstacles,"WASD","r",
            SimpleSubmarine.getHeight()/2+1+(int)(Math.random()*(widthPanel-1-SimpleSubmarine.getHeight()/2)-(SimpleSubmarine.getHeight()/2+1)),  
            SimpleSubmarine.getWidth()/2+1+(int)(Math.random()*(heightPanel-1-SimpleSubmarine.getWidth()/2)-(SimpleSubmarine.getWidth()/2+1)),
            speedOfSubmarine,speedOfTorpedo,true);
            wasd=new SimpleSubmarine(obstacles,"Arrow","l",
            SimpleSubmarine.getHeight()/2+1+(int)(Math.random()*(widthPanel-1-SimpleSubmarine.getHeight()/2)-(SimpleSubmarine.getHeight()/2+1)),
            SimpleSubmarine.getWidth()/2+1+(int)(Math.random()*(heightPanel-1-SimpleSubmarine.getWidth()/2)-(SimpleSubmarine.getWidth()/2+1)),
            speedOfSubmarine,speedOfTorpedo,false);
            
            //note: the location is random for both submarines 
            
            
            /*
            arrows=new SimpleSubmarine(obstacles,"WASD","r",SimpleSubmarine.getHeight()/2+1,heightPanel-1-SimpleSubmarine.getWidth()/2,
                speedOfSubmarine,speedOfTorpedo,true);
            wasd=new SimpleSubmarine(obstacles,"Arrow","l",widthPanel-1-SimpleSubmarine.getHeight()/2,SimpleSubmarine.getWidth()/2+1,
                speedOfSubmarine,speedOfTorpedo,false);*/ //original
        }

        if(hasFocus())
            g.setColor(Color.BLACK);
            
        else{
            g.setColor(Color.CYAN);
            g.drawString("Click to activate",0,20);
            //g.setColor(Color.gray);
        }   
        //if out of focus, draw the string "Click to activate"

        arrows.draw(g);
        wasd.draw(g);
        //draw the 2 submarines (&inside the submarine draw torpedo if applicable)
    }
}
