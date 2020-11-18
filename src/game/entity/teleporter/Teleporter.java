package game.entity.teleporter;

import game.helper.Settings;
import game.helper.Vector2D;
import game.countdown.Cooldown;
import game.entity.Entity;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class game.entity.teleporter.Teleporter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Teleporter extends Entity
{
    private TeleporterObject teleporter1;
    private TeleporterObject teleporter2;
    private Vector2D positionTeleporter1;
    private Vector2D positionTeleporter2;
    private Cooldown teleportCooldown;
    private final int TELEPORT_TIME = 200;

    public Teleporter(Vector2D positionTeleporter1, Vector2D positionTeleporter2){
        super(new GreenfootImage(Settings.getFilePath("Transparent.png")));
        this.teleporter1 = new TeleporterObject();
        this.teleporter2 = new TeleporterObject();
        this.teleporter1.setOther(this.teleporter2);
        this.teleporter2.setOther(this.teleporter1);

        this.positionTeleporter1 = positionTeleporter1;
        this.positionTeleporter2 = positionTeleporter2;

    }

    @Override
    protected void addedToWorld(World world) {
        super.addedToWorld(world);
        world.addObject(this.teleporter1, this.positionTeleporter1.getIntX(), this.positionTeleporter1.getIntY());
        world.addObject(this.teleporter2, this.positionTeleporter2.getIntX(), this.positionTeleporter2.getIntY());
        this.teleportCooldown = this.createCooldown(this.TELEPORT_TIME);
    }

    /**
     * Act - do whatever the game.entity.teleporter.Teleporter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        if(this.teleportCooldown.isCooledDown()) {
            if (this.teleporter1.hasTeleportableIntersecting()) {
                this.teleporter1.teleport();
                this.teleportCooldown.activate();
            } else if (this.teleporter2.hasTeleportableIntersecting()) {
                this.teleporter2.teleport();
                this.teleportCooldown.activate();
            }
        }
    }

}
