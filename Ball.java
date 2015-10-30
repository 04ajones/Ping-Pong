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
public class Ball {
    
    //declare variables and assign them a value
    private int leftScore = 0;
    private int rightScore = 0;
    private int x = Pong.WINDOW_WIDTH/2;
    private int y = Pong.WINDOW_LENGTH/2;
    
    private int xVelocity = -4;
    private int yVelocity = 4;
    
    private int size = 5;
    
    public void update()
    {
        //change x and y values
        x = x + xVelocity;
        y = y + yVelocity;
        
        //if x is less then 0
        if (x < 0)
        {
            //change these variables
            xVelocity = 4;
            rightScore += 1;
            //if the score on the left or right is 3 then change the score to 0
            if(leftScore == 3 || rightScore == 3)
            {
                leftScore = 0;
                rightScore = 0;
            } 
        }
        //if x and the size is greater then the window width minus 7
        else if (x + size > Pong.WINDOW_WIDTH -7)
        {
            //change these variables 
            xVelocity = -4;
            leftScore += 1;
            //if the score on the left or right is 3 then change the score to 0
            if(leftScore == 3 || rightScore == 3)
            {
                leftScore = 0;
                rightScore = 0;
            } 
        }
        //if y is less then 0 then change the below variable
        if (y < 0)
        {
            yVelocity = 4;
        }
        //if not and y plus the size is greater then the length minus 30
        //change the below variable
        else if (y + size > Pong.WINDOW_LENGTH -30)
        {
            yVelocity = -4;
        }
    }
    
    public void paint(Graphics g)
    {
        //change colour
        g.setColor(Color.blue);
        //create oval
        g.fillOval(x, y, size, size);
        //create the scores
        g.drawString(Integer.toString(leftScore), Pong.WINDOW_WIDTH/2 -100, 20);
        g.drawString(Integer.toString(rightScore), Pong.WINDOW_WIDTH/2 +100, 20);
    }
    //new method for the reverse direction
    public void reverseDirection()
    {
        xVelocity = -xVelocity;
    }
    
    //method that uses the player variables
    public void checkCollision(Player player)
    {
        //if the below conditions are met do the below if statement
        if(this.x > player.getX()&& this.x < player.getX() + player.getWidth())
        {
            //if the below if statement is correct call the reverseDirection method
            //run what is in there
            if (this.y > player.getY() && this.y < player.getY() + player.getLength())
            {
                reverseDirection();
            }
        }
    }
    
        //method that uses the player variables 
        public void checkCollision(Computer cpu)
    {
        //if the below conditions are met do the below if statement
        if(this.x > cpu.getX()&& this.x < cpu.getX() + cpu.getWidth())
        {
            //if the below if statement is correct call the reverseDirection method
            //run what is in there
            if (this.y > cpu.getY() && this.y < cpu.getY() + cpu.getLength())
            {
                reverseDirection();
            }
        }
    }
    // return the value of x
    public int getX()
    {
        return x;
    }
    //return the value of y
    public int getY()
    {
        return y;
    }
}
