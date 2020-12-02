package game.worlds;

import game.database.Connection;
import game.entity.SnakeSpawner;
import game.player.Player;
import game.entity.teleporter.Teleporter;
import game.helper.Vector2D;
import game.entity.Entity;
import game.entity.movingactor.MovingActor;
import game.entity.movingactor.Rabbit;
import game.entity.movingactor.Snake;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.sql.SQLException;


/**
 * Write a description of class src.worlds.game.worlds.MyWorld here.
 *
 * @author Tobias Bück
 * @version 1
 */
final public class MyWorld extends World {
    private final Rabbit rabbit;

    @Override
    public void removeObject(Actor object) {
        super.removeObject(object);
        if (object instanceof Entity) {
            Entity entity = (Entity) object;
            entity.removedFromWorld(this);
        }
    }

    public boolean isPositionInWorld(Vector2D position) {
        return this.getWidth() > position.getX() && position.getX() > 0 && position.getY() < this.getHeight() && position.getY() > 0;
    }

    /**
     * Constructor for objects of class src.worlds.game.worlds.MyWorld
     */
    public MyWorld() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Snake s = new Snake();
        this.addObject(s, 100, 100);
        Rabbit r = new Rabbit();
        this.rabbit = r;
        Connection c = new Connection();
        Vector2D rabbitPosition;
        try {
            rabbitPosition = c.getRabbitPosition();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            rabbitPosition = new Vector2D(400, 400);
        }
        this.addObject(new SnakeSpawner(),0,0);

        this.addObject(r, rabbitPosition.getIntX(), rabbitPosition.getIntY());
        Player p = new Player(r);
        this.addObject(p, 0, 0);
        Teleporter t1 = new Teleporter(new Vector2D(100, 200), new Vector2D(400, 100));
        this.addObject(t1, 0, 0);
        this.setPaintOrder(Rabbit.class, MovingActor.class);
    }

    @Override
    public void stopped() {
        super.stopped();
        Connection c = new Connection();
        try {
            c.setRabbitPosition(new Vector2D(this.rabbit.getX(), this.rabbit.getY()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
