/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pong;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author ashleigh
 */
public class Player {
    //declare variables
    private int y = Pong.WINDOW_LENGTH/2;
    private int yVelocity = 0;
    
    private int width = 10;
    private int length = 40;
    
    public Player()
    {
        
    }
    //method with the y variable value changed
    public void update()
    {
        y = y +yVelocity;
    }
    
    public void paint(Graphics g)
    {
        //set the colour
        g.setColor(Color.red);
        //create a rectange
        g.fillRect(35, y, width, length);
    }
    
    public void setYVelocity(int speed)
    {
        yVelocity = speed;
    }
    
    //return the value of x as 35 when getX is called
    public int getX()
    {
        return 35;
    }    
    //return y when getY is called
    public int getY()
    {
        return y;
    }
    //return width when getWidth is called
    public int getWidth()
    {
        return width;
    }
    //return length when getLength is called
    public int getLength()
    {
        return length;
    }
}
