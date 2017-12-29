/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChickenGame;

import java.awt.Point;

/**
 *
 * @author ASUS
 */
public class Spaceship {
    public Point pos=new Point();
    public String ImagePath;
    public Bullet Rocket=new Bullet();
    public int speed;
    public Spaceship (String ImagePath)
    {
        speed=10;
        this.ImagePath=ImagePath;
        Rocket.imgPath="C:\\Users\\Shehab\\Documents\\NetBeansProjects\\bullet.png";
    }

    void mover() {
        this.pos.x+=speed;
    }
      void movel() {
        this.pos.x-=speed;
    }

    public void fireBullet() {
        Rocket.pos.x=this.pos.x+50;
        Rocket.pos.y=this.pos.y+70;
        Thread t1=new Thread (Rocket);
        t1.start();
    }
}
