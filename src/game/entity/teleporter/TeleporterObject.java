package game.entity.teleporter;

import game.helper.Settings;
import game.entity.Entity;
import greenfoot.GreenfootImage;

import java.util.List;

/**
 * Write a description of class game.entity.teleporter.TeleporterObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
final public class TeleporterObject extends Entity
{
    protected TeleporterObject getOther() {
        return other;
    }

    public void setOther(TeleporterObject other) {
        this.other = other;
    }

    private TeleporterObject other;
    protected TeleporterObject(){
        super(new GreenfootImage(Settings.getFilePath("Wall.jpg")));
    }

    private List<Teleportable> getTeleportableIntersecting(){
        return this.getIntersectingObjects(Teleportable.class);
    }

    private void teleport(Teleportable t){
        t.setLocation(this.other.getX(), this.other.getY());
    }

    protected boolean hasTeleportableIntersecting(){
        return this.getTeleportableIntersecting().size() > 0;
    }

    protected void teleport(){
        this.teleport(this.getTeleportableIntersecting().get(0));
    }

    /**
     * Act - do whatever the game.entity.teleporter.TeleporterObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }    
}
