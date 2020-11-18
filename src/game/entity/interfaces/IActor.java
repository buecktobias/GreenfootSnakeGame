package game.entity.interfaces;

import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;
import greenfoot.platforms.ActorDelegate;

/**
 * Write a description of class game.entity.interfaces.IActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IActor
{
    int getX();
    int getY();
    GreenfootImage getImage();
    World getWorld();
    void setLocation(int x, int y);
}
