package game.entity;
import game.Cooldown;
import game.Countdown;
import greenfoot.Actor;
import greenfoot.GreenfootImage;
import greenfoot.World;

/**
 * Write a description of class game.entity.Entity here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Entity  extends Actor
{
    private boolean isInWorld = false;
    private final GreenfootImage defaultImage;

    public Entity(GreenfootImage greenfootImage){
        this.setImage(new GreenfootImage(greenfootImage));
        this.defaultImage = new GreenfootImage(greenfootImage);
    }

    @Override
    protected void addedToWorld(World world) {
        super.addedToWorld(world);
        this.isInWorld = true;
    }

    protected void removedFromWorld(World world){
        this.isInWorld = false;
    }

    protected void destroySelf(){
        this.getWorld().removeObject(this);
    }

    public Countdown createCountdown(int START_COUNT){
        return new Countdown(START_COUNT, this.getWorld());
    }

    public Cooldown createCooldown(int START_COUNT){
        return new Cooldown(START_COUNT, this.getWorld());
    }

    public boolean isInWorld() {
        return isInWorld;
    }

    public GreenfootImage getDefaultImage() {
        return new GreenfootImage(defaultImage);
    }
}
