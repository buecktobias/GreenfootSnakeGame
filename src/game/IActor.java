package game;

import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;
import greenfoot.platforms.ActorDelegate;

/**
 * Write a description of class game.IActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
interface IActor
{
    int getX();
    int getY();
    GreenfootImage getImage();
    World getWorld();
    void setLocation(int x, int y);
}
