package game.entity.movingactor;

import game.countdown.Cooldown;
import game.entity.interfaces.CanShoot;
import game.entity.interfaces.LivingActor;
import game.entity.teleporter.Teleportable;
import game.helper.Settings;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class game.entity.movingactor.Rabbit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
final public class Rabbit extends MovingActor implements CanShoot, LivingActor, Teleportable
{
    private int life = 100;
    private Cooldown throwingCooldown;
    public Rabbit(){
        super(2, new GreenfootImage(Settings.getFilePath("hase.png")));
    }

    @Override
    protected void addedToWorld(World world) {
        super.addedToWorld(world);
        this.throwingCooldown = this.createCooldown(10);
        this.createLifeBar();
    }

    /**
     * Act - do whatever the game.entity.movingactor.Rabbit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }


    public void shoot(){
        if (this.throwingCooldown.activate()) {
            ThrowStar s = new ThrowStar();
            this.getWorld().addObject(s, this.getX(), this.getY());
            s.shoot(this.getLastDirection(), this);
        }
    }

    @Override
    public int getLife() {
        return life;
    }

    @Override
    public void setLife(int life) {
        if (life < 0 ){
            Greenfoot.stop();
        }
        this.life = life;
    }

    @Override
    public boolean isInWorld() {
        return super.isInWorld();
    }

}
