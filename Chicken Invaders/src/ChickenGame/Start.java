/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChickenGame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author Shehab
 */
public class Start extends JFrame {
    JButton newgame;
    JButton newgame2;
    JButton quitButton;
    Image img;
    Image img2;
    Graphics g;
    @Override
    public void paint (Graphics g)
    {
        g.drawImage(img, 0, 0, null);
        g.drawImage(img2, 110, 20, null);
    }
    public Start() throws IOException {
        img = ImageIO.read(new File("C:\\Users\\Shehab\\Documents\\NetBeansProjects\\back.jpg"));
        img2 = ImageIO.read(new File("C:\\Users\\Shehab\\Documents\\NetBeansProjects\\logo.png"));
        newgame = new JButton("NEW GAME ONE PLAYER");
        newgame2 = new JButton("NEW GAME TWO PLAYERS");
        quitButton = new JButton("EXIT");
        newgame.setBounds(200,230,200,20);
        newgame2.setBounds(200,260,200,20);
        quitButton.setBounds(250,290,90,20);
        add(newgame);
        add(newgame2);
        add(quitButton);
        setSize(600,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        newgame.addActionListener(new menuselect());
        newgame2.addActionListener(new menuselect());
    }
    private class menuselect implements ActionListener
    {
        private menuselect() throws HeadlessException, IOException {
        }
        @Override
        public void actionPerformed(ActionEvent ae) {
           Object buttonPressed=ae.getSource();
           if(buttonPressed.equals(newgame))
           {
            Movement mb=new Movement();
            dispose();
             //mb.Balls.add(new Chickens());
             mb.Balls.add(new Chickens(0,0,20,Color.ORANGE));
             mb.Balls.add(new Chickens(0,0,15,Color.red));
             mb.Balls.add(new Chickens(0,0,10,Color.CYAN));
             mb.eggs.add(new EGGClass(0,0,5,5));
             mb.eggs.add(new EGGClass(300,0,5,5));
             mb.eggs.add(new EGGClass(600,0,5,5));
             mb.eggs.add(new EGGClass(150,0,5,5));
             mb.eggs.add(new EGGClass(450,0,5,5));
        
            JFrame jf=new JFrame();
            jf.setSize(600, 600);
            jf.add(mb,BorderLayout.CENTER);
            mb.setFocusable(true);
            Thread t1=new Thread(mb);
            t1.start();
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setVisible(true);

            }
           if(buttonPressed.equals(newgame2))
           {
            Movement2Players mb=new Movement2Players();
             //mb.Balls.add(new Chickens());
             mb.Balls.add(new Chickens(0,0,20,Color.ORANGE));
             mb.Balls.add(new Chickens(0,0,15,Color.red));
             mb.Balls.add(new Chickens(0,0,10,Color.CYAN));
             mb.eggs.add(new EGGClass(0,0,5,5));
             mb.eggs.add(new EGGClass(300,0,5,5));
             mb.eggs.add(new EGGClass(600,0,5,5));
             mb.eggs.add(new EGGClass(150,0,5,5));
             mb.eggs.add(new EGGClass(450,0,5,5));
        
            JFrame jf=new JFrame();
            jf.setSize(600, 600);
            jf.add(mb,BorderLayout.CENTER);
            mb.setFocusable(true);
            Thread t1=new Thread(mb);
            t1.start();
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setVisible(true);

            }
            if(buttonPressed.equals(quitButton))
            {
                System.exit(1);
            }
        }
    }
}