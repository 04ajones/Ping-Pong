/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author ashleigh
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener {
    
    //declare variables
    Player player = new Player();
    Ball ball = new Ball();
    Computer computer = new Computer(this);
    
        
    public GamePanel()
    {
        //set the timer for the refresh rate
        Timer tim = new Timer(50,this);
        tim.start();
        
        this.addKeyListener(this);
        this.setFocusable(true);
    }
    
    private void update()
    {
        //call variables with methods
        player.update();
        ball.update();
        computer.update();
        ball.checkCollision(player);
        ball.checkCollision(computer);
    }
    
    public Ball getBall()
    {
        return ball;
    }
    
    
    @Override
    public void paintComponent(Graphics g)
    {
        //set the colour 
        g.setColor(Color.green);
        //create teh rectangle 
        g.fillRect(0, 0, Pong.WINDOW_WIDTH, Pong.WINDOW_LENGTH);
        player.paint(g);
        ball.paint(g);
        computer.paint(g);
        //set the colour
        g.setColor(Color.black);
        //draw line and oval for the background
        g.drawLine(Pong.WINDOW_WIDTH/2, 0, Pong.WINDOW_WIDTH/2, Pong.WINDOW_LENGTH);
        g.drawOval(Pong.WINDOW_WIDTH/2 -25, Pong.WINDOW_LENGTH/2 -25, 50, 50);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //call these methods
        update();
        repaint();
    }
    
    //public void KeyPressed(KeyEvent e)
    //{

    //}
    
    @Override
    public void keyReleased(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        //if the up or down key is released change the below variable
        if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN)
        {
            player.setYVelocity(0);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        //if the up key is pressed change the below variable
        if(ke.getKeyCode() == KeyEvent.VK_UP)
        {
            player.setYVelocity(-4);
        }
        //if not and the down key is pressed change the below variable
        else if(ke.getKeyCode() == KeyEvent.VK_DOWN)
        {
            player.setYVelocity(4);
        }
    }
}
