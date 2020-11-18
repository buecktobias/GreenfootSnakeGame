package game;

import greenfoot.GreenfootImage;

import java.util.List;

/**
 * Write a description of class game.ThrowStar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThrowStar extends Projectile
{
    private Countdown countdown;

    public ThrowStar(){
        super(5, new GreenfootImage(Settings.getFilePath("Stern2.png")));
    }

    /**
     * Act - do whatever the game.ThrowStar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        if(this.countdown != null && this.countdown.isDown()){
            this.destroySelf();
        }
    }

    protected void hasHit(List<CanBeHit> cbh){
        cbh.get(0).hit();
        this.destroySelf();
    }

    public void shoot(Direction d, CanShoot canShoot){
        super.shoot(canShoot);
        this.changeDirection(d);
        this.countdown = this.createCooldown(20);
    }

}