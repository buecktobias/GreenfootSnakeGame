package game;

import game.entity.MovingActor;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class game.Rabbit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rabbit extends MovingActor implements  CanShoot, LivingActor, Teleportable
{
    private int life = 10;
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
     * Act - do whatever the game.Rabbit wants to do. This method is called whenever
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
        this.life = life;
    }
}
