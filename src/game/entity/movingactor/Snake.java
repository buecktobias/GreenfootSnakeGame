package game.entity.movingactor;

import game.entity.interfaces.CanBeHit;
import game.entity.interfaces.LivingActor;
import game.helper.Settings;
import greenfoot.GreenfootImage;
import greenfoot.World;

/**
 * Write a description of class game.entity.movingactor.Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends MovingActor implements CanBeHit, LivingActor
{
    private int life;
    public Snake(){
        super(1, new GreenfootImage(Settings.getFilePath("snake2.png")));
        this.setLife(20);
    }

    @Override
    protected void addedToWorld(World world) {
        super.addedToWorld(world);
        this.createLifeBar();
    }

    @Override
    public void hit() {
        this.setLife(this.getLife() - 5);
    }

    /**
     * Act - do whatever the game.entity.movingactor.Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        this.doRandomMovement(0.01, 0.5);
    }

    @Override
    public int getLife() {
        return life;
    }

    @Override
    public void setLife(int life) {
        if(life < 0 ){
            this.destroySelf();
        }

        this.life = life;
    }
}
