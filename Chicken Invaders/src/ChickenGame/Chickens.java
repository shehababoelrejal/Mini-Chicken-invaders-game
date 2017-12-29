/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChickenGame;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author ASUS
 */
public class Chickens {
     public int x,y;
    public int speedx;
    public Color CurrentColor;
    public JLabel chick;
    
    public Chickens(int x,int y,int speedx,Color color)
    {
        this.x=x;
        this.chick = new JLabel();
        this.y=y;
        this.speedx=speedx;
        this.CurrentColor=color;
        //chick.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\Shehab\\Documents\\NetBeansProjects\\ball.png").getImage().getScaledInstance(200,157, Image.SCALE_DEFAULT)));
    }
    public Chickens()
    {
        x=0;
        this.chick = new JLabel();
        y=0;
        speedx=10;
        CurrentColor=Color.GREEN;
    }
    public  void move(int width)
    {
        x+=speedx;
        if (x+50>width)
        {
            speedx= -speedx;
        }
        if (x<0)
        {
            speedx= -speedx;
        }
    }
    
}
