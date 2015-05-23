
/**
 * Write a description of class JFrameAdded here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.imageio.ImageIO;
import javax.swing.*;
public class JFrameAdded extends JFrame
{
    /**
     * Constructor for objects of class JFrameAdded
     */
    public JFrameAdded()
    //added a JFrame for use later but no real use yet
    {
        //this.setSize(650,650);
        this.setLocation(200,0);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Submarine Game");
        
        JPanelAdded panel = new JPanelAdded();
        this.add(panel);
        setBackground(Color.BLUE);
        this.pack();
        this.setVisible(true);

    }
}
