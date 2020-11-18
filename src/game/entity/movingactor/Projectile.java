package game.entity.movingactor;

import game.entity.interfaces.CanBeHit;
import game.entity.interfaces.CanShoot;
import greenfoot.GreenfootImage;

import java.util.List;

/**
 * Write a description of class game.entity.movingactor.Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Projectile extends MovingActor
{
    private CanShoot currentShooter;
    private boolean isShooted;
    protected Projectile(int speed, GreenfootImage greenfootImage){
        super(speed, greenfootImage);
    }
    /**
     * Act - do whatever the game.entity.movingactor.Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        if(this.isShooted){
            List<CanBeHit> canBeHitList = this.getIntersectingObjects(CanBeHit.class);
            if (canBeHitList.contains(this.currentShooter)){
                canBeHitList.remove(this.currentShooter);
            }
            if (canBeHitList.size() > 0) {
                this.hasHit(canBeHitList);
            }
        }
    }

    abstract protected void hasHit(List<CanBeHit> cbh);

    protected void shoot(CanShoot c){
        this.currentShooter = c;
        this.isShooted = true;
    }
}
