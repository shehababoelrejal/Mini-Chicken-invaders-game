/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChickenGame;

import java.awt.Color;
import java.awt.Point;
import javax.swing.JLabel;

/**
 *
 * @author Shehab
 */
public class EGGClass {
    public int x, y;
    public int speedx;
    public int speedy;
    public JLabel egg;
    public EGGClass(int x,int y,int speedx,int speedy)
    {
        this.egg = new JLabel();
        this.x=x;
        this.y=y;
        this.speedx=speedx;
        this.speedy=speedy;
        //chick.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\Shehab\\Documents\\NetBeansProjects\\ball.png").getImage().getScaledInstance(200,157, Image.SCALE_DEFAULT)));
    }
    public EGGClass()
    {
        this.egg = new JLabel();
        x=0;
        y=0;
        speedx=5;
        speedy=5;
    }
    public  void move(int height)
    {
        y+=speedx;
//        if (y+50>width)
//        {
//            speedx= -speedx;
//        }
//        if (y<0)
//        {
//            speedx= -speedx;
//        }
        
    }
    
    
}
