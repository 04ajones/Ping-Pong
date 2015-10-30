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
//create public class called Computer
public class Computer {
    //create variables and assign them values
    private GamePanel field;
    
    private int y = Pong.WINDOW_LENGTH/2;
    private int yVelocity = 0;
    
    private int width = 10;
    private int length = 40;
    
    //use the GamePanel class to get value, assign to variable
    public Computer(GamePanel game)
    {
        this.field = game;
    }
    
    public void update()
    {
        //if the getBall and getY methods are less then y change the below variable
        if (field.getBall().getY() < this.y)
        {
            yVelocity = -2;
        }
        //if not and getY methods are more then y change the below variable
        else if (field.getBall().getY() > this.y)
        {
            yVelocity = 2;
        }
        y = y +yVelocity;
    }
    
    public void paint(Graphics g)
    {
        //set colour 
        g.setColor(Color.red);
        //create rectange 
        g.fillRect(Pong.WINDOW_WIDTH -(35 - width), y, width, length);
    }
    
    public int getX()
    {
        //return the below when getX is called
        return Pong.WINDOW_WIDTH -7 - (35 - width);
    }
    
    public int getY()
    {
        //return y when getY is called
        return y;
    }
    public int getWidth()
    {
        //return width when getWidth is called
        return width;
    }
    public int getLength()
    {
        //return length when getLength is called
        return length;
    }
    
}
