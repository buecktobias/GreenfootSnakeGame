package game.worlds;


import game.entity.movingactor.Car;
import game.helper.Vector2D;
import game.entity.Entity;
import game.entity.movingactor.MovingActor;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.sql.SQLException;


/**
 * Write a description of class src.worlds.game.worlds.MyWorld here.
 *
 * @author Tobias Bück
 * @version 1
 */
final public class MyWorld extends World {

    /**
     * Constructor for objects of class src.worlds.game.worlds.MyWorld
     */
    public MyWorld() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        this.addObject(new Car(10, new GreenfootImage("car.png")), 100, 100);
    }

    @Override
    public void stopped() {
    }
}
