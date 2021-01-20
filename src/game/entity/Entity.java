package game.entity;


import greenfoot.Actor;
import greenfoot.GreenfootImage;
import greenfoot.World;

/**
 * Write a description of class game.entity.Entity here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Entity extends Actor {
    private boolean isInWorld = false;
    private final GreenfootImage defaultImage;

    protected Entity(GreenfootImage greenfootImage) {
        this.setImage(new GreenfootImage(greenfootImage));
        this.defaultImage = new GreenfootImage(greenfootImage);
    }

    @Override
    protected void addedToWorld(World world) {
        super.addedToWorld(world);
        this.isInWorld = true;
    }

    public void removedFromWorld(World world) {
        this.isInWorld = false;
    }

    protected void destroySelf() {
        if(this.isInWorld) {
            this.getWorld().removeObject(this);
        }
    }

    protected boolean isInWorld() {
        return isInWorld;
    }

    protected GreenfootImage getDefaultImage() {
        return new GreenfootImage(defaultImage);
    }
}
