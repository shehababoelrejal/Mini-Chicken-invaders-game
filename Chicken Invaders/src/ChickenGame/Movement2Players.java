/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChickenGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class Movement2Players extends JPanel implements Runnable{

   public ArrayList<Chickens>Balls=new ArrayList<Chickens>(5);
   public ArrayList<EGGClass>eggs=new ArrayList<EGGClass>();
   public Spaceship BlueTank=new Spaceship("C:\\Users\\Shehab\\Documents\\NetBeansProjects\\tank2.png");
   public Spaceship BlueTank2=new Spaceship("C:\\Users\\Shehab\\Documents\\NetBeansProjects\\tank2.png");
   public Chickens ball = new Chickens();
   public int cnt = 0;
   public int cnt2 = 0;
   public JLabel cnt1 = new JLabel();
   
    public Movement2Players()
    {
        setSize(600,600);
        //setBackground(Color.red);
        BlueTank.pos.x=150;
        BlueTank.pos.y=340;
        BlueTank2.pos.x=300;
        BlueTank2.pos.y=340;
        this.addKeyListener(new keylist());
        
    }
    private class keylist implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("Test");
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                
                BlueTank.mover();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                
                BlueTank.movel();
                //repaint();
            }
            if (e.getKeyCode()==KeyEvent.VK_SPACE)
            {
                
                BlueTank.fireBullet();
            }
             if (e.getKeyCode()==KeyEvent.VK_D)
            {
                
                BlueTank2.mover();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_A)
            {
                
                BlueTank2.movel();
                //repaint();
            }
            if (e.getKeyCode()==KeyEvent.VK_F)
            {
                
                BlueTank2.fireBullet();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
    }
    public void  paintComponent(Graphics g)
    {
       // g.clearRect(0, 0, 600, 600);
        
        try
        {
        BufferedImage imgtank = ImageIO.read(new File(BlueTank.ImagePath));
        BufferedImage imgrocket = ImageIO.read(new File(BlueTank.Rocket.imgPath));
        BufferedImage imgrocket2 = ImageIO.read(new File(BlueTank2.Rocket.imgPath));
        BufferedImage imgback = ImageIO.read(new File("C:\\Users\\Shehab\\Documents\\NetBeansProjects\\back.jpg"));
        BufferedImage imgball = ImageIO.read(new File("C:\\Users\\Shehab\\Documents\\NetBeansProjects\\ball.png"));
        BufferedImage imgegg = ImageIO.read(new File("C:\\Users\\Shehab\\Documents\\NetBeansProjects\\egg.png"));
        g.drawImage(imgback, 0, 0,null);
        g.drawImage(imgtank, BlueTank.pos.x, BlueTank.pos.y,null);
        g.drawImage(imgtank, BlueTank2.pos.x, BlueTank2.pos.y,null);
        g.drawImage(imgrocket, BlueTank.Rocket.pos.x, BlueTank.Rocket.pos.y,null);
        g.drawImage(imgrocket2, BlueTank2.Rocket.pos.x, BlueTank2.Rocket.pos.y,null);
        for(EGGClass eg: eggs)
        {
            g.drawImage(imgegg, eg.x, eg.y, null);
        }
        for(Chickens ball: Balls)
        {
            g.drawImage(imgball, ball.x, ball.y, null);}
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        
        for (EGGClass egg: eggs)
        {
           if(egg.y == 600)
           {
             eggs.add(new EGGClass(0,0,5,5));
             eggs.add(new EGGClass(300,0,5,5));
             eggs.add(new EGGClass(600,0,5,5));
             eggs.add(new EGGClass(150,0,5,5));
             eggs.add(new EGGClass(450,0,5,5));
           }
               //g.setColor(OneBall.CurrentColor);
               //g.fillOval(OneBall.x,OneBall.y, 50, 50);
               egg.egg.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\Shehab\\Documents\\NetBeansProjects\\ball.png").getImage().getScaledInstance(200,157, Image.SCALE_DEFAULT)));
                if(BlueTank.pos.distance(egg.x,egg.y)<=20)
                {
                    JOptionPane.showMessageDialog(null,"Player 1 You lost. ", " Game Over.",JOptionPane.ERROR_MESSAGE);
                    setVisible(false);
                    System.exit(1);
                    break;
            }
                if(BlueTank2.pos.distance(egg.x,egg.y)<=20)
                {
                    JOptionPane.showMessageDialog(null,"Player 2 lost. ", " Game Over.",JOptionPane.ERROR_MESSAGE);
                    setVisible(false);
                    System.exit(1);
                    break;
            }
            if (BlueTank.Rocket.pos.distance(egg.x, egg.y)<=50)
            {
                BlueTank.Rocket.pos.x = -20;
                BlueTank.Rocket.pos.y = -20;
                System.out.println("Hit Occurs" );
                cnt++;
                eggs.remove(egg);
                break;
                
            }
            if (BlueTank2.Rocket.pos.distance(egg.x, egg.y)<=50)
            {
                BlueTank2.Rocket.pos.x = -20;
                BlueTank2.Rocket.pos.y = -20;
                System.out.println("Hit Occurs" );
                cnt2++;
                eggs.remove(egg);
                break;
                
            }
            
        }
        
        for (Chickens OneBall: Balls)
        
        {
//            Balls.add(new Chickens(0,0,15,Color.red));
            
               //g.setColor(OneBall.CurrentColor);
               //g.fillOval(OneBall.x,OneBall.y, 50, 50);
               OneBall.chick.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\Shehab\\Documents\\NetBeansProjects\\ball.png").getImage().getScaledInstance(200,157, Image.SCALE_DEFAULT)));
            if (BlueTank.Rocket.pos.distance(OneBall.x, OneBall.y)<=50)
            {
                BlueTank.Rocket.pos.x = -20;
                BlueTank.Rocket.pos.y = -20;
                System.out.println("Hit Occurs" + OneBall.CurrentColor.toString());
                cnt++;
                Balls.remove(OneBall);
                break;
                
            }
            if (BlueTank2.Rocket.pos.distance(OneBall.x, OneBall.y)<=50)
            {
                BlueTank2.Rocket.pos.x = -20;
                BlueTank2.Rocket.pos.y = -20;
                System.out.println("Hit Occurs" + OneBall.CurrentColor.toString());
                cnt2++;
                Balls.remove(OneBall);
                break;
                
            }
        
            if(OneBall.x == 400)
            {
                Balls.add(new Chickens(0,0,15,Color.red));
                Balls.add(new Chickens(0,95,15,Color.red));
            }
        

//            for (EGGClass egg : eggs) {
//                if(OneBall.x == 0 && OneBall.y == 0)
//            {
//                eggs.add(egg);
//            }
//            }
            
            
        }
        
    }
    @Override
    public void run() {
    try
    {
    while(true)
    {
        if(Balls.isEmpty())
        {
          JOptionPane.showMessageDialog(null,"Players Win!, Player 1 High Score: "+cnt+" Player 2 High Score: "+cnt2);
          Start st = new Start();
          st.setVisible(true);
          st.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//          setOpaque(false); setEnabled(false); setVisible(false); removeAll();
          break;
        }
        
        
        for (Chickens OneBall: Balls)
        {
            OneBall.move(this.getWidth());
        }    
        
        //y+=10;
        Thread.sleep(30);
        repaint();
        for (EGGClass egg: eggs)
        {
            egg.move(this.getHeight());
        }    
        
        //y+=10;
        Thread.sleep(50);
        repaint();
    }
    }
    catch (InterruptedException e)
    {} catch (IOException ex) {
           Logger.getLogger(Movement2Players.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    
}
