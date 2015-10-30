/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pong;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ashleigh
 */
public class Pong extends JFrame {
    
    //give the values of the size of the window 
    final static int WINDOW_WIDTH = 407;
    final static int WINDOW_LENGTH = 283;
    
    public Pong()
    {
        //set the size of the window
        setSize(WINDOW_WIDTH,WINDOW_LENGTH);
        //make the window so it cant change size
        setResizable(false);
        //stop the program when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new GamePanel());
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Pong();
    }
    
}
