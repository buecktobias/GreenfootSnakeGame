package game.entity.interfaces;

import game.entity.LifeBar;

/**
 * Write a description of class game.entity.interfaces.LivingActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface LivingActor extends IActor
{
    int getLife();
    void setLife(int newLife);
    default void createLifeBar(){
        new LifeBar(this);
    }
    boolean isInWorld();
}
